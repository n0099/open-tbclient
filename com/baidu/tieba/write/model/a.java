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
    private String bFy;
    private InterfaceC0428a jHO;
    private com.baidu.tieba.write.a.a jHP;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener jHQ = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.iB().removeCallbacks(a.this.cVX);
                if (a.this.jHO != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.jHo = false;
                        aVar.linkUrl = a.this.bFy;
                        aVar.jHp = 1;
                        a.this.jHP = aVar;
                    } else {
                        a.this.jHP = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.jHP.jHo) {
                            a.this.jHP.linkUrl = a.this.bFy;
                            a.this.jHP.jHp = 1;
                        }
                    }
                    a.this.jHO.a(a.this.jHP);
                }
            }
        }
    };
    private Runnable cVX = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cxD();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.jHo = false;
            aVar.linkUrl = a.this.bFy;
            aVar.jHp = 1;
            a.this.jHP = aVar;
            if (a.this.jHO != null) {
                a.this.jHO.a(a.this.jHP);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0428a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.jHQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jHQ);
    }

    public void FO(String str) {
        this.bFy = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(UIMsg.m_AppUI.MSG_APP_GPS));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.iB().removeCallbacks(this.cVX);
        e.iB().postDelayed(this.cVX, 15000L);
    }

    public void cxD() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.iB().removeCallbacks(this.cVX);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.jHQ);
        e.iB().removeCallbacks(this.cVX);
    }

    public void a(InterfaceC0428a interfaceC0428a) {
        this.jHO = interfaceC0428a;
    }

    public com.baidu.tieba.write.a.a cxE() {
        return this.jHP;
    }
}
