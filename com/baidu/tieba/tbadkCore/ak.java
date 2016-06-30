package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends HttpMessageListener {
    final /* synthetic */ aj eWz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(aj ajVar, int i) {
        super(i);
        this.eWz = ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        aj.a aVar;
        aj.a aVar2;
        aj.a aVar3;
        aj.a aVar4;
        aj.a aVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            int statusCode = httpResponsedMessage.getStatusCode();
            if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                aVar = this.eWz.eWy;
                if (aVar != null) {
                    aVar2 = this.eWz.eWy;
                    aVar2.u(statusCode, null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aVar5 = this.eWz.eWy;
                aVar5.gR(praiseResponseMessage.getErrMsg());
                return;
            }
            aVar3 = this.eWz.eWy;
            if (aVar3 != null) {
                aVar4 = this.eWz.eWy;
                aVar4.u(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
            }
        }
    }
}
