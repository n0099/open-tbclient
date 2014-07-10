package com.baidu.tieba.person.post;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends HttpMessageListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(l lVar, int i) {
        super(i);
        this.a = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        g gVar;
        g gVar2;
        if (httpResponsedMessage instanceof UserPostPageHttpResponseMessage) {
            UserPostPageHttpResponseMessage userPostPageHttpResponseMessage = (UserPostPageHttpResponseMessage) httpResponsedMessage;
            if (userPostPageHttpResponseMessage.getOrginalMessage() == null) {
                gVar2 = this.a.n;
                gVar2.a(null, false);
                return;
            }
            UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageHttpResponseMessage.getOrginalMessage().getExtra();
            if (!userPostPageRequestMessage.isThread() && (gVar = userPostPageRequestMessage.getmCallbackWeakReference().get()) != null) {
                gVar.a(userPostPageHttpResponseMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
            }
        }
    }
}
