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
    private String VD;
    private InterfaceC0127a gCQ;
    private com.baidu.tieba.write.a.a gCR;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener gCS = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fQ().removeCallbacks(a.this.aYh);
                if (a.this.gCQ != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.gCy = false;
                        aVar.linkUrl = a.this.VD;
                        aVar.gCz = 1;
                        a.this.gCR = aVar;
                    } else {
                        a.this.gCR = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.gCR.gCy) {
                            a.this.gCR.linkUrl = a.this.VD;
                            a.this.gCR.gCz = 1;
                        }
                    }
                    a.this.gCQ.a(a.this.gCR);
                }
            }
        }
    };
    private Runnable aYh = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.byr();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.gCy = false;
            aVar.linkUrl = a.this.VD;
            aVar.gCz = 1;
            a.this.gCR = aVar;
            if (a.this.gCQ != null) {
                a.this.gCQ.a(a.this.gCR);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0127a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.gCS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gCS);
    }

    public void sY(String str) {
        this.VD = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fQ().removeCallbacks(this.aYh);
        e.fQ().postDelayed(this.aYh, 15000L);
    }

    public void byr() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.fQ().removeCallbacks(this.aYh);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gCS);
        e.fQ().removeCallbacks(this.aYh);
    }

    public void a(InterfaceC0127a interfaceC0127a) {
        this.gCQ = interfaceC0127a;
    }

    public com.baidu.tieba.write.a.a bys() {
        return this.gCR;
    }
}
