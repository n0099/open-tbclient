package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.person.post.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends HttpMessageListener {
    final /* synthetic */ r ciI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(r rVar, int i) {
        super(i);
        this.ciI = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        String str;
        PersonBarActivity agd;
        String str2;
        PersonBarActivity agd2;
        boolean z;
        String str3;
        String str4;
        ad adVar;
        ad adVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
            agd = this.ciI.agd();
            if (agd != null) {
                this.ciI.mListView.completePullRefresh();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                agd2 = this.ciI.agd();
                if (tag == agd2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            q personBarData = personBarResponseMessage.getPersonBarData();
                            adVar = this.ciI.cih;
                            adVar.iI(this.ciI.civ);
                            adVar2 = this.ciI.cih;
                            adVar2.jx(personBarResponseMessage.getResultString());
                            this.ciI.a(personBarData, false);
                            return;
                        }
                        this.ciI.showToast(httpResponsedMessage.getErrorString());
                        p.a aVar = this.ciI.cir;
                        str4 = this.ciI.ciy;
                        aVar.jz(str4);
                        return;
                    }
                    this.ciI.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.ciI.getResources().getString(i.C0057i.neterror) : httpResponsedMessage.getErrorString());
                    z = this.ciI.ciC;
                    if (z) {
                        p.a aVar2 = this.ciI.cir;
                        str3 = this.ciI.ciy;
                        aVar2.jz(str3);
                        return;
                    }
                    this.ciI.cir.jz("");
                    return;
                }
                return;
            }
            p.a aVar3 = this.ciI.cir;
            str2 = this.ciI.ciy;
            aVar3.jz(str2);
            return;
        }
        p.a aVar4 = this.ciI.cir;
        str = this.ciI.ciy;
        aVar4.jz(str);
    }
}
