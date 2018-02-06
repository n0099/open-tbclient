package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
/* loaded from: classes2.dex */
public class IMBlackListActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008001, new CustomMessageTask.CustomRunnable<IMBlackListActivityConfig>() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<IMBlackListActivityConfig> run(CustomMessage<IMBlackListActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(IMBlackListActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
