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
/* loaded from: classes3.dex */
public class a {
    private String amC;
    private InterfaceC0294a hKZ;
    private com.baidu.tieba.write.a.a hLa;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hLb = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.jI().removeCallbacks(a.this.bxG);
                if (a.this.hKZ != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hKy = false;
                        aVar.linkUrl = a.this.amC;
                        aVar.hKz = 1;
                        a.this.hLa = aVar;
                    } else {
                        a.this.hLa = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hLa.hKy) {
                            a.this.hLa.linkUrl = a.this.amC;
                            a.this.hLa.hKz = 1;
                        }
                    }
                    a.this.hKZ.a(a.this.hLa);
                }
            }
        }
    };
    private Runnable bxG = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bMC();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hKy = false;
            aVar.linkUrl = a.this.amC;
            aVar.hKz = 1;
            a.this.hLa = aVar;
            if (a.this.hKZ != null) {
                a.this.hKZ.a(a.this.hLa);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0294a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hLb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hLb);
    }

    public void wT(String str) {
        this.amC = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.jI().removeCallbacks(this.bxG);
        e.jI().postDelayed(this.bxG, 15000L);
    }

    public void bMC() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.jI().removeCallbacks(this.bxG);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hLb);
        e.jI().removeCallbacks(this.bxG);
    }

    public void a(InterfaceC0294a interfaceC0294a) {
        this.hKZ = interfaceC0294a;
    }

    public com.baidu.tieba.write.a.a bMD() {
        return this.hLa;
    }
}
