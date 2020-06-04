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
    private String dBY;
    private InterfaceC0753a lUm;
    private com.baidu.tieba.write.a.a lUn;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener lUo = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.ld().removeCallbacks(a.this.lLj);
                if (a.this.lUm != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.lTL = false;
                        aVar.linkUrl = a.this.dBY;
                        aVar.lTM = 1;
                        a.this.lUn = aVar;
                    } else {
                        a.this.lUn = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.lUn.lTL) {
                            a.this.lUn.linkUrl = a.this.dBY;
                            a.this.lUn.lTM = 1;
                        }
                    }
                    a.this.lUm.a(a.this.lUn);
                }
            }
        }
    };
    private Runnable lLj = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dnn();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.lTL = false;
            aVar.linkUrl = a.this.dBY;
            aVar.lTM = 1;
            a.this.lUn = aVar;
            if (a.this.lUm != null) {
                a.this.lUm.a(a.this.lUn);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0753a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.lUo.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lUo);
    }

    public void On(String str) {
        this.dBY = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.ld().removeCallbacks(this.lLj);
        e.ld().postDelayed(this.lLj, 15000L);
    }

    public void dnn() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.ld().removeCallbacks(this.lLj);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.lUo);
        e.ld().removeCallbacks(this.lLj);
    }

    public void a(InterfaceC0753a interfaceC0753a) {
        this.lUm = interfaceC0753a;
    }

    public com.baidu.tieba.write.a.a dno() {
        return this.lUn;
    }
}
