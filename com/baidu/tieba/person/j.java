package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends HttpMessageListener {
    final /* synthetic */ g bFr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g gVar, int i) {
        super(i);
        this.bFr = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity aag;
        PersonBarActivity aag2;
        s sVar;
        s sVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            aag = this.bFr.aag();
            if (aag != null) {
                this.bFr.mListView.jJ();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aag2 = this.bFr.aag();
                if (tag == aag2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            f personBarData = personBarResponseMessage.getPersonBarData();
                            sVar = this.bFr.bEV;
                            sVar.hf(this.bFr.bFj);
                            sVar2 = this.bFr.bEV;
                            sVar2.hF(personBarResponseMessage.getResultString());
                            this.bFr.a(personBarData, false);
                            return;
                        }
                        this.bFr.showToast(httpResponsedMessage.getErrorString());
                        this.bFr.bFf.EJ();
                        return;
                    }
                    this.bFr.showToast(httpResponsedMessage.getErrorString());
                    this.bFr.bFf.EJ();
                    return;
                }
                return;
            }
            this.bFr.bFf.EJ();
            return;
        }
        this.bFr.bFf.EJ();
    }
}
