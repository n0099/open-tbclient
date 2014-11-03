package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends HttpMessageListener {
    final /* synthetic */ bu bDu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(bu buVar, int i) {
        super(i);
        this.bDu = buVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        bx bxVar;
        bx bxVar2;
        bx bxVar3;
        bx bxVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002003 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode != 200 || error != 0) {
                bxVar = this.bDu.bDg;
                if (bxVar != null) {
                    bxVar2 = this.bDu.bDg;
                    bxVar2.D(httpResponsedMessage.getErrorString(), false);
                    return;
                }
                return;
            }
            ResponseNetPersonListMessage responseNetPersonListMessage = (ResponseNetPersonListMessage) httpResponsedMessage;
            responseNetPersonListMessage.setModel(this.bDu);
            com.baidu.tieba.data.aj data = responseNetPersonListMessage.getData();
            bxVar3 = this.bDu.bDg;
            if (bxVar3 != null) {
                bxVar4 = this.bDu.bDg;
                bxVar4.d(data, false);
            }
        }
    }
}
