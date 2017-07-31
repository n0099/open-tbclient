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
    private InterfaceC0123a gCl;
    private com.baidu.tieba.write.a.a gCm;
    private BdUniqueId mBdUniqueId;
    private String mLinkUrl;
    private HttpMessageListener gCn = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.ga().removeCallbacks(a.this.aYt);
                if (a.this.gCl != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.gBS = false;
                        aVar.linkUrl = a.this.mLinkUrl;
                        aVar.gBT = 1;
                        a.this.gCm = aVar;
                    } else {
                        a.this.gCm = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.gCm.gBS) {
                            a.this.gCm.linkUrl = a.this.mLinkUrl;
                            a.this.gCm.gBT = 1;
                        }
                    }
                    a.this.gCl.a(a.this.gCm);
                }
            }
        }
    };
    private Runnable aYt = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.byC();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.gBS = false;
            aVar.linkUrl = a.this.mLinkUrl;
            aVar.gBT = 1;
            a.this.gCm = aVar;
            if (a.this.gCl != null) {
                a.this.gCl.a(a.this.gCm);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0123a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.gCn.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gCn);
    }

    public void sW(String str) {
        this.mLinkUrl = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.ga().removeCallbacks(this.aYt);
        e.ga().postDelayed(this.aYt, 15000L);
    }

    public void byC() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.ga().removeCallbacks(this.aYt);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gCn);
        e.ga().removeCallbacks(this.aYt);
    }

    public void a(InterfaceC0123a interfaceC0123a) {
        this.gCl = interfaceC0123a;
    }

    public com.baidu.tieba.write.a.a byD() {
        return this.gCm;
    }
}
