package com.baidu.tieba.newfaceshop;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.faceshop.i;
import com.baidu.tieba.newfaceshop.message.GetFaceGroupInfoResponseMessage;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class NewFaceGroupDownloadModel extends FaceBaseModel {
    private final HttpMessageListener lrT = new HttpMessageListener(1003338) { // from class: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            final Boolean bool;
            final com.baidu.tieba.newfaceshop.a.b bVar;
            Object extra;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003338 && (httpResponsedMessage instanceof GetFaceGroupInfoResponseMessage)) {
                if (httpResponsedMessage.getOrginalMessage() == null || (extra = httpResponsedMessage.getOrginalMessage().getExtra()) == null || !(extra instanceof HashMap)) {
                    bool = false;
                    bVar = null;
                } else {
                    HashMap hashMap = (HashMap) extra;
                    Object obj = hashMap.get(BuyTBeanActivityConfig.CALLBACK);
                    if (obj == null || !(obj instanceof com.baidu.tieba.newfaceshop.a.b)) {
                        bVar = null;
                    } else {
                        bVar = (com.baidu.tieba.newfaceshop.a.b) obj;
                    }
                    Object obj2 = hashMap.get("sync");
                    bool = (obj2 == null || !(obj2 instanceof Boolean)) ? false : (Boolean) obj2;
                }
                final com.baidu.tieba.newfaceshop.b.a data = ((GetFaceGroupInfoResponseMessage) httpResponsedMessage).getData();
                if (data == null) {
                    if (bVar != null) {
                        bVar.onFail("group data null");
                        return;
                    }
                    return;
                }
                b.a(data, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel.1.1
                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onSuccess(final String str) {
                        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel.1.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                            public Boolean doInBackground(Void... voidArr) {
                                int a2 = com.baidu.tieba.faceshop.a.cxd().a(data);
                                if (a2 == 0) {
                                    return false;
                                }
                                EmotionGroupData emotionGroupData = new EmotionGroupData();
                                emotionGroupData.setGroupId(data.id);
                                emotionGroupData.setEmotionsCount(a2);
                                emotionGroupData.setHeight(data.pics.get(0).height);
                                emotionGroupData.setWidth(data.pics.get(0).width);
                                emotionGroupData.setDownloadTime(System.currentTimeMillis());
                                emotionGroupData.setGroupName(data.name);
                                emotionGroupData.setStatus(1);
                                if (i.cxt().a(emotionGroupData)) {
                                    return Boolean.valueOf(i.cxt().a(TbadkCoreApplication.getCurrentAccount(), emotionGroupData));
                                }
                                return false;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                            public void onPostExecute(Boolean bool2) {
                                if (bool2 != null && bool2.booleanValue()) {
                                    MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
                                    if (bool.booleanValue()) {
                                        d.dgo().dgp();
                                    }
                                    if (bVar != null) {
                                        bVar.onSuccess(str);
                                    }
                                    com.baidu.tieba.faceshop.packagedetail.a aVar = new com.baidu.tieba.faceshop.packagedetail.a();
                                    aVar.resultCode = 0;
                                    aVar.path = str;
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
                                    return;
                                }
                                if (bVar != null) {
                                    bVar.onFail("failed to download");
                                }
                                com.baidu.tieba.faceshop.packagedetail.a aVar2 = new com.baidu.tieba.faceshop.packagedetail.a();
                                aVar2.resultCode = 1;
                                aVar2.errorMsg = "failed to download";
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar2));
                            }
                        }.execute(new Void[0]);
                    }

                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onProgress(int i) {
                        if (bVar != null) {
                            bVar.onProgress(i);
                        }
                        com.baidu.tieba.faceshop.packagedetail.a aVar = new com.baidu.tieba.faceshop.packagedetail.a();
                        aVar.resultCode = 2;
                        aVar.progress = i;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
                    }

                    @Override // com.baidu.tieba.newfaceshop.a.b
                    public void onFail(String str) {
                        BdLog.e("FaceDownload:" + str);
                        if (bVar != null) {
                            bVar.onFail(str);
                        }
                        com.baidu.tieba.faceshop.packagedetail.a aVar = new com.baidu.tieba.faceshop.packagedetail.a();
                        aVar.resultCode = 1;
                        aVar.errorMsg = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
                    }
                });
            }
        }
    };

    public NewFaceGroupDownloadModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.lrT.setTag(getUniqueId());
        this.lrT.setSelfListener(true);
        registerListener(this.lrT);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003338, TbConfig.SERVER_ADDRESS + Config.GET_FACE_GROUP_INFO);
        tbHttpMessageTask.setResponsedClass(GetFaceGroupInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, Boolean bool, com.baidu.tieba.newfaceshop.a.b bVar) {
        HttpMessage httpMessage = new HttpMessage(1003338);
        HashMap hashMap = new HashMap();
        hashMap.put("sync", bool);
        hashMap.put(BuyTBeanActivityConfig.CALLBACK, bVar);
        httpMessage.setExtra(hashMap);
        httpMessage.addParam("id", str);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.lrT);
        MessageManager.getInstance().unRegisterTask(1003338);
        return true;
    }
}
