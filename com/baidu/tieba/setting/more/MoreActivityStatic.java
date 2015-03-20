package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class MoreActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015004, new v());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
