package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends HttpMessageListener {
    final /* synthetic */ bc bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bc bcVar, int i) {
        super(i);
        this.bTa = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aez;
        PersonFriendActivity aez2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.bTa.bSX = false;
            aez = this.bTa.aez();
            if (aez != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aez2 = this.bTa.aez();
                if (tag == aez2.getUniqueId()) {
                    this.bTa.mListView.completePullRefresh();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.bTa.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.bTa.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bTa.getResources().getString(com.baidu.tieba.t.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.bTa.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bTa.getResources().getString(com.baidu.tieba.t.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
