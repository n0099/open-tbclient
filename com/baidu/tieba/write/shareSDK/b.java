package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a eIO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.eIO = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        a.InterfaceC0088a interfaceC0088a;
        a.InterfaceC0088a interfaceC0088a2;
        a.InterfaceC0088a interfaceC0088a3;
        interfaceC0088a = this.eIO.eIN;
        if (interfaceC0088a != null) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002701) {
                interfaceC0088a2 = this.eIO.eIN;
                interfaceC0088a2.aZH();
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ForumPrefixResponsedMessage)) {
                ForumPrefixResponsedMessage forumPrefixResponsedMessage = (ForumPrefixResponsedMessage) httpResponsedMessage;
                interfaceC0088a3 = this.eIO.eIN;
                interfaceC0088a3.a(forumPrefixResponsedMessage.isHasPostpre(), forumPrefixResponsedMessage.getData());
            }
        }
    }
}
