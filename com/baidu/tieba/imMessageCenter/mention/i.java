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
    private static i dKh = null;
    private final HttpMessageListener dKi = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.yD() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.b.yY().za()) {
                    if (msgData.aAK() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yB().setMsgBookmark(msgData.aAK());
                    }
                    if (msgData.aAI() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.yY().zd()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yB().setMsgAtme(msgData.aAI());
                    }
                    if (msgData.aAH() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.yY().zf()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yB().setMsgReplyme(msgData.aAH());
                    }
                    if (msgData.aAJ() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.yY().ze()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.yB().setMsgFans(msgData.aAJ());
                    }
                }
            }
        }
    };
    private long dKj = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                i.this.dKj = System.currentTimeMillis();
                if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.j.hh()) {
                    i.this.aAM();
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

    public static synchronized i aAL() {
        i iVar;
        synchronized (i.class) {
            if (dKh == null) {
                dKh = new i();
            }
            iVar = dKh;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.dKi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAM() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void abH() {
        this.dKj = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.dKj;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.dKj = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
