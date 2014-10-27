package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends HttpMessageListener {
    final /* synthetic */ at bCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(at atVar, int i) {
        super(i);
        this.bCz = atVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity ZZ;
        PersonFriendActivity ZZ2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002000) {
            this.bCz.bCv = false;
            ZZ = this.bCz.ZZ();
            if (ZZ != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                ZZ2 = this.bCz.ZZ();
                if (tag == ZZ2.getUniqueId()) {
                    this.bCz.vl.hN();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.bCz.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        }
                        this.bCz.showToast(httpResponsedMessage.getErrorString());
                        return;
                    }
                    this.bCz.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
