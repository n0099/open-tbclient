package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends HttpMessageListener {
    final /* synthetic */ ao bXk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(ao aoVar, int i) {
        super(i);
        this.bXk = aoVar;
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
                aqVar = this.bXk.bXj;
                if (aqVar != null) {
                    aqVar2 = this.bXk.bXj;
                    aqVar2.fy(null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aqVar5 = this.bXk.bXj;
                aqVar5.fx(praiseResponseMessage.getErrMsg());
                return;
            }
            aqVar3 = this.bXk.bXj;
            if (aqVar3 != null) {
                aqVar4 = this.bXk.bXj;
                aqVar4.fy(praiseResponseMessage.getErrMsg());
            }
        }
    }
}
