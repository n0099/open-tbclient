package com.baidu.tieba.write.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.g.h;
import com.baidu.tieba.write.model.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a fWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.fWp = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        Runnable runnable;
        a.InterfaceC0085a interfaceC0085a;
        com.baidu.tieba.write.a.a aVar;
        com.baidu.tieba.write.a.a aVar2;
        String str;
        com.baidu.tieba.write.a.a aVar3;
        a.InterfaceC0085a interfaceC0085a2;
        com.baidu.tieba.write.a.a aVar4;
        String str2;
        if (httpResponsedMessage instanceof AddLinkResponseMessage) {
            AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
            h fS = h.fS();
            runnable = this.fWp.aUO;
            fS.removeCallbacks(runnable);
            interfaceC0085a = this.fWp.fWm;
            if (interfaceC0085a != null) {
                if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                    com.baidu.tieba.write.a.a aVar5 = new com.baidu.tieba.write.a.a();
                    aVar5.fVV = false;
                    str2 = this.fWp.mLinkUrl;
                    aVar5.linkUrl = str2;
                    aVar5.fVW = 1;
                    this.fWp.fWn = aVar5;
                } else {
                    this.fWp.fWn = addLinkResponseMessage.getAddLinkResponseData();
                    aVar = this.fWp.fWn;
                    if (!aVar.fVV) {
                        aVar2 = this.fWp.fWn;
                        str = this.fWp.mLinkUrl;
                        aVar2.linkUrl = str;
                        aVar3 = this.fWp.fWn;
                        aVar3.fVW = 1;
                    }
                }
                interfaceC0085a2 = this.fWp.fWm;
                aVar4 = this.fWp.fWn;
                interfaceC0085a2.a(aVar4);
            }
        }
    }
}
