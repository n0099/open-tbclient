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
    private static i dDb = null;
    private final HttpMessageListener dDc = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.yT() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.b.zo().zq()) {
                    if (msgData.azm() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yR().setMsgBookmark(msgData.azm());
                    }
                    if (msgData.azk() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zo().zt()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yR().setMsgAtme(msgData.azk());
                    }
                    if (msgData.azj() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zo().zv()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yR().setMsgReplyme(msgData.azj());
                    }
                    if (msgData.azl() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zo().zu()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yR().setMsgFans(msgData.azl());
                    }
                }
            }
        }
    };
    private long dDd = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                i.this.dDd = System.currentTimeMillis();
                if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.i.hh()) {
                    i.this.azo();
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

    public static synchronized i azn() {
        i iVar;
        synchronized (i.class) {
            if (dDb == null) {
                dDb = new i();
            }
            iVar = dDb;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.dDc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azo() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void aaj() {
        this.dDd = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.dDd;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.dDd = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
