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
/* loaded from: classes13.dex */
public class a {
    private String cOO;
    private InterfaceC0633a kQq;
    private com.baidu.tieba.write.a.a kQr;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener kQs = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.gx().removeCallbacks(a.this.eat);
                if (a.this.kQq != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.kPP = false;
                        aVar.linkUrl = a.this.cOO;
                        aVar.kPQ = 1;
                        a.this.kQr = aVar;
                    } else {
                        a.this.kQr = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.kQr.kPP) {
                            a.this.kQr.linkUrl = a.this.cOO;
                            a.this.kQr.kPQ = 1;
                        }
                    }
                    a.this.kQq.a(a.this.kQr);
                }
            }
        }
    };
    private Runnable eat = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cVn();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.kPP = false;
            aVar.linkUrl = a.this.cOO;
            aVar.kPQ = 1;
            a.this.kQr = aVar;
            if (a.this.kQq != null) {
                a.this.kQq.a(a.this.kQr);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0633a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.kQs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kQs);
    }

    public void KS(String str) {
        this.cOO = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.gx().removeCallbacks(this.eat);
        e.gx().postDelayed(this.eat, 15000L);
    }

    public void cVn() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.gx().removeCallbacks(this.eat);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.kQs);
        e.gx().removeCallbacks(this.eat);
    }

    public void a(InterfaceC0633a interfaceC0633a) {
        this.kQq = interfaceC0633a;
    }

    public com.baidu.tieba.write.a.a cVo() {
        return this.kQr;
    }
}
