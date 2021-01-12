package com.baidu.tieba.newfaceshop;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes8.dex */
public class NewFaceSyncUploadModel extends FaceBaseModel {
    public NewFaceSyncUploadModel() {
        registerTask();
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003350, TbConfig.SERVER_ADDRESS + Config.SYNC_UPLOAD_LOCAL_FACE_GROUP);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void Oa(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HttpMessage httpMessage = new HttpMessage(1003350);
        httpMessage.addParam("package_ids", str);
        httpMessage.addParam("pkg_update_time", currentTimeMillis);
        sendMessage(httpMessage);
        d.hj(currentTimeMillis);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(1003350);
        return true;
    }
}
