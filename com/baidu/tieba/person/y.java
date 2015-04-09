package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends HttpMessageListener {
    final /* synthetic */ v bPV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(v vVar, int i) {
        super(i);
        this.bPV = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        String str;
        PersonBarActivity adl;
        String str2;
        PersonBarActivity adl2;
        String str3;
        String str4;
        ah ahVar;
        ah ahVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            adl = this.bPV.adl();
            if (adl != null) {
                this.bPV.mListView.mW();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                adl2 = this.bPV.adl();
                if (tag == adl2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            u personBarData = personBarResponseMessage.getPersonBarData();
                            ahVar = this.bPV.bPy;
                            ahVar.hC(this.bPV.bPM);
                            ahVar2 = this.bPV.bPy;
                            ahVar2.hY(personBarResponseMessage.getResultString());
                            this.bPV.a(personBarData, false);
                            return;
                        }
                        this.bPV.showToast(httpResponsedMessage.getErrorString());
                        com.baidu.tieba.person.post.z zVar = this.bPV.bPI;
                        str4 = this.bPV.bPQ;
                        zVar.ia(str4);
                        return;
                    }
                    this.bPV.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bPV.getResources().getString(com.baidu.tieba.y.neterror) : httpResponsedMessage.getErrorString());
                    com.baidu.tieba.person.post.z zVar2 = this.bPV.bPI;
                    str3 = this.bPV.bPQ;
                    zVar2.ia(str3);
                    return;
                }
                return;
            }
            com.baidu.tieba.person.post.z zVar3 = this.bPV.bPI;
            str2 = this.bPV.bPQ;
            zVar3.ia(str2);
            return;
        }
        com.baidu.tieba.person.post.z zVar4 = this.bPV.bPI;
        str = this.bPV.bPQ;
        zVar4.ia(str);
    }
}
