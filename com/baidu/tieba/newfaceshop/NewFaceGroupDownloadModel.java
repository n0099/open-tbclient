package com.baidu.tieba.newfaceshop;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.newfaceshop.message.GetFaceGroupInfoResponseMessage;
import d.b.i0.l0.g;
import d.b.i0.x1.d;
import d.b.i0.x1.e.b;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class NewFaceGroupDownloadModel extends FaceBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f19187e = new a(this, CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {

        /* renamed from: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0204a implements b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.i0.x1.f.a f19188a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Boolean f19189b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f19190c;

            /* renamed from: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0205a extends BdAsyncTask<Void, Void, Boolean> {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f19191a;

                public C0205a(String str) {
                    this.f19191a = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    int f2 = d.b.i0.l0.a.c().f(C0204a.this.f19188a);
                    if (f2 == 0) {
                        return Boolean.FALSE;
                    }
                    EmotionGroupData emotionGroupData = new EmotionGroupData();
                    emotionGroupData.setGroupId(C0204a.this.f19188a.f62367a);
                    emotionGroupData.setEmotionsCount(f2);
                    emotionGroupData.setHeight(C0204a.this.f19188a.f62371e.get(0).i);
                    emotionGroupData.setWidth(C0204a.this.f19188a.f62371e.get(0).j);
                    emotionGroupData.setDownloadTime(System.currentTimeMillis());
                    emotionGroupData.setGroupName(C0204a.this.f19188a.f62368b);
                    emotionGroupData.setStatus(1);
                    if (g.k().e(emotionGroupData)) {
                        return Boolean.valueOf(g.k().f(TbadkCoreApplication.getCurrentAccount(), emotionGroupData));
                    }
                    return Boolean.FALSE;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    if (bool != null && bool.booleanValue()) {
                        MessageManager.getInstance().runTask(2004603, (Class) null);
                        if (C0204a.this.f19189b.booleanValue()) {
                            d.m().w();
                        }
                        b bVar = C0204a.this.f19190c;
                        if (bVar != null) {
                            bVar.onSuccess(this.f19191a);
                        }
                        d.b.i0.l0.a0.a aVar = new d.b.i0.l0.a0.a();
                        aVar.f56481a = 0;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
                        return;
                    }
                    b bVar2 = C0204a.this.f19190c;
                    if (bVar2 != null) {
                        bVar2.onFail("failed to download");
                    }
                    d.b.i0.l0.a0.a aVar2 = new d.b.i0.l0.a0.a();
                    aVar2.f56481a = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar2));
                }
            }

            public C0204a(a aVar, d.b.i0.x1.f.a aVar2, Boolean bool, b bVar) {
                this.f19188a = aVar2;
                this.f19189b = bool;
                this.f19190c = bVar;
            }

            @Override // d.b.i0.x1.e.b
            public void onFail(String str) {
                BdLog.e("FaceDownload:" + str);
                b bVar = this.f19190c;
                if (bVar != null) {
                    bVar.onFail(str);
                }
                d.b.i0.l0.a0.a aVar = new d.b.i0.l0.a0.a();
                aVar.f56481a = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
            }

            @Override // d.b.i0.x1.e.b
            public void onProgress(int i) {
                b bVar = this.f19190c;
                if (bVar != null) {
                    bVar.onProgress(i);
                }
                d.b.i0.l0.a0.a aVar = new d.b.i0.l0.a0.a();
                aVar.f56481a = 2;
                aVar.f56482b = i;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
            }

            @Override // d.b.i0.x1.e.b
            public void onSuccess(String str) {
                new C0205a(str).execute(new Void[0]);
            }
        }

        public a(NewFaceGroupDownloadModel newFaceGroupDownloadModel, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Object extra;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003338 && (httpResponsedMessage instanceof GetFaceGroupInfoResponseMessage)) {
                b bVar = null;
                Boolean bool = Boolean.FALSE;
                if (httpResponsedMessage.getOrginalMessage() != null && (extra = httpResponsedMessage.getOrginalMessage().getExtra()) != null && (extra instanceof HashMap)) {
                    HashMap hashMap = (HashMap) extra;
                    Object obj = hashMap.get("callback");
                    if (obj != null && (obj instanceof b)) {
                        bVar = (b) obj;
                    }
                    Object obj2 = hashMap.get("sync");
                    if (obj2 != null && (obj2 instanceof Boolean)) {
                        bool = (Boolean) obj2;
                    }
                }
                d.b.i0.x1.f.a data = ((GetFaceGroupInfoResponseMessage) httpResponsedMessage).getData();
                if (data != null) {
                    d.b.i0.x1.b.c(data, new C0204a(this, data, bool, bVar));
                } else if (bVar != null) {
                    bVar.onFail("group data null");
                }
            }
        }
    }

    public NewFaceGroupDownloadModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f19187e.setTag(getUniqueId());
        this.f19187e.setSelfListener(true);
        registerListener(this.f19187e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f19187e);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FACE_GROUP_INFO, TbConfig.SERVER_ADDRESS + "c/e/meme/download");
        tbHttpMessageTask.setResponsedClass(GetFaceGroupInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void s(String str, Boolean bool, b bVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);
        HashMap hashMap = new HashMap();
        hashMap.put("sync", bool);
        hashMap.put("callback", bVar);
        httpMessage.setExtra(hashMap);
        httpMessage.addParam("id", str);
        sendMessage(httpMessage);
    }
}
