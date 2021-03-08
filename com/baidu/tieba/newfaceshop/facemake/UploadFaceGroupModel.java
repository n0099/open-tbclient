package com.baidu.tieba.newfaceshop.facemake;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.newfaceshop.FaceBaseModel;
import com.baidu.tieba.newfaceshop.facemake.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class UploadFaceGroupModel extends FaceBaseModel {
    private final HttpMessageListener lEQ = new HttpMessageListener(1003345) { // from class: com.baidu.tieba.newfaceshop.facemake.UploadFaceGroupModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            boolean z;
            ArrayList arrayList;
            e.c cVar;
            Object extra;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003345 && (httpResponsedMessage instanceof UploadFaceGroupResponseMessage)) {
                if (httpResponsedMessage.getOrginalMessage() == null || (extra = httpResponsedMessage.getOrginalMessage().getExtra()) == null || !(extra instanceof HashMap)) {
                    z = true;
                    arrayList = null;
                    cVar = null;
                } else {
                    HashMap hashMap = (HashMap) extra;
                    Object obj = hashMap.get(BuyTBeanActivityConfig.CALLBACK);
                    cVar = (obj == null || !(obj instanceof e.c)) ? null : (e.c) obj;
                    Object obj2 = hashMap.get("list");
                    arrayList = (obj2 == null || !(obj2 instanceof ArrayList)) ? null : (ArrayList) obj2;
                    Object obj3 = hashMap.get("autoInstall");
                    z = (obj3 == null || !(obj3 instanceof Boolean)) ? true : ((Boolean) obj3).booleanValue();
                }
                if (arrayList == null) {
                    UploadFaceGroupModel.this.b(cVar, null);
                    BdLog.e("msg extra empty");
                } else if (httpResponsedMessage.getError() != 0) {
                    UploadFaceGroupModel.this.b(cVar, httpResponsedMessage.getErrorString());
                } else {
                    String groupId = ((UploadFaceGroupResponseMessage) httpResponsedMessage).getGroupId();
                    if (TextUtils.isEmpty(groupId)) {
                        UploadFaceGroupModel.this.b(cVar, httpResponsedMessage.getErrorString());
                        return;
                    }
                    if (cVar != null) {
                        cVar.l(groupId, arrayList);
                    }
                    e.diT().D(true, httpResponsedMessage.getErrorString());
                    if (z) {
                        e.diT().a(groupId, arrayList, (e.b) null);
                        return;
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("upload_result", new Boolean(true));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPLOAD_FACE_GROUP_FINISH, hashMap2));
                }
            }
        }
    };

    public UploadFaceGroupModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.lEQ.setTag(getUniqueId());
        this.lEQ.setSelfListener(true);
        registerListener(this.lEQ);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003345, TbConfig.SERVER_ADDRESS + Config.UPLOAD_FACE_GROUP);
        tbHttpMessageTask.setResponsedClass(UploadFaceGroupResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e.c cVar, String str) {
        if (cVar != null) {
            cVar.onFail(str);
        }
        e.diT().D(false, str);
    }

    public void b(String str, List<FaceData> list, e.c cVar, int i) {
        if (list == null || list.isEmpty()) {
            b(cVar, "empty list");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            FaceData faceData = list.get(i2);
            if (faceData != null) {
                sb.append(faceData.pid);
                if (i2 < list.size() - 1) {
                    sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList);
        HttpMessage httpMessage = new HttpMessage(1003345);
        httpMessage.addParam("name", str);
        httpMessage.addParam("cover", ((FaceData) arrayList.get(0)).pid);
        httpMessage.addParam("memes", sb.toString());
        httpMessage.addParam("forum_id", i);
        HashMap hashMap = new HashMap();
        hashMap.put(BuyTBeanActivityConfig.CALLBACK, cVar);
        hashMap.put("list", arrayList);
        hashMap.put("autoInstall", Boolean.valueOf(i == 0));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.lEQ);
        MessageManager.getInstance().unRegisterTask(1003345);
        return true;
    }
}
