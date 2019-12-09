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
    private String bXT;
    private InterfaceC0534a jPt;
    private com.baidu.tieba.write.a.a jPu;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener jPv = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fZ().removeCallbacks(a.this.dhP);
                if (a.this.jPt != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.jOS = false;
                        aVar.linkUrl = a.this.bXT;
                        aVar.jOT = 1;
                        a.this.jPu = aVar;
                    } else {
                        a.this.jPu = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.jPu.jOS) {
                            a.this.jPu.linkUrl = a.this.bXT;
                            a.this.jPu.jOT = 1;
                        }
                    }
                    a.this.jPt.a(a.this.jPu);
                }
            }
        }
    };
    private Runnable dhP = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cyu();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.jOS = false;
            aVar.linkUrl = a.this.bXT;
            aVar.jOT = 1;
            a.this.jPu = aVar;
            if (a.this.jPt != null) {
                a.this.jPt.a(a.this.jPu);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0534a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.jPv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jPv);
    }

    public void FC(String str) {
        this.bXT = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fZ().removeCallbacks(this.dhP);
        e.fZ().postDelayed(this.dhP, 15000L);
    }

    public void cyu() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.fZ().removeCallbacks(this.dhP);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.jPv);
        e.fZ().removeCallbacks(this.dhP);
    }

    public void a(InterfaceC0534a interfaceC0534a) {
        this.jPt = interfaceC0534a;
    }

    public com.baidu.tieba.write.a.a cyv() {
        return this.jPu;
    }
}
