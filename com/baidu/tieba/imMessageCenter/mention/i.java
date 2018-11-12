package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
/* loaded from: classes4.dex */
public class i {
    private static i eXP = null;
    private final HttpMessageListener ayu = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.GN() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.Hs().Hu()) {
                    if (msgData.aUb() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgBookmark(msgData.aUb());
                    }
                    if (msgData.aTZ() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgAtme(msgData.aTZ());
                    }
                    if (msgData.aTY() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgReplyme(msgData.aTY());
                    }
                    if (msgData.aUa() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.Hs().Hy()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgFans(msgData.aUa());
                    }
                    if (msgData.aTX() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GL().eH(msgData.aTX());
                    }
                }
            }
        }
    };
    private long eXQ = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.eXQ = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.kV())) {
                    i.this.aUd();
                }
                i.this.j(1, KeepJobService.JOB_CHECK_PERIODIC);
            }
        }
    };

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized i aUc() {
        i iVar;
        synchronized (i.class) {
            if (eXP == null) {
                eXP = new i();
            }
            iVar = eXP;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.ayu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUd() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void restart() {
        this.eXQ = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.eXQ;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= KeepJobService.JOB_CHECK_PERIODIC) {
            i = 2;
            j = ErrDef.Feature.WEIGHT;
        } else {
            i = 1;
            j = KeepJobService.JOB_CHECK_PERIODIC - j2;
        }
        j(i, j);
        this.eXQ = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, long j) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessageDelayed(obtainMessage, j);
    }
}
