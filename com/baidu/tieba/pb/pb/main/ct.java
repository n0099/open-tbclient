package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class ct {
    private BaseActivity aPR;
    private dh emx;
    private a enW = null;
    protected final HttpMessageListener eoT = new cu(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void h(int i, String str, String str2);
    }

    public ct(dh dhVar, BaseActivity baseActivity) {
        this.emx = dhVar;
        this.aPR = baseActivity;
        this.aPR.registerListener(this.eoT);
    }

    public void a(a aVar) {
        this.enW = aVar;
    }

    public void og(int i) {
        if (this.emx != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.emx.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
