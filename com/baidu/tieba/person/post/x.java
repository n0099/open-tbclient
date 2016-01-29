package com.baidu.tieba.person.post;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.UserPostPageHttpResponseMessage;
import com.baidu.tieba.person.UserPostPageRequestMessage;
/* loaded from: classes.dex */
class x extends HttpMessageListener {
    final /* synthetic */ v dhq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(v vVar, int i) {
        super(i);
        this.dhq = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonPostModel.a aVar;
        if (httpResponsedMessage instanceof UserPostPageHttpResponseMessage) {
            UserPostPageHttpResponseMessage userPostPageHttpResponseMessage = (UserPostPageHttpResponseMessage) httpResponsedMessage;
            if (userPostPageHttpResponseMessage.getOrginalMessage() == null) {
                this.dhq.b(null, false);
                return;
            }
            UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageHttpResponseMessage.getOrginalMessage().getExtra();
            if (userPostPageRequestMessage.isThread() && (aVar = userPostPageRequestMessage.getmCallbackWeakReference().get()) != null) {
                aVar.a(userPostPageHttpResponseMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
            }
        }
    }
}
