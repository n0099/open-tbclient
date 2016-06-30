package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.person.t;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends HttpMessageListener {
    final /* synthetic */ t eeh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(t tVar, int i) {
        super(i);
        this.eeh = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity aKx;
        String str;
        PersonBarActivity aKx2;
        boolean z;
        String str2;
        String str3;
        ag agVar;
        ag agVar2;
        PersonBarActivity aKx3;
        String str4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
            aKx = this.eeh.aKx();
            if (aKx != null) {
                if (this.eeh.edQ != null && this.eeh.edQ.getView() != null) {
                    this.eeh.edQ.getView().setVisibility(0);
                }
                this.eeh.zt.k(2000L);
                this.eeh.dsg = false;
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aKx2 = this.eeh.aKx();
                if (tag == aKx2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            s personBarData = personBarResponseMessage.getPersonBarData();
                            agVar = this.eeh.edG;
                            agVar.nP(this.eeh.edU);
                            agVar2 = this.eeh.edG;
                            agVar2.nW(personBarResponseMessage.getResultString());
                            this.eeh.a(personBarData, false);
                            aKx3 = this.eeh.aKx();
                            if (1 == aKx3.aqa()) {
                                t.a aVar = this.eeh.edQ;
                                str4 = this.eeh.edX;
                                aVar.nU(str4);
                                return;
                            }
                            return;
                        }
                        this.eeh.showToast(httpResponsedMessage.getErrorString());
                        t.a aVar2 = this.eeh.edQ;
                        str3 = this.eeh.edX;
                        aVar2.nU(str3);
                        return;
                    }
                    this.eeh.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.eeh.getResources().getString(u.j.neterror) : httpResponsedMessage.getErrorString());
                    z = this.eeh.eea;
                    if (z) {
                        t.a aVar3 = this.eeh.edQ;
                        str2 = this.eeh.edX;
                        aVar3.nU(str2);
                        return;
                    }
                    this.eeh.edQ.nU("");
                    return;
                }
                return;
            }
            t.a aVar4 = this.eeh.edQ;
            str = this.eeh.edX;
            aVar4.nU(str);
        }
    }
}
