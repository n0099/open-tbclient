package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class cn {
    private BaseActivity bek;
    private cw dih;
    private a djz = null;
    protected final HttpMessageListener dkK = new co(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void h(int i, String str, String str2);
    }

    public cn(cw cwVar, BaseActivity baseActivity) {
        this.dih = cwVar;
        this.bek = baseActivity;
        this.bek.registerListener(this.dkK);
    }

    public void a(a aVar) {
        this.djz = aVar;
    }

    public void lL(int i) {
        if (this.dih != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.dih.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
