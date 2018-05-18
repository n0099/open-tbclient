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
    private static i eoC = null;
    private final HttpMessageListener can = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.zy() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Af()) {
                    if (msgData.aID() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.zw().setMsgBookmark(msgData.aID());
                    }
                    if (msgData.aIB() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.zw().setMsgAtme(msgData.aIB());
                    }
                    if (msgData.aIA() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.zw().setMsgReplyme(msgData.aIA());
                    }
                    if (msgData.aIC() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Aj()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.zw().setMsgFans(msgData.aIC());
                    }
                    if (msgData.aIz() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.zw().dT(msgData.aIz());
                    }
                }
            }
        }
    };
    private long eoD = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.eoD = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.gP())) {
                    i.this.aIF();
                }
                i.this.j(1, 600000L);
            }
        }
    };

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized i aIE() {
        i iVar;
        synchronized (i.class) {
            if (eoC == null) {
                eoC = new i();
            }
            iVar = eoC;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.can);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIF() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void restart() {
        this.eoD = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.eoD;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= 600000) {
            i = 2;
            j = 10000;
        } else {
            i = 1;
            j = 600000 - j2;
        }
        j(i, j);
        this.eoD = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, long j) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessageDelayed(obtainMessage, j);
    }
}
