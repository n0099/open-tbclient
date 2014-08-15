package com.baidu.tieba.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.message.ResponseSetBubbleMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends HttpMessageListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        i iVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001501) {
            iVar = this.a.b;
            if (iVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (!(httpResponsedMessage instanceof ResponseSetBubbleMessage)) {
                    iVar5 = this.a.b;
                    iVar5.b(null);
                    return;
                }
                ResponseSetBubbleMessage responseSetBubbleMessage = (ResponseSetBubbleMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    iVar2 = this.a.b;
                    iVar2.b(responseSetBubbleMessage.getSetBubbleResultData());
                } else if (responseSetBubbleMessage.getSetBubbleResultData() == null) {
                    iVar4 = this.a.b;
                    iVar4.b(responseSetBubbleMessage.getSetBubbleResultData());
                } else {
                    iVar3 = this.a.b;
                    iVar3.a(responseSetBubbleMessage.getSetBubbleResultData());
                }
            }
        }
    }
}
