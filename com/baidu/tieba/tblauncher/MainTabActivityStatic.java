package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class MainTabActivityStatic {
    private static Game dfs;

    static {
        LC();
        azC();
        Hm();
        azB();
        MessageManager.getInstance().registerListener(new ai(CmdConfigCustom.START_GO_HOME));
    }

    private static void LC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_MAINTAB, new aj());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Hm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.FRIEND_FEED_NEW, new ak());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void azB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHOW_GAME_ICON, new al());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void azC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MSG_NEW, new am());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static Game getGame() {
        return dfs;
    }
}
