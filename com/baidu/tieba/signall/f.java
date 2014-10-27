package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends HttpMessageListener {
    final /* synthetic */ e bKE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i) {
        super(i);
        this.bKE = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        g gVar;
        g gVar2;
        g gVar3;
        b bVar;
        g gVar4;
        b bVar2;
        g gVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
            int error = httpResponsedMessage.getError();
            if (!httpResponsedMessage.isSuccess()) {
                String errorString = httpResponsedMessage.getErrorString();
                gVar5 = this.bKE.bKz;
                gVar5.fw(errorString);
            } else if (error == 0) {
                this.bKE.bKy = ((GetForumResponsed) httpResponsedMessage).listData;
                gVar2 = this.bKE.bKz;
                if (gVar2 != null) {
                    bVar = this.bKE.bKy;
                    if (bVar != null) {
                        gVar4 = this.bKE.bKz;
                        bVar2 = this.bKE.bKy;
                        gVar4.a(bVar2);
                    }
                }
                String errorString2 = httpResponsedMessage.getErrorString();
                gVar3 = this.bKE.bKz;
                gVar3.fw(errorString2);
            } else {
                String errorString3 = httpResponsedMessage.getErrorString();
                gVar = this.bKE.bKz;
                gVar.fw(errorString3);
            }
            this.bKE.bKA = null;
        }
    }
}
