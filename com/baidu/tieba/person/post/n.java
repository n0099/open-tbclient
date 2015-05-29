package com.baidu.tieba.person.post;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.person.UserPostPageHttpResponseMessage;
import com.baidu.tieba.person.UserPostPageRequestMessage;
import com.baidu.tieba.person.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends HttpMessageListener {
    final /* synthetic */ k bUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(k kVar, int i) {
        super(i);
        this.bUy = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ch chVar;
        ch chVar2;
        if (httpResponsedMessage instanceof UserPostPageHttpResponseMessage) {
            UserPostPageHttpResponseMessage userPostPageHttpResponseMessage = (UserPostPageHttpResponseMessage) httpResponsedMessage;
            if (userPostPageHttpResponseMessage.getOrginalMessage() == null) {
                chVar2 = this.bUy.bUf;
                chVar2.a(null, false);
                return;
            }
            UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageHttpResponseMessage.getOrginalMessage().getExtra();
            if (!userPostPageRequestMessage.isThread() && (chVar = userPostPageRequestMessage.getmCallbackWeakReference().get()) != null) {
                chVar.a(userPostPageHttpResponseMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
            }
        }
    }
}
