package com.baidu.tieba.service;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class FatalErrorServiceStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2006002, new f());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
