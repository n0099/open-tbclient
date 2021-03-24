package com.baidu.tieba.nightResource;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import d.b.h0.r.c;
/* loaded from: classes4.dex */
public class NightResourceStatic {

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<Boolean> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            return new CustomResponsedMessage<>(2001281, Boolean.TRUE);
        }
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001281, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        c.f50426f = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001354));
    }
}
