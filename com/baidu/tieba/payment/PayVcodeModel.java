package com.baidu.tieba.payment;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.payment.message.ResponsePayNewVcodeInfoMessage;
import d.a.c.a.f;
/* loaded from: classes5.dex */
public class PayVcodeModel extends BdBaseModel<PayVcodeModel> {

    /* renamed from: e  reason: collision with root package name */
    public f<?> f18855e;

    public PayVcodeModel(f<?> fVar) {
        this.f18855e = fVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void w() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PAY_NEW_VCODE, TbConfig.SERVER_ADDRESS + "c/c/encourage/consume/getVcode");
        tbHttpMessageTask.setResponsedClass(ResponsePayNewVcodeInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void x() {
        this.f18855e.sendMessage(new HttpMessage(CmdConfigHttp.CMD_PAY_NEW_VCODE));
    }
}
