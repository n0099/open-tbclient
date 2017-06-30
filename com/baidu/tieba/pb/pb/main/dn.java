package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.dm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn extends HttpMessageListener {
    final /* synthetic */ dm exu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dn(dm dmVar, int i) {
        super(i);
        this.exu = dmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dm.a aVar;
        dm.a aVar2;
        dm.a aVar3;
        dm.a aVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001803) {
            aVar = this.exu.exr;
            if (aVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                String errorString = httpResponsedMessage.getErrorString();
                if (!(httpResponsedMessage instanceof HideChudianPostResponseMessage)) {
                    aVar4 = this.exu.exr;
                    aVar4.onError(error, errorString);
                    return;
                }
                HideChudianPostResponseMessage hideChudianPostResponseMessage = (HideChudianPostResponseMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    aVar2 = this.exu.exr;
                    aVar2.onError(error, errorString);
                    return;
                }
                hideChudianPostResponseMessage.getResultFlag();
                aVar3 = this.exu.exr;
                aVar3.i(hideChudianPostResponseMessage.getResultFlag(), hideChudianPostResponseMessage.getTemplateId());
            }
        }
    }
}
