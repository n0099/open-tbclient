package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class da {
    private BaseActivity bcF;
    private PbModel ejZ;
    private a elI = null;
    protected final HttpMessageListener emM = new db(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void h(int i, String str, String str2);
    }

    public da(PbModel pbModel, BaseActivity baseActivity) {
        this.ejZ = pbModel;
        this.bcF = baseActivity;
        this.bcF.registerListener(this.emM);
    }

    public void a(a aVar) {
        this.elI = aVar;
    }

    public void oi(int i) {
        if (this.ejZ != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.ejZ.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
