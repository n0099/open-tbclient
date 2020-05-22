package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes9.dex */
public class o {
    private BaseFragmentActivity gRv;
    private PbModel jGP;
    private a jJd = null;
    protected final HttpMessageListener jJe = new HttpMessageListener(1003066) { // from class: com.baidu.tieba.pb.pb.main.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    o.this.jJd.n(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                o.this.jJd.n(errorCode, errorMessage, tid);
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void n(int i, String str, String str2);
    }

    public o(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        this.jGP = pbModel;
        this.gRv = baseFragmentActivity;
        this.gRv.registerListener(this.jJe);
    }

    public void a(a aVar) {
        this.jJd = aVar;
    }

    public void Ab(int i) {
        if (this.jGP != null) {
            HttpMessage httpMessage = new HttpMessage(1003066);
            httpMessage.addParam("thread_id", this.jGP.cFt());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
