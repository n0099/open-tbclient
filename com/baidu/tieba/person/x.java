package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.person.s;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends HttpMessageListener {
    final /* synthetic */ s dst;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(s sVar, int i) {
        super(i);
        this.dst = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PersonBarActivity aBf;
        String str;
        PersonBarActivity aBf2;
        boolean z;
        String str2;
        String str3;
        ae aeVar;
        ae aeVar2;
        PersonBarActivity aBf3;
        String str4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
            aBf = this.dst.aBf();
            if (aBf != null) {
                if (this.dst.dsc != null && this.dst.dsc.getView() != null) {
                    this.dst.dsc.getView().setVisibility(0);
                }
                this.dst.Je.nj();
                this.dst.cLw = false;
                BdUniqueId tag = httpResponsedMessage.getOrginalMessage().getTag();
                aBf2 = this.dst.aBf();
                if (tag == aBf2.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            r personBarData = personBarResponseMessage.getPersonBarData();
                            aeVar = this.dst.drS;
                            aeVar.my(this.dst.dsg);
                            aeVar2 = this.dst.drS;
                            aeVar2.mn(personBarResponseMessage.getResultString());
                            this.dst.a(personBarData, false);
                            aBf3 = this.dst.aBf();
                            if (1 == aBf3.ahE()) {
                                s.a aVar = this.dst.dsc;
                                str4 = this.dst.dsj;
                                aVar.ml(str4);
                                return;
                            }
                            return;
                        }
                        this.dst.showToast(httpResponsedMessage.getErrorString());
                        s.a aVar2 = this.dst.dsc;
                        str3 = this.dst.dsj;
                        aVar2.ml(str3);
                        return;
                    }
                    this.dst.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.dst.getResources().getString(t.j.neterror) : httpResponsedMessage.getErrorString());
                    z = this.dst.dsm;
                    if (z) {
                        s.a aVar3 = this.dst.dsc;
                        str2 = this.dst.dsj;
                        aVar3.ml(str2);
                        return;
                    }
                    this.dst.dsc.ml("");
                    return;
                }
                return;
            }
            s.a aVar4 = this.dst.dsc;
            str = this.dst.dsj;
            aVar4.ml(str);
        }
    }
}
