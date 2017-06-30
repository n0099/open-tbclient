package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
public class MainTabActivityStatic {
    private static int fQG = 0;

    static {
        adA();
        boh();
        bog();
        boi();
        MessageManager.getInstance().registerListener(new v(CmdConfigCustom.START_GO_HOME));
        be.vP().a(new w());
        MessageManager.getInstance().registerListener(new x(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL));
    }

    private static int a(NewsNotifyMessage newsNotifyMessage) {
        int i;
        int i2;
        if (newsNotifyMessage == null) {
            return 0;
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zd().zl() && com.baidu.tbadk.coreExtra.messageCenter.c.zd().zs()) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        int msgAtme = ((com.baidu.tbadk.coreExtra.messageCenter.c.zd().zi() ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (com.baidu.tbadk.coreExtra.messageCenter.c.zd().zk() ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zx()) {
            msgAtme -= newsNotifyMessage.getMsgOfficialMerge();
        }
        return msgAtme;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            int a = a((NewsNotifyMessage) responsedMessage);
            if (a > fQG) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_NOTIFY_MSG, true));
            }
            fQG = a;
        }
    }

    private static void adA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_MAINTAB, new y());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bog() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.FRIEND_FEED_NEW, new z());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void boh() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MSG_NEW, new aa());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void boi() {
        be.vP().a(new ab());
    }
}
