package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class MainTabActivityStatic {
    private static Game crP;

    static {
        JK();
        aot();
        FV();
        aos();
        MessageManager.getInstance().registerListener(new ac(2002004));
    }

    private static void JK() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015001, new ad());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void FV() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012118, new ae());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aos() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001258, new af());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aot() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012111, new ag());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static Game getGame() {
        return crP;
    }
}
