package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes16.dex */
public class q {
    private BaseFragmentActivity hjZ;
    private PbModel kkj;
    private a kmF = null;
    protected final HttpMessageListener kmG = new HttpMessageListener(1003066) { // from class: com.baidu.tieba.pb.pb.main.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    q.this.kmF.n(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                q.this.kmF.n(errorCode, errorMessage, tid);
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void n(int i, String str, String str2);
    }

    public q(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        this.kkj = pbModel;
        this.hjZ = baseFragmentActivity;
        this.hjZ.registerListener(this.kmG);
    }

    public void a(a aVar) {
        this.kmF = aVar;
    }

    public void BE(int i) {
        if (this.kkj != null) {
            HttpMessage httpMessage = new HttpMessage(1003066);
            httpMessage.addParam("thread_id", this.kkj.cNL());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
