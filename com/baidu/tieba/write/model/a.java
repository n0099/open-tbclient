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
    private InterfaceC0294a hKY;
    private com.baidu.tieba.write.a.a hKZ;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hLa = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.jI().removeCallbacks(a.this.bxG);
                if (a.this.hKY != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hKx = false;
                        aVar.linkUrl = a.this.amC;
                        aVar.hKy = 1;
                        a.this.hKZ = aVar;
                    } else {
                        a.this.hKZ = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hKZ.hKx) {
                            a.this.hKZ.linkUrl = a.this.amC;
                            a.this.hKZ.hKy = 1;
                        }
                    }
                    a.this.hKY.a(a.this.hKZ);
                }
            }
        }
    };
    private Runnable bxG = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bMC();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hKx = false;
            aVar.linkUrl = a.this.amC;
            aVar.hKy = 1;
            a.this.hKZ = aVar;
            if (a.this.hKY != null) {
                a.this.hKY.a(a.this.hKZ);
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
        this.hLa.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hLa);
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
        MessageManager.getInstance().unRegisterListener(this.hLa);
        e.jI().removeCallbacks(this.bxG);
    }

    public void a(InterfaceC0294a interfaceC0294a) {
        this.hKY = interfaceC0294a;
    }

    public com.baidu.tieba.write.a.a bMD() {
        return this.hKZ;
    }
}
