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
    private String Wu;
    private InterfaceC0140a heq;
    private com.baidu.tieba.write.a.a her;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hes = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.fP().removeCallbacks(a.this.bdo);
                if (a.this.heq != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hdP = false;
                        aVar.linkUrl = a.this.Wu;
                        aVar.hdQ = 1;
                        a.this.her = aVar;
                    } else {
                        a.this.her = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.her.hdP) {
                            a.this.her.linkUrl = a.this.Wu;
                            a.this.her.hdQ = 1;
                        }
                    }
                    a.this.heq.a(a.this.her);
                }
            }
        }
    };
    private Runnable bdo = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bGc();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hdP = false;
            aVar.linkUrl = a.this.Wu;
            aVar.hdQ = 1;
            a.this.her = aVar;
            if (a.this.heq != null) {
                a.this.heq.a(a.this.her);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0140a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hes.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hes);
    }

    public void uE(String str) {
        this.Wu = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.fP().removeCallbacks(this.bdo);
        e.fP().postDelayed(this.bdo, 15000L);
    }

    public void bGc() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.fP().removeCallbacks(this.bdo);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hes);
        e.fP().removeCallbacks(this.bdo);
    }

    public void a(InterfaceC0140a interfaceC0140a) {
        this.heq = interfaceC0140a;
    }

    public com.baidu.tieba.write.a.a bGd() {
        return this.her;
    }
}
