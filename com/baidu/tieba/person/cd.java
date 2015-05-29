package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd extends HttpMessageListener {
    final /* synthetic */ cc bTH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd(cc ccVar, int i) {
        super(i);
        this.bTH = ccVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        cf cfVar;
        String errorString;
        cf cfVar2;
        PersonListActivity personListActivity;
        cf cfVar3;
        cf cfVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode != 200 || error != 0) {
                cfVar = this.bTH.bTt;
                if (cfVar != null) {
                    if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        personListActivity = this.bTH.bTF;
                        errorString = personListActivity.getResources().getString(com.baidu.tieba.t.neterror);
                    } else {
                        errorString = httpResponsedMessage.getErrorString();
                    }
                    cfVar2 = this.bTH.bTt;
                    cfVar2.A(errorString, false);
                    return;
                }
                return;
            }
            ResponseNetPersonListMessage responseNetPersonListMessage = (ResponseNetPersonListMessage) httpResponsedMessage;
            responseNetPersonListMessage.setModel(this.bTH);
            com.baidu.tieba.person.a.a data = responseNetPersonListMessage.getData();
            cfVar3 = this.bTH.bTt;
            if (cfVar3 != null) {
                cfVar4 = this.bTH.bTt;
                cfVar4.d(data, false);
            }
        }
    }
}
