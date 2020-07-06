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
    private InterfaceC0770a moJ;
    private com.baidu.tieba.write.a.a moK;
    private HttpMessageListener moL = new HttpMessageListener(1003324) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.lt().removeCallbacks(a.this.mfd);
                if (a.this.moJ != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.mof = false;
                        aVar.linkUrl = a.this.dIt;
                        aVar.mog = 1;
                        a.this.moK = aVar;
                    } else {
                        a.this.moK = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.moK.mof) {
                            a.this.moK.linkUrl = a.this.dIt;
                            a.this.moK.mog = 1;
                        }
                    }
                    a.this.moJ.a(a.this.moK);
                }
            }
        }
    };
    private Runnable mfd = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.drE();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.mof = false;
            aVar.linkUrl = a.this.dIt;
            aVar.mog = 1;
            a.this.moK = aVar;
            if (a.this.moJ != null) {
                a.this.moJ.a(a.this.moK);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0770a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.moL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.moL);
    }

    public void OV(String str) {
        this.dIt = str;
        HttpMessage httpMessage = new HttpMessage(1003324, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003324, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.d.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.lt().removeCallbacks(this.mfd);
        e.lt().postDelayed(this.mfd, 15000L);
    }

    public void drE() {
        MessageManager.getInstance().removeMessage(1003324, this.mBdUniqueId);
        e.lt().removeCallbacks(this.mfd);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.moL);
        e.lt().removeCallbacks(this.mfd);
    }

    public void a(InterfaceC0770a interfaceC0770a) {
        this.moJ = interfaceC0770a;
    }

    public com.baidu.tieba.write.a.a drF() {
        return this.moK;
    }
}
