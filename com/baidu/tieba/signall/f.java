package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends HttpMessageListener {
    final /* synthetic */ e bQT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i) {
        super(i);
        this.bQT = eVar;
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
                gVar5 = this.bQT.bQO;
                gVar5.gK(errorString);
            } else if (error == 0) {
                this.bQT.bQN = ((GetForumResponsed) httpResponsedMessage).listData;
                gVar2 = this.bQT.bQO;
                if (gVar2 != null) {
                    bVar = this.bQT.bQN;
                    if (bVar != null) {
                        gVar4 = this.bQT.bQO;
                        bVar2 = this.bQT.bQN;
                        gVar4.a(bVar2);
                    }
                }
                String errorString2 = httpResponsedMessage.getErrorString();
                gVar3 = this.bQT.bQO;
                gVar3.gK(errorString2);
            } else {
                String errorString3 = httpResponsedMessage.getErrorString();
                gVar = this.bQT.bQO;
                gVar.gK(errorString3);
            }
            this.bQT.bQP = null;
        }
    }
}
