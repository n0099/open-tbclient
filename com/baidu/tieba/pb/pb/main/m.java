package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes4.dex */
public class m {
    private PbModel hLS;
    private a hNm = null;
    protected final HttpMessageListener hPz = new HttpMessageListener(1003066) { // from class: com.baidu.tieba.pb.pb.main.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    m.this.hNm.o(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                m.this.hNm.o(errorCode, errorMessage, tid);
            }
        }
    };
    private BaseActivity mActivity;

    /* loaded from: classes4.dex */
    public interface a {
        void o(int i, String str, String str2);
    }

    public m(PbModel pbModel, BaseActivity baseActivity) {
        this.hLS = pbModel;
        this.mActivity = baseActivity;
        this.mActivity.registerListener(this.hPz);
    }

    public void a(a aVar) {
        this.hNm = aVar;
    }

    public void wz(int i) {
        if (this.hLS != null) {
            HttpMessage httpMessage = new HttpMessage(1003066);
            httpMessage.addParam("thread_id", this.hLS.bTA());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
