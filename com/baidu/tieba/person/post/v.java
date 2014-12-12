package com.baidu.tieba.person.post;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.person.UserPostPageHttpResponseMessage;
import com.baidu.tieba.person.UserPostPageRequestMessage;
import com.baidu.tieba.person.br;
/* loaded from: classes.dex */
class v extends HttpMessageListener {
    final /* synthetic */ t bHQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(t tVar, int i) {
        super(i);
        this.bHQ = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        br brVar;
        if (httpResponsedMessage instanceof UserPostPageHttpResponseMessage) {
            UserPostPageHttpResponseMessage userPostPageHttpResponseMessage = (UserPostPageHttpResponseMessage) httpResponsedMessage;
            if (userPostPageHttpResponseMessage.getOrginalMessage() == null) {
                this.bHQ.b(null, false);
                return;
            }
            UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageHttpResponseMessage.getOrginalMessage().getExtra();
            if (userPostPageRequestMessage.isThread() && (brVar = userPostPageRequestMessage.getmCallbackWeakReference().get()) != null) {
                brVar.a(userPostPageHttpResponseMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
            }
        }
    }
}
