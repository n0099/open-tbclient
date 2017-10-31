package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ImMessageCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes2.dex */
public class ImMessageCenterActivityStatic {
    private static void aqR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.IM_MESSAGE_CENTER_ACTIVITY_START, new CustomMessageTask.CustomRunnable<ImMessageCenterActivityConfig>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ImMessageCenterActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(ImMessageCenterActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    static {
        aqR();
    }
}
