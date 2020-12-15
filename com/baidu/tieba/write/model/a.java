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
    private String eFW;
    private BdUniqueId mBdUniqueId;
    private InterfaceC0897a nWO;
    private com.baidu.tieba.write.a.a nWP;
    private HttpMessageListener nWQ = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.mY().removeCallbacks(a.this.nLy);
                if (a.this.nWO != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.nWl = false;
                        aVar.linkUrl = a.this.eFW;
                        aVar.nWm = 1;
                        a.this.nWP = aVar;
                    } else {
                        a.this.nWP = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.nWP.nWl) {
                            a.this.nWP.linkUrl = a.this.eFW;
                            a.this.nWP.nWm = 1;
                        }
                    }
                    a.this.nWO.a(a.this.nWP);
                }
            }
        }
    };
    private Runnable nLy = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dZe();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.nWl = false;
            aVar.linkUrl = a.this.eFW;
            aVar.nWm = 1;
            a.this.nWP = aVar;
            if (a.this.nWO != null) {
                a.this.nWO.a(a.this.nWP);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0897a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.nWQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.nWQ);
    }

    public void VI(String str) {
        this.eFW = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.mY().removeCallbacks(this.nLy);
        e.mY().postDelayed(this.nLy, 15000L);
    }

    public void dZe() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.mY().removeCallbacks(this.nLy);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.nWQ);
        e.mY().removeCallbacks(this.nLy);
    }

    public void a(InterfaceC0897a interfaceC0897a) {
        this.nWO = interfaceC0897a;
    }

    public com.baidu.tieba.write.a.a dZf() {
        return this.nWP;
    }
}
