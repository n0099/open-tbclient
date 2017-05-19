package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class da {
    private BaseActivity bdY;
    private PbModel efE;
    private a eiE = null;
    private final HttpMessageListener eiF = new db(this, CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);

    /* loaded from: classes.dex */
    public interface a {
        void i(int i, long j);

        void onError(int i, String str);
    }

    public da(PbModel pbModel, BaseActivity baseActivity) {
        this.efE = pbModel;
        this.bdY = baseActivity;
        aJI();
        this.bdY.registerListener(this.eiF);
    }

    public void a(a aVar) {
        this.eiE = aVar;
    }

    public void aJI() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/b/commit/tpointhide");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(HideChudianPostResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void bX(long j) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);
        httpMessage.addParam("template_id", String.valueOf(j));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
