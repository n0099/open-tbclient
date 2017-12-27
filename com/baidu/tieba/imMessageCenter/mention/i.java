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
    private static i eMK = null;
    private final HttpMessageListener cFb = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.Go() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.b.GJ().GL()) {
                    if (msgData.aLO() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().setMsgBookmark(msgData.aLO());
                    }
                    if (msgData.aLM() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.GJ().GO()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().setMsgAtme(msgData.aLM());
                    }
                    if (msgData.aLL() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.GJ().GQ()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().setMsgReplyme(msgData.aLL());
                    }
                    if (msgData.aLN() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.GJ().GP()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().setMsgFans(msgData.aLN());
                    }
                }
            }
        }
    };
    private long eML = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                i.this.eML = System.currentTimeMillis();
                if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.j.oI()) {
                    i.this.aLQ();
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

    public static synchronized i aLP() {
        i iVar;
        synchronized (i.class) {
            if (eMK == null) {
                eMK = new i();
            }
            iVar = eMK;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.cFb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLQ() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void restart() {
        this.eML = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.eML;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.eML = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
