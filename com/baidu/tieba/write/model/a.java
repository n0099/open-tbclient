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
    private String aff;
    private InterfaceC0253a hvQ;
    private com.baidu.tieba.write.a.a hvR;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hvS = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.in().removeCallbacks(a.this.bnM);
                if (a.this.hvQ != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hvp = false;
                        aVar.linkUrl = a.this.aff;
                        aVar.hvq = 1;
                        a.this.hvR = aVar;
                    } else {
                        a.this.hvR = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hvR.hvp) {
                            a.this.hvR.linkUrl = a.this.aff;
                            a.this.hvR.hvq = 1;
                        }
                    }
                    a.this.hvQ.a(a.this.hvR);
                }
            }
        }
    };
    private Runnable bnM = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bGA();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hvp = false;
            aVar.linkUrl = a.this.aff;
            aVar.hvq = 1;
            a.this.hvR = aVar;
            if (a.this.hvQ != null) {
                a.this.hvQ.a(a.this.hvR);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0253a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hvS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hvS);
    }

    public void vJ(String str) {
        this.aff = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.in().removeCallbacks(this.bnM);
        e.in().postDelayed(this.bnM, 15000L);
    }

    public void bGA() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.in().removeCallbacks(this.bnM);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hvS);
        e.in().removeCallbacks(this.bnM);
    }

    public void a(InterfaceC0253a interfaceC0253a) {
        this.hvQ = interfaceC0253a;
    }

    public com.baidu.tieba.write.a.a bGB() {
        return this.hvR;
    }
}
