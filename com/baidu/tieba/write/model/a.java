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
    private String byj;
    private InterfaceC0409a joW;
    private com.baidu.tieba.write.a.a joX;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener joY = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.jH().removeCallbacks(a.this.cNJ);
                if (a.this.joW != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.jow = false;
                        aVar.linkUrl = a.this.byj;
                        aVar.jox = 1;
                        a.this.joX = aVar;
                    } else {
                        a.this.joX = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.joX.jow) {
                            a.this.joX.linkUrl = a.this.byj;
                            a.this.joX.jox = 1;
                        }
                    }
                    a.this.joW.a(a.this.joX);
                }
            }
        }
    };
    private Runnable cNJ = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cpz();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.jow = false;
            aVar.linkUrl = a.this.byj;
            aVar.jox = 1;
            a.this.joX = aVar;
            if (a.this.joW != null) {
                a.this.joW.a(a.this.joX);
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
        this.joY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.joY);
    }

    public void Et(String str) {
        this.byj = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(UIMsg.m_AppUI.MSG_APP_GPS));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.jH().removeCallbacks(this.cNJ);
        e.jH().postDelayed(this.cNJ, 15000L);
    }

    public void cpz() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.jH().removeCallbacks(this.cNJ);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.joY);
        e.jH().removeCallbacks(this.cNJ);
    }

    public void a(InterfaceC0409a interfaceC0409a) {
        this.joW = interfaceC0409a;
    }

    public com.baidu.tieba.write.a.a cpA() {
        return this.joX;
    }
}
