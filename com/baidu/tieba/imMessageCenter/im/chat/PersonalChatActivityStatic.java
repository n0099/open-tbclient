package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes2.dex */
public class PersonalChatActivityStatic {
    private static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e dqU;
    private static CustomMessageListener dqV = new l(CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(dqV);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PERSONAL_CHAT, new m());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        be.vP().a(new p());
    }

    public static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e awH() {
        return dqU;
    }

    public static void a(com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e eVar) {
        dqU = eVar;
    }
}
