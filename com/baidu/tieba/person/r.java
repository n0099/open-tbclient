package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends HttpMessageListener {
    final /* synthetic */ o bBB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(o oVar, int i) {
        super(i);
        this.bBB = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity ZM;
        PersonBarActivity ZM2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            ZM = this.bBB.ZM();
            if (ZM != null) {
                this.bBB.vl.hN();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                ZM2 = this.bBB.ZM();
                if (tag == ZM2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            this.bBB.a(personBarResponseMessage.getPersonBarData(), false);
                            return;
                        }
                        this.bBB.showToast(httpResponsedMessage.getErrorString());
                        return;
                    }
                    this.bBB.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
