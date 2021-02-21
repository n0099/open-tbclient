package com.baidu.tieba.newfaceshop;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
/* loaded from: classes9.dex */
public class NewFaceSyncDownloadModel extends FaceBaseModel {
    private final HttpMessageListener lAA = new HttpMessageListener(1003351) { // from class: com.baidu.tieba.newfaceshop.NewFaceSyncDownloadModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.newfaceshop.a.a aVar;
            Object extra;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003351 && (httpResponsedMessage instanceof GetCloudFaceGroupMessage)) {
                if (httpResponsedMessage.getOrginalMessage() == null || (extra = httpResponsedMessage.getOrginalMessage().getExtra()) == null || !(extra instanceof com.baidu.tieba.newfaceshop.a.a)) {
                    aVar = null;
                } else {
                    aVar = (com.baidu.tieba.newfaceshop.a.a) extra;
                }
                if (aVar != null) {
                    aVar.a((GetCloudFaceGroupMessage) httpResponsedMessage);
                }
            }
        }
    };

    public NewFaceSyncDownloadModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.lAA.setTag(getUniqueId());
        this.lAA.setSelfListener(true);
        registerListener(this.lAA);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003351, TbConfig.SERVER_ADDRESS + Config.SYNC_DOWNLOAD_CLOUD_FACE_GROUP);
        tbHttpMessageTask.setResponsedClass(GetCloudFaceGroupMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(com.baidu.tieba.newfaceshop.a.a aVar) {
        HttpMessage httpMessage = new HttpMessage(1003351);
        httpMessage.setExtra(aVar);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(1003351);
        return true;
    }
}
