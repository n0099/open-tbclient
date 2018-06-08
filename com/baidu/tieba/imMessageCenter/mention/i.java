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
    private static i ezT = null;
    private final HttpMessageListener cir = new HttpMessageListener(CmdConfigHttp.MSG_REMINDER_CMD) { // from class: com.baidu.tieba.imMessageCenter.mention.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
                h msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
                if (!com.baidu.tbadk.coreExtra.messageCenter.a.CZ() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.DE().DG()) {
                    if (msgData.aNy() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgBookmark(msgData.aNy());
                    }
                    if (msgData.aNw() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgAtme(msgData.aNw());
                    }
                    if (msgData.aNv() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgReplyme(msgData.aNv());
                    }
                    if (msgData.aNx() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.DE().DK()) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgFans(msgData.aNx());
                    }
                    if (msgData.aNu() >= 0) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.CX().dV(msgData.aNu());
                    }
                }
            }
        }
    };
    private long ezU = 0;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.imMessageCenter.mention.i.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                i.this.ezU = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().isValid();
                if (i == 2 || (z && com.baidu.adp.lib.util.j.jD())) {
                    i.this.aNA();
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

    public static synchronized i aNz() {
        i iVar;
        synchronized (i.class) {
            if (ezT == null) {
                ezT = new i();
            }
            iVar = ezT;
        }
        return iVar;
    }

    public i() {
        MessageManager.getInstance().registerListener(this.cir);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNA() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void restart() {
        this.ezU = 0L;
        destroy();
        start();
    }

    public void start() {
        int i;
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.ezU;
        long j2 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j2 >= 600000) {
            i = 2;
            j = 10000;
        } else {
            i = 1;
            j = 600000 - j2;
        }
        j(i, j);
        this.ezU = System.currentTimeMillis();
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
