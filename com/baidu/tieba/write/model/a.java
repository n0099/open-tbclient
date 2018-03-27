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
    private String aLZ;
    private InterfaceC0252a hGZ;
    private com.baidu.tieba.write.a.a hHa;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hHb = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.ns().removeCallbacks(a.this.bTq);
                if (a.this.hGZ != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hGw = false;
                        aVar.linkUrl = a.this.aLZ;
                        aVar.hGx = 1;
                        a.this.hHa = aVar;
                    } else {
                        a.this.hHa = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hHa.hGw) {
                            a.this.hHa.linkUrl = a.this.aLZ;
                            a.this.hHa.hGx = 1;
                        }
                    }
                    a.this.hGZ.a(a.this.hHa);
                }
            }
        }
    };
    private Runnable bTq = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bGV();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hGw = false;
            aVar.linkUrl = a.this.aLZ;
            aVar.hGx = 1;
            a.this.hHa = aVar;
            if (a.this.hGZ != null) {
                a.this.hGZ.a(a.this.hHa);
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
        this.hHb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hHb);
    }

    public void uv(String str) {
        this.aLZ = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.ns().removeCallbacks(this.bTq);
        e.ns().postDelayed(this.bTq, 15000L);
    }

    public void bGV() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.ns().removeCallbacks(this.bTq);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hHb);
        e.ns().removeCallbacks(this.bTq);
    }

    public void a(InterfaceC0252a interfaceC0252a) {
        this.hGZ = interfaceC0252a;
    }

    public com.baidu.tieba.write.a.a bGW() {
        return this.hHa;
    }
}
