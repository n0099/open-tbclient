package com.baidu.tieba.newfaceshop;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class NewFaceGroupShareModel extends FaceBaseModel {
    public NewFaceGroupShareModel() {
        registerTask();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_SHARE_FACE_GROUP);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SHARE_FACE_GROUP, TbConfig.SERVER_ADDRESS + "c/e/meme/share");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void s(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SHARE_FACE_GROUP);
        httpMessage.addParam("id", str);
        sendMessage(httpMessage);
    }
}
