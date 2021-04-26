package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.message.ResponseReportUserInfoMessage;
/* loaded from: classes3.dex */
public class ReportUserInfoModel extends BdBaseModel {
    public static final long TIME_INTERVAL = 300000;
    public static final int TYPE_ADDRESS = 1;

    /* renamed from: e  reason: collision with root package name */
    public b f19148e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f19149f;
    public long timeInterval;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001522 || ReportUserInfoModel.this.f19148e == null || !(httpResponsedMessage instanceof ResponseReportUserInfoMessage)) {
                return;
            }
            ResponseReportUserInfoMessage responseReportUserInfoMessage = (ResponseReportUserInfoMessage) httpResponsedMessage;
            if (responseReportUserInfoMessage.getErrorCode() == 0) {
                ReportUserInfoModel.this.f19148e.a(responseReportUserInfoMessage.getTimeInterval());
            } else {
                ReportUserInfoModel.this.f19148e.onError(responseReportUserInfoMessage.getErrorCode(), responseReportUserInfoMessage.getErrorMsg());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2);

        void onError(int i2, String str);
    }

    public ReportUserInfoModel(Context context) {
        super(null);
        this.timeInterval = 300000L;
        this.f19149f = new a(CmdConfigHttp.REPORT_USER_INFO);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean t() {
        return Math.abs(System.currentTimeMillis() - TbadkCoreApplication.getInst().getReporyUserInfoLastTime()) >= this.timeInterval;
    }

    public void u() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REPORT_USER_INFO, TbConfig.SERVER_ADDRESS + "c/c/user/report");
        tbHttpMessageTask.setResponsedClass(ResponseReportUserInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.f19149f);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.f19149f);
    }

    public void v(int i2, float f2, float f3) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.REPORT_USER_INFO);
        httpMessage.addParam("type", String.valueOf(i2));
        httpMessage.addParam(SuggestAddrField.KEY_LNG, String.valueOf(f2));
        httpMessage.addParam(SuggestAddrField.KEY_LAT, String.valueOf(f3));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void w() {
        TbadkCoreApplication.getInst().setReporyUserInfoCurrentTime();
    }

    public void x(long j) {
        this.timeInterval = j;
    }

    public void y(b bVar) {
        this.f19148e = bVar;
    }
}
