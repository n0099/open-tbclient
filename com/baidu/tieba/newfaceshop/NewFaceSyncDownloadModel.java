package com.baidu.tieba.newfaceshop;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
/* loaded from: classes5.dex */
public class NewFaceSyncDownloadModel extends FaceBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f18706e = new a(this, CmdConfigHttp.CMD_SYNC_DOWNLOAD_CLOUD_FACE_GROUP);

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(NewFaceSyncDownloadModel newFaceSyncDownloadModel, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Object extra;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003351 && (httpResponsedMessage instanceof GetCloudFaceGroupMessage)) {
                d.a.o0.z1.e.a aVar = null;
                if (httpResponsedMessage.getOrginalMessage() != null && (extra = httpResponsedMessage.getOrginalMessage().getExtra()) != null && (extra instanceof d.a.o0.z1.e.a)) {
                    aVar = (d.a.o0.z1.e.a) extra;
                }
                if (aVar != null) {
                    aVar.a((GetCloudFaceGroupMessage) httpResponsedMessage);
                }
            }
        }
    }

    public NewFaceSyncDownloadModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f18706e.setTag(getUniqueId());
        this.f18706e.setSelfListener(true);
        registerListener(this.f18706e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_SYNC_DOWNLOAD_CLOUD_FACE_GROUP);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SYNC_DOWNLOAD_CLOUD_FACE_GROUP, TbConfig.SERVER_ADDRESS + "c/e/meme/getAllMeme");
        tbHttpMessageTask.setResponsedClass(GetCloudFaceGroupMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void w(d.a.o0.z1.e.a aVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SYNC_DOWNLOAD_CLOUD_FACE_GROUP);
        httpMessage.setExtra(aVar);
        sendMessage(httpMessage);
    }
}
