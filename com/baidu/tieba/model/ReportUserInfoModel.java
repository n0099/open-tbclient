package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.message.ResponseReportUserInfoMessage;
/* loaded from: classes.dex */
public class ReportUserInfoModel extends BdBaseModel {
    public static final long TIME_INTERVAL = 300000;
    public static final int TYPE_ADDRESS = 1;
    private a ena;
    private final HttpMessageListener enb;
    public long timeInterval;

    /* loaded from: classes.dex */
    public interface a {
        void om(int i);

        void onError(int i, String str);
    }

    public void a(a aVar) {
        this.ena = aVar;
    }

    public ReportUserInfoModel(Context context) {
        super(null);
        this.timeInterval = TIME_INTERVAL;
        this.enb = new HttpMessageListener(CmdConfigHttp.REPORT_USER_INFO) { // from class: com.baidu.tieba.model.ReportUserInfoModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001522 && ReportUserInfoModel.this.ena != null && (httpResponsedMessage instanceof ResponseReportUserInfoMessage)) {
                    ResponseReportUserInfoMessage responseReportUserInfoMessage = (ResponseReportUserInfoMessage) httpResponsedMessage;
                    if (responseReportUserInfoMessage.getErrorCode() == 0) {
                        ReportUserInfoModel.this.ena.om(responseReportUserInfoMessage.getTimeInterval());
                    } else {
                        ReportUserInfoModel.this.ena.onError(responseReportUserInfoMessage.getErrorCode(), responseReportUserInfoMessage.getErrorMsg());
                    }
                }
            }
        };
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aKc() {
        return Math.abs(System.currentTimeMillis() - TbadkCoreApplication.getInst().getReporyUserInfoLastTime()) >= this.timeInterval;
    }

    public void aKd() {
        TbadkCoreApplication.getInst().setReporyUserInfoCurrentTime();
    }

    public void ci(long j) {
        this.timeInterval = j;
    }

    public void aKe() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REPORT_USER_INFO, TbConfig.SERVER_ADDRESS + "c/c/user/report");
        tbHttpMessageTask.setResponsedClass(ResponseReportUserInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.enb);
    }

    public void b(int i, float f, float f2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.REPORT_USER_INFO);
        httpMessage.addParam("type", String.valueOf(i));
        httpMessage.addParam("lng", String.valueOf(f));
        httpMessage.addParam("lat", String.valueOf(f2));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.enb);
    }
}
