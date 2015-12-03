package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatActivityStatic {
    private static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e bZh;
    private static List<UserData> mUserDataList = null;
    private static CustomMessageListener bZi = new y(CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(bZi);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new z());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static List<UserData> Qw() {
        return mUserDataList;
    }

    public static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e acs() {
        return bZh;
    }

    public static void c(com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e eVar) {
        bZh = eVar;
    }
}
