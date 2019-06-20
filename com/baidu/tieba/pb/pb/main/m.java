package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes4.dex */
public class m {
    private BaseActivity cVq;
    private PbModel hEl;
    private a hFE = null;
    protected final HttpMessageListener hHQ = new HttpMessageListener(CmdConfigHttp.CMD_APPLY_COPY_THREAD) { // from class: com.baidu.tieba.pb.pb.main.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    m.this.hFE.m(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                m.this.hFE.m(errorCode, errorMessage, tid);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void m(int i, String str, String str2);
    }

    public m(PbModel pbModel, BaseActivity baseActivity) {
        this.hEl = pbModel;
        this.cVq = baseActivity;
        this.cVq.registerListener(this.hHQ);
    }

    public void a(a aVar) {
        this.hFE = aVar;
    }

    public void xl(int i) {
        if (this.hEl != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.hEl.bSJ());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
