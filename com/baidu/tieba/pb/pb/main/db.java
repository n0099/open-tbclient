package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.da;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db extends HttpMessageListener {
    final /* synthetic */ da eiG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db(da daVar, int i) {
        super(i);
        this.eiG = daVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        da.a aVar;
        da.a aVar2;
        da.a aVar3;
        da.a aVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001803) {
            aVar = this.eiG.eiE;
            if (aVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                String errorString = httpResponsedMessage.getErrorString();
                if (!(httpResponsedMessage instanceof HideChudianPostResponseMessage)) {
                    aVar4 = this.eiG.eiE;
                    aVar4.onError(error, errorString);
                    return;
                }
                HideChudianPostResponseMessage hideChudianPostResponseMessage = (HideChudianPostResponseMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    aVar2 = this.eiG.eiE;
                    aVar2.onError(error, errorString);
                    return;
                }
                hideChudianPostResponseMessage.getResultFlag();
                aVar3 = this.eiG.eiE;
                aVar3.i(hideChudianPostResponseMessage.getResultFlag(), hideChudianPostResponseMessage.getTemplateId());
            }
        }
    }
}
