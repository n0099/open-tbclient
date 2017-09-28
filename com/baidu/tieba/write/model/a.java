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
    private String VR;
    private InterfaceC0137a gIF;
    private com.baidu.tieba.write.a.a gIG;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener gIH = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fP().removeCallbacks(a.this.aZR);
                if (a.this.gIF != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.gIo = false;
                        aVar.linkUrl = a.this.VR;
                        aVar.gIp = 1;
                        a.this.gIG = aVar;
                    } else {
                        a.this.gIG = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.gIG.gIo) {
                            a.this.gIG.linkUrl = a.this.VR;
                            a.this.gIG.gIp = 1;
                        }
                    }
                    a.this.gIF.a(a.this.gIG);
                }
            }
        }
    };
    private Runnable aZR = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bzT();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.gIo = false;
            aVar.linkUrl = a.this.VR;
            aVar.gIp = 1;
            a.this.gIG = aVar;
            if (a.this.gIF != null) {
                a.this.gIF.a(a.this.gIG);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0137a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.gIH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gIH);
    }

    public void te(String str) {
        this.VR = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fP().removeCallbacks(this.aZR);
        e.fP().postDelayed(this.aZR, 15000L);
    }

    public void bzT() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.fP().removeCallbacks(this.aZR);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gIH);
        e.fP().removeCallbacks(this.aZR);
    }

    public void a(InterfaceC0137a interfaceC0137a) {
        this.gIF = interfaceC0137a;
    }

    public com.baidu.tieba.write.a.a bzU() {
        return this.gIG;
    }
}
