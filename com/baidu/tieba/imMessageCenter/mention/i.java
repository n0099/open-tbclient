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
/* loaded from: classes2.dex */
public class i {
    private static i kUh = null;
    private final HttpMessageListener fbX = new HttpMessageListener(1002500) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            h msgData;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage) && (msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData()) != null) {
                if (msgData.cZB() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgAtme(msgData.cZB());
                }
                if (msgData.cZA() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgReplyme(msgData.cZA());
                }
                if (msgData.cZC() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgFans(msgData.cZC());
                }
                if (msgData.cZz() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxE().qt(msgData.cZz());
                }
                if (msgData.cZD() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgBookmark(msgData.cZD());
                }
            }
        }
    };
    private long kUi = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.kUi = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                    i.this.cZF();
                }
                i.this.A(1, 600000L);
            }
        }
    };

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002500, TbConfig.SERVER_ADDRESS + Config.GET_MSG_ADDRESS);
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized i cZE() {
        i iVar;
        synchronized (i.class) {
            if (kUh == null) {
                kUh = new i();
            }
            iVar = kUh;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.fbX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZF() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1002500));
    }

    public void restart() {
        this.kUi = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.kUi;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= 600000) {
            i = 2;
            j = 10000;
        } else {
            i = 1;
            j = 600000 - j2;
        }
        A(i, j);
        this.kUi = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i, long j) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessageDelayed(obtainMessage, j);
    }
}
