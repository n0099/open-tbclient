package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class cy {
    private BaseActivity bdG;
    private PbModel ekv;
    private a eme = null;
    protected final HttpMessageListener enm = new cz(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void h(int i, String str, String str2);
    }

    public cy(PbModel pbModel, BaseActivity baseActivity) {
        this.ekv = pbModel;
        this.bdG = baseActivity;
        this.bdG.registerListener(this.enm);
    }

    public void a(a aVar) {
        this.eme = aVar;
    }

    public void om(int i) {
        if (this.ekv != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.ekv.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
