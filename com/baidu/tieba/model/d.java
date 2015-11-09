package com.baidu.tieba.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.message.ResponseReportUserInfoMessage;
import com.baidu.tieba.model.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends HttpMessageListener {
    final /* synthetic */ c cbN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.cbN = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        c.a aVar;
        c.a aVar2;
        c.a aVar3;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001522) {
            aVar = this.cbN.cbL;
            if (aVar != null && (httpResponsedMessage instanceof ResponseReportUserInfoMessage)) {
                ResponseReportUserInfoMessage responseReportUserInfoMessage = (ResponseReportUserInfoMessage) httpResponsedMessage;
                if (responseReportUserInfoMessage.getErrorCode() == 0) {
                    aVar3 = this.cbN.cbL;
                    aVar3.iI(responseReportUserInfoMessage.getTimeInterval());
                    return;
                }
                aVar2 = this.cbN.cbL;
                aVar2.onError(responseReportUserInfoMessage.getErrorCode(), responseReportUserInfoMessage.getErrorMsg());
            }
        }
    }
}
