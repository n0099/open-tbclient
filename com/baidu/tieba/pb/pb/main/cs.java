package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class cs {
    private BaseActivity bkc;
    private dg dOf;
    private a dPA = null;
    protected final HttpMessageListener dQz = new ct(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void h(int i, String str, String str2);
    }

    public cs(dg dgVar, BaseActivity baseActivity) {
        this.dOf = dgVar;
        this.bkc = baseActivity;
        this.bkc.registerListener(this.dQz);
    }

    public void a(a aVar) {
        this.dPA = aVar;
    }

    public void nk(int i) {
        if (this.dOf != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.dOf.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
