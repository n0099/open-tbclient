package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends HttpMessageListener {
    final /* synthetic */ ax dtv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(ax axVar, int i) {
        super(i);
        this.dtv = axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aBv;
        PersonFriendActivity aBv2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.dtv.dtr = false;
            aBv = this.dtv.aBv();
            if (aBv != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aBv2 = this.dtv.aBv();
                if (tag == aBv2.getUniqueId()) {
                    this.dtv.Je.nj();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.dtv.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.dtv.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.dtv.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.dtv.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.dtv.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
