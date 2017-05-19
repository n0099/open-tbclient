package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
public class MainTabActivityStatic {
    private static int fdy = 0;

    static {
        YG();
        bix();
        biw();
        biy();
        MessageManager.getInstance().registerListener(new z(CmdConfigCustom.START_GO_HOME));
        bb.vB().a(new aa());
        MessageManager.getInstance().registerListener(new ab(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL));
    }

    private static int a(NewsNotifyMessage newsNotifyMessage) {
        int i;
        int i2;
        if (newsNotifyMessage == null) {
            return 0;
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yR().yZ() && com.baidu.tbadk.coreExtra.messageCenter.c.yR().zg()) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        int msgAtme = ((com.baidu.tbadk.coreExtra.messageCenter.c.yR().yW() ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (com.baidu.tbadk.coreExtra.messageCenter.c.yR().yY() ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().zl()) {
            msgAtme -= newsNotifyMessage.getMsgOfficialMerge();
        }
        return msgAtme;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            int a = a((NewsNotifyMessage) responsedMessage);
            if (a > fdy) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_NOTIFY_MSG, true));
            }
            fdy = a;
        }
    }

    private static void YG() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_MAINTAB, new ac());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void biw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.FRIEND_FEED_NEW, new ad());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bix() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MSG_NEW, new ae());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void biy() {
        bb.vB().a(new af());
    }
}
