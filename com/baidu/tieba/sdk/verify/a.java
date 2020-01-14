package com.baidu.tieba.sdk.verify;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.a.c;
/* loaded from: classes2.dex */
public class a {
    private static a jPo;
    private c jPp;
    private String jPs;
    private String mFrom;
    private boolean jPq = false;
    private boolean jPr = false;
    private boolean mIsValid = false;
    private final int jPt = 2;
    private final HttpMessageListener jPu = new HttpMessageListener(1003403) { // from class: com.baidu.tieba.sdk.verify.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof VerifyStatusResponseMessage)) {
                VerifyStatusResponseMessage verifyStatusResponseMessage = (VerifyStatusResponseMessage) httpResponsedMessage;
                int statusCode = verifyStatusResponseMessage.getStatusCode();
                int error = verifyStatusResponseMessage.getError();
                if ((statusCode != 200 || error == 0) && statusCode == 200) {
                    a.this.jPr = true;
                    a.this.mIsValid = verifyStatusResponseMessage.cDg();
                    return;
                }
                a.this.jPr = false;
            }
        }
    };

    private a() {
    }

    private void cDd() {
        this.jPq = true;
        MessageManager.getInstance().registerListener(this.jPu);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003403, TbConfig.SERVER_ADDRESS + "ala/sdk/verify");
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(VerifyStatusResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static a cDe() {
        if (jPo == null) {
            synchronized (a.class) {
                if (jPo == null) {
                    jPo = new a();
                }
            }
        }
        return jPo;
    }

    private boolean cDf() {
        if (!this.jPq) {
            cDd();
        }
        if (StringUtils.isNull(this.mFrom) || StringUtils.isNull(this.jPs)) {
            throw new RuntimeException("SDK未设置参数");
        }
        HttpMessage httpMessage = new HttpMessage(1003403);
        httpMessage.addParam("from", this.mFrom);
        httpMessage.addParam("packet_name", this.jPs);
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
        return true;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void Ih(String str) {
        this.jPs = str;
        if (!StringUtils.isNull(this.mFrom) && !StringUtils.isNull(this.jPs)) {
            cDf();
        }
    }

    public void a(c cVar) {
        this.jPp = cVar;
    }
}
