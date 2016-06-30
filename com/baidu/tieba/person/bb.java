package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends HttpMessageListener {
    final /* synthetic */ az efi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(az azVar, int i) {
        super(i);
        this.efi = azVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity aKM;
        PersonFriendActivity aKM2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            this.efi.efe = false;
            aKM = this.efi.aKM();
            if (aKM != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aKM2 = this.efi.aKM();
                if (tag == aKM2.getUniqueId()) {
                    this.efi.zt.k(2000L);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.efi.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.efi.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.efi.getResources().getString(u.j.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.efi.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.efi.getResources().getString(u.j.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
