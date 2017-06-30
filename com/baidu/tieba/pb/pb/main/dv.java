package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class dv {
    private BaseActivity bhX;
    private PbModel eue;
    private a ewb = null;
    protected final HttpMessageListener exP = new dw(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void i(int i, String str, String str2);
    }

    public dv(PbModel pbModel, BaseActivity baseActivity) {
        this.eue = pbModel;
        this.bhX = baseActivity;
        this.bhX.registerListener(this.exP);
    }

    public void a(a aVar) {
        this.ewb = aVar;
    }

    public void oN(int i) {
        if (this.eue != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.eue.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
