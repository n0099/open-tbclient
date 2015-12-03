package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
import com.baidu.tieba.person.post.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends HttpMessageListener {
    final /* synthetic */ s cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(s sVar, int i) {
        super(i);
        this.cKg = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity anx;
        String str;
        PersonBarActivity anx2;
        boolean z;
        String str2;
        String str3;
        ae aeVar;
        ae aeVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
            anx = this.cKg.anx();
            if (anx != null) {
                if (this.cKg.cJQ != null && this.cKg.cJQ.getView() != null) {
                    this.cKg.cJQ.getView().setVisibility(0);
                }
                this.cKg.mListView.completePullRefresh();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                anx2 = this.cKg.anx();
                if (tag == anx2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            r personBarData = personBarResponseMessage.getPersonBarData();
                            aeVar = this.cKg.cJG;
                            aeVar.km(this.cKg.cJU);
                            aeVar2 = this.cKg.cJG;
                            aeVar2.kU(personBarResponseMessage.getResultString());
                            this.cKg.a(personBarData, false);
                            return;
                        }
                        this.cKg.showToast(httpResponsedMessage.getErrorString());
                        u.a aVar = this.cKg.cJQ;
                        str3 = this.cKg.cJX;
                        aVar.kW(str3);
                        return;
                    }
                    this.cKg.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cKg.getResources().getString(n.i.neterror) : httpResponsedMessage.getErrorString());
                    z = this.cKg.cKa;
                    if (z) {
                        u.a aVar2 = this.cKg.cJQ;
                        str2 = this.cKg.cJX;
                        aVar2.kW(str2);
                        return;
                    }
                    this.cKg.cJQ.kW("");
                    return;
                }
                return;
            }
            u.a aVar3 = this.cKg.cJQ;
            str = this.cKg.cJX;
            aVar3.kW(str);
        }
    }
}
