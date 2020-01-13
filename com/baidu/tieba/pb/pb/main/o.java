package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes7.dex */
public class o {
    private BaseFragmentActivity gpB;
    private PbModel iCx;
    private a iED = null;
    protected final HttpMessageListener iEE = new HttpMessageListener(1003066) { // from class: com.baidu.tieba.pb.pb.main.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    o.this.iED.m(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                o.this.iED.m(errorCode, errorMessage, tid);
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void m(int i, String str, String str2);
    }

    public o(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        this.iCx = pbModel;
        this.gpB = baseFragmentActivity;
        this.gpB.registerListener(this.iEE);
    }

    public void a(a aVar) {
        this.iED = aVar;
    }

    public void yB(int i) {
        if (this.iCx != null) {
            HttpMessage httpMessage = new HttpMessage(1003066);
            httpMessage.addParam("thread_id", this.iCx.cmc());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
