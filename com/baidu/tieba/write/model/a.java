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
    private InterfaceC0897a nWM;
    private com.baidu.tieba.write.a.a nWN;
    private HttpMessageListener nWO = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.mY().removeCallbacks(a.this.nLw);
                if (a.this.nWM != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.nWj = false;
                        aVar.linkUrl = a.this.eFW;
                        aVar.nWk = 1;
                        a.this.nWN = aVar;
                    } else {
                        a.this.nWN = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.nWN.nWj) {
                            a.this.nWN.linkUrl = a.this.eFW;
                            a.this.nWN.nWk = 1;
                        }
                    }
                    a.this.nWM.a(a.this.nWN);
                }
            }
        }
    };
    private Runnable nLw = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dZd();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.nWj = false;
            aVar.linkUrl = a.this.eFW;
            aVar.nWk = 1;
            a.this.nWN = aVar;
            if (a.this.nWM != null) {
                a.this.nWM.a(a.this.nWN);
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
        this.nWO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.nWO);
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
        e.mY().removeCallbacks(this.nLw);
        e.mY().postDelayed(this.nLw, 15000L);
    }

    public void dZd() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.mY().removeCallbacks(this.nLw);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.nWO);
        e.mY().removeCallbacks(this.nLw);
    }

    public void a(InterfaceC0897a interfaceC0897a) {
        this.nWM = interfaceC0897a;
    }

    public com.baidu.tieba.write.a.a dZe() {
        return this.nWN;
    }
}
