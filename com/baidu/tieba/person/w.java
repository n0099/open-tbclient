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
    final /* synthetic */ r cjC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(r rVar, int i) {
        super(i);
        this.cjC = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        String str;
        PersonBarActivity agt;
        String str2;
        PersonBarActivity agt2;
        boolean z;
        String str3;
        String str4;
        ad adVar;
        ad adVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
            agt = this.cjC.agt();
            if (agt != null) {
                this.cjC.mListView.completePullRefresh();
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                agt2 = this.cjC.agt();
                if (tag == agt2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            q personBarData = personBarResponseMessage.getPersonBarData();
                            adVar = this.cjC.cjb;
                            adVar.iU(this.cjC.cjp);
                            adVar2 = this.cjC.cjb;
                            adVar2.jF(personBarResponseMessage.getResultString());
                            this.cjC.a(personBarData, false);
                            return;
                        }
                        this.cjC.showToast(httpResponsedMessage.getErrorString());
                        u.a aVar = this.cjC.cjl;
                        str4 = this.cjC.cjs;
                        aVar.jG(str4);
                        return;
                    }
                    this.cjC.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cjC.getResources().getString(i.h.neterror) : httpResponsedMessage.getErrorString());
                    z = this.cjC.cjw;
                    if (z) {
                        u.a aVar2 = this.cjC.cjl;
                        str3 = this.cjC.cjs;
                        aVar2.jG(str3);
                        return;
                    }
                    this.cjC.cjl.jG("");
                    return;
                }
                return;
            }
            u.a aVar3 = this.cjC.cjl;
            str2 = this.cjC.cjs;
            aVar3.jG(str2);
            return;
        }
        u.a aVar4 = this.cjC.cjl;
        str = this.cjC.cjs;
        aVar4.jG(str);
    }
}
