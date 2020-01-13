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
    private static a jPj;
    private c jPk;
    private String jPn;
    private String mFrom;
    private boolean jPl = false;
    private boolean jPm = false;
    private boolean mIsValid = false;
    private final int jPo = 2;
    private final HttpMessageListener jPp = new HttpMessageListener(1003403) { // from class: com.baidu.tieba.sdk.verify.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof VerifyStatusResponseMessage)) {
                VerifyStatusResponseMessage verifyStatusResponseMessage = (VerifyStatusResponseMessage) httpResponsedMessage;
                int statusCode = verifyStatusResponseMessage.getStatusCode();
                int error = verifyStatusResponseMessage.getError();
                if ((statusCode != 200 || error == 0) && statusCode == 200) {
                    a.this.jPm = true;
                    a.this.mIsValid = verifyStatusResponseMessage.cDe();
                    return;
                }
                a.this.jPm = false;
            }
        }
    };

    private a() {
    }

    private void cDb() {
        this.jPl = true;
        MessageManager.getInstance().registerListener(this.jPp);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003403, TbConfig.SERVER_ADDRESS + "ala/sdk/verify");
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(VerifyStatusResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static a cDc() {
        if (jPj == null) {
            synchronized (a.class) {
                if (jPj == null) {
                    jPj = new a();
                }
            }
        }
        return jPj;
    }

    private boolean cDd() {
        if (!this.jPl) {
            cDb();
        }
        if (StringUtils.isNull(this.mFrom) || StringUtils.isNull(this.jPn)) {
            throw new RuntimeException("SDK未设置参数");
        }
        HttpMessage httpMessage = new HttpMessage(1003403);
        httpMessage.addParam("from", this.mFrom);
        httpMessage.addParam("packet_name", this.jPn);
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
        return true;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void Ih(String str) {
        this.jPn = str;
        if (!StringUtils.isNull(this.mFrom) && !StringUtils.isNull(this.jPn)) {
            cDd();
        }
    }

    public void a(c cVar) {
        this.jPk = cVar;
    }
}
