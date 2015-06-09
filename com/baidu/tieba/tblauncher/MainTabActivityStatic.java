package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class MainTabActivityStatic {
    private static Game cvZ;

    static {
        KP();
        aqm();
        GU();
        aql();
        MessageManager.getInstance().registerListener(new ad(2002004));
    }

    private static void KP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015002, new ae());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void GU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012118, new af());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aql() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001258, new ag());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aqm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012111, new ah());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static Game getGame() {
        return cvZ;
    }
}
