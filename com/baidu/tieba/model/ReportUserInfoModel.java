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
    private a dUi;
    private final HttpMessageListener dUj;
    public long timeInterval;

    /* loaded from: classes.dex */
    public interface a {
        void nO(int i);

        void onError(int i, String str);
    }

    public void a(a aVar) {
        this.dUi = aVar;
    }

    public ReportUserInfoModel(Context context) {
        super(null);
        this.timeInterval = TIME_INTERVAL;
        this.dUj = new f(this, CmdConfigHttp.REPORT_USER_INFO);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aEc() {
        return Math.abs(System.currentTimeMillis() - TbadkCoreApplication.m9getInst().getReporyUserInfoLastTime()) >= this.timeInterval;
    }

    public void aEd() {
        TbadkCoreApplication.m9getInst().setReporyUserInfoCurrentTime();
    }

    public void bQ(long j) {
        this.timeInterval = j;
    }

    public void aEe() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REPORT_USER_INFO, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/user/report");
        tbHttpMessageTask.setResponsedClass(ResponseReportUserInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.dUj);
    }

    public void b(int i, float f, float f2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.REPORT_USER_INFO);
        httpMessage.addParam("type", String.valueOf(i));
        httpMessage.addParam("lng", String.valueOf(f));
        httpMessage.addParam("lat", String.valueOf(f2));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.dUj);
    }
}
