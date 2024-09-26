import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.sun.rowset.internal.Row

@Composable
@Preview
fun TaskListApp() {
    // Тут список задач с состоянием (переменные чтоль)
    var taskText by remember { mutableStateOf("") }
    val tasks = remember { mutableListOf<String>() }

    // ----
    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {

            OutlinedTextField(
                value = taskText,
                onValueChange = { taskText = it },
                label = { Text("Введите задачу") },
                modifier = Modifier.weight(1f).padding(8.dp)
            )

            Button(
                onClick = {
                    if (taskText.isNotEmpty()) {
                        tasks.add(taskText)
                        taskText = ""
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Добавить задачу")
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
                .border(0.5.dp, Color.Black, RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            items(tasks) { task ->
                Text(text = task, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        TaskListApp()
    }
}