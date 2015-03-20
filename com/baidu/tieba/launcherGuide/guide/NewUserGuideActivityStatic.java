package com.baidu.tieba.launcherGuide.guide;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class NewUserGuideActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012116, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
