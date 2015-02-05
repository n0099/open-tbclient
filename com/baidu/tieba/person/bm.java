package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends HttpMessageListener {
    final /* synthetic */ bl bIE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(bl blVar, int i) {
        super(i);
        this.bIE = blVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        bo boVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002003 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode != 200 || error != 0) {
                boVar = this.bIE.bIq;
                if (boVar != null) {
                    boVar2 = this.bIE.bIq;
                    boVar2.A(httpResponsedMessage.getErrorString(), false);
                    return;
                }
                return;
            }
            ResponseNetPersonListMessage responseNetPersonListMessage = (ResponseNetPersonListMessage) httpResponsedMessage;
            responseNetPersonListMessage.setModel(this.bIE);
            com.baidu.tbadk.core.data.r data = responseNetPersonListMessage.getData();
            boVar3 = this.bIE.bIq;
            if (boVar3 != null) {
                boVar4 = this.bIE.bIq;
                boVar4.d(data, false);
            }
        }
    }
}
