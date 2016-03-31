package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.df;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk extends HttpMessageListener {
    final /* synthetic */ df dju;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dk(df dfVar, int i) {
        super(i);
        this.dju = dfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        df.a aVar;
        df.a aVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
            if (httpResponsedMessage.getStatusCode() != 200) {
                aVar = this.dju.dho;
                aVar.g(-1, null, null);
                return;
            }
            ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
            String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
            int errorCode = applyCopyThreadResponseMessage.getErrorCode();
            String tid = applyCopyThreadResponseMessage.getTid();
            if (errorCode == 0) {
                errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
            }
            aVar2 = this.dju.dho;
            aVar2.g(errorCode, errorMessage, tid);
        }
    }
}
