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
/* loaded from: classes.dex */
public class a {
    private InterfaceC0124a gEd;
    private com.baidu.tieba.write.a.a gEe;
    private BdUniqueId mBdUniqueId;
    private String mLinkUrl;
    private HttpMessageListener gEf = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.ga().removeCallbacks(a.this.aYv);
                if (a.this.gEd != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.gDK = false;
                        aVar.linkUrl = a.this.mLinkUrl;
                        aVar.gDL = 1;
                        a.this.gEe = aVar;
                    } else {
                        a.this.gEe = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.gEe.gDK) {
                            a.this.gEe.linkUrl = a.this.mLinkUrl;
                            a.this.gEe.gDL = 1;
                        }
                    }
                    a.this.gEd.a(a.this.gEe);
                }
            }
        }
    };
    private Runnable aYv = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bzb();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.gDK = false;
            aVar.linkUrl = a.this.mLinkUrl;
            aVar.gDL = 1;
            a.this.gEe = aVar;
            if (a.this.gEd != null) {
                a.this.gEd.a(a.this.gEe);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0124a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.gEf.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gEf);
    }

    public void td(String str) {
        this.mLinkUrl = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.ga().removeCallbacks(this.aYv);
        e.ga().postDelayed(this.aYv, 15000L);
    }

    public void bzb() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.ga().removeCallbacks(this.aYv);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gEf);
        e.ga().removeCallbacks(this.aYv);
    }

    public void a(InterfaceC0124a interfaceC0124a) {
        this.gEd = interfaceC0124a;
    }

    public com.baidu.tieba.write.a.a bzc() {
        return this.gEe;
    }
}
