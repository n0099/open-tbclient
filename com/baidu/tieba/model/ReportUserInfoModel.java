package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.message.ResponseReportUserInfoMessage;
/* loaded from: classes.dex */
public class ReportUserInfoModel extends BdBaseModel {
    public static final long TIME_INTERVAL = 300000;
    public static final int TYPE_ADDRESS = 1;
    private a iny;
    private final HttpMessageListener inz;
    public long timeInterval;

    /* loaded from: classes.dex */
    public interface a {
        void onError(int i, String str);

        void onSuccess(int i);
    }

    public void a(a aVar) {
        this.iny = aVar;
    }

    public ReportUserInfoModel(Context context) {
        super(null);
        this.timeInterval = 300000L;
        this.inz = new HttpMessageListener(1001522) { // from class: com.baidu.tieba.model.ReportUserInfoModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001522 && ReportUserInfoModel.this.iny != null && (httpResponsedMessage instanceof ResponseReportUserInfoMessage)) {
                    ResponseReportUserInfoMessage responseReportUserInfoMessage = (ResponseReportUserInfoMessage) httpResponsedMessage;
                    if (responseReportUserInfoMessage.getErrorCode() == 0) {
                        ReportUserInfoModel.this.iny.onSuccess(responseReportUserInfoMessage.getTimeInterval());
                    } else {
                        ReportUserInfoModel.this.iny.onError(responseReportUserInfoMessage.getErrorCode(), responseReportUserInfoMessage.getErrorMsg());
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

    public boolean ceL() {
        return Math.abs(System.currentTimeMillis() - TbadkCoreApplication.getInst().getReporyUserInfoLastTime()) >= this.timeInterval;
    }

    public void ceM() {
        TbadkCoreApplication.getInst().setReporyUserInfoCurrentTime();
    }

    public void ej(long j) {
        this.timeInterval = j;
    }

    public void ceN() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001522, TbConfig.SERVER_ADDRESS + Config.REPORT_USER_INFO);
        tbHttpMessageTask.setResponsedClass(ResponseReportUserInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.inz);
    }

    public void a(int i, float f, float f2) {
        HttpMessage httpMessage = new HttpMessage(1001522);
        httpMessage.addParam("type", String.valueOf(i));
        httpMessage.addParam("lng", String.valueOf(f));
        httpMessage.addParam("lat", String.valueOf(f2));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.inz);
    }
}
