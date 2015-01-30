package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class g {
    private static g bOV = null;
    private HttpMessageListener bOW = new h(this, CmdConfigHttp.MSG_REMINDER_CMD);
    private long bNF = 0;
    private final Handler mHandler = new i(this);

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized g acS() {
        g gVar;
        synchronized (g.class) {
            if (bOV == null) {
                bOV = new g();
            }
            gVar = bOV;
        }
        return gVar;
    }

    public g() {
        MessageManager.getInstance().registerListener(this.bOW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acT() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ff() {
        return UtilHelper.getNetStatusInfo(TbadkApplication.getInst().getApp().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    public void acC() {
        this.bNF = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.bNF;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.bNF = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
