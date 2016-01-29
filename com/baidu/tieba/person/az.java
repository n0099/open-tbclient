package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends HttpMessageListener {
    final /* synthetic */ ax cYT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(ax axVar, int i) {
        super(i);
        this.cYT = axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity atP;
        PersonFriendActivity atP2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.cYT.cYP = false;
            atP = this.cYT.atP();
            if (atP != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                atP2 = this.cYT.atP();
                if (tag == atP2.getUniqueId()) {
                    this.cYT.IY.nr();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.cYT.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.cYT.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cYT.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.cYT.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cYT.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
