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
    private String dOE;
    private BdUniqueId mBdUniqueId;
    private InterfaceC0780a mwK;
    private com.baidu.tieba.write.a.a mwL;
    private HttpMessageListener mwM = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.lt().removeCallbacks(a.this.mmv);
                if (a.this.mwK != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.mwh = false;
                        aVar.linkUrl = a.this.dOE;
                        aVar.mwi = 1;
                        a.this.mwL = aVar;
                    } else {
                        a.this.mwL = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.mwL.mwh) {
                            a.this.mwL.linkUrl = a.this.dOE;
                            a.this.mwL.mwi = 1;
                        }
                    }
                    a.this.mwK.a(a.this.mwL);
                }
            }
        }
    };
    private Runnable mmv = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.duR();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.mwh = false;
            aVar.linkUrl = a.this.dOE;
            aVar.mwi = 1;
            a.this.mwL = aVar;
            if (a.this.mwK != null) {
                a.this.mwK.a(a.this.mwL);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0780a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.mwM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mwM);
    }

    public void PG(String str) {
        this.dOE = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.lt().removeCallbacks(this.mmv);
        e.lt().postDelayed(this.mmv, 15000L);
    }

    public void duR() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.lt().removeCallbacks(this.mmv);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.mwM);
        e.lt().removeCallbacks(this.mmv);
    }

    public void a(InterfaceC0780a interfaceC0780a) {
        this.mwK = interfaceC0780a;
    }

    public com.baidu.tieba.write.a.a duS() {
        return this.mwL;
    }
}
