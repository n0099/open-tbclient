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
    private String VX;
    private InterfaceC0141a gTv;
    private com.baidu.tieba.write.a.a gTw;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener gTx = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fP().removeCallbacks(a.this.bad);
                if (a.this.gTv != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.gTe = false;
                        aVar.linkUrl = a.this.VX;
                        aVar.gTf = 1;
                        a.this.gTw = aVar;
                    } else {
                        a.this.gTw = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.gTw.gTe) {
                            a.this.gTw.linkUrl = a.this.VX;
                            a.this.gTw.gTf = 1;
                        }
                    }
                    a.this.gTv.a(a.this.gTw);
                }
            }
        }
    };
    private Runnable bad = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bDw();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.gTe = false;
            aVar.linkUrl = a.this.VX;
            aVar.gTf = 1;
            a.this.gTw = aVar;
            if (a.this.gTv != null) {
                a.this.gTv.a(a.this.gTw);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0141a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.gTx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gTx);
    }

    public void tW(String str) {
        this.VX = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fP().removeCallbacks(this.bad);
        e.fP().postDelayed(this.bad, 15000L);
    }

    public void bDw() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.fP().removeCallbacks(this.bad);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gTx);
        e.fP().removeCallbacks(this.bad);
    }

    public void a(InterfaceC0141a interfaceC0141a) {
        this.gTv = interfaceC0141a;
    }

    public com.baidu.tieba.write.a.a bDx() {
        return this.gTw;
    }
}
