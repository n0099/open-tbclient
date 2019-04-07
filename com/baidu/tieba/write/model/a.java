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
    private String bym;
    private InterfaceC0409a joL;
    private com.baidu.tieba.write.a.a joM;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener joN = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.jH().removeCallbacks(a.this.cNL);
                if (a.this.joL != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.jol = false;
                        aVar.linkUrl = a.this.bym;
                        aVar.jom = 1;
                        a.this.joM = aVar;
                    } else {
                        a.this.joM = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.joM.jol) {
                            a.this.joM.linkUrl = a.this.bym;
                            a.this.joM.jom = 1;
                        }
                    }
                    a.this.joL.a(a.this.joM);
                }
            }
        }
    };
    private Runnable cNL = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cpx();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.jol = false;
            aVar.linkUrl = a.this.bym;
            aVar.jom = 1;
            a.this.joM = aVar;
            if (a.this.joL != null) {
                a.this.joL.a(a.this.joM);
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
        this.joN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.joN);
    }

    public void Es(String str) {
        this.bym = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(UIMsg.m_AppUI.MSG_APP_GPS));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.jH().removeCallbacks(this.cNL);
        e.jH().postDelayed(this.cNL, 15000L);
    }

    public void cpx() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.jH().removeCallbacks(this.cNL);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.joN);
        e.jH().removeCallbacks(this.cNL);
    }

    public void a(InterfaceC0409a interfaceC0409a) {
        this.joL = interfaceC0409a;
    }

    public com.baidu.tieba.write.a.a cpy() {
        return this.joM;
    }
}
