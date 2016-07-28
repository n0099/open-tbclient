package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class ct {
    private BaseActivity bem;
    private dh eas;
    private a ebO = null;
    protected final HttpMessageListener ecO = new cu(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void h(int i, String str, String str2);
    }

    public ct(dh dhVar, BaseActivity baseActivity) {
        this.eas = dhVar;
        this.bem = baseActivity;
        this.bem.registerListener(this.ecO);
    }

    public void a(a aVar) {
        this.ebO = aVar;
    }

    public void nC(int i) {
        if (this.eas != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.eas.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
