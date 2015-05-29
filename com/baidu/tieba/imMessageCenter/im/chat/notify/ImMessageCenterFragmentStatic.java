package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class ImMessageCenterFragmentStatic {
    static {
        VA();
    }

    private static void VA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008002, new o());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
