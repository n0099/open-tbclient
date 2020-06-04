package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
/* loaded from: classes9.dex */
public class i {
    private static i iQf = null;
    private final HttpMessageListener dNE = new HttpMessageListener(1002500) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.aZo() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.d.aZT().aZV()) {
                    if (msgData.crh() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZm().setMsgBookmark(msgData.crh());
                    }
                    if (msgData.crf() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZm().setMsgAtme(msgData.crf());
                    }
                    if (msgData.cre() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZm().setMsgReplyme(msgData.cre());
                    }
                    if (msgData.crg() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.d.aZT().aZZ()) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZm().setMsgFans(msgData.crg());
                    }
                    if (msgData.crd() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZm().mG(msgData.crd());
                    }
                }
            }
        }
    };
    private long iQg = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.iQg = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                    i.this.crj();
                }
                i.this.y(1, KeepJobService.JOB_CHECK_PERIODIC);
            }
        }
    };

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002500, TbConfig.SERVER_ADDRESS + Config.GET_MSG_ADDRESS);
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized i cri() {
        i iVar;
        synchronized (i.class) {
            if (iQf == null) {
                iQf = new i();
            }
            iVar = iQf;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.dNE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crj() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1002500));
    }

    public void restart() {
        this.iQg = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.iQg;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= KeepJobService.JOB_CHECK_PERIODIC) {
            i = 2;
            j = 10000;
        } else {
            i = 1;
            j = KeepJobService.JOB_CHECK_PERIODIC - j2;
        }
        y(i, j);
        this.iQg = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i, long j) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessageDelayed(obtainMessage, j);
    }
}
