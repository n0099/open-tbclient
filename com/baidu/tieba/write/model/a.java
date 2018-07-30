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
    private InterfaceC0253a hvO;
    private com.baidu.tieba.write.a.a hvP;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hvQ = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.in().removeCallbacks(a.this.bnJ);
                if (a.this.hvO != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hvn = false;
                        aVar.linkUrl = a.this.aff;
                        aVar.hvo = 1;
                        a.this.hvP = aVar;
                    } else {
                        a.this.hvP = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hvP.hvn) {
                            a.this.hvP.linkUrl = a.this.aff;
                            a.this.hvP.hvo = 1;
                        }
                    }
                    a.this.hvO.a(a.this.hvP);
                }
            }
        }
    };
    private Runnable bnJ = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bGw();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hvn = false;
            aVar.linkUrl = a.this.aff;
            aVar.hvo = 1;
            a.this.hvP = aVar;
            if (a.this.hvO != null) {
                a.this.hvO.a(a.this.hvP);
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
        this.hvQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hvQ);
    }

    public void vF(String str) {
        this.aff = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.in().removeCallbacks(this.bnJ);
        e.in().postDelayed(this.bnJ, 15000L);
    }

    public void bGw() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.in().removeCallbacks(this.bnJ);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hvQ);
        e.in().removeCallbacks(this.bnJ);
    }

    public void a(InterfaceC0253a interfaceC0253a) {
        this.hvO = interfaceC0253a;
    }

    public com.baidu.tieba.write.a.a bGx() {
        return this.hvP;
    }
}
