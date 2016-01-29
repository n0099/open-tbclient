package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.cm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr extends HttpMessageListener {
    final /* synthetic */ cm cPd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr(cm cmVar, int i) {
        super(i);
        this.cPd = cmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        cm.b bVar;
        cm.b bVar2;
        cm.b bVar3;
        cm.b bVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001803) {
            bVar = this.cPd.cOM;
            if (bVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                String errorString = httpResponsedMessage.getErrorString();
                if (!(httpResponsedMessage instanceof HideChudianPostResponseMessage)) {
                    bVar4 = this.cPd.cOM;
                    bVar4.onError(error, errorString);
                    return;
                }
                HideChudianPostResponseMessage hideChudianPostResponseMessage = (HideChudianPostResponseMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    bVar2 = this.cPd.cOM;
                    bVar2.onError(error, errorString);
                    return;
                }
                hideChudianPostResponseMessage.getResultFlag();
                bVar3 = this.cPd.cOM;
                bVar3.h(hideChudianPostResponseMessage.getResultFlag(), hideChudianPostResponseMessage.getTemplateId());
            }
        }
    }
}
