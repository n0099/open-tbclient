package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends HttpMessageListener {
    final /* synthetic */ ay dwQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(ay ayVar, int i) {
        super(i);
        this.dwQ = ayVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aBR;
        PersonFriendActivity aBR2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.dwQ.dwM = false;
            aBR = this.dwQ.aBR();
            if (aBR != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aBR2 = this.dwQ.aBR();
                if (tag == aBR2.getUniqueId()) {
                    this.dwQ.zu.k(2000L);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.dwQ.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.dwQ.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.dwQ.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.dwQ.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.dwQ.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
