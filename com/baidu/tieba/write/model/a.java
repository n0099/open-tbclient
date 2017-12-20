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
    private String Wo;
    private InterfaceC0157a hhi;
    private com.baidu.tieba.write.a.a hhj;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hhk = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fP().removeCallbacks(a.this.bdp);
                if (a.this.hhi != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hgF = false;
                        aVar.linkUrl = a.this.Wo;
                        aVar.hgG = 1;
                        a.this.hhj = aVar;
                    } else {
                        a.this.hhj = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hhj.hgF) {
                            a.this.hhj.linkUrl = a.this.Wo;
                            a.this.hhj.hgG = 1;
                        }
                    }
                    a.this.hhi.a(a.this.hhj);
                }
            }
        }
    };
    private Runnable bdp = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bGN();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hgF = false;
            aVar.linkUrl = a.this.Wo;
            aVar.hgG = 1;
            a.this.hhj = aVar;
            if (a.this.hhi != null) {
                a.this.hhi.a(a.this.hhj);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0157a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hhk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hhk);
    }

    public void uJ(String str) {
        this.Wo = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fP().removeCallbacks(this.bdp);
        e.fP().postDelayed(this.bdp, 15000L);
    }

    public void bGN() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.fP().removeCallbacks(this.bdp);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hhk);
        e.fP().removeCallbacks(this.bdp);
    }

    public void a(InterfaceC0157a interfaceC0157a) {
        this.hhi = interfaceC0157a;
    }

    public com.baidu.tieba.write.a.a bGO() {
        return this.hhj;
    }
}
