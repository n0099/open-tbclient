package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class Static {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001279, new CustomMessageTask.CustomRunnable<BaseActivity>() { // from class: com.baidu.tieba.myCollection.baseEditMark.Static.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.baseEditMark.a> run(CustomMessage<BaseActivity> customMessage) {
                b bVar = null;
                if (customMessage != null && customMessage.getData() != null) {
                    bVar = new b(customMessage.getData());
                }
                return new CustomResponsedMessage<>(2001279, bVar);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921318, new CustomMessageTask.CustomRunnable<BaseFragmentActivity>() { // from class: com.baidu.tieba.myCollection.baseEditMark.Static.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.baseEditMark.a> run(CustomMessage<BaseFragmentActivity> customMessage) {
                b bVar = null;
                if (customMessage != null && customMessage.getData() != null) {
                    bVar = new b(customMessage.getData());
                }
                return new CustomResponsedMessage<>(2921318, bVar);
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
