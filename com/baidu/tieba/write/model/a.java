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
/* loaded from: classes2.dex */
public class a {
    private String aMj;
    private InterfaceC0251a hGO;
    private com.baidu.tieba.write.a.a hGP;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hGQ = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.ns().removeCallbacks(a.this.bTz);
                if (a.this.hGO != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hGl = false;
                        aVar.linkUrl = a.this.aMj;
                        aVar.hGm = 1;
                        a.this.hGP = aVar;
                    } else {
                        a.this.hGP = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hGP.hGl) {
                            a.this.hGP.linkUrl = a.this.aMj;
                            a.this.hGP.hGm = 1;
                        }
                    }
                    a.this.hGO.a(a.this.hGP);
                }
            }
        }
    };
    private Runnable bTz = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bGR();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hGl = false;
            aVar.linkUrl = a.this.aMj;
            aVar.hGm = 1;
            a.this.hGP = aVar;
            if (a.this.hGO != null) {
                a.this.hGO.a(a.this.hGP);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0251a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hGQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hGQ);
    }

    public void uv(String str) {
        this.aMj = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.ns().removeCallbacks(this.bTz);
        e.ns().postDelayed(this.bTz, 15000L);
    }

    public void bGR() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.ns().removeCallbacks(this.bTz);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hGQ);
        e.ns().removeCallbacks(this.bTz);
    }

    public void a(InterfaceC0251a interfaceC0251a) {
        this.hGO = interfaceC0251a;
    }

    public com.baidu.tieba.write.a.a bGS() {
        return this.hGP;
    }
}
