package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends HttpMessageListener {
    final /* synthetic */ af dyy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(af afVar, int i) {
        super(i);
        this.dyy = afVar;
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
                aVar = this.dyy.dyx;
                if (aVar != null) {
                    aVar2 = this.dyy.dyx;
                    aVar2.y(statusCode, null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aVar5 = this.dyy.dyx;
                aVar5.gt(praiseResponseMessage.getErrMsg());
                return;
            }
            aVar3 = this.dyy.dyx;
            if (aVar3 != null) {
                aVar4 = this.dyy.dyx;
                aVar4.y(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
            }
        }
    }
}
