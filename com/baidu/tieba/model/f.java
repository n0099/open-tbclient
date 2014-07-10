package com.baidu.tieba.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.message.ResponseSetBubbleMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends HttpMessageListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        h hVar;
        h hVar2;
        h hVar3;
        h hVar4;
        h hVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001501) {
            hVar = this.a.b;
            if (hVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (!(httpResponsedMessage instanceof ResponseSetBubbleMessage)) {
                    hVar5 = this.a.b;
                    hVar5.b(null);
                    return;
                }
                ResponseSetBubbleMessage responseSetBubbleMessage = (ResponseSetBubbleMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    hVar2 = this.a.b;
                    hVar2.b(responseSetBubbleMessage.getSetBubbleResultData());
                } else if (responseSetBubbleMessage.getSetBubbleResultData() == null) {
                    hVar4 = this.a.b;
                    hVar4.b(responseSetBubbleMessage.getSetBubbleResultData());
                } else {
                    hVar3 = this.a.b;
                    hVar3.a(responseSetBubbleMessage.getSetBubbleResultData());
                }
            }
        }
    }
}
