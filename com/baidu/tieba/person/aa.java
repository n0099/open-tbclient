package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends HttpMessageListener {
    final /* synthetic */ v bSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(v vVar, int i) {
        super(i);
        this.bSb = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        String str;
        PersonBarActivity ael;
        String str2;
        PersonBarActivity ael2;
        String str3;
        String str4;
        ai aiVar;
        ai aiVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
            ael = this.bSb.ael();
            if (ael != null) {
                this.bSb.mListView.completePullRefresh();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                ael2 = this.bSb.ael();
                if (tag == ael2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            u personBarData = personBarResponseMessage.getPersonBarData();
                            aiVar = this.bSb.bRB;
                            aiVar.hP(this.bSb.bRP);
                            aiVar2 = this.bSb.bRB;
                            aiVar2.iD(personBarResponseMessage.getResultString());
                            this.bSb.a(personBarData, false);
                            return;
                        }
                        this.bSb.showToast(httpResponsedMessage.getErrorString());
                        com.baidu.tieba.person.post.z zVar = this.bSb.bRL;
                        str4 = this.bSb.bRS;
                        zVar.iF(str4);
                        return;
                    }
                    this.bSb.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bSb.getResources().getString(com.baidu.tieba.t.neterror) : httpResponsedMessage.getErrorString());
                    com.baidu.tieba.person.post.z zVar2 = this.bSb.bRL;
                    str3 = this.bSb.bRS;
                    zVar2.iF(str3);
                    return;
                }
                return;
            }
            com.baidu.tieba.person.post.z zVar3 = this.bSb.bRL;
            str2 = this.bSb.bRS;
            zVar3.iF(str2);
            return;
        }
        com.baidu.tieba.person.post.z zVar4 = this.bSb.bRL;
        str = this.bSb.bRS;
        zVar4.iF(str);
    }
}
