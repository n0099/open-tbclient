package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends HttpMessageListener {
    final /* synthetic */ at bCN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(at atVar, int i) {
        super(i);
        this.bCN = atVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aab;
        PersonFriendActivity aab2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002000) {
            this.bCN.bCJ = false;
            aab = this.bCN.aab();
            if (aab != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aab2 = this.bCN.aab();
                if (tag == aab2.getUniqueId()) {
                    this.bCN.vl.hN();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.bCN.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        }
                        this.bCN.showToast(httpResponsedMessage.getErrorString());
                        return;
                    }
                    this.bCN.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
