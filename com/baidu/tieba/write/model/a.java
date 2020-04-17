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
    private String dnT;
    private InterfaceC0678a lzI;
    private com.baidu.tieba.write.a.a lzJ;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener lzK = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.lb().removeCallbacks(a.this.lrs);
                if (a.this.lzI != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.lzh = false;
                        aVar.linkUrl = a.this.dnT;
                        aVar.lzi = 1;
                        a.this.lzJ = aVar;
                    } else {
                        a.this.lzJ = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.lzJ.lzh) {
                            a.this.lzJ.linkUrl = a.this.dnT;
                            a.this.lzJ.lzi = 1;
                        }
                    }
                    a.this.lzI.a(a.this.lzJ);
                }
            }
        }
    };
    private Runnable lrs = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dfJ();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.lzh = false;
            aVar.linkUrl = a.this.dnT;
            aVar.lzi = 1;
            a.this.lzJ = aVar;
            if (a.this.lzI != null) {
                a.this.lzI.a(a.this.lzJ);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0678a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.lzK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lzK);
    }

    public void Mw(String str) {
        this.dnT = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.lb().removeCallbacks(this.lrs);
        e.lb().postDelayed(this.lrs, 15000L);
    }

    public void dfJ() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.lb().removeCallbacks(this.lrs);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.lzK);
        e.lb().removeCallbacks(this.lrs);
    }

    public void a(InterfaceC0678a interfaceC0678a) {
        this.lzI = interfaceC0678a;
    }

    public com.baidu.tieba.write.a.a dfK() {
        return this.lzJ;
    }
}
