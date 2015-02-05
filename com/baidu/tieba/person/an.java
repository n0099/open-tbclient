package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends HttpMessageListener {
    final /* synthetic */ al bHW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(al alVar, int i) {
        super(i);
        this.bHW = alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aaS;
        PersonFriendActivity aaS2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002000) {
            this.bHW.bHT = false;
            aaS = this.bHW.aaS();
            if (aaS != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aaS2 = this.bHW.aaS();
                if (tag == aaS2.getUniqueId()) {
                    this.bHW.mListView.jB();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.bHW.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        }
                        this.bHW.showToast(httpResponsedMessage.getErrorString());
                        return;
                    }
                    this.bHW.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
