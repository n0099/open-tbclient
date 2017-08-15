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
    private static i dGp = null;
    private final HttpMessageListener dGq = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.zb() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.b.zw().zy()) {
                    if (msgData.aAe() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgBookmark(msgData.aAe());
                    }
                    if (msgData.aAc() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zw().zB()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgAtme(msgData.aAc());
                    }
                    if (msgData.aAb() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zw().zD()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgReplyme(msgData.aAb());
                    }
                    if (msgData.aAd() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zw().zC()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgFans(msgData.aAd());
                    }
                }
            }
        }
    };
    private long dGr = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                i.this.dGr = System.currentTimeMillis();
                if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.i.hr()) {
                    i.this.aAg();
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

    public static synchronized i aAf() {
        i iVar;
        synchronized (i.class) {
            if (dGp == null) {
                dGp = new i();
            }
            iVar = dGp;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.dGq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAg() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void aaJ() {
        this.dGr = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.dGr;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.dGr = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
