package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class ct {
    private BaseActivity aRd;
    private dh eov;
    private a epV = null;
    protected final HttpMessageListener eqR = new cu(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void h(int i, String str, String str2);
    }

    public ct(dh dhVar, BaseActivity baseActivity) {
        this.eov = dhVar;
        this.aRd = baseActivity;
        this.aRd.registerListener(this.eqR);
    }

    public void a(a aVar) {
        this.epV = aVar;
    }

    public void oq(int i) {
        if (this.eov != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.eov.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
