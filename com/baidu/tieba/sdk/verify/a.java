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
    private static volatile a jQk;
    private c jQl;
    private String jQo;
    private String mFrom;
    private boolean jQm = false;
    private boolean jQn = false;
    private boolean mIsValid = false;
    private final HttpMessageListener jQp = new HttpMessageListener(1003403) { // from class: com.baidu.tieba.sdk.verify.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof VerifyStatusResponseMessage)) {
                VerifyStatusResponseMessage verifyStatusResponseMessage = (VerifyStatusResponseMessage) httpResponsedMessage;
                int statusCode = verifyStatusResponseMessage.getStatusCode();
                int error = verifyStatusResponseMessage.getError();
                if ((statusCode != 200 || error == 0) && statusCode == 200) {
                    a.this.jQn = true;
                    a.this.mIsValid = verifyStatusResponseMessage.cEH();
                    return;
                }
                a.this.jQn = false;
            }
        }
    };

    private a() {
    }

    private void cEE() {
        this.jQm = true;
        MessageManager.getInstance().registerListener(this.jQp);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003403, TbConfig.SERVER_ADDRESS + "ala/sdk/verify");
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(VerifyStatusResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static a cEF() {
        if (jQk == null) {
            synchronized (a.class) {
                if (jQk == null) {
                    jQk = new a();
                }
            }
        }
        return jQk;
    }

    private boolean cEG() {
        if (!this.jQm) {
            cEE();
        }
        if (StringUtils.isNull(this.mFrom) || StringUtils.isNull(this.jQo)) {
            throw new RuntimeException("SDK未设置参数");
        }
        HttpMessage httpMessage = new HttpMessage(1003403);
        httpMessage.addParam("from", this.mFrom);
        httpMessage.addParam("packet_name", this.jQo);
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
        return true;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void Iv(String str) {
        this.jQo = str;
        if (!StringUtils.isNull(this.mFrom) && !StringUtils.isNull(this.jQo)) {
            cEG();
        }
    }

    public void a(c cVar) {
        this.jQl = cVar;
    }
}
