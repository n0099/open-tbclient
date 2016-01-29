package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.person.bv;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw extends HttpMessageListener {
    final /* synthetic */ bv cZD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(bv bvVar, int i) {
        super(i);
        this.cZD = bvVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        bv.a aVar;
        String errorString;
        bv.a aVar2;
        PersonListActivity personListActivity;
        bv.a aVar3;
        bv.a aVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode != 200 || error != 0) {
                aVar = this.cZD.cZp;
                if (aVar != null) {
                    if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        personListActivity = this.cZD.cZB;
                        errorString = personListActivity.getResources().getString(t.j.neterror);
                    } else {
                        errorString = httpResponsedMessage.getErrorString();
                    }
                    aVar2 = this.cZD.cZp;
                    aVar2.F(errorString, false);
                    return;
                }
                return;
            }
            ResponseNetPersonListMessage responseNetPersonListMessage = (ResponseNetPersonListMessage) httpResponsedMessage;
            responseNetPersonListMessage.setModel(this.cZD);
            com.baidu.tieba.person.data.r data = responseNetPersonListMessage.getData();
            aVar3 = this.cZD.cZp;
            if (aVar3 != null) {
                aVar4 = this.cZD.cZp;
                aVar4.d(data, false);
            }
        }
    }
}
