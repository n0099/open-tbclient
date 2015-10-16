package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends HttpMessageListener {
    final /* synthetic */ aw cqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(aw awVar, int i) {
        super(i);
        this.cqq = awVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aiG;
        PersonFriendActivity aiG2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.cqq.cqm = false;
            aiG = this.cqq.aiG();
            if (aiG != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aiG2 = this.cqq.aiG();
                if (tag == aiG2.getUniqueId()) {
                    this.cqq.mListView.completePullRefresh();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.cqq.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.cqq.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cqq.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.cqq.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cqq.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
