package com.baidu.tieba.payment;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.payment.message.ResponsePayNewVcodeInfoMessage;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e<a> {
    private com.baidu.adp.base.h<?> cGY;

    public a(com.baidu.adp.base.h<?> hVar) {
        this.cGY = hVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void anX() {
        this.cGY.sendMessage(new HttpMessage(CmdConfigHttp.CMD_PAY_NEW_VCODE));
    }

    public void anY() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PAY_NEW_VCODE, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/encourage/consume/getVcode");
        tbHttpMessageTask.setResponsedClass(ResponsePayNewVcodeInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }
}
