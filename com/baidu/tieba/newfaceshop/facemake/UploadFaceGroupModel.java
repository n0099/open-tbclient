package com.baidu.tieba.newfaceshop.facemake;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.newfaceshop.FaceBaseModel;
import d.b.j0.y1.g.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class UploadFaceGroupModel extends FaceBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f18947e = new a(CmdConfigHttp.CMD_UPLOAD_FACE_GROUP);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            e.l lVar;
            ArrayList arrayList;
            boolean z;
            Object extra;
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003345 || !(httpResponsedMessage instanceof UploadFaceGroupResponseMessage)) {
                return;
            }
            if (httpResponsedMessage.getOrginalMessage() == null || (extra = httpResponsedMessage.getOrginalMessage().getExtra()) == null || !(extra instanceof HashMap)) {
                lVar = null;
                arrayList = null;
            } else {
                HashMap hashMap = (HashMap) extra;
                Object obj = hashMap.get("callback");
                lVar = (obj == null || !(obj instanceof e.l)) ? null : (e.l) obj;
                Object obj2 = hashMap.get("list");
                arrayList = (obj2 == null || !(obj2 instanceof ArrayList)) ? null : (ArrayList) obj2;
                Object obj3 = hashMap.get("autoInstall");
                if (obj3 != null && (obj3 instanceof Boolean)) {
                    z = ((Boolean) obj3).booleanValue();
                    if (arrayList != null) {
                        UploadFaceGroupModel.this.t(lVar, null);
                        BdLog.e("msg extra empty");
                        return;
                    } else if (httpResponsedMessage.getError() != 0) {
                        UploadFaceGroupModel.this.t(lVar, httpResponsedMessage.getErrorString());
                        return;
                    } else {
                        String groupId = ((UploadFaceGroupResponseMessage) httpResponsedMessage).getGroupId();
                        if (TextUtils.isEmpty(groupId)) {
                            UploadFaceGroupModel.this.t(lVar, httpResponsedMessage.getErrorString());
                            return;
                        }
                        if (lVar != null) {
                            lVar.a(groupId, arrayList);
                        }
                        e.l().u(true, httpResponsedMessage.getErrorString());
                        if (z) {
                            e.l().p(groupId, arrayList, null);
                            return;
                        }
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("upload_result", new Boolean(true));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, hashMap2));
                        return;
                    }
                }
            }
            z = true;
            if (arrayList != null) {
            }
        }
    }

    public UploadFaceGroupModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f18947e.setTag(getUniqueId());
        this.f18947e.setSelfListener(true);
        registerListener(this.f18947e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f18947e);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_UPLOAD_FACE_GROUP);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_UPLOAD_FACE_GROUP, TbConfig.SERVER_ADDRESS + "c/e/meme/addPackage");
        tbHttpMessageTask.setResponsedClass(UploadFaceGroupResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void t(e.l lVar, String str) {
        if (lVar != null) {
            lVar.onFail(str);
        }
        e.l().u(false, str);
    }

    public void u(String str, List<FaceData> list, e.l lVar, int i) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                FaceData faceData = list.get(i2);
                if (faceData != null) {
                    sb.append(faceData.pid);
                    if (i2 < list.size() - 1) {
                        sb.append("_");
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            Collections.sort(arrayList);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_UPLOAD_FACE_GROUP);
            httpMessage.addParam("name", str);
            httpMessage.addParam(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, ((FaceData) arrayList.get(0)).pid);
            httpMessage.addParam("memes", sb.toString());
            httpMessage.addParam("forum_id", i);
            HashMap hashMap = new HashMap();
            hashMap.put("callback", lVar);
            hashMap.put("list", arrayList);
            hashMap.put("autoInstall", Boolean.valueOf(i == 0));
            httpMessage.setExtra(hashMap);
            sendMessage(httpMessage);
            return;
        }
        t(lVar, "empty list");
    }
}
