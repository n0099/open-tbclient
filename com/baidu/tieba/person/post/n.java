package com.baidu.tieba.person.post;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.person.UserPostPageHttpResponseMessage;
import com.baidu.tieba.person.UserPostPageRequestMessage;
import com.baidu.tieba.person.br;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends HttpMessageListener {
    final /* synthetic */ k bHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(k kVar, int i) {
        super(i);
        this.bHG = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        br brVar;
        br brVar2;
        if (httpResponsedMessage instanceof UserPostPageHttpResponseMessage) {
            UserPostPageHttpResponseMessage userPostPageHttpResponseMessage = (UserPostPageHttpResponseMessage) httpResponsedMessage;
            if (userPostPageHttpResponseMessage.getOrginalMessage() == null) {
                brVar2 = this.bHG.bHn;
                brVar2.a(null, false);
                return;
            }
            UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageHttpResponseMessage.getOrginalMessage().getExtra();
            if (!userPostPageRequestMessage.isThread() && (brVar = userPostPageRequestMessage.getmCallbackWeakReference().get()) != null) {
                brVar.a(userPostPageHttpResponseMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
            }
        }
    }
}
