package com.baidu.tieba.write.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.c.e;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.g.h;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0087a ghb;
    private com.baidu.tieba.write.a.a ghc;
    private BdUniqueId mBdUniqueId;
    private String mLinkUrl;
    private HttpMessageListener ghd = new b(this, CmdConfigHttp.CMD_ADD_LINK);
    private Runnable aWh = new c(this);

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0087a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.ghd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ghd);
    }

    public void sk(String str) {
        this.mLinkUrl = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.m9getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        h.fR().removeCallbacks(this.aWh);
        h.fR().postDelayed(this.aWh, 15000L);
    }

    public void bsM() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        h.fR().removeCallbacks(this.aWh);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.ghd);
        h.fR().removeCallbacks(this.aWh);
    }

    public void a(InterfaceC0087a interfaceC0087a) {
        this.ghb = interfaceC0087a;
    }

    public com.baidu.tieba.write.a.a bsN() {
        return this.ghc;
    }
}
