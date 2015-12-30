package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends HttpMessageListener {
    final /* synthetic */ ax cPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(ax axVar, int i) {
        super(i);
        this.cPw = axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aoW;
        PersonFriendActivity aoW2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.cPw.cPs = false;
            aoW = this.cPw.aoW();
            if (aoW != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aoW2 = this.cPw.aoW();
                if (tag == aoW2.getUniqueId()) {
                    this.cPw.mListView.completePullRefresh();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.cPw.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.cPw.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cPw.getResources().getString(n.j.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.cPw.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cPw.getResources().getString(n.j.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
