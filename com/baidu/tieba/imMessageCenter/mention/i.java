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
public class i {
    private static i eaD = null;
    private final HttpMessageListener bQr = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.yP() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.b.zk().zm()) {
                    if (msgData.aEN() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgBookmark(msgData.aEN());
                    }
                    if (msgData.aEL() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zk().zp()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgAtme(msgData.aEL());
                    }
                    if (msgData.aEK() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zk().zr()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgReplyme(msgData.aEK());
                    }
                    if (msgData.aEM() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zk().zq()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgFans(msgData.aEM());
                    }
                }
            }
        }
    };
    private long eaE = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                i.this.eaE = System.currentTimeMillis();
                if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.j.hh()) {
                    i.this.aEP();
                }
                i.this.mHandler.sendMessageDelayed(i.this.mHandler.obtainMessage(1), 600000L);
            }
        }
    };

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized i aEO() {
        i iVar;
        synchronized (i.class) {
            if (eaD == null) {
                eaD = new i();
            }
            iVar = eaD;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.bQr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEP() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void afS() {
        this.eaE = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.eaE;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.eaE = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
