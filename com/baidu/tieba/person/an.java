package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends HttpMessageListener {
    final /* synthetic */ al bHX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(al alVar, int i) {
        super(i);
        this.bHX = alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aaX;
        PersonFriendActivity aaX2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002000) {
            this.bHX.bHU = false;
            aaX = this.bHX.aaX();
            if (aaX != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aaX2 = this.bHX.aaX();
                if (tag == aaX2.getUniqueId()) {
                    this.bHX.mListView.jI();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.bHX.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        }
                        this.bHX.showToast(httpResponsedMessage.getErrorString());
                        return;
                    }
                    this.bHX.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
