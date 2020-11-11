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
/* loaded from: classes3.dex */
public class a {
    private String eAG;
    private BdUniqueId mBdUniqueId;
    private InterfaceC0878a nHf;
    private com.baidu.tieba.write.a.a nHg;
    private HttpMessageListener nHh = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.mY().removeCallbacks(a.this.nwo);
                if (a.this.nHf != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.nGC = false;
                        aVar.linkUrl = a.this.eAG;
                        aVar.nGD = 1;
                        a.this.nHg = aVar;
                    } else {
                        a.this.nHg = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.nHg.nGC) {
                            a.this.nHg.linkUrl = a.this.eAG;
                            a.this.nHg.nGD = 1;
                        }
                    }
                    a.this.nHf.a(a.this.nHg);
                }
            }
        }
    };
    private Runnable nwo = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dTK();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.nGC = false;
            aVar.linkUrl = a.this.eAG;
            aVar.nGD = 1;
            a.this.nHg = aVar;
            if (a.this.nHf != null) {
                a.this.nHf.a(a.this.nHg);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0878a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.nHh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.nHh);
    }

    public void UI(String str) {
        this.eAG = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.mY().removeCallbacks(this.nwo);
        e.mY().postDelayed(this.nwo, 15000L);
    }

    public void dTK() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.mY().removeCallbacks(this.nwo);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.nHh);
        e.mY().removeCallbacks(this.nwo);
    }

    public void a(InterfaceC0878a interfaceC0878a) {
        this.nHf = interfaceC0878a;
    }

    public com.baidu.tieba.write.a.a dTL() {
        return this.nHg;
    }
}
