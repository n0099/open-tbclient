package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class EditMarkActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015005, new c());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
