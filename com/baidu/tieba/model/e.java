package com.baidu.tieba.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.message.ResponseBubbleListMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends HttpMessageListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001500) {
            gVar = this.a.a;
            if (gVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (!(httpResponsedMessage instanceof ResponseBubbleListMessage)) {
                    gVar5 = this.a.a;
                    gVar5.b(null);
                    return;
                }
                ResponseBubbleListMessage responseBubbleListMessage = (ResponseBubbleListMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    gVar2 = this.a.a;
                    gVar2.b(responseBubbleListMessage.getBubbleListData());
                } else if (responseBubbleListMessage.getBubbleListData() == null) {
                    gVar4 = this.a.a;
                    gVar4.b(responseBubbleListMessage.getBubbleListData());
                } else {
                    gVar3 = this.a.a;
                    gVar3.a(responseBubbleListMessage.getBubbleListData());
                }
            }
        }
    }
}
