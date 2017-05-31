package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
public class MainTabActivityStatic {
    private static int flr = 0;

    static {
        ZJ();
        bjV();
        bjU();
        bjW();
        MessageManager.getInstance().registerListener(new ac(CmdConfigCustom.START_GO_HOME));
        com.baidu.tbadk.core.util.bb.vy().a(new ad());
        MessageManager.getInstance().registerListener(new ae(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL));
    }

    private static int a(NewsNotifyMessage newsNotifyMessage) {
        int i;
        int i2;
        if (newsNotifyMessage == null) {
            return 0;
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yK().yS() && com.baidu.tbadk.coreExtra.messageCenter.c.yK().yZ()) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        int msgAtme = ((com.baidu.tbadk.coreExtra.messageCenter.c.yK().yP() ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (com.baidu.tbadk.coreExtra.messageCenter.c.yK().yR() ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.yK().ze()) {
            msgAtme -= newsNotifyMessage.getMsgOfficialMerge();
        }
        return msgAtme;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            int a = a((NewsNotifyMessage) responsedMessage);
            if (a > flr) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_NOTIFY_MSG, true));
            }
            flr = a;
        }
    }

    private static void ZJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_MAINTAB, new af());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bjU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.FRIEND_FEED_NEW, new ag());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bjV() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MSG_NEW, new ah());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bjW() {
        com.baidu.tbadk.core.util.bb.vy().a(new ai());
    }
}
