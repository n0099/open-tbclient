package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.message.ResponseReportUserInfoMessage;
/* loaded from: classes.dex */
public class ReportUserInfoModel extends BdBaseModel {
    public static final long TIME_INTERVAL = 300000;
    public static final int TYPE_ADDRESS = 1;
    private a dOL;
    private final HttpMessageListener dOM;
    public long timeInterval;

    /* loaded from: classes.dex */
    public interface a {
        void nv(int i);

        void onError(int i, String str);
    }

    public void a(a aVar) {
        this.dOL = aVar;
    }

    public ReportUserInfoModel(Context context) {
        super(null);
        this.timeInterval = TIME_INTERVAL;
        this.dOM = new e(this, CmdConfigHttp.REPORT_USER_INFO);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aDf() {
        return Math.abs(System.currentTimeMillis() - TbadkCoreApplication.m9getInst().getReporyUserInfoLastTime()) >= this.timeInterval;
    }

    public void aDg() {
        TbadkCoreApplication.m9getInst().setReporyUserInfoCurrentTime();
    }

    public void bN(long j) {
        this.timeInterval = j;
    }

    public void aDh() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REPORT_USER_INFO, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/user/report");
        tbHttpMessageTask.setResponsedClass(ResponseReportUserInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.dOM);
    }

    public void b(int i, float f, float f2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.REPORT_USER_INFO);
        httpMessage.addParam("type", String.valueOf(i));
        httpMessage.addParam("lng", String.valueOf(f));
        httpMessage.addParam("lat", String.valueOf(f2));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.dOM);
    }
}
