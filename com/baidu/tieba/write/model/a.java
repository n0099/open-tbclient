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
/* loaded from: classes13.dex */
public class a {
    private String cOz;
    private InterfaceC0632a kOs;
    private com.baidu.tieba.write.a.a kOt;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener kOu = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.gx().removeCallbacks(a.this.dZP);
                if (a.this.kOs != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.kNR = false;
                        aVar.linkUrl = a.this.cOz;
                        aVar.kNS = 1;
                        a.this.kOt = aVar;
                    } else {
                        a.this.kOt = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.kOt.kNR) {
                            a.this.kOt.linkUrl = a.this.cOz;
                            a.this.kOt.kNS = 1;
                        }
                    }
                    a.this.kOs.a(a.this.kOt);
                }
            }
        }
    };
    private Runnable dZP = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cUP();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.kNR = false;
            aVar.linkUrl = a.this.cOz;
            aVar.kNS = 1;
            a.this.kOt = aVar;
            if (a.this.kOs != null) {
                a.this.kOs.a(a.this.kOt);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0632a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.kOu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kOu);
    }

    public void KR(String str) {
        this.cOz = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.gx().removeCallbacks(this.dZP);
        e.gx().postDelayed(this.dZP, 15000L);
    }

    public void cUP() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.gx().removeCallbacks(this.dZP);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.kOu);
        e.gx().removeCallbacks(this.dZP);
    }

    public void a(InterfaceC0632a interfaceC0632a) {
        this.kOs = interfaceC0632a;
    }

    public com.baidu.tieba.write.a.a cUQ() {
        return this.kOt;
    }
}
