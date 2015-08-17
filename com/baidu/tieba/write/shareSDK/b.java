package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a cRR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.cRR = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        a.InterfaceC0075a interfaceC0075a;
        a.InterfaceC0075a interfaceC0075a2;
        a.InterfaceC0075a interfaceC0075a3;
        interfaceC0075a = this.cRR.cRQ;
        if (interfaceC0075a != null) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002701) {
                interfaceC0075a2 = this.cRR.cRQ;
                interfaceC0075a2.auj();
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ForumPrefixResponsedMessage)) {
                ForumPrefixResponsedMessage forumPrefixResponsedMessage = (ForumPrefixResponsedMessage) httpResponsedMessage;
                interfaceC0075a3 = this.cRR.cRQ;
                interfaceC0075a3.a(forumPrefixResponsedMessage.isHasPostpre(), forumPrefixResponsedMessage.getData());
            }
        }
    }
}
