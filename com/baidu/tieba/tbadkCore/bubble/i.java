package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends HttpMessageListener {
    final /* synthetic */ h bXO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, int i) {
        super(i);
        this.bXO = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001500) {
            kVar = this.bXO.bVc;
            if (kVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (!(httpResponsedMessage instanceof ResponseBubbleListMessage)) {
                    kVar5 = this.bXO.bVc;
                    kVar5.b(null);
                    return;
                }
                ResponseBubbleListMessage responseBubbleListMessage = (ResponseBubbleListMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    kVar2 = this.bXO.bVc;
                    kVar2.b(responseBubbleListMessage.getBubbleListData());
                } else if (responseBubbleListMessage.getBubbleListData() == null) {
                    kVar4 = this.bXO.bVc;
                    kVar4.b(responseBubbleListMessage.getBubbleListData());
                } else {
                    kVar3 = this.bXO.bVc;
                    kVar3.a(responseBubbleListMessage.getBubbleListData());
                }
            }
        }
    }
}
