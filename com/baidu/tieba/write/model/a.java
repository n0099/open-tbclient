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
/* loaded from: classes3.dex */
public class a {
    private String emn;
    private BdUniqueId mBdUniqueId;
    private InterfaceC0848a noM;
    private com.baidu.tieba.write.a.a noN;
    private HttpMessageListener noO = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.mY().removeCallbacks(a.this.ndR);
                if (a.this.noM != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.noh = false;
                        aVar.linkUrl = a.this.emn;
                        aVar.noi = 1;
                        a.this.noN = aVar;
                    } else {
                        a.this.noN = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.noN.noh) {
                            a.this.noN.linkUrl = a.this.emn;
                            a.this.noN.noi = 1;
                        }
                    }
                    a.this.noM.a(a.this.noN);
                }
            }
        }
    };
    private Runnable ndR = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dOc();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.noh = false;
            aVar.linkUrl = a.this.emn;
            aVar.noi = 1;
            a.this.noN = aVar;
            if (a.this.noM != null) {
                a.this.noM.a(a.this.noN);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0848a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.noO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.noO);
    }

    public void TS(String str) {
        this.emn = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.mY().removeCallbacks(this.ndR);
        e.mY().postDelayed(this.ndR, 15000L);
    }

    public void dOc() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.mY().removeCallbacks(this.ndR);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.noO);
        e.mY().removeCallbacks(this.ndR);
    }

    public void a(InterfaceC0848a interfaceC0848a) {
        this.noM = interfaceC0848a;
    }

    public com.baidu.tieba.write.a.a dOd() {
        return this.noN;
    }
}
