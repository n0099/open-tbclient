package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class IMBlackListActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008001, new e());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
