package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class db {
    private BaseActivity aWr;
    private PbModel ehh;
    private a eiP = null;
    protected final HttpMessageListener ejT = new dc(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);

    /* loaded from: classes.dex */
    public interface a {
        void i(int i, String str, String str2);
    }

    public db(PbModel pbModel, BaseActivity baseActivity) {
        this.ehh = pbModel;
        this.aWr = baseActivity;
        this.aWr.registerListener(this.ejT);
    }

    public void a(a aVar) {
        this.eiP = aVar;
    }

    public void ou(int i) {
        if (this.ehh != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
            httpMessage.addParam("thread_id", this.ehh.getThreadID());
            httpMessage.addParam("status", String.valueOf(i));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
