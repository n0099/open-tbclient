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
    private String bGZ;
    private InterfaceC0444a jSy;
    private com.baidu.tieba.write.a.a jSz;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener jSA = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.iK().removeCallbacks(a.this.cZi);
                if (a.this.jSy != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.jRX = false;
                        aVar.linkUrl = a.this.bGZ;
                        aVar.jRY = 1;
                        a.this.jSz = aVar;
                    } else {
                        a.this.jSz = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.jSz.jRX) {
                            a.this.jSz.linkUrl = a.this.bGZ;
                            a.this.jSz.jRY = 1;
                        }
                    }
                    a.this.jSy.a(a.this.jSz);
                }
            }
        }
    };
    private Runnable cZi = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cBM();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.jRX = false;
            aVar.linkUrl = a.this.bGZ;
            aVar.jRY = 1;
            a.this.jSz = aVar;
            if (a.this.jSy != null) {
                a.this.jSy.a(a.this.jSz);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0444a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.jSA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jSA);
    }

    public void Hl(String str) {
        this.bGZ = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.iK().removeCallbacks(this.cZi);
        e.iK().postDelayed(this.cZi, 15000L);
    }

    public void cBM() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.iK().removeCallbacks(this.cZi);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.jSA);
        e.iK().removeCallbacks(this.cZi);
    }

    public void a(InterfaceC0444a interfaceC0444a) {
        this.jSy = interfaceC0444a;
    }

    public com.baidu.tieba.write.a.a cBN() {
        return this.jSz;
    }
}
