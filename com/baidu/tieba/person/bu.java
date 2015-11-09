package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.person.bt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends HttpMessageListener {
    final /* synthetic */ bt csw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(bt btVar, int i) {
        super(i);
        this.csw = btVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        bt.a aVar;
        String errorString;
        bt.a aVar2;
        PersonListActivity personListActivity;
        bt.a aVar3;
        bt.a aVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode != 200 || error != 0) {
                aVar = this.csw.csi;
                if (aVar != null) {
                    if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        personListActivity = this.csw.csu;
                        errorString = personListActivity.getResources().getString(i.h.neterror);
                    } else {
                        errorString = httpResponsedMessage.getErrorString();
                    }
                    aVar2 = this.csw.csi;
                    aVar2.E(errorString, false);
                    return;
                }
                return;
            }
            ResponseNetPersonListMessage responseNetPersonListMessage = (ResponseNetPersonListMessage) httpResponsedMessage;
            responseNetPersonListMessage.setModel(this.csw);
            com.baidu.tieba.person.data.a data = responseNetPersonListMessage.getData();
            aVar3 = this.csw.csi;
            if (aVar3 != null) {
                aVar4 = this.csw.csi;
                aVar4.d(data, false);
            }
        }
    }
}
