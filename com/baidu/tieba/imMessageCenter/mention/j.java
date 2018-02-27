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
/* loaded from: classes2.dex */
public class j {
    private static j eSG = null;
    private final HttpMessageListener cJi = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.GK() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hr()) {
                    if (msgData.aNB() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgBookmark(msgData.aNB());
                    }
                    if (msgData.aNz() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgAtme(msgData.aNz());
                    }
                    if (msgData.aNy() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgReplyme(msgData.aNy());
                    }
                    if (msgData.aNA() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hv()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgFans(msgData.aNA());
                    }
                    if (msgData.aNx() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.GI().gU(msgData.aNx());
                    }
                }
            }
        }
    };
    private long eSH = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.j.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                j.this.eSH = System.currentTimeMillis();
                if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.j.oJ()) {
                    j.this.aND();
                }
                j.this.mHandler.sendMessageDelayed(j.this.mHandler.obtainMessage(1), 600000L);
            }
        }
    };

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized j aNC() {
        j jVar;
        synchronized (j.class) {
            if (eSG == null) {
                eSG = new j();
            }
            jVar = eSG;
        }
        return jVar;
    }

    public j() {
        MessageManager.getInstance().registerListener(this.cJi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aND() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void restart() {
        this.eSH = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.eSH;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.eSH = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
