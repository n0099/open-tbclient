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
    final /* synthetic */ r cqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(r rVar, int i) {
        super(i);
        this.cqM = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity aiU;
        String str;
        PersonBarActivity aiU2;
        boolean z;
        String str2;
        String str3;
        ad adVar;
        ad adVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
            aiU = this.cqM.aiU();
            if (aiU != null) {
                if (this.cqM.cqv != null && this.cqM.cqv.getView() != null) {
                    this.cqM.cqv.getView().setVisibility(0);
                }
                this.cqM.mListView.completePullRefresh();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aiU2 = this.cqM.aiU();
                if (tag == aiU2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            q personBarData = personBarResponseMessage.getPersonBarData();
                            adVar = this.cqM.cql;
                            adVar.js(this.cqM.cqz);
                            adVar2 = this.cqM.cql;
                            adVar2.kd(personBarResponseMessage.getResultString());
                            this.cqM.a(personBarData, false);
                            return;
                        }
                        this.cqM.showToast(httpResponsedMessage.getErrorString());
                        u.a aVar = this.cqM.cqv;
                        str3 = this.cqM.cqC;
                        aVar.ke(str3);
                        return;
                    }
                    this.cqM.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cqM.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                    z = this.cqM.cqG;
                    if (z) {
                        u.a aVar2 = this.cqM.cqv;
                        str2 = this.cqM.cqC;
                        aVar2.ke(str2);
                        return;
                    }
                    this.cqM.cqv.ke("");
                    return;
                }
                return;
            }
            u.a aVar3 = this.cqM.cqv;
            str = this.cqM.cqC;
            aVar3.ke(str);
        }
    }
}
