package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes2.dex */
public class ImMessageCenterFragmentStatic {
    static {
        asi();
    }

    private static void asi() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.IM_NEW_MESSAGE_CENTER_FRAGMENT, new r());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
