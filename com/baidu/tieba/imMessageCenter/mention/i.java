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
    private static i dEs = null;
    private final HttpMessageListener dEt = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.zb() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.b.zw().zy()) {
                    if (msgData.azx() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgBookmark(msgData.azx());
                    }
                    if (msgData.azv() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zw().zB()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgAtme(msgData.azv());
                    }
                    if (msgData.azu() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zw().zD()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgReplyme(msgData.azu());
                    }
                    if (msgData.azw() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zw().zC()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgFans(msgData.azw());
                    }
                }
            }
        }
    };
    private long dEu = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                i.this.dEu = System.currentTimeMillis();
                if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.i.hr()) {
                    i.this.azz();
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

    public static synchronized i azy() {
        i iVar;
        synchronized (i.class) {
            if (dEs == null) {
                dEs = new i();
            }
            iVar = dEs;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.dEt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azz() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void aao() {
        this.dEu = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.dEu;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.dEu = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
