package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck extends HttpMessageListener {
    final /* synthetic */ cj dkB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck(cj cjVar, int i) {
        super(i);
        this.dkB = cjVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        cj.a aVar;
        cj.a aVar2;
        cj.a aVar3;
        cj.a aVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001803) {
            aVar = this.dkB.dkz;
            if (aVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                String errorString = httpResponsedMessage.getErrorString();
                if (!(httpResponsedMessage instanceof HideChudianPostResponseMessage)) {
                    aVar4 = this.dkB.dkz;
                    aVar4.onError(error, errorString);
                    return;
                }
                HideChudianPostResponseMessage hideChudianPostResponseMessage = (HideChudianPostResponseMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    aVar2 = this.dkB.dkz;
                    aVar2.onError(error, errorString);
                    return;
                }
                hideChudianPostResponseMessage.getResultFlag();
                aVar3 = this.dkB.dkz;
                aVar3.i(hideChudianPostResponseMessage.getResultFlag(), hideChudianPostResponseMessage.getTemplateId());
            }
        }
    }
}
