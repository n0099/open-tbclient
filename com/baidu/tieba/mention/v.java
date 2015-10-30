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
    private static v caC = null;
    private final HttpMessageListener caD = new w(this, CmdConfigHttp.MSG_REMINDER_CMD);
    private long caE = 0;
    private final Handler mHandler = new x(this);

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized v acV() {
        v vVar;
        synchronized (v.class) {
            if (caC == null) {
                caC = new v();
            }
            vVar = caC;
        }
        return vVar;
    }

    public v() {
        MessageManager.getInstance().registerListener(this.caD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acW() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iM() {
        return com.baidu.adp.lib.util.i.iM();
    }

    public void acX() {
        this.caE = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.caE;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.caE = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
