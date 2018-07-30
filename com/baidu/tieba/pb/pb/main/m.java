package com.baidu.tieba.pb.pb.main;

import android.support.v4.app.NotificationCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes2.dex */
public class m {
    private BaseActivity bmZ;
    private PbModel fvs;
    private a fwI = null;
    protected final HttpMessageListener fyW = new HttpMessageListener(CmdConfigHttp.CMD_APPLY_COPY_THREAD) { // from class: com.baidu.tieba.pb.pb.main.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    m.this.fwI.h(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                m.this.fwI.h(errorCode, errorMessage, tid);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void h(int i, String str, String str2);
    }

    public m(PbModel pbModel, BaseActivity baseActivity) {
        this.fvs = pbModel;
        this.bmZ = baseActivity;
        this.bmZ.registerListener(this.fyW);
    }

    public void a(a aVar) {
        this.fwI = aVar;
    }

    public void qz(int i) {
        if (this.fvs != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.fvs.bci());
            httpMessage.addParam(NotificationCompat.CATEGORY_STATUS, String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
