package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
public class PersonalChatActivityStatic {
    private static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e cti;
    private static CustomMessageListener ctj = new l(CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(ctj);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PERSONAL_CHAT, new m());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        bg.ut().a(new p());
    }

    public static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e aja() {
        return cti;
    }

    public static void a(com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e eVar) {
        cti = eVar;
    }
}
