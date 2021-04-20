package com.baidu.tieba.newfaceshop;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.b.i0.y1.d;
/* loaded from: classes3.dex */
public class NewFaceSyncUploadModel extends FaceBaseModel {
    public NewFaceSyncUploadModel() {
        registerTask();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_SYNC_UPLOAD_LOCAL_FACE_GROUP);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SYNC_UPLOAD_LOCAL_FACE_GROUP, TbConfig.SERVER_ADDRESS + "c/e/meme/uploadPackage");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void s(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SYNC_UPLOAD_LOCAL_FACE_GROUP);
        httpMessage.addParam("package_ids", str);
        httpMessage.addParam("pkg_update_time", currentTimeMillis);
        sendMessage(httpMessage);
        d.t(currentTimeMillis);
    }
}
