package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes21.dex */
public class q {
    private BaseFragmentActivity hEa;
    private PbModel kIh;
    private a kKE = null;
    protected final HttpMessageListener kKF = new HttpMessageListener(1003066) { // from class: com.baidu.tieba.pb.pb.main.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    q.this.kKE.o(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                q.this.kKE.o(errorCode, errorMessage, tid);
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void o(int i, String str, String str2);
    }

    public q(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        this.kIh = pbModel;
        this.hEa = baseFragmentActivity;
        this.hEa.registerListener(this.kKF);
    }

    public void a(a aVar) {
        this.kKE = aVar;
    }

    public void Ez(int i) {
        if (this.kIh != null) {
            HttpMessage httpMessage = new HttpMessage(1003066);
            httpMessage.addParam("thread_id", this.kIh.dcf());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
