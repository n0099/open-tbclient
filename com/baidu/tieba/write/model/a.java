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
/* loaded from: classes10.dex */
public class a {
    private String cKl;
    private InterfaceC0619a kKg;
    private com.baidu.tieba.write.a.a kKh;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener kKi = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.gy().removeCallbacks(a.this.dVC);
                if (a.this.kKg != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.kJF = false;
                        aVar.linkUrl = a.this.cKl;
                        aVar.kJG = 1;
                        a.this.kKh = aVar;
                    } else {
                        a.this.kKh = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.kKh.kJF) {
                            a.this.kKh.linkUrl = a.this.cKl;
                            a.this.kKh.kJG = 1;
                        }
                    }
                    a.this.kKg.a(a.this.kKh);
                }
            }
        }
    };
    private Runnable dVC = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cSw();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.kJF = false;
            aVar.linkUrl = a.this.cKl;
            aVar.kJG = 1;
            a.this.kKh = aVar;
            if (a.this.kKg != null) {
                a.this.kKg.a(a.this.kKh);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0619a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.kKi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kKi);
    }

    public void Ku(String str) {
        this.cKl = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.gy().removeCallbacks(this.dVC);
        e.gy().postDelayed(this.dVC, 15000L);
    }

    public void cSw() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.gy().removeCallbacks(this.dVC);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.kKi);
        e.gy().removeCallbacks(this.dVC);
    }

    public void a(InterfaceC0619a interfaceC0619a) {
        this.kKg = interfaceC0619a;
    }

    public com.baidu.tieba.write.a.a cSx() {
        return this.kKh;
    }
}
