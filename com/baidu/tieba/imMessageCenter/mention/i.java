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
/* loaded from: classes2.dex */
public class i {
    private static i eOO = null;
    private final HttpMessageListener asW = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.EA() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fh()) {
                    if (msgData.aRq() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgBookmark(msgData.aRq());
                    }
                    if (msgData.aRo() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgAtme(msgData.aRo());
                    }
                    if (msgData.aRn() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgReplyme(msgData.aRn());
                    }
                    if (msgData.aRp() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fl()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgFans(msgData.aRp());
                    }
                    if (msgData.aRm() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Ey().ek(msgData.aRm());
                    }
                }
            }
        }
    };
    private long eOP = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.eOP = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.kK())) {
                    i.this.aRs();
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

    public static synchronized i aRr() {
        i iVar;
        synchronized (i.class) {
            if (eOO == null) {
                eOO = new i();
            }
            iVar = eOO;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.asW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRs() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void restart() {
        this.eOP = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.eOP;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= KeepJobService.JOB_CHECK_PERIODIC) {
            i = 2;
            j = 10000;
        } else {
            i = 1;
            j = KeepJobService.JOB_CHECK_PERIODIC - j2;
        }
        j(i, j);
        this.eOP = System.currentTimeMillis();
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
