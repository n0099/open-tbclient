package com.baidu.tieba.sdk.verify;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.a.c;
/* loaded from: classes6.dex */
public class a {
    private static a iRm;
    private c iRn;
    private String iRq;
    private String mFrom;
    private boolean iRo = false;
    private boolean iRp = false;
    private boolean mIsValid = false;
    private final int iRr = 2;
    private final HttpMessageListener iRs = new HttpMessageListener(1003403) { // from class: com.baidu.tieba.sdk.verify.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof VerifyStatusResponseMessage)) {
                VerifyStatusResponseMessage verifyStatusResponseMessage = (VerifyStatusResponseMessage) httpResponsedMessage;
                int statusCode = verifyStatusResponseMessage.getStatusCode();
                int error = verifyStatusResponseMessage.getError();
                if ((statusCode != 200 || error == 0) && statusCode == 200) {
                    a.this.iRp = true;
                    a.this.mIsValid = verifyStatusResponseMessage.chY();
                    return;
                }
                a.this.iRp = false;
            }
        }
    };

    private a() {
    }

    private void chV() {
        this.iRo = true;
        MessageManager.getInstance().registerListener(this.iRs);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003403, TbConfig.SERVER_ADDRESS + "ala/sdk/verify");
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(VerifyStatusResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static a chW() {
        if (iRm == null) {
            synchronized (a.class) {
                if (iRm == null) {
                    iRm = new a();
                }
            }
        }
        return iRm;
    }

    private boolean chX() {
        if (!this.iRo) {
            chV();
        }
        if (StringUtils.isNull(this.mFrom) || StringUtils.isNull(this.iRq)) {
            throw new RuntimeException("SDK未设置参数");
        }
        HttpMessage httpMessage = new HttpMessage(1003403);
        httpMessage.addParam("from", this.mFrom);
        httpMessage.addParam("packet_name", this.iRq);
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
        return true;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void Dk(String str) {
        this.iRq = str;
        if (!StringUtils.isNull(this.mFrom) && !StringUtils.isNull(this.iRq)) {
            chX();
        }
    }

    public void a(c cVar) {
        this.iRn = cVar;
    }
}
