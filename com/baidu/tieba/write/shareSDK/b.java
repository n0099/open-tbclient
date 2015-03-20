package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a cvw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.cvw = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        c cVar;
        c cVar2;
        c cVar3;
        cVar = this.cvw.cvv;
        if (cVar != null) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002701) {
                cVar2 = this.cvw.cvv;
                cVar2.aqn();
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ForumPrefixResponsedMessage)) {
                ForumPrefixResponsedMessage forumPrefixResponsedMessage = (ForumPrefixResponsedMessage) httpResponsedMessage;
                cVar3 = this.cvw.cvv;
                cVar3.a(forumPrefixResponsedMessage.isHasPostpre(), forumPrefixResponsedMessage.getData());
            }
        }
    }
}
