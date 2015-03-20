package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends HttpMessageListener {
    final /* synthetic */ v bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(v vVar, int i) {
        super(i);
        this.bPF = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        String str;
        PersonBarActivity acW;
        String str2;
        PersonBarActivity acW2;
        String str3;
        String str4;
        ah ahVar;
        ah ahVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
            acW = this.bPF.acW();
            if (acW != null) {
                this.bPF.mListView.mW();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                acW2 = this.bPF.acW();
                if (tag == acW2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            u personBarData = personBarResponseMessage.getPersonBarData();
                            ahVar = this.bPF.bPi;
                            ahVar.hz(this.bPF.bPw);
                            ahVar2 = this.bPF.bPi;
                            ahVar2.hV(personBarResponseMessage.getResultString());
                            this.bPF.a(personBarData, false);
                            return;
                        }
                        this.bPF.showToast(httpResponsedMessage.getErrorString());
                        com.baidu.tieba.person.post.z zVar = this.bPF.bPs;
                        str4 = this.bPF.bPA;
                        zVar.hX(str4);
                        return;
                    }
                    this.bPF.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bPF.getResources().getString(com.baidu.tieba.y.neterror) : httpResponsedMessage.getErrorString());
                    com.baidu.tieba.person.post.z zVar2 = this.bPF.bPs;
                    str3 = this.bPF.bPA;
                    zVar2.hX(str3);
                    return;
                }
                return;
            }
            com.baidu.tieba.person.post.z zVar3 = this.bPF.bPs;
            str2 = this.bPF.bPA;
            zVar3.hX(str2);
            return;
        }
        com.baidu.tieba.person.post.z zVar4 = this.bPF.bPs;
        str = this.bPF.bPA;
        zVar4.hX(str);
    }
}
