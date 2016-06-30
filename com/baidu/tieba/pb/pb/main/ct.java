package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.cs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct extends HttpMessageListener {
    final /* synthetic */ cs dQA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ct(cs csVar, int i) {
        super(i);
        this.dQA = csVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        cs.a aVar;
        cs.a aVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
            if (httpResponsedMessage.getStatusCode() != 200) {
                aVar = this.dQA.dPA;
                aVar.h(-1, null, null);
                return;
            }
            ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
            String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
            int errorCode = applyCopyThreadResponseMessage.getErrorCode();
            String tid = applyCopyThreadResponseMessage.getTid();
            if (errorCode == 0) {
                errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
            }
            aVar2 = this.dQA.dPA;
            aVar2.h(errorCode, errorMessage, tid);
        }
    }
}
