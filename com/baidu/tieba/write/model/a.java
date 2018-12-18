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
    private InterfaceC0336a hTU;
    private com.baidu.tieba.write.a.a hTV;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hTW = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.jG().removeCallbacks(a.this.bBO);
                if (a.this.hTU != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hTt = false;
                        aVar.linkUrl = a.this.aqQ;
                        aVar.hTu = 1;
                        a.this.hTV = aVar;
                    } else {
                        a.this.hTV = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hTV.hTt) {
                            a.this.hTV.linkUrl = a.this.aqQ;
                            a.this.hTV.hTu = 1;
                        }
                    }
                    a.this.hTU.a(a.this.hTV);
                }
            }
        }
    };
    private Runnable bBO = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bOg();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hTt = false;
            aVar.linkUrl = a.this.aqQ;
            aVar.hTu = 1;
            a.this.hTV = aVar;
            if (a.this.hTU != null) {
                a.this.hTU.a(a.this.hTV);
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
        this.hTW.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hTW);
    }

    public void xB(String str) {
        this.aqQ = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(UIMsg.m_AppUI.MSG_APP_GPS));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.jG().removeCallbacks(this.bBO);
        e.jG().postDelayed(this.bBO, 15000L);
    }

    public void bOg() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.jG().removeCallbacks(this.bBO);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hTW);
        e.jG().removeCallbacks(this.bBO);
    }

    public void a(InterfaceC0336a interfaceC0336a) {
        this.hTU = interfaceC0336a;
    }

    public com.baidu.tieba.write.a.a bOh() {
        return this.hTV;
    }
}
