package com.baidu.tieba.sdk.verify;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.a.c;
/* loaded from: classes3.dex */
public class a {
    private static volatile a jQy;
    private String jQC;
    private c jQz;
    private String mFrom;
    private boolean jQA = false;
    private boolean jQB = false;
    private boolean mIsValid = false;
    private final HttpMessageListener jQD = new HttpMessageListener(1003403) { // from class: com.baidu.tieba.sdk.verify.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof VerifyStatusResponseMessage)) {
                VerifyStatusResponseMessage verifyStatusResponseMessage = (VerifyStatusResponseMessage) httpResponsedMessage;
                int statusCode = verifyStatusResponseMessage.getStatusCode();
                int error = verifyStatusResponseMessage.getError();
                if ((statusCode != 200 || error == 0) && statusCode == 200) {
                    a.this.jQB = true;
                    a.this.mIsValid = verifyStatusResponseMessage.cEK();
                    return;
                }
                a.this.jQB = false;
            }
        }
    };

    private a() {
    }

    private void cEH() {
        this.jQA = true;
        MessageManager.getInstance().registerListener(this.jQD);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003403, TbConfig.SERVER_ADDRESS + "ala/sdk/verify");
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(VerifyStatusResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static a cEI() {
        if (jQy == null) {
            synchronized (a.class) {
                if (jQy == null) {
                    jQy = new a();
                }
            }
        }
        return jQy;
    }

    private boolean cEJ() {
        if (!this.jQA) {
            cEH();
        }
        if (StringUtils.isNull(this.mFrom) || StringUtils.isNull(this.jQC)) {
            throw new RuntimeException("SDK未设置参数");
        }
        HttpMessage httpMessage = new HttpMessage(1003403);
        httpMessage.addParam("from", this.mFrom);
        httpMessage.addParam("packet_name", this.jQC);
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
        return true;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void Iw(String str) {
        this.jQC = str;
        if (!StringUtils.isNull(this.mFrom) && !StringUtils.isNull(this.jQC)) {
            cEJ();
        }
    }

    public void a(c cVar) {
        this.jQz = cVar;
    }
}
