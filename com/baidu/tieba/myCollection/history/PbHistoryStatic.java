package com.baidu.tieba.myCollection.history;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class PbHistoryStatic {
    static {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001274));
        CustomMessageTask customMessageTask = new CustomMessageTask(2001303, new h());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
