package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
import com.baidu.tieba.person.bu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends HttpMessageListener {
    final /* synthetic */ bu cLQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(bu buVar, int i) {
        super(i);
        this.cLQ = buVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        bu.a aVar;
        String errorString;
        bu.a aVar2;
        PersonListActivity personListActivity;
        bu.a aVar3;
        bu.a aVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode != 200 || error != 0) {
                aVar = this.cLQ.cLC;
                if (aVar != null) {
                    if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        personListActivity = this.cLQ.cLO;
                        errorString = personListActivity.getResources().getString(n.i.neterror);
                    } else {
                        errorString = httpResponsedMessage.getErrorString();
                    }
                    aVar2 = this.cLQ.cLC;
                    aVar2.G(errorString, false);
                    return;
                }
                return;
            }
            ResponseNetPersonListMessage responseNetPersonListMessage = (ResponseNetPersonListMessage) httpResponsedMessage;
            responseNetPersonListMessage.setModel(this.cLQ);
            com.baidu.tieba.person.data.n data = responseNetPersonListMessage.getData();
            aVar3 = this.cLQ.cLC;
            if (aVar3 != null) {
                aVar4 = this.cLQ.cLC;
                aVar4.d(data, false);
            }
        }
    }
}
