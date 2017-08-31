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
    private static i dMV = null;
    private final HttpMessageListener dMW = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.zf() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.b.zA().zC()) {
                    if (msgData.aBO() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgBookmark(msgData.aBO());
                    }
                    if (msgData.aBM() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zA().zF()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgAtme(msgData.aBM());
                    }
                    if (msgData.aBL() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zA().zH()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgReplyme(msgData.aBL());
                    }
                    if (msgData.aBN() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zA().zG()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgFans(msgData.aBN());
                    }
                }
            }
        }
    };
    private long dMX = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                i.this.dMX = System.currentTimeMillis();
                if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.i.hi()) {
                    i.this.aBQ();
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

    public static synchronized i aBP() {
        i iVar;
        synchronized (i.class) {
            if (dMV == null) {
                dMV = new i();
            }
            iVar = dMV;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.dMW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBQ() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void abJ() {
        this.dMX = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.dMX;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.dMX = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
