package com.baidu.tieba.im.validate;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class ValidateActivityStatic {
    static {
        Ns();
    }

    private static void Ns() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008021, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
