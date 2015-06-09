package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends HttpMessageListener {
    final /* synthetic */ v bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(v vVar, int i) {
        super(i);
        this.bSc = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        String str;
        PersonBarActivity aem;
        String str2;
        PersonBarActivity aem2;
        String str3;
        String str4;
        ai aiVar;
        ai aiVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
            aem = this.bSc.aem();
            if (aem != null) {
                this.bSc.mListView.completePullRefresh();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aem2 = this.bSc.aem();
                if (tag == aem2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            u personBarData = personBarResponseMessage.getPersonBarData();
                            aiVar = this.bSc.bRC;
                            aiVar.hP(this.bSc.bRQ);
                            aiVar2 = this.bSc.bRC;
                            aiVar2.iD(personBarResponseMessage.getResultString());
                            this.bSc.a(personBarData, false);
                            return;
                        }
                        this.bSc.showToast(httpResponsedMessage.getErrorString());
                        com.baidu.tieba.person.post.z zVar = this.bSc.bRM;
                        str4 = this.bSc.bRT;
                        zVar.iF(str4);
                        return;
                    }
                    this.bSc.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.bSc.getResources().getString(com.baidu.tieba.t.neterror) : httpResponsedMessage.getErrorString());
                    com.baidu.tieba.person.post.z zVar2 = this.bSc.bRM;
                    str3 = this.bSc.bRT;
                    zVar2.iF(str3);
                    return;
                }
                return;
            }
            com.baidu.tieba.person.post.z zVar3 = this.bSc.bRM;
            str2 = this.bSc.bRT;
            zVar3.iF(str2);
            return;
        }
        com.baidu.tieba.person.post.z zVar4 = this.bSc.bRM;
        str = this.bSc.bRT;
        zVar4.iF(str);
    }
}
