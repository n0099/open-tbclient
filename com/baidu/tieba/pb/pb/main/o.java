package com.baidu.tieba.pb.pb.main;

import android.support.v4.app.NotificationCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes2.dex */
public class o {
    private BaseActivity cmI;
    private PbModel fFY;
    private a fHl = null;
    protected final HttpMessageListener fJr = new HttpMessageListener(CmdConfigHttp.CMD_APPLY_COPY_THREAD) { // from class: com.baidu.tieba.pb.pb.main.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    o.this.fHl.j(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                o.this.fHl.j(errorCode, errorMessage, tid);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void j(int i, String str, String str2);
    }

    public o(PbModel pbModel, BaseActivity baseActivity) {
        this.fFY = pbModel;
        this.cmI = baseActivity;
        this.cmI.registerListener(this.fJr);
    }

    public void a(a aVar) {
        this.fHl = aVar;
    }

    public void sR(int i) {
        if (this.fFY != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.fFY.bbB());
            httpMessage.addParam(NotificationCompat.CATEGORY_STATUS, String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
