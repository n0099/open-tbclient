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
    private String Xv;
    private InterfaceC0234a heE;
    private com.baidu.tieba.write.a.a heF;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener heG = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fw().removeCallbacks(a.this.bdu);
                if (a.this.heE != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hec = false;
                        aVar.linkUrl = a.this.Xv;
                        aVar.hed = 1;
                        a.this.heF = aVar;
                    } else {
                        a.this.heF = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.heF.hec) {
                            a.this.heF.linkUrl = a.this.Xv;
                            a.this.heF.hed = 1;
                        }
                    }
                    a.this.heE.a(a.this.heF);
                }
            }
        }
    };
    private Runnable bdu = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bCf();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hec = false;
            aVar.linkUrl = a.this.Xv;
            aVar.hed = 1;
            a.this.heF = aVar;
            if (a.this.heE != null) {
                a.this.heE.a(a.this.heF);
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
        this.heG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.heG);
    }

    public void uO(String str) {
        this.Xv = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fw().removeCallbacks(this.bdu);
        e.fw().postDelayed(this.bdu, 15000L);
    }

    public void bCf() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.fw().removeCallbacks(this.bdu);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.heG);
        e.fw().removeCallbacks(this.bdu);
    }

    public void a(InterfaceC0234a interfaceC0234a) {
        this.heE = interfaceC0234a;
    }

    public com.baidu.tieba.write.a.a bCg() {
        return this.heF;
    }
}
