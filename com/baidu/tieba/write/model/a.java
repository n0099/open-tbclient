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
    private InterfaceC0138a gSn;
    private com.baidu.tieba.write.a.a gSo;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener gSp = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fP().removeCallbacks(a.this.aZU);
                if (a.this.gSn != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.gRW = false;
                        aVar.linkUrl = a.this.VX;
                        aVar.gRX = 1;
                        a.this.gSo = aVar;
                    } else {
                        a.this.gSo = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.gSo.gRW) {
                            a.this.gSo.linkUrl = a.this.VX;
                            a.this.gSo.gRX = 1;
                        }
                    }
                    a.this.gSn.a(a.this.gSo);
                }
            }
        }
    };
    private Runnable aZU = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bDk();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.gRW = false;
            aVar.linkUrl = a.this.VX;
            aVar.gRX = 1;
            a.this.gSo = aVar;
            if (a.this.gSn != null) {
                a.this.gSn.a(a.this.gSo);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0138a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.gSp.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gSp);
    }

    public void tQ(String str) {
        this.VX = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fP().removeCallbacks(this.aZU);
        e.fP().postDelayed(this.aZU, 15000L);
    }

    public void bDk() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.fP().removeCallbacks(this.aZU);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gSp);
        e.fP().removeCallbacks(this.aZU);
    }

    public void a(InterfaceC0138a interfaceC0138a) {
        this.gSn = interfaceC0138a;
    }

    public com.baidu.tieba.write.a.a bDl() {
        return this.gSo;
    }
}
