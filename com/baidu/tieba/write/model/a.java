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
    private String ahG;
    private InterfaceC0259a hDL;
    private com.baidu.tieba.write.a.a hDM;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hDN = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.jt().removeCallbacks(a.this.btB);
                if (a.this.hDL != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hDk = false;
                        aVar.linkUrl = a.this.ahG;
                        aVar.hDl = 1;
                        a.this.hDM = aVar;
                    } else {
                        a.this.hDM = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hDM.hDk) {
                            a.this.hDM.linkUrl = a.this.ahG;
                            a.this.hDM.hDl = 1;
                        }
                    }
                    a.this.hDL.a(a.this.hDM);
                }
            }
        }
    };
    private Runnable btB = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bJq();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hDk = false;
            aVar.linkUrl = a.this.ahG;
            aVar.hDl = 1;
            a.this.hDM = aVar;
            if (a.this.hDL != null) {
                a.this.hDL.a(a.this.hDM);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0259a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hDN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hDN);
    }

    public void ws(String str) {
        this.ahG = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.jt().removeCallbacks(this.btB);
        e.jt().postDelayed(this.btB, 15000L);
    }

    public void bJq() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.jt().removeCallbacks(this.btB);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hDN);
        e.jt().removeCallbacks(this.btB);
    }

    public void a(InterfaceC0259a interfaceC0259a) {
        this.hDL = interfaceC0259a;
    }

    public com.baidu.tieba.write.a.a bJr() {
        return this.hDM;
    }
}
