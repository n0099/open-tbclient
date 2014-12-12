package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends HttpMessageListener {
    final /* synthetic */ ao bVt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(ao aoVar, int i) {
        super(i);
        this.bVt = aoVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        aq aqVar;
        aq aqVar2;
        aq aqVar3;
        aq aqVar4;
        aq aqVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                aqVar = this.bVt.bVs;
                if (aqVar != null) {
                    aqVar2 = this.bVt.bVs;
                    aqVar2.fw(null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aqVar5 = this.bVt.bVs;
                aqVar5.fv(praiseResponseMessage.getErrMsg());
                return;
            }
            aqVar3 = this.bVt.bVs;
            if (aqVar3 != null) {
                aqVar4 = this.bVt.bVs;
                aqVar4.fw(praiseResponseMessage.getErrMsg());
            }
        }
    }
}
