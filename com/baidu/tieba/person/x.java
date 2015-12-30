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
    final /* synthetic */ s cOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(s sVar, int i) {
        super(i);
        this.cOw = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity aoI;
        String str;
        PersonBarActivity aoI2;
        boolean z;
        String str2;
        String str3;
        ae aeVar;
        ae aeVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
            aoI = this.cOw.aoI();
            if (aoI != null) {
                if (this.cOw.cOg != null && this.cOw.cOg.getView() != null) {
                    this.cOw.cOg.getView().setVisibility(0);
                }
                this.cOw.mListView.completePullRefresh();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aoI2 = this.cOw.aoI();
                if (tag == aoI2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            r personBarData = personBarResponseMessage.getPersonBarData();
                            aeVar = this.cOw.cNW;
                            aeVar.kJ(this.cOw.cOk);
                            aeVar2 = this.cOw.cNW;
                            aeVar2.kR(personBarResponseMessage.getResultString());
                            this.cOw.a(personBarData, false);
                            return;
                        }
                        this.cOw.showToast(httpResponsedMessage.getErrorString());
                        u.a aVar = this.cOw.cOg;
                        str3 = this.cOw.cOn;
                        aVar.kT(str3);
                        return;
                    }
                    this.cOw.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cOw.getResources().getString(n.j.neterror) : httpResponsedMessage.getErrorString());
                    z = this.cOw.cOq;
                    if (z) {
                        u.a aVar2 = this.cOw.cOg;
                        str2 = this.cOw.cOn;
                        aVar2.kT(str2);
                        return;
                    }
                    this.cOw.cOg.kT("");
                    return;
                }
                return;
            }
            u.a aVar3 = this.cOw.cOg;
            str = this.cOw.cOn;
            aVar3.kT(str);
        }
    }
}
