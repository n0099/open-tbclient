package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ah {
    private static ah dkM = null;
    private final HttpMessageListener dkN = new ai(this, CmdConfigHttp.MSG_REMINDER_CMD);
    private long dkO = 0;
    private final Handler mHandler = new aj(this);

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized ah avl() {
        ah ahVar;
        synchronized (ah.class) {
            if (dkM == null) {
                dkM = new ah();
            }
            ahVar = dkM;
        }
        return ahVar;
    }

    public ah() {
        MessageManager.getInstance().registerListener(this.dkN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avm() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void avn() {
        this.dkO = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.dkO;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.dkO = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
