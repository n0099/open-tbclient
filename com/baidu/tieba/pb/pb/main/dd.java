package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class dd {
    private PbModel ejZ;

    public dd(PbModel pbModel) {
        this.ejZ = pbModel;
        Ee();
    }

    private void Ee() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_FLOOR_AGREE, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PB_FLOOR_AGREE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bL(String str, String str2) {
        if (this.ejZ != null && this.ejZ.getPbData() != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("post_id", str);
            httpMessage.addParam("thread_id", this.ejZ.getPbData().getThreadId());
            httpMessage.addParam(PbActivityConfig.KEY_MSG_OP_TYPE, str2);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
