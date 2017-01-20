package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.db;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc extends HttpMessageListener {
    final /* synthetic */ db ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc(db dbVar, int i) {
        super(i);
        this.ejU = dbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        db.a aVar;
        db.a aVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
            if (httpResponsedMessage.getStatusCode() != 200) {
                aVar = this.ejU.eiP;
                aVar.i(-1, null, null);
                return;
            }
            ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
            String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
            int errorCode = applyCopyThreadResponseMessage.getErrorCode();
            String tid = applyCopyThreadResponseMessage.getTid();
            if (errorCode == 0) {
                errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
            }
            aVar2 = this.ejU.eiP;
            aVar2.i(errorCode, errorMessage, tid);
        }
    }
}
