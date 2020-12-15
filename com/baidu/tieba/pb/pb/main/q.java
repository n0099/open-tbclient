package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes22.dex */
public class q {
    private BaseFragmentActivity ixe;
    private PbModel lDS;
    private a lGt = null;
    protected final HttpMessageListener lGu = new HttpMessageListener(1003066) { // from class: com.baidu.tieba.pb.pb.main.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    q.this.lGt.q(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                q.this.lGt.q(errorCode, errorMessage, tid);
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void q(int i, String str, String str2);
    }

    public q(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        this.lDS = pbModel;
        this.ixe = baseFragmentActivity;
        this.ixe.registerListener(this.lGu);
    }

    public void a(a aVar) {
        this.lGt = aVar;
    }

    public void GY(int i) {
        if (this.lDS != null) {
            HttpMessage httpMessage = new HttpMessage(1003066);
            httpMessage.addParam("thread_id", this.lDS.dqk());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
