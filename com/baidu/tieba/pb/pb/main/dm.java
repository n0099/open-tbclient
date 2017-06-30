package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class dm {
    private BaseActivity bhX;
    private PbModel eue;
    private a exr = null;
    private final HttpMessageListener exs = new dn(this, CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);

    /* loaded from: classes.dex */
    public interface a {
        void i(int i, long j);

        void onError(int i, String str);
    }

    public dm(PbModel pbModel, BaseActivity baseActivity) {
        this.eue = pbModel;
        this.bhX = baseActivity;
        aOz();
        this.bhX.registerListener(this.exs);
    }

    public void a(a aVar) {
        this.exr = aVar;
    }

    public void aOz() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/b/commit/tpointhide");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(HideChudianPostResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void cq(long j) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);
        httpMessage.addParam("template_id", String.valueOf(j));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
