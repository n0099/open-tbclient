package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class di {
    private BaseActivity bdY;
    private PbModel efE;
    private a ehs = null;
    protected final HttpMessageListener eja = new dj(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void i(int i, String str, String str2);
    }

    public di(PbModel pbModel, BaseActivity baseActivity) {
        this.efE = pbModel;
        this.bdY = baseActivity;
        this.bdY.registerListener(this.eja);
    }

    public void a(a aVar) {
        this.ehs = aVar;
    }

    public void od(int i) {
        if (this.efE != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.efE.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
