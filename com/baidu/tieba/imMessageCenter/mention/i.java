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
    private static i gya = null;
    private final HttpMessageListener bKu = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.ahz() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.d.aie().aig()) {
                    if (msgData.bxG() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().setMsgBookmark(msgData.bxG());
                    }
                    if (msgData.bxE() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().setMsgAtme(msgData.bxE());
                    }
                    if (msgData.bxD() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().setMsgReplyme(msgData.bxD());
                    }
                    if (msgData.bxF() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.d.aie().aik()) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().setMsgFans(msgData.bxF());
                    }
                    if (msgData.bxC() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().iB(msgData.bxC());
                    }
                }
            }
        }
    };
    private long gyb = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.gyb = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.kY())) {
                    i.this.bxI();
                }
                i.this.m(1, KeepJobService.JOB_CHECK_PERIODIC);
            }
        }
    };

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized i bxH() {
        i iVar;
        synchronized (i.class) {
            if (gya == null) {
                gya = new i();
            }
            iVar = gya;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.bKu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxI() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void restart() {
        this.gyb = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.gyb;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= KeepJobService.JOB_CHECK_PERIODIC) {
            i = 2;
            j = 10000;
        } else {
            i = 1;
            j = KeepJobService.JOB_CHECK_PERIODIC - j2;
        }
        m(i, j);
        this.gyb = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, long j) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessageDelayed(obtainMessage, j);
    }
}
