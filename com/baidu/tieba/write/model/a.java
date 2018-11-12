package com.baidu.tieba.write.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class a {
    private String anp;
    private InterfaceC0322a hMJ;
    private com.baidu.tieba.write.a.a hMK;
    private BdUniqueId mBdUniqueId;
    private HttpMessageListener hML = new HttpMessageListener(CmdConfigHttp.CMD_ADD_LINK) { // from class: com.baidu.tieba.write.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AddLinkResponseMessage) {
                AddLinkResponseMessage addLinkResponseMessage = (AddLinkResponseMessage) httpResponsedMessage;
                e.jG().removeCallbacks(a.this.byr);
                if (a.this.hMJ != null) {
                    if (addLinkResponseMessage.getAddLinkResponseData() == null) {
                        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
                        aVar.hMi = false;
                        aVar.linkUrl = a.this.anp;
                        aVar.hMj = 1;
                        a.this.hMK = aVar;
                    } else {
                        a.this.hMK = addLinkResponseMessage.getAddLinkResponseData();
                        if (!a.this.hMK.hMi) {
                            a.this.hMK.linkUrl = a.this.anp;
                            a.this.hMK.hMj = 1;
                        }
                    }
                    a.this.hMJ.a(a.this.hMK);
                }
            }
        }
    };
    private Runnable byr = new Runnable() { // from class: com.baidu.tieba.write.model.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bMb();
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.hMi = false;
            aVar.linkUrl = a.this.anp;
            aVar.hMj = 1;
            a.this.hMK = aVar;
            if (a.this.hMJ != null) {
                a.this.hMJ.a(a.this.hMK);
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0322a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.hML.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hML);
    }

    public void wY(String str) {
        this.anp = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, TbConfig.SERVER_ADDRESS + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new com.baidu.adp.framework.c.e(UIMsg.m_AppUI.MSG_APP_GPS));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        e.jG().removeCallbacks(this.byr);
        e.jG().postDelayed(this.byr, 15000L);
    }

    public void bMb() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        e.jG().removeCallbacks(this.byr);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.hML);
        e.jG().removeCallbacks(this.byr);
    }

    public void a(InterfaceC0322a interfaceC0322a) {
        this.hMJ = interfaceC0322a;
    }

    public com.baidu.tieba.write.a.a bMc() {
        return this.hMK;
    }
}
