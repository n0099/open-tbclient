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
    private InterfaceC0126a gDJ;
    private com.baidu.tieba.write.a.a gDK;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener gDL = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fQ().removeCallbacks(a.this.aYe);
                if (a.this.gDJ != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.gDr = false;
                        aVar.linkUrl = a.this.VD;
                        aVar.gDs = 1;
                        a.this.gDK = aVar;
                    } else {
                        a.this.gDK = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.gDK.gDr) {
                            a.this.gDK.linkUrl = a.this.VD;
                            a.this.gDK.gDs = 1;
                        }
                    }
                    a.this.gDJ.a(a.this.gDK);
                }
            }
        }
    };
    private Runnable aYe = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.byC();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.gDr = false;
            aVar.linkUrl = a.this.VD;
            aVar.gDs = 1;
            a.this.gDK = aVar;
            if (a.this.gDJ != null) {
                a.this.gDJ.a(a.this.gDK);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0126a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.gDL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gDL);
    }

    public void ta(String str) {
        this.VD = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fQ().removeCallbacks(this.aYe);
        e.fQ().postDelayed(this.aYe, 15000L);
    }

    public void byC() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.fQ().removeCallbacks(this.aYe);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gDL);
        e.fQ().removeCallbacks(this.aYe);
    }

    public void a(InterfaceC0126a interfaceC0126a) {
        this.gDJ = interfaceC0126a;
    }

    public com.baidu.tieba.write.a.a byD() {
        return this.gDK;
    }
}
