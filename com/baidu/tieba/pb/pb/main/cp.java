package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class cp {
    private BaseActivity bkc;
    private dg dOf;
    private a dQv = null;
    private final HttpMessageListener dQw = new cq(this, CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);

    /* loaded from: classes.dex */
    public interface a {
        void i(int i, long j);

        void onError(int i, String str);
    }

    public cp(dg dgVar, BaseActivity baseActivity) {
        this.dOf = dgVar;
        this.bkc = baseActivity;
        aFt();
        this.bkc.registerListener(this.dQw);
    }

    public void a(a aVar) {
        this.dQv = aVar;
    }

    public void aFt() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/b/commit/tpointhide");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(HideChudianPostResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void cg(long j) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);
        httpMessage.addParam("template_id", String.valueOf(j));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
