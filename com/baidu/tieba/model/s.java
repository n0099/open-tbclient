package com.baidu.tieba.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.message.ResponseReportUserInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends HttpMessageListener {
    final /* synthetic */ r btr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i) {
        super(i);
        this.btr = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        t tVar;
        t tVar2;
        t tVar3;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001522) {
            tVar = this.btr.btp;
            if (tVar != null && (httpResponsedMessage instanceof ResponseReportUserInfoMessage)) {
                ResponseReportUserInfoMessage responseReportUserInfoMessage = (ResponseReportUserInfoMessage) httpResponsedMessage;
                if (responseReportUserInfoMessage.getErrorCode() == 0) {
                    tVar3 = this.btr.btp;
                    tVar3.gI(responseReportUserInfoMessage.getTimeInterval());
                    return;
                }
                tVar2 = this.btr.btp;
                tVar2.onError(responseReportUserInfoMessage.getErrorCode(), responseReportUserInfoMessage.getErrorMsg());
            }
        }
    }
}
