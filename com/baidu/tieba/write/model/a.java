package com.baidu.tieba.write.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class a {
    private String afw;
    private com.baidu.tieba.write.a.a hqA;
    private InterfaceC0251a hqz;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hqB = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.im().removeCallbacks(a.this.blE);
                if (a.this.hqz != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hpX = false;
                        aVar.linkUrl = a.this.afw;
                        aVar.hpY = 1;
                        a.this.hqA = aVar;
                    } else {
                        a.this.hqA = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hqA.hpX) {
                            a.this.hqA.linkUrl = a.this.afw;
                            a.this.hqA.hpY = 1;
                        }
                    }
                    a.this.hqz.a(a.this.hqA);
                }
            }
        }
    };
    private Runnable blE = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bHk();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hpX = false;
            aVar.linkUrl = a.this.afw;
            aVar.hpY = 1;
            a.this.hqA = aVar;
            if (a.this.hqz != null) {
                a.this.hqz.a(a.this.hqA);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0251a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hqB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hqB);
    }

    public void vI(String str) {
        this.afw = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.im().removeCallbacks(this.blE);
        e.im().postDelayed(this.blE, 15000L);
    }

    public void bHk() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.im().removeCallbacks(this.blE);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hqB);
        e.im().removeCallbacks(this.blE);
    }

    public void a(InterfaceC0251a interfaceC0251a) {
        this.hqz = interfaceC0251a;
    }

    public com.baidu.tieba.write.a.a bHl() {
        return this.hqA;
    }
}
