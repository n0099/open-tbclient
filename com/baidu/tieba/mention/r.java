package com.baidu.tieba.mention;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class r {
    private static r bGf = null;
    private final HttpMessageListener bGg = new s(this, CmdConfigHttp.MSG_REMINDER_CMD);
    private long bGh = 0;
    private final Handler mHandler = new t(this);

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized r Zl() {
        r rVar;
        synchronized (r.class) {
            if (bGf == null) {
                bGf = new r();
            }
            rVar = bGf;
        }
        return rVar;
    }

    public r() {
        MessageManager.getInstance().registerListener(this.bGg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zm() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iX() {
        return UtilHelper.getNetStatusInfo(TbadkCoreApplication.m411getInst().getApp().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    public void Zn() {
        this.bGh = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.bGh;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.bGh = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
