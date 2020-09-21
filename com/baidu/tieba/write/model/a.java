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
    private String eal;
    private BdUniqueId mBdUniqueId;
    private InterfaceC0830a mZm;
    private com.baidu.tieba.write.a.a mZn;
    private HttpMessageListener mZo = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.mX().removeCallbacks(a.this.mOl);
                if (a.this.mZm != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.mYJ = false;
                        aVar.linkUrl = a.this.eal;
                        aVar.mYK = 1;
                        a.this.mZn = aVar;
                    } else {
                        a.this.mZn = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.mZn.mYJ) {
                            a.this.mZn.linkUrl = a.this.eal;
                            a.this.mZn.mYK = 1;
                        }
                    }
                    a.this.mZm.a(a.this.mZn);
                }
            }
        }
    };
    private Runnable mOl = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.dKq();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.mYJ = false;
            aVar.linkUrl = a.this.eal;
            aVar.mYK = 1;
            a.this.mZn = aVar;
            if (a.this.mZm != null) {
                a.this.mZm.a(a.this.mZn);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0830a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.mZo.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mZo);
    }

    public void Te(String str) {
        this.eal = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.mX().removeCallbacks(this.mOl);
        e.mX().postDelayed(this.mOl, 15000L);
    }

    public void dKq() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.mX().removeCallbacks(this.mOl);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.mZo);
        e.mX().removeCallbacks(this.mOl);
    }

    public void a(InterfaceC0830a interfaceC0830a) {
        this.mZm = interfaceC0830a;
    }

    public com.baidu.tieba.write.a.a dKr() {
        return this.mZn;
    }
}
