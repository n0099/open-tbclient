package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.person.s;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends HttpMessageListener {
    final /* synthetic */ s dvP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(s sVar, int i) {
        super(i);
        this.dvP = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity aBF;
        String str;
        PersonBarActivity aBF2;
        boolean z;
        String str2;
        String str3;
        af afVar;
        af afVar2;
        PersonBarActivity aBF3;
        String str4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
            aBF = this.dvP.aBF();
            if (aBF != null) {
                if (this.dvP.dvy != null && this.dvP.dvy.getView() != null) {
                    this.dvP.dvy.getView().setVisibility(0);
                }
                this.dvP.zu.k(2000L);
                this.dvP.cMs = false;
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aBF2 = this.dvP.aBF();
                if (tag == aBF2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            r personBarData = personBarResponseMessage.getPersonBarData();
                            afVar = this.dvP.dvo;
                            afVar.mo(this.dvP.dvC);
                            afVar2 = this.dvP.dvo;
                            afVar2.mr(personBarResponseMessage.getResultString());
                            this.dvP.a(personBarData, false);
                            aBF3 = this.dvP.aBF();
                            if (1 == aBF3.ahN()) {
                                s.a aVar = this.dvP.dvy;
                                str4 = this.dvP.dvF;
                                aVar.mp(str4);
                                return;
                            }
                            return;
                        }
                        this.dvP.showToast(httpResponsedMessage.getErrorString());
                        s.a aVar2 = this.dvP.dvy;
                        str3 = this.dvP.dvF;
                        aVar2.mp(str3);
                        return;
                    }
                    this.dvP.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.dvP.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
                    z = this.dvP.dvI;
                    if (z) {
                        s.a aVar3 = this.dvP.dvy;
                        str2 = this.dvP.dvF;
                        aVar3.mp(str2);
                        return;
                    }
                    this.dvP.dvy.mp("");
                    return;
                }
                return;
            }
            s.a aVar4 = this.dvP.dvy;
            str = this.dvP.dvF;
            aVar4.mp(str);
        }
    }
}
