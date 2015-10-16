package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a dma;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.dma = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        a.InterfaceC0080a interfaceC0080a;
        a.InterfaceC0080a interfaceC0080a2;
        a.InterfaceC0080a interfaceC0080a3;
        interfaceC0080a = this.dma.dlZ;
        if (interfaceC0080a != null) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002701) {
                interfaceC0080a2 = this.dma.dlZ;
                interfaceC0080a2.aBT();
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ForumPrefixResponsedMessage)) {
                ForumPrefixResponsedMessage forumPrefixResponsedMessage = (ForumPrefixResponsedMessage) httpResponsedMessage;
                interfaceC0080a3 = this.dma.dlZ;
                interfaceC0080a3.a(forumPrefixResponsedMessage.isHasPostpre(), forumPrefixResponsedMessage.getData());
            }
        }
    }
}
