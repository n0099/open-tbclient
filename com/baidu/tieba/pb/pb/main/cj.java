package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class cj {
    private BaseActivity bek;
    private cw dih;
    private a dkz = null;
    private final HttpMessageListener dkA = new ck(this, CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);

    /* loaded from: classes.dex */
    public interface a {
        void i(int i, long j);

        void onError(int i, String str);
    }

    public cj(cw cwVar, BaseActivity baseActivity) {
        this.dih = cwVar;
        this.bek = baseActivity;
        axl();
        this.bek.registerListener(this.dkA);
    }

    public void a(a aVar) {
        this.dkz = aVar;
    }

    public void axl() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/b/commit/tpointhide");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(HideChudianPostResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void bE(long j) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);
        httpMessage.addParam("template_id", String.valueOf(j));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
