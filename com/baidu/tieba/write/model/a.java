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
    private InterfaceC0137a gIE;
    private com.baidu.tieba.write.a.a gIF;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener gIG = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fP().removeCallbacks(a.this.aZR);
                if (a.this.gIE != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.gIn = false;
                        aVar.linkUrl = a.this.VR;
                        aVar.gIo = 1;
                        a.this.gIF = aVar;
                    } else {
                        a.this.gIF = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.gIF.gIn) {
                            a.this.gIF.linkUrl = a.this.VR;
                            a.this.gIF.gIo = 1;
                        }
                    }
                    a.this.gIE.a(a.this.gIF);
                }
            }
        }
    };
    private Runnable aZR = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bzS();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.gIn = false;
            aVar.linkUrl = a.this.VR;
            aVar.gIo = 1;
            a.this.gIF = aVar;
            if (a.this.gIE != null) {
                a.this.gIE.a(a.this.gIF);
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
        this.gIG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gIG);
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

    public void bzS() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.fP().removeCallbacks(this.aZR);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gIG);
        e.fP().removeCallbacks(this.aZR);
    }

    public void a(InterfaceC0137a interfaceC0137a) {
        this.gIE = interfaceC0137a;
    }

    public com.baidu.tieba.write.a.a bzT() {
        return this.gIF;
    }
}
