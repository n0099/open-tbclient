package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends HttpMessageListener {
    final /* synthetic */ bm bGT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bm bmVar, int i) {
        super(i);
        this.bGT = bmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002003 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode != 200 || error != 0) {
                bpVar = this.bGT.bGF;
                if (bpVar != null) {
                    bpVar2 = this.bGT.bGF;
                    bpVar2.B(httpResponsedMessage.getErrorString(), false);
                    return;
                }
                return;
            }
            ResponseNetPersonListMessage responseNetPersonListMessage = (ResponseNetPersonListMessage) httpResponsedMessage;
            responseNetPersonListMessage.setModel(this.bGT);
            com.baidu.tbadk.core.data.q data = responseNetPersonListMessage.getData();
            bpVar3 = this.bGT.bGF;
            if (bpVar3 != null) {
                bpVar4 = this.bGT.bGF;
                bpVar4.d(data, false);
            }
        }
    }
}
