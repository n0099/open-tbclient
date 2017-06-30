package com.baidu.tieba.write.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.g.h;
import com.baidu.tieba.write.model.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a ghe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.ghe = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        Runnable runnable;
        a.InterfaceC0087a interfaceC0087a;
        com.baidu.tieba.write.a.a aVar;
        com.baidu.tieba.write.a.a aVar2;
        String str;
        com.baidu.tieba.write.a.a aVar3;
        a.InterfaceC0087a interfaceC0087a2;
        com.baidu.tieba.write.a.a aVar4;
        String str2;
        if (httpResponsedMessage instanceof AddLinkResponseMessage) {
            AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
            h fR = h.fR();
            runnable = this.ghe.aWh;
            fR.removeCallbacks(runnable);
            interfaceC0087a = this.ghe.ghb;
            if (interfaceC0087a != null) {
                if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                    com.baidu.tieba.write.a.a aVar5 = new com.baidu.tieba.write.a.a();
                    aVar5.ggG = false;
                    str2 = this.ghe.mLinkUrl;
                    aVar5.linkUrl = str2;
                    aVar5.ggH = 1;
                    this.ghe.ghc = aVar5;
                } else {
                    this.ghe.ghc = addLinkResponseMessage.getAddLinkResponseData();
                    aVar = this.ghe.ghc;
                    if (!aVar.ggG) {
                        aVar2 = this.ghe.ghc;
                        str = this.ghe.mLinkUrl;
                        aVar2.linkUrl = str;
                        aVar3 = this.ghe.ghc;
                        aVar3.ggH = 1;
                    }
                }
                interfaceC0087a2 = this.ghe.ghb;
                aVar4 = this.ghe.ghc;
                interfaceC0087a2.a(aVar4);
            }
        }
    }
}
