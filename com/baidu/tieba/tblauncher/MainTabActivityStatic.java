package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class MainTabActivityStatic {
    private static Game dKK;

    static {
        Nu();
        aHe();
        IW();
        aHd();
        MessageManager.getInstance().registerListener(new q(CmdConfigCustom.START_GO_HOME));
    }

    private static void Nu() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_MAINTAB, new r());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void IW() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.FRIEND_FEED_NEW, new s());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aHd() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHOW_GAME_ICON, new t());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aHe() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MSG_NEW, new u());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static Game getGame() {
        return dKK;
    }
}
