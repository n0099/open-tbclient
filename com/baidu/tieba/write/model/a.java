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
    private String bGA;
    private InterfaceC0427a jOU;
    private com.baidu.tieba.write.a.a jOV;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener jOW = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.iK().removeCallbacks(a.this.cXv);
                if (a.this.jOU != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.jOv = false;
                        aVar.linkUrl = a.this.bGA;
                        aVar.jOw = 1;
                        a.this.jOV = aVar;
                    } else {
                        a.this.jOV = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.jOV.jOv) {
                            a.this.jOV.linkUrl = a.this.bGA;
                            a.this.jOV.jOw = 1;
                        }
                    }
                    a.this.jOU.a(a.this.jOV);
                }
            }
        }
    };
    private Runnable cXv = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cAD();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.jOv = false;
            aVar.linkUrl = a.this.bGA;
            aVar.jOw = 1;
            a.this.jOV = aVar;
            if (a.this.jOU != null) {
                a.this.jOU.a(a.this.jOV);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0427a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.jOW.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jOW);
    }

    public void GK(String str) {
        this.bGA = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(UIMsg.m_AppUI.MSG_APP_GPS));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.iK().removeCallbacks(this.cXv);
        e.iK().postDelayed(this.cXv, 15000L);
    }

    public void cAD() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.iK().removeCallbacks(this.cXv);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.jOW);
        e.iK().removeCallbacks(this.cXv);
    }

    public void a(InterfaceC0427a interfaceC0427a) {
        this.jOU = interfaceC0427a;
    }

    public com.baidu.tieba.write.a.a cAE() {
        return this.jOV;
    }
}
