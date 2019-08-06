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
    private String bGB;
    private InterfaceC0433a jQb;
    private com.baidu.tieba.write.a.a jQc;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener jQd = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.iK().removeCallbacks(a.this.cXC);
                if (a.this.jQb != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.jPC = false;
                        aVar.linkUrl = a.this.bGB;
                        aVar.jPD = 1;
                        a.this.jQc = aVar;
                    } else {
                        a.this.jQc = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.jQc.jPC) {
                            a.this.jQc.linkUrl = a.this.bGB;
                            a.this.jQc.jPD = 1;
                        }
                    }
                    a.this.jQb.a(a.this.jQc);
                }
            }
        }
    };
    private Runnable cXC = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cAY();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.jPC = false;
            aVar.linkUrl = a.this.bGB;
            aVar.jPD = 1;
            a.this.jQc = aVar;
            if (a.this.jQb != null) {
                a.this.jQb.a(a.this.jQc);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0433a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.jQd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jQd);
    }

    public void GL(String str) {
        this.bGB = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(UIMsg.m_AppUI.MSG_APP_GPS));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.iK().removeCallbacks(this.cXC);
        e.iK().postDelayed(this.cXC, 15000L);
    }

    public void cAY() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.iK().removeCallbacks(this.cXC);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.jQd);
        e.iK().removeCallbacks(this.cXC);
    }

    public void a(InterfaceC0433a interfaceC0433a) {
        this.jQb = interfaceC0433a;
    }

    public com.baidu.tieba.write.a.a cAZ() {
        return this.jQc;
    }
}
