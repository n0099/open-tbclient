package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class PersonalChatActivityStatic {
    private static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e bKc;
    private static CustomMessageListener bKd = new l(CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(bKd);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PERSONAL_CHAT, new m());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e Ya() {
        return bKc;
    }

    public static void a(com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e eVar) {
        bKc = eVar;
    }
}
