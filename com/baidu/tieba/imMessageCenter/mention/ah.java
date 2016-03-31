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
    private static ah cxH = null;
    private final HttpMessageListener cxI = new ai(this, CmdConfigHttp.MSG_REMINDER_CMD);
    private long cxJ = 0;
    private final Handler mHandler = new aj(this);

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized ah ali() {
        ah ahVar;
        synchronized (ah.class) {
            if (cxH == null) {
                cxH = new ah();
            }
            ahVar = cxH;
        }
        return ahVar;
    }

    public ah() {
        MessageManager.getInstance().registerListener(this.cxI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jf() {
        return com.baidu.adp.lib.util.i.jf();
    }

    public void restart() {
        this.cxJ = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.cxJ;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.cxJ = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
