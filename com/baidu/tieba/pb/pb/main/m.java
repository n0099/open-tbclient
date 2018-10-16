package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes6.dex */
public class m {
    private BaseActivity bwX;
    private PbModel fKE;
    private a fLT = null;
    protected final HttpMessageListener fOb = new HttpMessageListener(CmdConfigHttp.CMD_APPLY_COPY_THREAD) { // from class: com.baidu.tieba.pb.pb.main.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    m.this.fLT.j(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                m.this.fLT.j(errorCode, errorMessage, tid);
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void j(int i, String str, String str2);
    }

    public m(PbModel pbModel, BaseActivity baseActivity) {
        this.fKE = pbModel;
        this.bwX = baseActivity;
        this.bwX.registerListener(this.fOb);
    }

    public void a(a aVar) {
        this.fLT = aVar;
    }

    public void rw(int i) {
        if (this.fKE != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.fKE.bhP());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
