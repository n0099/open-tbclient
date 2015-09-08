package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends HttpMessageListener {
    final /* synthetic */ ae cQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(ae aeVar, int i) {
        super(i);
        this.cQu = aeVar;
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
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                aVar = this.cQu.cQt;
                if (aVar != null) {
                    aVar2 = this.cQu.cQt;
                    aVar2.bF(null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aVar5 = this.cQu.cQt;
                aVar5.gb(praiseResponseMessage.getErrMsg());
                return;
            }
            aVar3 = this.cQu.cQt;
            if (aVar3 != null) {
                aVar4 = this.cQu.cQt;
                aVar4.bF(praiseResponseMessage.getErrMsg());
            }
        }
    }
}
