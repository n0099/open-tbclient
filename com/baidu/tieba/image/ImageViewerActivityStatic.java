package com.baidu.tieba.image;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class ImageViewerActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010000, new q());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
