package com.baidu.tieba.myCollection.history;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes3.dex */
public class PbHistoryStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001296, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.myCollection.history.PbHistoryStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Object> run(CustomMessage<String> customMessage) {
                return new CustomResponsedMessage<>(2001296, new a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001267));
    }
}
