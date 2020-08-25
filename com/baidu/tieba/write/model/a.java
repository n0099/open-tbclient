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
    private String dXX;
    private BdUniqueId mBdUniqueId;
    private InterfaceC0833a mOX;
    private com.baidu.tieba.write.a.a mOY;
    private HttpMessageListener mOZ = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.mS().removeCallbacks(a.this.mEi);
                if (a.this.mOX != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.mOu = false;
                        aVar.linkUrl = a.this.dXX;
                        aVar.mOv = 1;
                        a.this.mOY = aVar;
                    } else {
                        a.this.mOY = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.mOY.mOu) {
                            a.this.mOY.linkUrl = a.this.dXX;
                            a.this.mOY.mOv = 1;
                        }
                    }
                    a.this.mOX.a(a.this.mOY);
                }
            }
        }
    };
    private Runnable mEi = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dGn();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.mOu = false;
            aVar.linkUrl = a.this.dXX;
            aVar.mOv = 1;
            a.this.mOY = aVar;
            if (a.this.mOX != null) {
                a.this.mOX.a(a.this.mOY);
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
        this.mOZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mOZ);
    }

    public void SE(String str) {
        this.dXX = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.mS().removeCallbacks(this.mEi);
        e.mS().postDelayed(this.mEi, 15000L);
    }

    public void dGn() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.mS().removeCallbacks(this.mEi);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.mOZ);
        e.mS().removeCallbacks(this.mEi);
    }

    public void a(InterfaceC0833a interfaceC0833a) {
        this.mOX = interfaceC0833a;
    }

    public com.baidu.tieba.write.a.a dGo() {
        return this.mOY;
    }
}
