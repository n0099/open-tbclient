package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends HttpMessageListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(u uVar, int i) {
        super(i);
        this.a = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity g;
        PersonBarActivity g2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            g = this.a.g();
            if (g != null) {
                this.a.b.d();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                g2 = this.a.g();
                if (tag == g2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            this.a.a(personBarResponseMessage.getPersonBarData(), false);
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
