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
/* loaded from: classes9.dex */
public class i {
    private static i iAL = null;
    private final HttpMessageListener dzA = new HttpMessageListener(1002500) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.aTg() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTN()) {
                    if (msgData.ckA() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().setMsgBookmark(msgData.ckA());
                    }
                    if (msgData.cky() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().setMsgAtme(msgData.cky());
                    }
                    if (msgData.ckx() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().setMsgReplyme(msgData.ckx());
                    }
                    if (msgData.ckz() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTR()) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().setMsgFans(msgData.ckz());
                    }
                    if (msgData.ckw() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().mb(msgData.ckw());
                    }
                }
            }
        }
    };
    private long iAM = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.iAM = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                    i.this.ckC();
                }
                i.this.y(1, 600000L);
            }
        }
    };

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002500, TbConfig.SERVER_ADDRESS + Config.GET_MSG_ADDRESS);
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized i ckB() {
        i iVar;
        synchronized (i.class) {
            if (iAL == null) {
                iAL = new i();
            }
            iVar = iAL;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.dzA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckC() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1002500));
    }

    public void restart() {
        this.iAM = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.iAM;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= 600000) {
            i = 2;
            j = 10000;
        } else {
            i = 1;
            j = 600000 - j2;
        }
        y(i, j);
        this.iAM = System.currentTimeMillis();
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
