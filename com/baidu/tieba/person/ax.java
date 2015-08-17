package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends HttpMessageListener {
    final /* synthetic */ av cjG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(av avVar, int i) {
        super(i);
        this.cjG = avVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity agq;
        PersonFriendActivity agq2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.cjG.cjC = false;
            agq = this.cjG.agq();
            if (agq != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                agq2 = this.cjG.agq();
                if (tag == agq2.getUniqueId()) {
                    this.cjG.mListView.completePullRefresh();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.cjG.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.cjG.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cjG.getResources().getString(i.C0057i.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.cjG.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cjG.getResources().getString(i.C0057i.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
