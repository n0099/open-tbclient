package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends HttpMessageListener {
    final /* synthetic */ af dFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(af afVar, int i) {
        super(i);
        this.dFS = afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        af.a aVar;
        af.a aVar2;
        af.a aVar3;
        af.a aVar4;
        af.a aVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            int statusCode = httpResponsedMessage.getStatusCode();
            if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                aVar = this.dFS.dFR;
                if (aVar != null) {
                    aVar2 = this.dFS.dFR;
                    aVar2.y(statusCode, null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aVar5 = this.dFS.dFR;
                aVar5.gx(praiseResponseMessage.getErrMsg());
                return;
            }
            aVar3 = this.dFS.dFR;
            if (aVar3 != null) {
                aVar4 = this.dFS.dFR;
                aVar4.y(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
            }
        }
    }
}
