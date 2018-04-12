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
/* loaded from: classes3.dex */
public class a {
    private String Xu;
    private InterfaceC0234a hdD;
    private com.baidu.tieba.write.a.a hdE;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hdF = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fw().removeCallbacks(a.this.bdt);
                if (a.this.hdD != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hdb = false;
                        aVar.linkUrl = a.this.Xu;
                        aVar.hdc = 1;
                        a.this.hdE = aVar;
                    } else {
                        a.this.hdE = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hdE.hdb) {
                            a.this.hdE.linkUrl = a.this.Xu;
                            a.this.hdE.hdc = 1;
                        }
                    }
                    a.this.hdD.a(a.this.hdE);
                }
            }
        }
    };
    private Runnable bdt = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bCh();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hdb = false;
            aVar.linkUrl = a.this.Xu;
            aVar.hdc = 1;
            a.this.hdE = aVar;
            if (a.this.hdD != null) {
                a.this.hdD.a(a.this.hdE);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0234a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hdF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hdF);
    }

    public void uL(String str) {
        this.Xu = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fw().removeCallbacks(this.bdt);
        e.fw().postDelayed(this.bdt, 15000L);
    }

    public void bCh() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.fw().removeCallbacks(this.bdt);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hdF);
        e.fw().removeCallbacks(this.bdt);
    }

    public void a(InterfaceC0234a interfaceC0234a) {
        this.hdD = interfaceC0234a;
    }

    public com.baidu.tieba.write.a.a bCi() {
        return this.hdE;
    }
}
