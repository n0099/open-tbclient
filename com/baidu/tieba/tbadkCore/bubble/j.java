package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends HttpMessageListener {
    final /* synthetic */ h bXP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, int i) {
        super(i);
        this.bXP = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001501) {
            lVar = this.bXP.bVe;
            if (lVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (!(httpResponsedMessage instanceof ResponseSetBubbleMessage)) {
                    lVar5 = this.bXP.bVe;
                    lVar5.b(null);
                    return;
                }
                ResponseSetBubbleMessage responseSetBubbleMessage = (ResponseSetBubbleMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    lVar2 = this.bXP.bVe;
                    lVar2.b(responseSetBubbleMessage.getSetBubbleResultData());
                } else if (responseSetBubbleMessage.getSetBubbleResultData() == null) {
                    lVar4 = this.bXP.bVe;
                    lVar4.b(responseSetBubbleMessage.getSetBubbleResultData());
                } else {
                    lVar3 = this.bXP.bVe;
                    lVar3.a(responseSetBubbleMessage.getSetBubbleResultData());
                }
            }
        }
    }
}
