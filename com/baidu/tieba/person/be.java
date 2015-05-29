package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends HttpMessageListener {
    final /* synthetic */ bc bSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bc bcVar, int i) {
        super(i);
        this.bSZ = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aey;
        PersonFriendActivity aey2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.bSZ.bSW = false;
            aey = this.bSZ.aey();
            if (aey != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aey2 = this.bSZ.aey();
                if (tag == aey2.getUniqueId()) {
                    this.bSZ.mListView.completePullRefresh();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.bSZ.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.bSZ.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bSZ.getResources().getString(com.baidu.tieba.t.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.bSZ.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bSZ.getResources().getString(com.baidu.tieba.t.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
