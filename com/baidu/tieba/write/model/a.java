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
    private String VF;
    private InterfaceC0137a gIp;
    private com.baidu.tieba.write.a.a gIq;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener gIr = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fP().removeCallbacks(a.this.aZD);
                if (a.this.gIp != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.gHY = false;
                        aVar.linkUrl = a.this.VF;
                        aVar.gHZ = 1;
                        a.this.gIq = aVar;
                    } else {
                        a.this.gIq = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.gIq.gHY) {
                            a.this.gIq.linkUrl = a.this.VF;
                            a.this.gIq.gHZ = 1;
                        }
                    }
                    a.this.gIp.a(a.this.gIq);
                }
            }
        }
    };
    private Runnable aZD = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bzM();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.gHY = false;
            aVar.linkUrl = a.this.VF;
            aVar.gHZ = 1;
            a.this.gIq = aVar;
            if (a.this.gIp != null) {
                a.this.gIp.a(a.this.gIq);
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
        this.gIr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gIr);
    }

    public void td(String str) {
        this.VF = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fP().removeCallbacks(this.aZD);
        e.fP().postDelayed(this.aZD, 15000L);
    }

    public void bzM() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.fP().removeCallbacks(this.aZD);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gIr);
        e.fP().removeCallbacks(this.aZD);
    }

    public void a(InterfaceC0137a interfaceC0137a) {
        this.gIp = interfaceC0137a;
    }

    public com.baidu.tieba.write.a.a bzN() {
        return this.gIq;
    }
}
