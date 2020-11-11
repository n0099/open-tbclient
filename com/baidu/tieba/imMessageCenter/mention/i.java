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
/* loaded from: classes22.dex */
public class i {
    private static i kve = null;
    private final HttpMessageListener eNk = new HttpMessageListener(1002500) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            h msgData;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage) && (msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData()) != null) {
                if (msgData.cWK() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bvS().setMsgAtme(msgData.cWK());
                }
                if (msgData.cWJ() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bvS().setMsgReplyme(msgData.cWJ());
                }
                if (msgData.cWL() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bvS().setMsgFans(msgData.cWL());
                }
                if (msgData.cWI() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bvS().qI(msgData.cWI());
                }
                if (msgData.cWM() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bvS().setMsgBookmark(msgData.cWM());
                }
            }
        }
    };
    private long kvf = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.kvf = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                    i.this.cWO();
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

    public static synchronized i cWN() {
        i iVar;
        synchronized (i.class) {
            if (kve == null) {
                kve = new i();
            }
            iVar = kve;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.eNk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWO() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1002500));
    }

    public void restart() {
        this.kvf = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.kvf;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= 600000) {
            i = 2;
            j = 10000;
        } else {
            i = 1;
            j = 600000 - j2;
        }
        A(i, j);
        this.kvf = System.currentTimeMillis();
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
