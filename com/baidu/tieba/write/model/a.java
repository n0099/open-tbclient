package com.baidu.tieba.write.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes2.dex */
public class a {
    private String dIt;
    private BdUniqueId mBdUniqueId;
    private InterfaceC0769a moG;
    private com.baidu.tieba.write.a.a moH;
    private HttpMessageListener moI = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.lt().removeCallbacks(a.this.mfa);
                if (a.this.moG != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.moc = false;
                        aVar.linkUrl = a.this.dIt;
                        aVar.mod = 1;
                        a.this.moH = aVar;
                    } else {
                        a.this.moH = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.moH.moc) {
                            a.this.moH.linkUrl = a.this.dIt;
                            a.this.moH.mod = 1;
                        }
                    }
                    a.this.moG.a(a.this.moH);
                }
            }
        }
    };
    private Runnable mfa = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.drA();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.moc = false;
            aVar.linkUrl = a.this.dIt;
            aVar.mod = 1;
            a.this.moH = aVar;
            if (a.this.moG != null) {
                a.this.moG.a(a.this.moH);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0769a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.moI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.moI);
    }

    public void OU(String str) {
        this.dIt = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.lt().removeCallbacks(this.mfa);
        e.lt().postDelayed(this.mfa, 15000L);
    }

    public void drA() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.lt().removeCallbacks(this.mfa);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.moI);
        e.lt().removeCallbacks(this.mfa);
    }

    public void a(InterfaceC0769a interfaceC0769a) {
        this.moG = interfaceC0769a;
    }

    public com.baidu.tieba.write.a.a drB() {
        return this.moH;
    }
}
