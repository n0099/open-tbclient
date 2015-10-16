package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.person.post.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends HttpMessageListener {
    final /* synthetic */ r cpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(r rVar, int i) {
        super(i);
        this.cpq = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity ais;
        String str;
        PersonBarActivity ais2;
        boolean z;
        String str2;
        String str3;
        ad adVar;
        ad adVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
            ais = this.cpq.ais();
            if (ais != null) {
                if (this.cpq.coZ != null && this.cpq.coZ.getView() != null) {
                    this.cpq.coZ.getView().setVisibility(0);
                }
                this.cpq.mListView.completePullRefresh();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                ais2 = this.cpq.ais();
                if (tag == ais2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            q personBarData = personBarResponseMessage.getPersonBarData();
                            adVar = this.cpq.coP;
                            adVar.je(this.cpq.cpd);
                            adVar2 = this.cpq.coP;
                            adVar2.ka(personBarResponseMessage.getResultString());
                            this.cpq.a(personBarData, false);
                            return;
                        }
                        this.cpq.showToast(httpResponsedMessage.getErrorString());
                        u.a aVar = this.cpq.coZ;
                        str3 = this.cpq.cpg;
                        aVar.kb(str3);
                        return;
                    }
                    this.cpq.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cpq.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                    z = this.cpq.cpk;
                    if (z) {
                        u.a aVar2 = this.cpq.coZ;
                        str2 = this.cpq.cpg;
                        aVar2.kb(str2);
                        return;
                    }
                    this.cpq.coZ.kb("");
                    return;
                }
                return;
            }
            u.a aVar3 = this.cpq.coZ;
            str = this.cpq.cpg;
            aVar3.kb(str);
        }
    }
}
