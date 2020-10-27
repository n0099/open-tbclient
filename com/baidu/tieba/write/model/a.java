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
    private String euN;
    private BdUniqueId mBdUniqueId;
    private InterfaceC0863a nBl;
    private com.baidu.tieba.write.a.a nBm;
    private HttpMessageListener nBn = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.mY().removeCallbacks(a.this.nqt);
                if (a.this.nBl != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.nAI = false;
                        aVar.linkUrl = a.this.euN;
                        aVar.nAJ = 1;
                        a.this.nBm = aVar;
                    } else {
                        a.this.nBm = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.nBm.nAI) {
                            a.this.nBm.linkUrl = a.this.euN;
                            a.this.nBm.nAJ = 1;
                        }
                    }
                    a.this.nBl.a(a.this.nBm);
                }
            }
        }
    };
    private Runnable nqt = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dRk();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.nAI = false;
            aVar.linkUrl = a.this.euN;
            aVar.nAJ = 1;
            a.this.nBm = aVar;
            if (a.this.nBl != null) {
                a.this.nBl.a(a.this.nBm);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0863a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.nBn.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.nBn);
    }

    public void Ur(String str) {
        this.euN = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.mY().removeCallbacks(this.nqt);
        e.mY().postDelayed(this.nqt, 15000L);
    }

    public void dRk() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.mY().removeCallbacks(this.nqt);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.nBn);
        e.mY().removeCallbacks(this.nqt);
    }

    public void a(InterfaceC0863a interfaceC0863a) {
        this.nBl = interfaceC0863a;
    }

    public com.baidu.tieba.write.a.a dRl() {
        return this.nBm;
    }
}
