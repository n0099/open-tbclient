package com.baidu.tieba.shareSDK;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a bJk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.bJk = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        c cVar;
        c cVar2;
        c cVar3;
        cVar = this.bJk.bJj;
        if (cVar != null) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002701) {
                cVar2 = this.bJk.bJj;
                cVar2.abW();
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ForumPrefixResponsedMessage)) {
                ForumPrefixResponsedMessage forumPrefixResponsedMessage = (ForumPrefixResponsedMessage) httpResponsedMessage;
                cVar3 = this.bJk.bJj;
                cVar3.a(forumPrefixResponsedMessage.isHasPostpre(), forumPrefixResponsedMessage.getData());
            }
        }
    }
}
