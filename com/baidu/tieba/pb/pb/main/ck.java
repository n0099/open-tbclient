package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck extends HttpMessageListener {
    final /* synthetic */ cf cHv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck(cf cfVar, int i) {
        super(i);
        this.cHv = cfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        cf.b bVar;
        cf.b bVar2;
        cf.b bVar3;
        cf.b bVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001803) {
            bVar = this.cHv.cHg;
            if (bVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                String errorString = httpResponsedMessage.getErrorString();
                if (!(httpResponsedMessage instanceof HideChudianPostResponseMessage)) {
                    bVar4 = this.cHv.cHg;
                    bVar4.onError(error, errorString);
                    return;
                }
                HideChudianPostResponseMessage hideChudianPostResponseMessage = (HideChudianPostResponseMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    bVar2 = this.cHv.cHg;
                    bVar2.onError(error, errorString);
                    return;
                }
                hideChudianPostResponseMessage.getResultFlag();
                bVar3 = this.cHv.cHg;
                bVar3.g(hideChudianPostResponseMessage.getResultFlag(), hideChudianPostResponseMessage.getTemplateId());
            }
        }
    }
}
