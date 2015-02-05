package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends HttpMessageListener {
    final /* synthetic */ g bHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g gVar, int i) {
        super(i);
        this.bHb = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity aaG;
        PersonBarActivity aaG2;
        s sVar;
        s sVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            aaG = this.bHb.aaG();
            if (aaG != null) {
                this.bHb.mListView.jB();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aaG2 = this.bHb.aaG();
                if (tag == aaG2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            f personBarData = personBarResponseMessage.getPersonBarData();
                            sVar = this.bHb.bGF;
                            sVar.ho(this.bHb.bGT);
                            sVar2 = this.bHb.bGF;
                            sVar2.hJ(personBarResponseMessage.getResultString());
                            this.bHb.a(personBarData, false);
                            return;
                        }
                        this.bHb.showToast(httpResponsedMessage.getErrorString());
                        this.bHb.bGP.hL(this.bHb.getString(com.baidu.tieba.z.person_post_bar_no_more));
                        return;
                    }
                    this.bHb.showToast(httpResponsedMessage.getErrorString());
                    this.bHb.bGP.hL(this.bHb.getString(com.baidu.tieba.z.person_post_bar_no_more));
                    return;
                }
                return;
            }
            this.bHb.bGP.hL(this.bHb.getString(com.baidu.tieba.z.person_post_bar_no_more));
            return;
        }
        this.bHb.bGP.hL(this.bHb.getString(com.baidu.tieba.z.person_post_bar_no_more));
    }
}
