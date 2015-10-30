package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ImMessageCenterFragmentStatic {
    static {
        XO();
    }

    private static void XO() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.IM_NEW_MESSAGE_CENTER_FRAGMENT, new q());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
