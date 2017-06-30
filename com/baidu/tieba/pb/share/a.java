package com.baidu.tieba.pb.share;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class a extends HttpMessageListener {
    final /* synthetic */ AddExperiencedModel eJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddExperiencedModel addExperiencedModel, int i) {
        super(i);
        this.eJj = addExperiencedModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof AddExperiencedResponseMessage) {
            AddExperiencedResponseMessage addExperiencedResponseMessage = (AddExperiencedResponseMessage) httpResponsedMessage;
        }
    }
}
