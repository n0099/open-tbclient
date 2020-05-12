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
    private String dnX;
    private InterfaceC0699a lzM;
    private com.baidu.tieba.write.a.a lzN;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener lzO = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.lb().removeCallbacks(a.this.lrw);
                if (a.this.lzM != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.lzl = false;
                        aVar.linkUrl = a.this.dnX;
                        aVar.lzm = 1;
                        a.this.lzN = aVar;
                    } else {
                        a.this.lzN = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.lzN.lzl) {
                            a.this.lzN.linkUrl = a.this.dnX;
                            a.this.lzN.lzm = 1;
                        }
                    }
                    a.this.lzM.a(a.this.lzN);
                }
            }
        }
    };
    private Runnable lrw = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dfH();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.lzl = false;
            aVar.linkUrl = a.this.dnX;
            aVar.lzm = 1;
            a.this.lzN = aVar;
            if (a.this.lzM != null) {
                a.this.lzM.a(a.this.lzN);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0699a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.lzO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lzO);
    }

    public void Mz(String str) {
        this.dnX = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.lb().removeCallbacks(this.lrw);
        e.lb().postDelayed(this.lrw, 15000L);
    }

    public void dfH() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.lb().removeCallbacks(this.lrw);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.lzO);
        e.lb().removeCallbacks(this.lrw);
    }

    public void a(InterfaceC0699a interfaceC0699a) {
        this.lzM = interfaceC0699a;
    }

    public com.baidu.tieba.write.a.a dfI() {
        return this.lzN;
    }
}
