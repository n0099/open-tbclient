package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class du extends HttpMessageListener {
    final /* synthetic */ dt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public du(dt dtVar, int i) {
        super(i);
        this.a = dtVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dw dwVar;
        dw dwVar2;
        dw dwVar3;
        dw dwVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002003 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode != 200 || error != 0) {
                dwVar = this.a.h;
                if (dwVar != null) {
                    dwVar2 = this.a.h;
                    dwVar2.a(httpResponsedMessage.getErrorString(), false);
                    return;
                }
                return;
            }
            ResponseNetPersonListMessage responseNetPersonListMessage = (ResponseNetPersonListMessage) httpResponsedMessage;
            responseNetPersonListMessage.setModel(this.a);
            com.baidu.tieba.data.am data = responseNetPersonListMessage.getData();
            dwVar3 = this.a.h;
            if (dwVar3 != null) {
                dwVar4 = this.a.h;
                dwVar4.a(data, false);
            }
        }
    }
}
