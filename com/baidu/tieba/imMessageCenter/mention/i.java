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
    private static i eOE = null;
    private final HttpMessageListener cFy = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.Gj() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.b.GE().GG()) {
                    if (msgData.aLY() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgBookmark(msgData.aLY());
                    }
                    if (msgData.aLW() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.GE().GJ()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgAtme(msgData.aLW());
                    }
                    if (msgData.aLV() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.GE().GL()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgReplyme(msgData.aLV());
                    }
                    if (msgData.aLX() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.GE().GK()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgFans(msgData.aLX());
                    }
                }
            }
        }
    };
    private long eOF = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                i.this.eOF = System.currentTimeMillis();
                if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.j.oJ()) {
                    i.this.aMa();
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

    public static synchronized i aLZ() {
        i iVar;
        synchronized (i.class) {
            if (eOE == null) {
                eOE = new i();
            }
            iVar = eOE;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.cFy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMa() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void restart() {
        this.eOF = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.eOF;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.eOF = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
