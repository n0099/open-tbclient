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
    private static g bNl = null;
    private HttpMessageListener bNm = new h(this, CmdConfigHttp.MSG_REMINDER_CMD);
    private long bLV = 0;
    private final Handler mHandler = new i(this);

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static synchronized g aco() {
        g gVar;
        synchronized (g.class) {
            if (bNl == null) {
                bNl = new g();
            }
            gVar = bNl;
        }
        return gVar;
    }

    public g() {
        MessageManager.getInstance().registerListener(this.bNm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acp() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fg() {
        return UtilHelper.getNetStatusInfo(TbadkApplication.getInst().getApp().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    public void abY() {
        this.bLV = 0L;
        destroy();
        start();
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis() - this.bLV;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 600000) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 10000L);
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000 - j);
        }
        this.bLV = System.currentTimeMillis();
    }

    public void destroy() {
        this.mHandler.removeMessages(1);
    }
}
