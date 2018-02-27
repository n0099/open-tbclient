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
    private String aLY;
    private InterfaceC0252a hGB;
    private com.baidu.tieba.write.a.a hGC;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hGD = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.ns().removeCallbacks(a.this.bTn);
                if (a.this.hGB != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hFY = false;
                        aVar.linkUrl = a.this.aLY;
                        aVar.hFZ = 1;
                        a.this.hGC = aVar;
                    } else {
                        a.this.hGC = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hGC.hFY) {
                            a.this.hGC.linkUrl = a.this.aLY;
                            a.this.hGC.hFZ = 1;
                        }
                    }
                    a.this.hGB.a(a.this.hGC);
                }
            }
        }
    };
    private Runnable bTn = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bGQ();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hFY = false;
            aVar.linkUrl = a.this.aLY;
            aVar.hFZ = 1;
            a.this.hGC = aVar;
            if (a.this.hGB != null) {
                a.this.hGB.a(a.this.hGC);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0252a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hGD.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hGD);
    }

    public void uv(String str) {
        this.aLY = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.ns().removeCallbacks(this.bTn);
        e.ns().postDelayed(this.bTn, 15000L);
    }

    public void bGQ() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.ns().removeCallbacks(this.bTn);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hGD);
        e.ns().removeCallbacks(this.bTn);
    }

    public void a(InterfaceC0252a interfaceC0252a) {
        this.hGB = interfaceC0252a;
    }

    public com.baidu.tieba.write.a.a bGR() {
        return this.hGC;
    }
}
