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
    private String cOA;
    private InterfaceC0632a kOu;
    private com.baidu.tieba.write.a.a kOv;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener kOw = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.gx().removeCallbacks(a.this.dZQ);
                if (a.this.kOu != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.kNT = false;
                        aVar.linkUrl = a.this.cOA;
                        aVar.kNU = 1;
                        a.this.kOv = aVar;
                    } else {
                        a.this.kOv = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.kOv.kNT) {
                            a.this.kOv.linkUrl = a.this.cOA;
                            a.this.kOv.kNU = 1;
                        }
                    }
                    a.this.kOu.a(a.this.kOv);
                }
            }
        }
    };
    private Runnable dZQ = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cUR();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.kNT = false;
            aVar.linkUrl = a.this.cOA;
            aVar.kNU = 1;
            a.this.kOv = aVar;
            if (a.this.kOu != null) {
                a.this.kOu.a(a.this.kOv);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0632a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.kOw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kOw);
    }

    public void KR(String str) {
        this.cOA = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.gx().removeCallbacks(this.dZQ);
        e.gx().postDelayed(this.dZQ, 15000L);
    }

    public void cUR() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.gx().removeCallbacks(this.dZQ);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.kOw);
        e.gx().removeCallbacks(this.dZQ);
    }

    public void a(InterfaceC0632a interfaceC0632a) {
        this.kOu = interfaceC0632a;
    }

    public com.baidu.tieba.write.a.a cUS() {
        return this.kOv;
    }
}
