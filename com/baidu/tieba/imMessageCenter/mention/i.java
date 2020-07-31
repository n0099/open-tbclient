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
/* loaded from: classes16.dex */
public class i {
    private static i jqd = null;
    private final HttpMessageListener eaN = new HttpMessageListener(1002500) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            h msgData;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage) && (msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData()) != null) {
                if (msgData.cyW() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgAtme(msgData.cyW());
                }
                if (msgData.cyV() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgReplyme(msgData.cyV());
                }
                if (msgData.cyX() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgFans(msgData.cyX());
                }
                if (msgData.cyU() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bfl().ns(msgData.cyU());
                }
                if (msgData.cyY() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgBookmark(msgData.cyY());
                }
            }
        }
    };
    private long jqe = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.jqe = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                    i.this.cza();
                }
                i.this.z(1, 600000L);
            }
        }
    };

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002500, TbConfig.SERVER_ADDRESS + Config.GET_MSG_ADDRESS);
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized i cyZ() {
        i iVar;
        synchronized (i.class) {
            if (jqd == null) {
                jqd = new i();
            }
            iVar = jqd;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.eaN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cza() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1002500));
    }

    public void restart() {
        this.jqe = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.jqe;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= 600000) {
            i = 2;
            j = 10000;
        } else {
            i = 1;
            j = 600000 - j2;
        }
        z(i, j);
        this.jqe = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, long j) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessageDelayed(obtainMessage, j);
    }
}
