package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class o {
    private BaseActivity byB;
    private PbModel eTs;
    private a eUE = null;
    protected final HttpMessageListener eWC = new HttpMessageListener(CmdConfigHttp.CMD_APPLY_COPY_THREAD) { // from class: com.baidu.tieba.pb.pb.main.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    o.this.eUE.i(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                o.this.eUE.i(errorCode, errorMessage, tid);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void i(int i, String str, String str2);
    }

    public o(PbModel pbModel, BaseActivity baseActivity) {
        this.eTs = pbModel;
        this.byB = baseActivity;
        this.byB.registerListener(this.eWC);
    }

    public void a(a aVar) {
        this.eUE = aVar;
    }

    public void pX(int i) {
        if (this.eTs != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.eTs.aUm());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
