package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends HttpMessageListener {
    final /* synthetic */ ai fru;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, int i) {
        super(i);
        this.fru = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ai.a aVar;
        ai.a aVar2;
        ai.a aVar3;
        ai.a aVar4;
        ai.a aVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            int statusCode = httpResponsedMessage.getStatusCode();
            if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                aVar = this.fru.frt;
                if (aVar != null) {
                    aVar2 = this.fru.frt;
                    aVar2.v(statusCode, null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aVar5 = this.fru.frt;
                aVar5.hu(praiseResponseMessage.getErrMsg());
                return;
            }
            aVar3 = this.fru.frt;
            if (aVar3 != null) {
                aVar4 = this.fru.frt;
                aVar4.v(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
            }
        }
    }
}
