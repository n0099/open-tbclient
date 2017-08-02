package com.baidu.tieba.write.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0124a gBa;
    private com.baidu.tieba.write.a.a gBb;
    private BdUniqueId mBdUniqueId;
    private String mLinkUrl;
    private HttpMessageListener gBc = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fP().removeCallbacks(a.this.aXi);
                if (a.this.gBa != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.gAH = false;
                        aVar.linkUrl = a.this.mLinkUrl;
                        aVar.gAI = 1;
                        a.this.gBb = aVar;
                    } else {
                        a.this.gBb = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.gBb.gAH) {
                            a.this.gBb.linkUrl = a.this.mLinkUrl;
                            a.this.gBb.gAI = 1;
                        }
                    }
                    a.this.gBa.a(a.this.gBb);
                }
            }
        }
    };
    private Runnable aXi = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.byv();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.gAH = false;
            aVar.linkUrl = a.this.mLinkUrl;
            aVar.gAI = 1;
            a.this.gBb = aVar;
            if (a.this.gBa != null) {
                a.this.gBa.a(a.this.gBb);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0124a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.gBc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gBc);
    }

    public void sR(String str) {
        this.mLinkUrl = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fP().removeCallbacks(this.aXi);
        e.fP().postDelayed(this.aXi, 15000L);
    }

    public void byv() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.fP().removeCallbacks(this.aXi);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gBc);
        e.fP().removeCallbacks(this.aXi);
    }

    public void a(InterfaceC0124a interfaceC0124a) {
        this.gBa = interfaceC0124a;
    }

    public com.baidu.tieba.write.a.a byw() {
        return this.gBb;
    }
}
