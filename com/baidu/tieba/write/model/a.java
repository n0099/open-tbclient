package com.baidu.tieba.write.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class a {
    private String art;
    private InterfaceC0335a hYn;
    private com.baidu.tieba.write.a.a hYo;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hYp = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.jG().removeCallbacks(a.this.bCF);
                if (a.this.hYn != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hXM = false;
                        aVar.linkUrl = a.this.art;
                        aVar.hXN = 1;
                        a.this.hYo = aVar;
                    } else {
                        a.this.hYo = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hYo.hXM) {
                            a.this.hYo.linkUrl = a.this.art;
                            a.this.hYo.hXN = 1;
                        }
                    }
                    a.this.hYn.a(a.this.hYo);
                }
            }
        }
    };
    private Runnable bCF = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bPF();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hXM = false;
            aVar.linkUrl = a.this.art;
            aVar.hXN = 1;
            a.this.hYo = aVar;
            if (a.this.hYn != null) {
                a.this.hYn.a(a.this.hYo);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0335a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hYp.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hYp);
    }

    public void xU(String str) {
        this.art = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(UIMsg.m_AppUI.MSG_APP_GPS));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.jG().removeCallbacks(this.bCF);
        e.jG().postDelayed(this.bCF, 15000L);
    }

    public void bPF() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.jG().removeCallbacks(this.bCF);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hYp);
        e.jG().removeCallbacks(this.bCF);
    }

    public void a(InterfaceC0335a interfaceC0335a) {
        this.hYn = interfaceC0335a;
    }

    public com.baidu.tieba.write.a.a bPG() {
        return this.hYo;
    }
}
