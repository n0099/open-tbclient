package com.baidu.tieba.square.flist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
/* loaded from: classes5.dex */
public class ForumListActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2902025, new CustomMessageTask.CustomRunnable<ForumListActivityConfig>() { // from class: com.baidu.tieba.square.flist.ForumListActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ForumListActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(ForumListActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
