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
    private InterfaceC0780a mwI;
    private com.baidu.tieba.write.a.a mwJ;
    private HttpMessageListener mwK = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.lt().removeCallbacks(a.this.mmt);
                if (a.this.mwI != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.mwf = false;
                        aVar.linkUrl = a.this.dOE;
                        aVar.mwg = 1;
                        a.this.mwJ = aVar;
                    } else {
                        a.this.mwJ = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.mwJ.mwf) {
                            a.this.mwJ.linkUrl = a.this.dOE;
                            a.this.mwJ.mwg = 1;
                        }
                    }
                    a.this.mwI.a(a.this.mwJ);
                }
            }
        }
    };
    private Runnable mmt = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.duQ();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.mwf = false;
            aVar.linkUrl = a.this.dOE;
            aVar.mwg = 1;
            a.this.mwJ = aVar;
            if (a.this.mwI != null) {
                a.this.mwI.a(a.this.mwJ);
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
        this.mwK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mwK);
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
        e.lt().removeCallbacks(this.mmt);
        e.lt().postDelayed(this.mmt, 15000L);
    }

    public void duQ() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.lt().removeCallbacks(this.mmt);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.mwK);
        e.lt().removeCallbacks(this.mmt);
    }

    public void a(InterfaceC0780a interfaceC0780a) {
        this.mwI = interfaceC0780a;
    }

    public com.baidu.tieba.write.a.a duR() {
        return this.mwJ;
    }
}
