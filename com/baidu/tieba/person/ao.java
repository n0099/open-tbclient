package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends HttpMessageListener {
    final /* synthetic */ am bGm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(am amVar, int i) {
        super(i);
        this.bGm = amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aas;
        PersonFriendActivity aas2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002000) {
            this.bGm.bGj = false;
            aas = this.bGm.aas();
            if (aas != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aas2 = this.bGm.aas();
                if (tag == aas2.getUniqueId()) {
                    this.bGm.mListView.jJ();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.bGm.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        }
                        this.bGm.showToast(httpResponsedMessage.getErrorString());
                        return;
                    }
                    this.bGm.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
