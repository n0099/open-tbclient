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
    private String eyX;
    private BdUniqueId mBdUniqueId;
    private InterfaceC0881a nIG;
    private com.baidu.tieba.write.a.a nIH;
    private HttpMessageListener nII = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.mY().removeCallbacks(a.this.nxv);
                if (a.this.nIG != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.nId = false;
                        aVar.linkUrl = a.this.eyX;
                        aVar.nIe = 1;
                        a.this.nIH = aVar;
                    } else {
                        a.this.nIH = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.nIH.nId) {
                            a.this.nIH.linkUrl = a.this.eyX;
                            a.this.nIH.nIe = 1;
                        }
                    }
                    a.this.nIG.a(a.this.nIH);
                }
            }
        }
    };
    private Runnable nxv = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dTJ();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.nId = false;
            aVar.linkUrl = a.this.eyX;
            aVar.nIe = 1;
            a.this.nIH = aVar;
            if (a.this.nIG != null) {
                a.this.nIG.a(a.this.nIH);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0881a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.nII.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.nII);
    }

    public void Ut(String str) {
        this.eyX = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.mY().removeCallbacks(this.nxv);
        e.mY().postDelayed(this.nxv, 15000L);
    }

    public void dTJ() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.mY().removeCallbacks(this.nxv);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.nII);
        e.mY().removeCallbacks(this.nxv);
    }

    public void a(InterfaceC0881a interfaceC0881a) {
        this.nIG = interfaceC0881a;
    }

    public com.baidu.tieba.write.a.a dTK() {
        return this.nIH;
    }
}
