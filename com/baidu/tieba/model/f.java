package com.baidu.tieba.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.message.ResponseBubbleListMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends HttpMessageListener {
    final /* synthetic */ e boh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i) {
        super(i);
        this.boh = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        h hVar;
        h hVar2;
        h hVar3;
        h hVar4;
        h hVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001500) {
            hVar = this.boh.aiV;
            if (hVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (!(httpResponsedMessage instanceof ResponseBubbleListMessage)) {
                    hVar5 = this.boh.aiV;
                    hVar5.b(null);
                    return;
                }
                ResponseBubbleListMessage responseBubbleListMessage = (ResponseBubbleListMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    hVar2 = this.boh.aiV;
                    hVar2.b(responseBubbleListMessage.getBubbleListData());
                } else if (responseBubbleListMessage.getBubbleListData() == null) {
                    hVar4 = this.boh.aiV;
                    hVar4.b(responseBubbleListMessage.getBubbleListData());
                } else {
                    hVar3 = this.boh.aiV;
                    hVar3.a(responseBubbleListMessage.getBubbleListData());
                }
            }
        }
    }
}
