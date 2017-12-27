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
    private String aKO;
    private InterfaceC0169a hPo;
    private com.baidu.tieba.write.a.a hPp;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hPq = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.nr().removeCallbacks(a.this.bRf);
                if (a.this.hPo != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hOL = false;
                        aVar.linkUrl = a.this.aKO;
                        aVar.hOM = 1;
                        a.this.hPp = aVar;
                    } else {
                        a.this.hPp = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hPp.hOL) {
                            a.this.hPp.linkUrl = a.this.aKO;
                            a.this.hPp.hOM = 1;
                        }
                    }
                    a.this.hPo.a(a.this.hPp);
                }
            }
        }
    };
    private Runnable bRf = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bMB();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hOL = false;
            aVar.linkUrl = a.this.aKO;
            aVar.hOM = 1;
            a.this.hPp = aVar;
            if (a.this.hPo != null) {
                a.this.hPo.a(a.this.hPp);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0169a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hPq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hPq);
    }

    public void uM(String str) {
        this.aKO = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.nr().removeCallbacks(this.bRf);
        e.nr().postDelayed(this.bRf, 15000L);
    }

    public void bMB() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.nr().removeCallbacks(this.bRf);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hPq);
        e.nr().removeCallbacks(this.bRf);
    }

    public void a(InterfaceC0169a interfaceC0169a) {
        this.hPo = interfaceC0169a;
    }

    public com.baidu.tieba.write.a.a bMC() {
        return this.hPp;
    }
}
