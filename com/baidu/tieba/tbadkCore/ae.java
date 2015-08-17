package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends HttpMessageListener {
    final /* synthetic */ ad cHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(ad adVar, int i) {
        super(i);
        this.cHU = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ad.a aVar;
        ad.a aVar2;
        ad.a aVar3;
        ad.a aVar4;
        ad.a aVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                aVar = this.cHU.cHT;
                if (aVar != null) {
                    aVar2 = this.cHU.cHT;
                    aVar2.bF(null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aVar5 = this.cHU.cHT;
                aVar5.fU(praiseResponseMessage.getErrMsg());
                return;
            }
            aVar3 = this.cHU.cHT;
            if (aVar3 != null) {
                aVar4 = this.cHU.cHT;
                aVar4.bF(praiseResponseMessage.getErrMsg());
            }
        }
    }
}
