package com.baidu.tieba.mention;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class v {
    private static v cbd = null;
    private final HttpMessageListener cbe = new w(this, CmdConfigHttp.MSG_REMINDER_CMD);
    private long cbf = 0;
    private final Handler mHandler = new x(this);

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized v adq() {
        v vVar;
        synchronized (v.class) {
            if (cbd == null) {
                cbd = new v();
            }
            vVar = cbd;
        }
        return vVar;
    }

    public v() {
        MessageManager.getInstance().registerListener(this.cbe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adr() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iN() {
        return com.baidu.adp.lib.util.i.iN();
    }

    public void ads() {
        this.cbf = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.cbf;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.cbf = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
