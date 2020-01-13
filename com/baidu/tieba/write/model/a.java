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
    private InterfaceC0624a kNH;
    private com.baidu.tieba.write.a.a kNI;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener kNJ = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.gx().removeCallbacks(a.this.dVL);
                if (a.this.kNH != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.kNg = false;
                        aVar.linkUrl = a.this.cKw;
                        aVar.kNh = 1;
                        a.this.kNI = aVar;
                    } else {
                        a.this.kNI = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.kNI.kNg) {
                            a.this.kNI.linkUrl = a.this.cKw;
                            a.this.kNI.kNh = 1;
                        }
                    }
                    a.this.kNH.a(a.this.kNI);
                }
            }
        }
    };
    private Runnable dVL = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cTz();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.kNg = false;
            aVar.linkUrl = a.this.cKw;
            aVar.kNh = 1;
            a.this.kNI = aVar;
            if (a.this.kNH != null) {
                a.this.kNH.a(a.this.kNI);
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
        this.kNJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kNJ);
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

    public void cTz() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.gx().removeCallbacks(this.dVL);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.kNJ);
        e.gx().removeCallbacks(this.dVL);
    }

    public void a(InterfaceC0624a interfaceC0624a) {
        this.kNH = interfaceC0624a;
    }

    public com.baidu.tieba.write.a.a cTA() {
        return this.kNI;
    }
}
