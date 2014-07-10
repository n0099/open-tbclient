package com.baidu.tieba.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.message.ResponseReportUserInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends HttpMessageListener {
    final /* synthetic */ ax a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(ax axVar, int i) {
        super(i);
        this.a = axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        az azVar;
        az azVar2;
        az azVar3;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001522) {
            azVar = this.a.b;
            if (azVar != null && (httpResponsedMessage instanceof ResponseReportUserInfoMessage)) {
                ResponseReportUserInfoMessage responseReportUserInfoMessage = (ResponseReportUserInfoMessage) httpResponsedMessage;
                if (responseReportUserInfoMessage.getErrorCode() == 0) {
                    azVar3 = this.a.b;
                    azVar3.a();
                    return;
                }
                azVar2 = this.a.b;
                azVar2.a(responseReportUserInfoMessage.getErrorCode(), responseReportUserInfoMessage.getErrorMsg());
            }
        }
    }
}
