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
    private static i dRK = null;
    private final HttpMessageListener bIn = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.yM() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.b.zh().zj()) {
                    if (msgData.aDe() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgBookmark(msgData.aDe());
                    }
                    if (msgData.aDc() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zh().zm()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgAtme(msgData.aDc());
                    }
                    if (msgData.aDb() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zh().zo()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgReplyme(msgData.aDb());
                    }
                    if (msgData.aDd() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zh().zn()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgFans(msgData.aDd());
                    }
                }
            }
        }
    };
    private long dRL = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                i.this.dRL = System.currentTimeMillis();
                if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.j.hh()) {
                    i.this.aDg();
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

    public static synchronized i aDf() {
        i iVar;
        synchronized (i.class) {
            if (dRK == null) {
                dRK = new i();
            }
            iVar = dRK;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.bIn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDg() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void adY() {
        this.dRL = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.dRL;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.dRL = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
