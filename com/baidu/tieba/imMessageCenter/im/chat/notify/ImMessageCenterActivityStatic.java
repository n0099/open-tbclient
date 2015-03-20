package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class ImMessageCenterActivityStatic {
    private static void Nf() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008012, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    static {
        Nf();
    }
}
