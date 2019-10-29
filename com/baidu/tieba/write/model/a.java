package com.baidu.tieba.write.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class a {
    private String bYK;
    private InterfaceC0539a jQk;
    private com.baidu.tieba.write.a.a jQl;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener jQm = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fZ().removeCallbacks(a.this.diH);
                if (a.this.jQk != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.jPJ = false;
                        aVar.linkUrl = a.this.bYK;
                        aVar.jPK = 1;
                        a.this.jQl = aVar;
                    } else {
                        a.this.jQl = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.jQl.jPJ) {
                            a.this.jQl.linkUrl = a.this.bYK;
                            a.this.jQl.jPK = 1;
                        }
                    }
                    a.this.jQk.a(a.this.jQl);
                }
            }
        }
    };
    private Runnable diH = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cyw();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.jPJ = false;
            aVar.linkUrl = a.this.bYK;
            aVar.jPK = 1;
            a.this.jQl = aVar;
            if (a.this.jQk != null) {
                a.this.jQk.a(a.this.jQl);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0539a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.jQm.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jQm);
    }

    public void FC(String str) {
        this.bYK = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fZ().removeCallbacks(this.diH);
        e.fZ().postDelayed(this.diH, 15000L);
    }

    public void cyw() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.fZ().removeCallbacks(this.diH);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.jQm);
        e.fZ().removeCallbacks(this.diH);
    }

    public void a(InterfaceC0539a interfaceC0539a) {
        this.jQk = interfaceC0539a;
    }

    public com.baidu.tieba.write.a.a cyx() {
        return this.jQl;
    }
}
