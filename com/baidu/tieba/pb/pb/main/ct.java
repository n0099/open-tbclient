package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class ct {
    private BaseActivity aSs;
    private dc dYA;
    private a eac = null;
    protected final HttpMessageListener ebb = new cu(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void h(int i, String str, String str2);
    }

    public ct(dc dcVar, BaseActivity baseActivity) {
        this.dYA = dcVar;
        this.aSs = baseActivity;
        this.aSs.registerListener(this.ebb);
    }

    public void a(a aVar) {
        this.eac = aVar;
    }

    public void nC(int i) {
        if (this.dYA != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.dYA.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
