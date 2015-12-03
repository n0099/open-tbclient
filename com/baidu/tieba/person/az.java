package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends HttpMessageListener {
    final /* synthetic */ ax cLg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(ax axVar, int i) {
        super(i);
        this.cLg = axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity anL;
        PersonFriendActivity anL2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.cLg.cLc = false;
            anL = this.cLg.anL();
            if (anL != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                anL2 = this.cLg.anL();
                if (tag == anL2.getUniqueId()) {
                    this.cLg.mListView.completePullRefresh();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.cLg.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.cLg.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cLg.getResources().getString(n.i.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.cLg.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cLg.getResources().getString(n.i.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
