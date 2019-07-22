package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
/* loaded from: classes4.dex */
public class i {
    private static i gVA = null;
    private final HttpMessageListener bTf = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.anF() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.d.aok().aom()) {
                    if (msgData.bHZ() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anD().setMsgBookmark(msgData.bHZ());
                    }
                    if (msgData.bHX() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anD().setMsgAtme(msgData.bHX());
                    }
                    if (msgData.bHW() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anD().setMsgReplyme(msgData.bHW());
                    }
                    if (msgData.bHY() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoq()) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anD().setMsgFans(msgData.bHY());
                    }
                    if (msgData.bHV() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anD().jv(msgData.bHV());
                    }
                }
            }
        }
    };
    private long gVB = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.gVB = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.kc())) {
                    i.this.bIb();
                }
                i.this.u(1, KeepJobService.JOB_CHECK_PERIODIC);
            }
        }
    };

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized i bIa() {
        i iVar;
        synchronized (i.class) {
            if (gVA == null) {
                gVA = new i();
            }
            iVar = gVA;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.bTf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIb() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void restart() {
        this.gVB = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.gVB;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= KeepJobService.JOB_CHECK_PERIODIC) {
            i = 2;
            j = 10000;
        } else {
            i = 1;
            j = KeepJobService.JOB_CHECK_PERIODIC - j2;
        }
        u(i, j);
        this.gVB = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, long j) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessageDelayed(obtainMessage, j);
    }
}
