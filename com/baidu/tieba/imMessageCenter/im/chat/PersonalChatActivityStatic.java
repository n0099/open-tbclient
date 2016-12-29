package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class PersonalChatActivityStatic {
    private static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e cZe;
    private static CustomMessageListener cZf = new l(CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(cZf);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PERSONAL_CHAT, new m());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        bc.vz().a(new p());
    }

    public static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e atJ() {
        return cZe;
    }

    public static void a(com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e eVar) {
        cZe = eVar;
    }
}
