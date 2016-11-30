package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class cu {
    private BaseActivity aTb;
    private dj euf;
    private a evG = null;
    protected final HttpMessageListener ewG = new cv(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void h(int i, String str, String str2);
    }

    public cu(dj djVar, BaseActivity baseActivity) {
        this.euf = djVar;
        this.aTb = baseActivity;
        this.aTb.registerListener(this.ewG);
    }

    public void a(a aVar) {
        this.evG = aVar;
    }

    public void oA(int i) {
        if (this.euf != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.euf.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
