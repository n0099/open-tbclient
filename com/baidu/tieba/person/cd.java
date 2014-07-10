package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd extends HttpMessageListener {
    final /* synthetic */ cb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd(cb cbVar, int i) {
        super(i);
        this.a = cbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonFriendActivity f;
        PersonFriendActivity f2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002000) {
            this.a.m = false;
            f = this.a.f();
            if (f != null) {
                int tag = httpResponsedMessage.getOrginalMessage().getTag();
                f2 = this.a.f();
                if (tag == f2.getUniqueId()) {
                    this.a.b.d();
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            this.a.a(personFriendResponseMessage.getPersonListData(), false);
                            return;
                        }
                        this.a.b(httpResponsedMessage.getErrorString());
                        return;
                    }
                    this.a.b(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
