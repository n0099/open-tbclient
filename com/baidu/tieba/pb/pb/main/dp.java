package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class dp {
    private PbModel efE;

    public dp(PbModel pbModel) {
        this.efE = pbModel;
        DG();
    }

    private void DG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_FLOOR_AGREE, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PB_FLOOR_AGREE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void ao(String str, int i) {
        if (this.efE != null && this.efE.getPbData() != null) {
            a(str, i, 1, 2, "");
        }
    }

    public void a(String str, int i, int i2, int i3, String str2) {
        if (this.efE != null && this.efE.getPbData() != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("post_id", str);
            httpMessage.addParam("thread_id", this.efE.getPbData().getThreadId());
            httpMessage.addParam(PbActivityConfig.KEY_MSG_OP_TYPE, i);
            httpMessage.addParam("obj_type", i2);
            httpMessage.addParam("agree_type", i3);
            httpMessage.addParam("forum_id", str2);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
