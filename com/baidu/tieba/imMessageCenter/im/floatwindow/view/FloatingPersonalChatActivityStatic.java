package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatActivityStatic {
    private static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f bpp;
    private static List<UserData> mUserDataList = null;
    private static CustomMessageListener bpq = new aa(2005016);

    static {
        MessageManager.getInstance().registerListener(bpq);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002011, new ab());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static List<UserData> getList() {
        return mUserDataList;
    }

    public static com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f Vm() {
        return bpp;
    }

    public static void c(com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f fVar) {
        bpp = fVar;
    }
}
