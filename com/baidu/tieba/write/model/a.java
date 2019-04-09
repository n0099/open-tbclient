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
    private String byn;
    private InterfaceC0409a joM;
    private com.baidu.tieba.write.a.a joN;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener joO = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.jH().removeCallbacks(a.this.cNM);
                if (a.this.joM != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.jom = false;
                        aVar.linkUrl = a.this.byn;
                        aVar.jon = 1;
                        a.this.joN = aVar;
                    } else {
                        a.this.joN = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.joN.jom) {
                            a.this.joN.linkUrl = a.this.byn;
                            a.this.joN.jon = 1;
                        }
                    }
                    a.this.joM.a(a.this.joN);
                }
            }
        }
    };
    private Runnable cNM = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cpx();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.jom = false;
            aVar.linkUrl = a.this.byn;
            aVar.jon = 1;
            a.this.joN = aVar;
            if (a.this.joM != null) {
                a.this.joM.a(a.this.joN);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0409a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.joO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.joO);
    }

    public void Es(String str) {
        this.byn = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(UIMsg.m_AppUI.MSG_APP_GPS));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.jH().removeCallbacks(this.cNM);
        e.jH().postDelayed(this.cNM, 15000L);
    }

    public void cpx() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.jH().removeCallbacks(this.cNM);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.joO);
        e.jH().removeCallbacks(this.cNM);
    }

    public void a(InterfaceC0409a interfaceC0409a) {
        this.joM = interfaceC0409a;
    }

    public com.baidu.tieba.write.a.a cpy() {
        return this.joN;
    }
}
