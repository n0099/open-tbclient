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
    final /* synthetic */ r cpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(r rVar, int i) {
        super(i);
        this.cpf = rVar;
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
            ais = this.cpf.ais();
            if (ais != null) {
                if (this.cpf.coO != null && this.cpf.coO.getView() != null) {
                    this.cpf.coO.getView().setVisibility(0);
                }
                this.cpf.mListView.completePullRefresh();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                ais2 = this.cpf.ais();
                if (tag == ais2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            q personBarData = personBarResponseMessage.getPersonBarData();
                            adVar = this.cpf.coE;
                            adVar.je(this.cpf.coS);
                            adVar2 = this.cpf.coE;
                            adVar2.ka(personBarResponseMessage.getResultString());
                            this.cpf.a(personBarData, false);
                            return;
                        }
                        this.cpf.showToast(httpResponsedMessage.getErrorString());
                        u.a aVar = this.cpf.coO;
                        str3 = this.cpf.coV;
                        aVar.kb(str3);
                        return;
                    }
                    this.cpf.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cpf.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                    z = this.cpf.coZ;
                    if (z) {
                        u.a aVar2 = this.cpf.coO;
                        str2 = this.cpf.coV;
                        aVar2.kb(str2);
                        return;
                    }
                    this.cpf.coO.kb("");
                    return;
                }
                return;
            }
            u.a aVar3 = this.cpf.coO;
            str = this.cpf.coV;
            aVar3.kb(str);
        }
    }
}
