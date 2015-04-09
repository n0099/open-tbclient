package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class EditMarkStatic {
    private static com.baidu.tbadk.mainTab.e bEa;
    private static int msgCount = 0;

    static {
        MessageManager.getInstance().registerListener(new d(2001124));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001274));
        CustomMessageTask customMessageTask = new CustomMessageTask(2001302, new e());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
