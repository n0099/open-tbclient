package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends HttpMessageListener {
    final /* synthetic */ ag fft;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ag agVar, int i) {
        super(i);
        this.fft = agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ag.a aVar;
        ag.a aVar2;
        ag.a aVar3;
        ag.a aVar4;
        ag.a aVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            int statusCode = httpResponsedMessage.getStatusCode();
            if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                aVar = this.fft.ffs;
                if (aVar != null) {
                    aVar2 = this.fft.ffs;
                    aVar2.H(statusCode, null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aVar5 = this.fft.ffs;
                aVar5.hw(praiseResponseMessage.getErrMsg());
                return;
            }
            aVar3 = this.fft.ffs;
            if (aVar3 != null) {
                aVar4 = this.fft.ffs;
                aVar4.H(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
            }
        }
    }
}
