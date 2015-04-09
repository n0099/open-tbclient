package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends HttpMessageListener {
    final /* synthetic */ aj bQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(aj ajVar, int i) {
        super(i);
        this.bQu = ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity adq;
        PersonFriendActivity adq2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002000) {
            this.bQu.bQr = false;
            adq = this.bQu.adq();
            if (adq != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                adq2 = this.bQu.adq();
                if (tag == adq2.getUniqueId()) {
                    this.bQu.mListView.mW();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.bQu.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.bQu.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bQu.getResources().getString(com.baidu.tieba.y.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.bQu.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bQu.getResources().getString(com.baidu.tieba.y.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
