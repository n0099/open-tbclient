package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends HttpMessageListener {
    final /* synthetic */ e bPj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i) {
        super(i);
        this.bPj = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
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
                gVar5 = this.bPj.bPe;
                gVar5.gF(errorString);
            } else if (error == 0) {
                this.bPj.bPd = ((GetForumResponsed) httpResponsedMessage).listData;
                gVar2 = this.bPj.bPe;
                if (gVar2 != null) {
                    bVar = this.bPj.bPd;
                    if (bVar != null) {
                        gVar4 = this.bPj.bPe;
                        bVar2 = this.bPj.bPd;
                        gVar4.a(bVar2);
                    }
                }
                String errorString2 = httpResponsedMessage.getErrorString();
                gVar3 = this.bPj.bPe;
                gVar3.gF(errorString2);
            } else {
                String errorString3 = httpResponsedMessage.getErrorString();
                gVar = this.bPj.bPe;
                gVar.gF(errorString3);
            }
            this.bPj.bPf = null;
        }
    }
}
