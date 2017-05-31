package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo {
    private BaseActivity bfa;
    private PbModel ele;
    private a emW = null;
    protected final HttpMessageListener eoJ = new dp(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* renamed from: com.baidu.tieba.pb.pb.main.do$a */
    /* loaded from: classes.dex */
    public interface a {
        void i(int i, String str, String str2);
    }

    public Cdo(PbModel pbModel, BaseActivity baseActivity) {
        this.ele = pbModel;
        this.bfa = baseActivity;
        this.bfa.registerListener(this.eoJ);
    }

    public void a(a aVar) {
        this.emW = aVar;
    }

    public void ow(int i) {
        if (this.ele != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.ele.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
