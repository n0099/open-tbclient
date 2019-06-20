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
    private String bFz;
    private InterfaceC0428a jHS;
    private com.baidu.tieba.write.a.a jHT;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener jHU = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.iB().removeCallbacks(a.this.cVZ);
                if (a.this.jHS != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.jHs = false;
                        aVar.linkUrl = a.this.bFz;
                        aVar.jHt = 1;
                        a.this.jHT = aVar;
                    } else {
                        a.this.jHT = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.jHT.jHs) {
                            a.this.jHT.linkUrl = a.this.bFz;
                            a.this.jHT.jHt = 1;
                        }
                    }
                    a.this.jHS.a(a.this.jHT);
                }
            }
        }
    };
    private Runnable cVZ = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cxE();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.jHs = false;
            aVar.linkUrl = a.this.bFz;
            aVar.jHt = 1;
            a.this.jHT = aVar;
            if (a.this.jHS != null) {
                a.this.jHS.a(a.this.jHT);
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
        this.jHU.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jHU);
    }

    public void FQ(String str) {
        this.bFz = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(UIMsg.m_AppUI.MSG_APP_GPS));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.iB().removeCallbacks(this.cVZ);
        e.iB().postDelayed(this.cVZ, 15000L);
    }

    public void cxE() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.iB().removeCallbacks(this.cVZ);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.jHU);
        e.iB().removeCallbacks(this.cVZ);
    }

    public void a(InterfaceC0428a interfaceC0428a) {
        this.jHS = interfaceC0428a;
    }

    public com.baidu.tieba.write.a.a cxF() {
        return this.jHT;
    }
}
