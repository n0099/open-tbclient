package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends HttpMessageListener {
    final /* synthetic */ o bBP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(o oVar, int i) {
        super(i);
        this.bBP = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity ZO;
        PersonBarActivity ZO2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            ZO = this.bBP.ZO();
            if (ZO != null) {
                this.bBP.vl.hN();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                ZO2 = this.bBP.ZO();
                if (tag == ZO2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            this.bBP.a(personBarResponseMessage.getPersonBarData(), false);
                            return;
                        }
                        this.bBP.showToast(httpResponsedMessage.getErrorString());
                        return;
                    }
                    this.bBP.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }
}
