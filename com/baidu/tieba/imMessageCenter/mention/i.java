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
    private static i dRG = null;
    private final HttpMessageListener bIa = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.yE() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.b.yZ().zb()) {
                    if (msgData.aDa() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yC().setMsgBookmark(msgData.aDa());
                    }
                    if (msgData.aCY() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.yZ().ze()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yC().setMsgAtme(msgData.aCY());
                    }
                    if (msgData.aCX() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.yZ().zg()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yC().setMsgReplyme(msgData.aCX());
                    }
                    if (msgData.aCZ() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.yZ().zf()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yC().setMsgFans(msgData.aCZ());
                    }
                }
            }
        }
    };
    private long dRH = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                i.this.dRH = System.currentTimeMillis();
                if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.j.hh()) {
                    i.this.aDc();
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

    public static synchronized i aDb() {
        i iVar;
        synchronized (i.class) {
            if (dRG == null) {
                dRG = new i();
            }
            iVar = dRG;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.bIa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDc() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void adM() {
        this.dRH = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.dRH;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.dRH = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
