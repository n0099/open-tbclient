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
    private static r bCX = null;
    private final HttpMessageListener bCY = new s(this, CmdConfigHttp.MSG_REMINDER_CMD);
    private long bCZ = 0;
    private final Handler mHandler = new t(this);

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized r XA() {
        r rVar;
        synchronized (r.class) {
            if (bCX == null) {
                bCX = new r();
            }
            rVar = bCX;
        }
        return rVar;
    }

    public r() {
        MessageManager.getInstance().registerListener(this.bCY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XB() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iH() {
        return UtilHelper.getNetStatusInfo(TbadkCoreApplication.m411getInst().getApp().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    public void XC() {
        this.bCZ = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.bCZ;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.bCZ = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
