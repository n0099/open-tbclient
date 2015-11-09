package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends HttpMessageListener {
    final /* synthetic */ aw crM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(aw awVar, int i) {
        super(i);
        this.crM = awVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aji;
        PersonFriendActivity aji2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.crM.crI = false;
            aji = this.crM.aji();
            if (aji != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aji2 = this.crM.aji();
                if (tag == aji2.getUniqueId()) {
                    this.crM.mListView.completePullRefresh();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.crM.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.crM.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.crM.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.crM.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.crM.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
