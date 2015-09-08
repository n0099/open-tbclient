package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends HttpMessageListener {
    final /* synthetic */ av ckB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(av avVar, int i) {
        super(i);
        this.ckB = avVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity agG;
        PersonFriendActivity agG2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.ckB.ckx = false;
            agG = this.ckB.agG();
            if (agG != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                agG2 = this.ckB.agG();
                if (tag == agG2.getUniqueId()) {
                    this.ckB.mListView.completePullRefresh();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.ckB.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.ckB.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.ckB.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.ckB.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.ckB.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
