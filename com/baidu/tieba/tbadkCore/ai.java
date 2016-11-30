package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.ah;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends HttpMessageListener {
    final /* synthetic */ ah fBo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(ah ahVar, int i) {
        super(i);
        this.fBo = ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ah.a aVar;
        ah.a aVar2;
        ah.a aVar3;
        ah.a aVar4;
        ah.a aVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            int statusCode = httpResponsedMessage.getStatusCode();
            if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                aVar = this.fBo.fBn;
                if (aVar != null) {
                    aVar2 = this.fBo.fBn;
                    aVar2.L(statusCode, null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aVar5 = this.fBo.fBn;
                aVar5.hB(praiseResponseMessage.getErrMsg());
                return;
            }
            aVar3 = this.fBo.fBn;
            if (aVar3 != null) {
                aVar4 = this.fBo.fBn;
                aVar4.L(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
            }
        }
    }
}
