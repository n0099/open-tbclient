package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ImMessageCenterActivityStatic {
    private static void Wc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.IM_MESSAGE_CENTER_ACTIVITY_START, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    static {
        Wc();
    }
}
