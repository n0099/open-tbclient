package com.baidu.tieba.tbadvert;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes5.dex */
public class TbAdvertStatic {

    /* loaded from: classes5.dex */
    public static class a implements CustomMessageTask.CustomRunnable<Context> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.a.m0.w0.a> run(CustomMessage<Context> customMessage) {
            if (customMessage.getData() != null) {
                return new CustomResponsedMessage<>(2921390, new d.a.n0.f3.a(customMessage.getData()));
            }
            return null;
        }
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921390, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
