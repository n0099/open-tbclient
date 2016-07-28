package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class cq {
    private BaseActivity bem;
    private dh eas;
    private a ecK = null;
    private final HttpMessageListener ecL = new cr(this, CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);

    /* loaded from: classes.dex */
    public interface a {
        void j(int i, long j);

        void onError(int i, String str);
    }

    public cq(dh dhVar, BaseActivity baseActivity) {
        this.eas = dhVar;
        this.bem = baseActivity;
        aIE();
        this.bem.registerListener(this.ecL);
    }

    public void a(a aVar) {
        this.ecK = aVar;
    }

    public void aIE() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/b/commit/tpointhide");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(HideChudianPostResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void cf(long j) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);
        httpMessage.addParam("template_id", String.valueOf(j));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
