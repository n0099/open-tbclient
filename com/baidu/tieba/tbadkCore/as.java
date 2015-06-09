package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends HttpMessageListener {
    final /* synthetic */ ar crt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(ar arVar, int i) {
        super(i);
        this.crt = arVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        at atVar;
        at atVar2;
        at atVar3;
        at atVar4;
        at atVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                atVar = this.crt.crs;
                if (atVar != null) {
                    atVar2 = this.crt.crs;
                    atVar2.fB(null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                atVar5 = this.crt.crs;
                atVar5.fA(praiseResponseMessage.getErrMsg());
                return;
            }
            atVar3 = this.crt.crs;
            if (atVar3 != null) {
                atVar4 = this.crt.crs;
                atVar4.fB(praiseResponseMessage.getErrMsg());
            }
        }
    }
}
