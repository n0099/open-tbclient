package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.person.post.v;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends HttpMessageListener {
    final /* synthetic */ s cXR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(s sVar, int i) {
        super(i);
        this.cXR = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity atz;
        String str;
        PersonBarActivity atz2;
        boolean z;
        String str2;
        String str3;
        ae aeVar;
        ae aeVar2;
        PersonBarActivity atz3;
        String str4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
            atz = this.cXR.atz();
            if (atz != null) {
                if (this.cXR.cXA != null && this.cXR.cXA.getView() != null) {
                    this.cXR.cXA.getView().setVisibility(0);
                }
                this.cXR.IY.nr();
                this.cXR.cwB = false;
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                atz2 = this.cXR.atz();
                if (tag == atz2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            r personBarData = personBarResponseMessage.getPersonBarData();
                            aeVar = this.cXR.cXq;
                            aeVar.lp(this.cXR.cXE);
                            aeVar2 = this.cXR.cXq;
                            aeVar2.kY(personBarResponseMessage.getResultString());
                            this.cXR.a(personBarData, false);
                            atz3 = this.cXR.atz();
                            if (1 == atz3.ael()) {
                                v.a aVar = this.cXR.cXA;
                                str4 = this.cXR.cXH;
                                aVar.ld(str4);
                                return;
                            }
                            return;
                        }
                        this.cXR.showToast(httpResponsedMessage.getErrorString());
                        v.a aVar2 = this.cXR.cXA;
                        str3 = this.cXR.cXH;
                        aVar2.ld(str3);
                        return;
                    }
                    this.cXR.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.cXR.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
                    z = this.cXR.cXK;
                    if (z) {
                        v.a aVar3 = this.cXR.cXA;
                        str2 = this.cXR.cXH;
                        aVar3.ld(str2);
                        return;
                    }
                    this.cXR.cXA.ld("");
                    return;
                }
                return;
            }
            v.a aVar4 = this.cXR.cXA;
            str = this.cXR.cXH;
            aVar4.ld(str);
        }
    }
}
