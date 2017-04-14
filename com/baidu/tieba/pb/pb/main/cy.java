package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class cy {
    private BaseActivity bcy;
    private PbModel eif;
    private a ejO = null;
    protected final HttpMessageListener ekU = new cz(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void h(int i, String str, String str2);
    }

    public cy(PbModel pbModel, BaseActivity baseActivity) {
        this.eif = pbModel;
        this.bcy = baseActivity;
        this.bcy.registerListener(this.ekU);
    }

    public void a(a aVar) {
        this.ejO = aVar;
    }

    public void og(int i) {
        if (this.eif != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.eif.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
