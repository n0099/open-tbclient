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
    public long Pl;
    private a cXI;
    private final HttpMessageListener cXJ;

    /* loaded from: classes.dex */
    public interface a {
        void lB(int i);

        void onError(int i, String str);
    }

    public void a(a aVar) {
        this.cXI = aVar;
    }

    public c(Context context) {
        super(null);
        this.Pl = 300000L;
        this.cXJ = new d(this, CmdConfigHttp.REPORT_USER_INFO);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean atI() {
        return Math.abs(System.currentTimeMillis() - TbadkCoreApplication.m411getInst().getReporyUserInfoLastTime()) >= this.Pl;
    }

    public void atJ() {
        TbadkCoreApplication.m411getInst().setReporyUserInfoCurrentTime();
    }

    public void bA(long j) {
        this.Pl = j;
    }

    public void atK() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REPORT_USER_INFO, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/user/report");
        tbHttpMessageTask.setResponsedClass(ResponseReportUserInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.cXJ);
    }

    public void a(int i, float f, float f2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.REPORT_USER_INFO);
        httpMessage.addParam("type", String.valueOf(i));
        httpMessage.addParam("lng", String.valueOf(f));
        httpMessage.addParam("lat", String.valueOf(f2));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.cXJ);
    }
}
