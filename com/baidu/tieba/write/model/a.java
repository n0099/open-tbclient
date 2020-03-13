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
    private String cOB;
    private InterfaceC0632a kOG;
    private com.baidu.tieba.write.a.a kOH;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener kOI = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.gx().removeCallbacks(a.this.ead);
                if (a.this.kOG != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.kOf = false;
                        aVar.linkUrl = a.this.cOB;
                        aVar.kOg = 1;
                        a.this.kOH = aVar;
                    } else {
                        a.this.kOH = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.kOH.kOf) {
                            a.this.kOH.linkUrl = a.this.cOB;
                            a.this.kOH.kOg = 1;
                        }
                    }
                    a.this.kOG.a(a.this.kOH);
                }
            }
        }
    };
    private Runnable ead = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cUS();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.kOf = false;
            aVar.linkUrl = a.this.cOB;
            aVar.kOg = 1;
            a.this.kOH = aVar;
            if (a.this.kOG != null) {
                a.this.kOG.a(a.this.kOH);
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
        this.kOI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kOI);
    }

    public void KS(String str) {
        this.cOB = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.gx().removeCallbacks(this.ead);
        e.gx().postDelayed(this.ead, 15000L);
    }

    public void cUS() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.gx().removeCallbacks(this.ead);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.kOI);
        e.gx().removeCallbacks(this.ead);
    }

    public void a(InterfaceC0632a interfaceC0632a) {
        this.kOG = interfaceC0632a;
    }

    public com.baidu.tieba.write.a.a cUT() {
        return this.kOH;
    }
}
