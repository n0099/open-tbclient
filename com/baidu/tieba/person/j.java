package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends HttpMessageListener {
    final /* synthetic */ g bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g gVar, int i) {
        super(i);
        this.bHc = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity aaL;
        PersonBarActivity aaL2;
        s sVar;
        s sVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            aaL = this.bHc.aaL();
            if (aaL != null) {
                this.bHc.mListView.jI();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aaL2 = this.bHc.aaL();
                if (tag == aaL2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            f personBarData = personBarResponseMessage.getPersonBarData();
                            sVar = this.bHc.bGG;
                            sVar.ho(this.bHc.bGU);
                            sVar2 = this.bHc.bGG;
                            sVar2.hM(personBarResponseMessage.getResultString());
                            this.bHc.a(personBarData, false);
                            return;
                        }
                        this.bHc.showToast(httpResponsedMessage.getErrorString());
                        this.bHc.bGQ.Fi();
                        return;
                    }
                    this.bHc.showToast(httpResponsedMessage.getErrorString());
                    this.bHc.bGQ.Fi();
                    return;
                }
                return;
            }
            this.bHc.bGQ.Fi();
            return;
        }
        this.bHc.bGQ.Fi();
    }
}
