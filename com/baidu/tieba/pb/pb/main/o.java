package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class o {
    private BaseActivity brJ;
    private PbModel eKq;
    private a eLB = null;
    protected final HttpMessageListener eNp = new HttpMessageListener(CmdConfigHttp.CMD_APPLY_COPY_THREAD) { // from class: com.baidu.tieba.pb.pb.main.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    o.this.eLB.i(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                o.this.eLB.i(errorCode, errorMessage, tid);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void i(int i, String str, String str2);
    }

    public o(PbModel pbModel, BaseActivity baseActivity) {
        this.eKq = pbModel;
        this.brJ = baseActivity;
        this.brJ.registerListener(this.eNp);
    }

    public void a(a aVar) {
        this.eLB = aVar;
    }

    public void pC(int i) {
        if (this.eKq != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.eKq.aSz());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
