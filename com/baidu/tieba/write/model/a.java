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
    private String ars;
    private InterfaceC0335a hYm;
    private com.baidu.tieba.write.a.a hYn;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hYo = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.jG().removeCallbacks(a.this.bCE);
                if (a.this.hYm != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hXL = false;
                        aVar.linkUrl = a.this.ars;
                        aVar.hXM = 1;
                        a.this.hYn = aVar;
                    } else {
                        a.this.hYn = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hYn.hXL) {
                            a.this.hYn.linkUrl = a.this.ars;
                            a.this.hYn.hXM = 1;
                        }
                    }
                    a.this.hYm.a(a.this.hYn);
                }
            }
        }
    };
    private Runnable bCE = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bPF();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hXL = false;
            aVar.linkUrl = a.this.ars;
            aVar.hXM = 1;
            a.this.hYn = aVar;
            if (a.this.hYm != null) {
                a.this.hYm.a(a.this.hYn);
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
        this.hYo.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hYo);
    }

    public void xU(String str) {
        this.ars = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(UIMsg.m_AppUI.MSG_APP_GPS));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.jG().removeCallbacks(this.bCE);
        e.jG().postDelayed(this.bCE, 15000L);
    }

    public void bPF() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.jG().removeCallbacks(this.bCE);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hYo);
        e.jG().removeCallbacks(this.bCE);
    }

    public void a(InterfaceC0335a interfaceC0335a) {
        this.hYm = interfaceC0335a;
    }

    public com.baidu.tieba.write.a.a bPG() {
        return this.hYn;
    }
}
