package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.cy;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz extends HttpMessageListener {
    final /* synthetic */ cy ekV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cz(cy cyVar, int i) {
        super(i);
        this.ekV = cyVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        cy.a aVar;
        cy.a aVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
            if (httpResponsedMessage.getStatusCode() != 200) {
                aVar = this.ekV.ejO;
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
            aVar2 = this.ekV.ejO;
            aVar2.h(errorCode, errorMessage, tid);
        }
    }
}
