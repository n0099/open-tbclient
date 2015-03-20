package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends HttpMessageListener {
    final /* synthetic */ bj bQM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(bj bjVar, int i) {
        super(i);
        this.bQM = bjVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        bm bmVar;
        String errorString;
        bm bmVar2;
        PersonListActivity personListActivity;
        bm bmVar3;
        bm bmVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002003 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode != 200 || error != 0) {
                bmVar = this.bQM.bQy;
                if (bmVar != null) {
                    if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        personListActivity = this.bQM.bQK;
                        errorString = personListActivity.getResources().getString(com.baidu.tieba.y.neterror);
                    } else {
                        errorString = httpResponsedMessage.getErrorString();
                    }
                    bmVar2 = this.bQM.bQy;
                    bmVar2.A(errorString, false);
                    return;
                }
                return;
            }
            ResponseNetPersonListMessage responseNetPersonListMessage = (ResponseNetPersonListMessage) httpResponsedMessage;
            responseNetPersonListMessage.setModel(this.bQM);
            com.baidu.tieba.person.a.a data = responseNetPersonListMessage.getData();
            bmVar3 = this.bQM.bQy;
            if (bmVar3 != null) {
                bmVar4 = this.bQM.bQy;
                bmVar4.d(data, false);
            }
        }
    }
}
