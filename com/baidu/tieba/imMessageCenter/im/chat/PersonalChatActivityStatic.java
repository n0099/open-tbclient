package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class PersonalChatActivityStatic {
    private static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f boZ;
    private static CustomMessageListener bpa = new l(2005016);

    static {
        MessageManager.getInstance().registerListener(bpa);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002005, new m());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f TQ() {
        return boZ;
    }

    public static void a(com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f fVar) {
        boZ = fVar;
    }
}
