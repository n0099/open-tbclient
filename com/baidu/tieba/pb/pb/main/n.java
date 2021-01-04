package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class n {
    private BaseFragmentActivity iJr;
    private PbModel lIY;
    private a lLI = null;
    protected final HttpMessageListener lLJ = new HttpMessageListener(1003066) { // from class: com.baidu.tieba.pb.pb.main.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    n.this.lLI.o(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                n.this.lLI.o(errorCode, errorMessage, tid);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void o(int i, String str, String str2);
    }

    public n(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        this.lIY = pbModel;
        this.iJr = baseFragmentActivity;
        this.iJr.registerListener(this.lLJ);
    }

    public void a(a aVar) {
        this.lLI = aVar;
    }

    public void GQ(int i) {
        if (this.lIY != null) {
            HttpMessage httpMessage = new HttpMessage(1003066);
            httpMessage.addParam("thread_id", this.lIY.dpW());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
