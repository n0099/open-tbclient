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
    private static volatile a jQm;
    private c jQn;
    private String jQq;
    private String mFrom;
    private boolean jQo = false;
    private boolean jQp = false;
    private boolean mIsValid = false;
    private final HttpMessageListener jQr = new HttpMessageListener(1003403) { // from class: com.baidu.tieba.sdk.verify.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof VerifyStatusResponseMessage)) {
                VerifyStatusResponseMessage verifyStatusResponseMessage = (VerifyStatusResponseMessage) httpResponsedMessage;
                int statusCode = verifyStatusResponseMessage.getStatusCode();
                int error = verifyStatusResponseMessage.getError();
                if ((statusCode != 200 || error == 0) && statusCode == 200) {
                    a.this.jQp = true;
                    a.this.mIsValid = verifyStatusResponseMessage.cEJ();
                    return;
                }
                a.this.jQp = false;
            }
        }
    };

    private a() {
    }

    private void cEG() {
        this.jQo = true;
        MessageManager.getInstance().registerListener(this.jQr);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003403, TbConfig.SERVER_ADDRESS + "ala/sdk/verify");
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(VerifyStatusResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static a cEH() {
        if (jQm == null) {
            synchronized (a.class) {
                if (jQm == null) {
                    jQm = new a();
                }
            }
        }
        return jQm;
    }

    private boolean cEI() {
        if (!this.jQo) {
            cEG();
        }
        if (StringUtils.isNull(this.mFrom) || StringUtils.isNull(this.jQq)) {
            throw new RuntimeException("SDK未设置参数");
        }
        HttpMessage httpMessage = new HttpMessage(1003403);
        httpMessage.addParam("from", this.mFrom);
        httpMessage.addParam("packet_name", this.jQq);
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
        return true;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void Iv(String str) {
        this.jQq = str;
        if (!StringUtils.isNull(this.mFrom) && !StringUtils.isNull(this.jQq)) {
            cEI();
        }
    }

    public void a(c cVar) {
        this.jQn = cVar;
    }
}
