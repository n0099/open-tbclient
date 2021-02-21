package com.baidu.tieba.payment;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.payment.message.ResponsePayNewVcodeInfoMessage;
/* loaded from: classes9.dex */
public class PayVcodeModel extends BdBaseModel<PayVcodeModel> {
    private f<?> lHA;

    public PayVcodeModel(f<?> fVar) {
        this.lHA = fVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dkz() {
        this.lHA.sendMessage(new HttpMessage(1001539));
    }

    public void dkA() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001539, TbConfig.SERVER_ADDRESS + Config.PAY_NEW_VCODE);
        tbHttpMessageTask.setResponsedClass(ResponsePayNewVcodeInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }
}
