package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.df;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl extends HttpMessageListener {
    final /* synthetic */ df dju;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dl(df dfVar, int i) {
        super(i);
        this.dju = dfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        df.b bVar;
        df.b bVar2;
        df.b bVar3;
        df.b bVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001803) {
            bVar = this.dju.diY;
            if (bVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                String errorString = httpResponsedMessage.getErrorString();
                if (!(httpResponsedMessage instanceof HideChudianPostResponseMessage)) {
                    bVar4 = this.dju.diY;
                    bVar4.onError(error, errorString);
                    return;
                }
                HideChudianPostResponseMessage hideChudianPostResponseMessage = (HideChudianPostResponseMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    bVar2 = this.dju.diY;
                    bVar2.onError(error, errorString);
                    return;
                }
                hideChudianPostResponseMessage.getResultFlag();
                bVar3 = this.dju.diY;
                bVar3.i(hideChudianPostResponseMessage.getResultFlag(), hideChudianPostResponseMessage.getTemplateId());
            }
        }
    }
}
