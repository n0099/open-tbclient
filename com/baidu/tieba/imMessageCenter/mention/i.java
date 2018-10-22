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
    private static i eWx = null;
    private final HttpMessageListener axH = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.GB() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hi()) {
                    if (msgData.aUE() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgBookmark(msgData.aUE());
                    }
                    if (msgData.aUC() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgAtme(msgData.aUC());
                    }
                    if (msgData.aUB() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgReplyme(msgData.aUB());
                    }
                    if (msgData.aUD() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hm()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgFans(msgData.aUD());
                    }
                    if (msgData.aUA() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().et(msgData.aUA());
                    }
                }
            }
        }
    };
    private long eWy = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.eWy = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.kX())) {
                    i.this.aUG();
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

    public static synchronized i aUF() {
        i iVar;
        synchronized (i.class) {
            if (eWx == null) {
                eWx = new i();
            }
            iVar = eWx;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.axH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUG() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void restart() {
        this.eWy = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.eWy;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= KeepJobService.JOB_CHECK_PERIODIC) {
            i = 2;
            j = ErrDef.Feature.WEIGHT;
        } else {
            i = 1;
            j = KeepJobService.JOB_CHECK_PERIODIC - j2;
        }
        j(i, j);
        this.eWy = System.currentTimeMillis();
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
