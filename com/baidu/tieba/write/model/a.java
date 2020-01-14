package com.baidu.tieba.write.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class a {
    private String cKw;
    private InterfaceC0624a kNM;
    private com.baidu.tieba.write.a.a kNN;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener kNO = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.gx().removeCallbacks(a.this.dVL);
                if (a.this.kNM != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.kNl = false;
                        aVar.linkUrl = a.this.cKw;
                        aVar.kNm = 1;
                        a.this.kNN = aVar;
                    } else {
                        a.this.kNN = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.kNN.kNl) {
                            a.this.kNN.linkUrl = a.this.cKw;
                            a.this.kNN.kNm = 1;
                        }
                    }
                    a.this.kNM.a(a.this.kNN);
                }
            }
        }
    };
    private Runnable dVL = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cTB();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.kNl = false;
            aVar.linkUrl = a.this.cKw;
            aVar.kNm = 1;
            a.this.kNN = aVar;
            if (a.this.kNM != null) {
                a.this.kNM.a(a.this.kNN);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0624a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.kNO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kNO);
    }

    public void KE(String str) {
        this.cKw = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.gx().removeCallbacks(this.dVL);
        e.gx().postDelayed(this.dVL, 15000L);
    }

    public void cTB() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.gx().removeCallbacks(this.dVL);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.kNO);
        e.gx().removeCallbacks(this.dVL);
    }

    public void a(InterfaceC0624a interfaceC0624a) {
        this.kNM = interfaceC0624a;
    }

    public com.baidu.tieba.write.a.a cTC() {
        return this.kNN;
    }
}
