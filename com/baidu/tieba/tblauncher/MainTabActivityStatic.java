package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
public class MainTabActivityStatic {
    static {
        Qq();
        aVF();
        aVD();
        aVE();
        MessageManager.getInstance().registerListener(new u(CmdConfigCustom.START_GO_HOME));
        bg.us().a(new v());
    }

    private static void Qq() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_MAINTAB, new w());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aVD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.FRIEND_FEED_NEW, new x());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aVE() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHOW_GAME_ICON, new y());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aVF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MSG_NEW, new z());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
