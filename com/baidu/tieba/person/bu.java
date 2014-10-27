package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends HttpMessageListener {
    final /* synthetic */ bt bDg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(bt btVar, int i) {
        super(i);
        this.bDg = btVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        bw bwVar;
        bw bwVar2;
        bw bwVar3;
        bw bwVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002003 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode != 200 || error != 0) {
                bwVar = this.bDg.bCS;
                if (bwVar != null) {
                    bwVar2 = this.bDg.bCS;
                    bwVar2.D(httpResponsedMessage.getErrorString(), false);
                    return;
                }
                return;
            }
            ResponseNetPersonListMessage responseNetPersonListMessage = (ResponseNetPersonListMessage) httpResponsedMessage;
            responseNetPersonListMessage.setModel(this.bDg);
            com.baidu.tieba.data.aj data = responseNetPersonListMessage.getData();
            bwVar3 = this.bDg.bCS;
            if (bwVar3 != null) {
                bwVar4 = this.bDg.bCS;
                bwVar4.d(data, false);
            }
        }
    }
}
