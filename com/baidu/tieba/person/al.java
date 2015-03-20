package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends HttpMessageListener {
    final /* synthetic */ aj bQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(aj ajVar, int i) {
        super(i);
        this.bQe = ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity adb;
        PersonFriendActivity adb2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002000) {
            this.bQe.bQb = false;
            adb = this.bQe.adb();
            if (adb != null) {
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                adb2 = this.bQe.adb();
                if (tag == adb2.getUniqueId()) {
                    this.bQe.mListView.mW();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.bQe.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        } else {
                            this.bQe.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bQe.getResources().getString(com.baidu.tieba.y.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    this.bQe.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bQe.getResources().getString(com.baidu.tieba.y.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
