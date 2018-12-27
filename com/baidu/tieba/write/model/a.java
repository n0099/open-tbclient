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
    private String aqQ;
    private InterfaceC0336a hXf;
    private com.baidu.tieba.write.a.a hXg;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hXh = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.jG().removeCallbacks(a.this.bBR);
                if (a.this.hXf != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hWE = false;
                        aVar.linkUrl = a.this.aqQ;
                        aVar.hWF = 1;
                        a.this.hXg = aVar;
                    } else {
                        a.this.hXg = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hXg.hWE) {
                            a.this.hXg.linkUrl = a.this.aqQ;
                            a.this.hXg.hWF = 1;
                        }
                    }
                    a.this.hXf.a(a.this.hXg);
                }
            }
        }
    };
    private Runnable bBR = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bOX();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hWE = false;
            aVar.linkUrl = a.this.aqQ;
            aVar.hWF = 1;
            a.this.hXg = aVar;
            if (a.this.hXf != null) {
                a.this.hXf.a(a.this.hXg);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0336a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hXh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hXh);
    }

    public void xE(String str) {
        this.aqQ = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(UIMsg.m_AppUI.MSG_APP_GPS));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.jG().removeCallbacks(this.bBR);
        e.jG().postDelayed(this.bBR, 15000L);
    }

    public void bOX() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.jG().removeCallbacks(this.bBR);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hXh);
        e.jG().removeCallbacks(this.bBR);
    }

    public void a(InterfaceC0336a interfaceC0336a) {
        this.hXf = interfaceC0336a;
    }

    public com.baidu.tieba.write.a.a bOY() {
        return this.hXg;
    }
}
