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
    private InterfaceC0428a jHP;
    private com.baidu.tieba.write.a.a jHQ;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener jHR = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.iB().removeCallbacks(a.this.cVY);
                if (a.this.jHP != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.jHp = false;
                        aVar.linkUrl = a.this.bFy;
                        aVar.jHq = 1;
                        a.this.jHQ = aVar;
                    } else {
                        a.this.jHQ = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.jHQ.jHp) {
                            a.this.jHQ.linkUrl = a.this.bFy;
                            a.this.jHQ.jHq = 1;
                        }
                    }
                    a.this.jHP.a(a.this.jHQ);
                }
            }
        }
    };
    private Runnable cVY = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cxF();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.jHp = false;
            aVar.linkUrl = a.this.bFy;
            aVar.jHq = 1;
            a.this.jHQ = aVar;
            if (a.this.jHP != null) {
                a.this.jHP.a(a.this.jHQ);
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
        this.jHR.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jHR);
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
        e.iB().removeCallbacks(this.cVY);
        e.iB().postDelayed(this.cVY, 15000L);
    }

    public void cxF() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.iB().removeCallbacks(this.cVY);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.jHR);
        e.iB().removeCallbacks(this.cVY);
    }

    public void a(InterfaceC0428a interfaceC0428a) {
        this.jHP = interfaceC0428a;
    }

    public com.baidu.tieba.write.a.a cxG() {
        return this.jHQ;
    }
}
