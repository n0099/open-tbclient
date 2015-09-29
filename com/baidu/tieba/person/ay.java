package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends HttpMessageListener {
    final /* synthetic */ aw cqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(aw awVar, int i) {
        super(i);
        this.cqf = awVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aiG;
        PersonFriendActivity aiG2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.cqf.cqb = false;
            aiG = this.cqf.aiG();
            if (aiG != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aiG2 = this.cqf.aiG();
                if (tag == aiG2.getUniqueId()) {
                    this.cqf.mListView.completePullRefresh();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.cqf.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.cqf.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cqf.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.cqf.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cqf.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
