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
    private InterfaceC0752a lTb;
    private com.baidu.tieba.write.a.a lTc;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener lTd = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.ld().removeCallbacks(a.this.lKb);
                if (a.this.lTb != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.lSA = false;
                        aVar.linkUrl = a.this.dBY;
                        aVar.lSB = 1;
                        a.this.lTc = aVar;
                    } else {
                        a.this.lTc = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.lTc.lSA) {
                            a.this.lTc.linkUrl = a.this.dBY;
                            a.this.lTc.lSB = 1;
                        }
                    }
                    a.this.lTb.a(a.this.lTc);
                }
            }
        }
    };
    private Runnable lKb = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dmX();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.lSA = false;
            aVar.linkUrl = a.this.dBY;
            aVar.lSB = 1;
            a.this.lTc = aVar;
            if (a.this.lTb != null) {
                a.this.lTb.a(a.this.lTc);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0752a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.lTd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lTd);
    }

    public void Om(String str) {
        this.dBY = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.ld().removeCallbacks(this.lKb);
        e.ld().postDelayed(this.lKb, 15000L);
    }

    public void dmX() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.ld().removeCallbacks(this.lKb);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.lTd);
        e.ld().removeCallbacks(this.lKb);
    }

    public void a(InterfaceC0752a interfaceC0752a) {
        this.lTb = interfaceC0752a;
    }

    public com.baidu.tieba.write.a.a dmY() {
        return this.lTc;
    }
}
