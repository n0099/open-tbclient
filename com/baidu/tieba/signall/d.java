package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends HttpMessageListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        e eVar;
        e eVar2;
        e eVar3;
        a aVar;
        e eVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
            int error = httpResponsedMessage.getError();
            if (!httpResponsedMessage.isSuccess()) {
                String errorString = httpResponsedMessage.getErrorString();
                eVar4 = this.a.b;
                eVar4.a(errorString);
            } else if (error == 0) {
                this.a.a = ((GetForumResponsed) httpResponsedMessage).listData;
                eVar2 = this.a.b;
                if (eVar2 != null) {
                    eVar3 = this.a.b;
                    aVar = this.a.a;
                    eVar3.a(aVar);
                }
            } else {
                String errorString2 = httpResponsedMessage.getErrorString();
                eVar = this.a.b;
                eVar.a(errorString2);
            }
            this.a.c = null;
        }
    }
}
