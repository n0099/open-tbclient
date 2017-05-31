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
    private InterfaceC0085a fWm;
    private com.baidu.tieba.write.a.a fWn;
    private BdUniqueId mBdUniqueId;
    private String mLinkUrl;
    private HttpMessageListener fWo = new b(this, CmdConfigHttp.CMD_ADD_LINK);
    private Runnable aUO = new c(this);

    /* renamed from: com.baidu.tieba.write.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0085a {
        void a(com.baidu.tieba.write.a.a aVar);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.fWo.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fWo);
    }

    public void rl(String str) {
        this.mLinkUrl = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        httpMessage.addParam("link_url", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.m9getInst().getTbs());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_LINK, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.ADD_LINK);
        tbHttpMessageTask.setResponsedClass(AddLinkResponseMessage.class);
        tbHttpMessageTask.setTimeOut(new e(5000));
        tbHttpMessageTask.setRetry(3);
        MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        h.fS().removeCallbacks(this.aUO);
        h.fS().postDelayed(this.aUO, 15000L);
    }

    public void boo() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_ADD_LINK, this.mBdUniqueId);
        h.fS().removeCallbacks(this.aUO);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.fWo);
        h.fS().removeCallbacks(this.aUO);
    }

    public void a(InterfaceC0085a interfaceC0085a) {
        this.fWm = interfaceC0085a;
    }

    public com.baidu.tieba.write.a.a bop() {
        return this.fWn;
    }
}
