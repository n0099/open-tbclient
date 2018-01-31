package com.baidu.tieba.write.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes2.dex */
public class a {
    private String aKP;
    private InterfaceC0169a hFq;
    private com.baidu.tieba.write.a.a hFr;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hFs = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.ns().removeCallbacks(a.this.bRu);
                if (a.this.hFq != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hEN = false;
                        aVar.linkUrl = a.this.aKP;
                        aVar.hEO = 1;
                        a.this.hFr = aVar;
                    } else {
                        a.this.hFr = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hFr.hEN) {
                            a.this.hFr.linkUrl = a.this.aKP;
                            a.this.hFr.hEO = 1;
                        }
                    }
                    a.this.hFq.a(a.this.hFr);
                }
            }
        }
    };
    private Runnable bRu = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bGd();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hEN = false;
            aVar.linkUrl = a.this.aKP;
            aVar.hEO = 1;
            a.this.hFr = aVar;
            if (a.this.hFq != null) {
                a.this.hFq.a(a.this.hFr);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0169a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hFs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hFs);
    }

    public void uo(String str) {
        this.aKP = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.ns().removeCallbacks(this.bRu);
        e.ns().postDelayed(this.bRu, 15000L);
    }

    public void bGd() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.ns().removeCallbacks(this.bRu);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hFs);
        e.ns().removeCallbacks(this.bRu);
    }

    public void a(InterfaceC0169a interfaceC0169a) {
        this.hFq = interfaceC0169a;
    }

    public com.baidu.tieba.write.a.a bGe() {
        return this.hFr;
    }
}
