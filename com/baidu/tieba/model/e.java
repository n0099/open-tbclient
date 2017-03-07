package com.baidu.tieba.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.message.ResponseReportUserInfoMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends HttpMessageListener {
    final /* synthetic */ ReportUserInfoModel dUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ReportUserInfoModel reportUserInfoModel, int i) {
        super(i);
        this.dUG = reportUserInfoModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ReportUserInfoModel.a aVar;
        ReportUserInfoModel.a aVar2;
        ReportUserInfoModel.a aVar3;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001522) {
            aVar = this.dUG.dUE;
            if (aVar != null && (httpResponsedMessage instanceof ResponseReportUserInfoMessage)) {
                ResponseReportUserInfoMessage responseReportUserInfoMessage = (ResponseReportUserInfoMessage) httpResponsedMessage;
                if (responseReportUserInfoMessage.getErrorCode() == 0) {
                    aVar3 = this.dUG.dUE;
                    aVar3.nB(responseReportUserInfoMessage.getTimeInterval());
                    return;
                }
                aVar2 = this.dUG.dUE;
                aVar2.onError(responseReportUserInfoMessage.getErrorCode(), responseReportUserInfoMessage.getErrorMsg());
            }
        }
    }
}
