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
    private String dYb;
    private BdUniqueId mBdUniqueId;
    private InterfaceC0833a mPr;
    private com.baidu.tieba.write.a.a mPs;
    private HttpMessageListener mPt = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.mS().removeCallbacks(a.this.mEA);
                if (a.this.mPr != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.mOM = false;
                        aVar.linkUrl = a.this.dYb;
                        aVar.mON = 1;
                        a.this.mPs = aVar;
                    } else {
                        a.this.mPs = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.mPs.mOM) {
                            a.this.mPs.linkUrl = a.this.dYb;
                            a.this.mPs.mON = 1;
                        }
                    }
                    a.this.mPr.a(a.this.mPs);
                }
            }
        }
    };
    private Runnable mEA = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dGw();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.mOM = false;
            aVar.linkUrl = a.this.dYb;
            aVar.mON = 1;
            a.this.mPs = aVar;
            if (a.this.mPr != null) {
                a.this.mPr.a(a.this.mPs);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0833a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.mPt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mPt);
    }

    public void SE(String str) {
        this.dYb = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.mS().removeCallbacks(this.mEA);
        e.mS().postDelayed(this.mEA, 15000L);
    }

    public void dGw() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.mS().removeCallbacks(this.mEA);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.mPt);
        e.mS().removeCallbacks(this.mEA);
    }

    public void a(InterfaceC0833a interfaceC0833a) {
        this.mPr = interfaceC0833a;
    }

    public com.baidu.tieba.write.a.a dGx() {
        return this.mPs;
    }
}
