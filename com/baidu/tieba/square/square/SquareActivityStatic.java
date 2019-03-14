package com.baidu.tieba.square.square;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes5.dex */
public class SquareActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2902023, new CustomMessageTask.CustomRunnable<SingleSquareActivityConfig>() { // from class: com.baidu.tieba.square.square.SquareActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<SingleSquareActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(SquareActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        ba.adD().a("square:", new ba.b() { // from class: com.baidu.tieba.square.square.SquareActivityStatic.2
            @Override // com.baidu.tbadk.core.util.ba.b
            public void a(TbPageContext<?> tbPageContext, Map<String, String> map) {
                if (tbPageContext != null) {
                    new SingleSquareActivityConfig(tbPageContext.getPageActivity()).start();
                }
            }
        });
    }
}
