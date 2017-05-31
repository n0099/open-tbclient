package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.df;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg extends HttpMessageListener {
    final /* synthetic */ df eoo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg(df dfVar, int i) {
        super(i);
        this.eoo = dfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        df.a aVar;
        df.a aVar2;
        df.a aVar3;
        df.a aVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001803) {
            aVar = this.eoo.eom;
            if (aVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                String errorString = httpResponsedMessage.getErrorString();
                if (!(httpResponsedMessage instanceof HideChudianPostResponseMessage)) {
                    aVar4 = this.eoo.eom;
                    aVar4.onError(error, errorString);
                    return;
                }
                HideChudianPostResponseMessage hideChudianPostResponseMessage = (HideChudianPostResponseMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    aVar2 = this.eoo.eom;
                    aVar2.onError(error, errorString);
                    return;
                }
                hideChudianPostResponseMessage.getResultFlag();
                aVar3 = this.eoo.eom;
                aVar3.i(hideChudianPostResponseMessage.getResultFlag(), hideChudianPostResponseMessage.getTemplateId());
            }
        }
    }
}
