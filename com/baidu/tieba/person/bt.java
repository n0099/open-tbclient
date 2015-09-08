package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.person.bs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends HttpMessageListener {
    final /* synthetic */ bs cll;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(bs bsVar, int i) {
        super(i);
        this.cll = bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        bs.a aVar;
        String errorString;
        bs.a aVar2;
        PersonListActivity personListActivity;
        bs.a aVar3;
        bs.a aVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode != 200 || error != 0) {
                aVar = this.cll.ckX;
                if (aVar != null) {
                    if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        personListActivity = this.cll.clj;
                        errorString = personListActivity.getResources().getString(i.h.neterror);
                    } else {
                        errorString = httpResponsedMessage.getErrorString();
                    }
                    aVar2 = this.cll.ckX;
                    aVar2.D(errorString, false);
                    return;
                }
                return;
            }
            ResponseNetPersonListMessage responseNetPersonListMessage = (ResponseNetPersonListMessage) httpResponsedMessage;
            responseNetPersonListMessage.setModel(this.cll);
            com.baidu.tieba.person.a.a data = responseNetPersonListMessage.getData();
            aVar3 = this.cll.ckX;
            if (aVar3 != null) {
                aVar4 = this.cll.ckX;
                aVar4.d(data, false);
            }
        }
    }
}
