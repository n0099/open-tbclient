package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends HttpMessageListener {
    final /* synthetic */ ae cXN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(ae aeVar, int i) {
        super(i);
        this.cXN = aeVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ae.a aVar;
        ae.a aVar2;
        ae.a aVar3;
        ae.a aVar4;
        ae.a aVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            int statusCode = httpResponsedMessage.getStatusCode();
            if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                aVar = this.cXN.cXM;
                if (aVar != null) {
                    aVar2 = this.cXN.cXM;
                    aVar2.y(statusCode, null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aVar5 = this.cXN.cXM;
                aVar5.ge(praiseResponseMessage.getErrMsg());
                return;
            }
            aVar3 = this.cXN.cXM;
            if (aVar3 != null) {
                aVar4 = this.cXN.cXM;
                aVar4.y(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
            }
        }
    }
}
