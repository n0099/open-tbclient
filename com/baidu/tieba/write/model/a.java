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
    private String afL;
    private InterfaceC0253a huI;
    private com.baidu.tieba.write.a.a huJ;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener huK = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.im().removeCallbacks(a.this.bnd);
                if (a.this.huI != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.huh = false;
                        aVar.linkUrl = a.this.afL;
                        aVar.hui = 1;
                        a.this.huJ = aVar;
                    } else {
                        a.this.huJ = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.huJ.huh) {
                            a.this.huJ.linkUrl = a.this.afL;
                            a.this.huJ.hui = 1;
                        }
                    }
                    a.this.huI.a(a.this.huJ);
                }
            }
        }
    };
    private Runnable bnd = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bHL();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.huh = false;
            aVar.linkUrl = a.this.afL;
            aVar.hui = 1;
            a.this.huJ = aVar;
            if (a.this.huI != null) {
                a.this.huI.a(a.this.huJ);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0253a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.huK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.huK);
    }

    public void vE(String str) {
        this.afL = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.im().removeCallbacks(this.bnd);
        e.im().postDelayed(this.bnd, 15000L);
    }

    public void bHL() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.im().removeCallbacks(this.bnd);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.huK);
        e.im().removeCallbacks(this.bnd);
    }

    public void a(InterfaceC0253a interfaceC0253a) {
        this.huI = interfaceC0253a;
    }

    public com.baidu.tieba.write.a.a bHM() {
        return this.huJ;
    }
}
