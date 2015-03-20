package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class GuideActivityStatic {
    GuideActivityStatic() {
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015000, new h());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
