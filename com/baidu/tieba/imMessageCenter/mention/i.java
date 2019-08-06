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
    private static i gWs = null;
    private final HttpMessageListener bTl = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.anH() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoo()) {
                    if (msgData.bIn() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anF().setMsgBookmark(msgData.bIn());
                    }
                    if (msgData.bIl() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anF().setMsgAtme(msgData.bIl());
                    }
                    if (msgData.bIk() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anF().setMsgReplyme(msgData.bIk());
                    }
                    if (msgData.bIm() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.d.aom().aos()) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anF().setMsgFans(msgData.bIm());
                    }
                    if (msgData.bIj() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.anF().jw(msgData.bIj());
                    }
                }
            }
        }
    };
    private long gWt = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.gWt = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.kc())) {
                    i.this.bIp();
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

    public static synchronized i bIo() {
        i iVar;
        synchronized (i.class) {
            if (gWs == null) {
                gWs = new i();
            }
            iVar = gWs;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.bTl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIp() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void restart() {
        this.gWt = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.gWt;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= KeepJobService.JOB_CHECK_PERIODIC) {
            i = 2;
            j = 10000;
        } else {
            i = 1;
            j = KeepJobService.JOB_CHECK_PERIODIC - j2;
        }
        u(i, j);
        this.gWt = System.currentTimeMillis();
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
