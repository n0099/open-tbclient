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
    private String byh;
    private InterfaceC0316a jpe;
    private com.baidu.tieba.write.a.a jpf;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener jpg = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.jH().removeCallbacks(a.this.cNM);
                if (a.this.jpe != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.joE = false;
                        aVar.linkUrl = a.this.byh;
                        aVar.joF = 1;
                        a.this.jpf = aVar;
                    } else {
                        a.this.jpf = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.jpf.joE) {
                            a.this.jpf.linkUrl = a.this.byh;
                            a.this.jpf.joF = 1;
                        }
                    }
                    a.this.jpe.a(a.this.jpf);
                }
            }
        }
    };
    private Runnable cNM = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cpw();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.joE = false;
            aVar.linkUrl = a.this.byh;
            aVar.joF = 1;
            a.this.jpf = aVar;
            if (a.this.jpe != null) {
                a.this.jpe.a(a.this.jpf);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0316a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.jpg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jpg);
    }

    public void Ev(String str) {
        this.byh = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.jH().removeCallbacks(this.cNM);
        e.jH().postDelayed(this.cNM, 15000L);
    }

    public void cpw() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.jH().removeCallbacks(this.cNM);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.jpg);
        e.jH().removeCallbacks(this.cNM);
    }

    public void a(InterfaceC0316a interfaceC0316a) {
        this.jpe = interfaceC0316a;
    }

    public com.baidu.tieba.write.a.a cpx() {
        return this.jpf;
    }
}
