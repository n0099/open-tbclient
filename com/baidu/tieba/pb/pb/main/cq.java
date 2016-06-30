package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.cp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq extends HttpMessageListener {
    final /* synthetic */ cp dQx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq(cp cpVar, int i) {
        super(i);
        this.dQx = cpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        cp.a aVar;
        cp.a aVar2;
        cp.a aVar3;
        cp.a aVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001803) {
            aVar = this.dQx.dQv;
            if (aVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                String errorString = httpResponsedMessage.getErrorString();
                if (!(httpResponsedMessage instanceof HideChudianPostResponseMessage)) {
                    aVar4 = this.dQx.dQv;
                    aVar4.onError(error, errorString);
                    return;
                }
                HideChudianPostResponseMessage hideChudianPostResponseMessage = (HideChudianPostResponseMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    aVar2 = this.dQx.dQv;
                    aVar2.onError(error, errorString);
                    return;
                }
                hideChudianPostResponseMessage.getResultFlag();
                aVar3 = this.dQx.dQv;
                aVar3.i(hideChudianPostResponseMessage.getResultFlag(), hideChudianPostResponseMessage.getTemplateId());
            }
        }
    }
}
