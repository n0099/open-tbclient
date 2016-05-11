package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.message.ResponseReportUserInfoMessage;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    public long Kc;
    private a cZu;
    private final HttpMessageListener cZv;

    /* loaded from: classes.dex */
    public interface a {
        void lo(int i);

        void onError(int i, String str);
    }

    public void a(a aVar) {
        this.cZu = aVar;
    }

    public c(Context context) {
        super(null);
        this.Kc = 300000L;
        this.cZv = new d(this, CmdConfigHttp.REPORT_USER_INFO);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean atH() {
        return Math.abs(System.currentTimeMillis() - TbadkCoreApplication.m11getInst().getReporyUserInfoLastTime()) >= this.Kc;
    }

    public void atI() {
        TbadkCoreApplication.m11getInst().setReporyUserInfoCurrentTime();
    }

    public void bA(long j) {
        this.Kc = j;
    }

    public void atJ() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REPORT_USER_INFO, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/user/report");
        tbHttpMessageTask.setResponsedClass(ResponseReportUserInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.cZv);
    }

    public void b(int i, float f, float f2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.REPORT_USER_INFO);
        httpMessage.addParam("type", String.valueOf(i));
        httpMessage.addParam("lng", String.valueOf(f));
        httpMessage.addParam("lat", String.valueOf(f2));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.cZv);
    }
}
