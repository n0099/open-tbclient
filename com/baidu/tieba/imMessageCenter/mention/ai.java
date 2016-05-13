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
    private static ai cyG = null;
    private final HttpMessageListener cyH = new aj(this, CmdConfigHttp.MSG_REMINDER_CMD);
    private long cyI = 0;
    private final Handler mHandler = new ak(this);

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized ai alq() {
        ai aiVar;
        synchronized (ai.class) {
            if (cyG == null) {
                cyG = new ai();
            }
            aiVar = cyG;
        }
        return aiVar;
    }

    public ai() {
        MessageManager.getInstance().registerListener(this.cyH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alr() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fq() {
        return com.baidu.adp.lib.util.i.fq();
    }

    public void als() {
        this.cyI = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.cyI;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.cyI = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
