package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ai {
    private static ai dec = null;
    private final HttpMessageListener ded = new aj(this, CmdConfigHttp.MSG_REMINDER_CMD);
    private long dee = 0;
    private final Handler mHandler = new ak(this);

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized ai atD() {
        ai aiVar;
        synchronized (ai.class) {
            if (dec == null) {
                dec = new ai();
            }
            aiVar = dec;
        }
        return aiVar;
    }

    public ai() {
        MessageManager.getInstance().registerListener(this.ded);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atE() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fr() {
        return com.baidu.adp.lib.util.i.fr();
    }

    public void atF() {
        this.dee = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.dee;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.dee = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
