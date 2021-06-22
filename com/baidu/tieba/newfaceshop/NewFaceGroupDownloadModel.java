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
import d.a.o0.m0.g;
import d.a.o0.z1.d;
import d.a.o0.z1.e.b;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class NewFaceGroupDownloadModel extends FaceBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f18676e = new a(this, CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {

        /* renamed from: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0197a implements b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.z1.f.a f18677a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Boolean f18678b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f18679c;

            /* renamed from: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0198a extends BdAsyncTask<Void, Void, Boolean> {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f18680a;

                public C0198a(String str) {
                    this.f18680a = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    int f2 = d.a.o0.m0.a.c().f(C0197a.this.f18677a);
                    if (f2 == 0) {
                        return Boolean.FALSE;
                    }
                    EmotionGroupData emotionGroupData = new EmotionGroupData();
                    emotionGroupData.setGroupId(C0197a.this.f18677a.f67480a);
                    emotionGroupData.setEmotionsCount(f2);
                    emotionGroupData.setHeight(C0197a.this.f18677a.f67484e.get(0).f67489i);
                    emotionGroupData.setWidth(C0197a.this.f18677a.f67484e.get(0).j);
                    emotionGroupData.setDownloadTime(System.currentTimeMillis());
                    emotionGroupData.setGroupName(C0197a.this.f18677a.f67481b);
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
                        if (C0197a.this.f18678b.booleanValue()) {
                            d.m().w();
                        }
                        b bVar = C0197a.this.f18679c;
                        if (bVar != null) {
                            bVar.onSuccess(this.f18680a);
                        }
                        d.a.o0.m0.a0.a aVar = new d.a.o0.m0.a0.a();
                        aVar.f61016a = 0;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
                        return;
                    }
                    b bVar2 = C0197a.this.f18679c;
                    if (bVar2 != null) {
                        bVar2.onFail("failed to download");
                    }
                    d.a.o0.m0.a0.a aVar2 = new d.a.o0.m0.a0.a();
                    aVar2.f61016a = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar2));
                }
            }

            public C0197a(a aVar, d.a.o0.z1.f.a aVar2, Boolean bool, b bVar) {
                this.f18677a = aVar2;
                this.f18678b = bool;
                this.f18679c = bVar;
            }

            @Override // d.a.o0.z1.e.b
            public void onFail(String str) {
                BdLog.e("FaceDownload:" + str);
                b bVar = this.f18679c;
                if (bVar != null) {
                    bVar.onFail(str);
                }
                d.a.o0.m0.a0.a aVar = new d.a.o0.m0.a0.a();
                aVar.f61016a = 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
            }

            @Override // d.a.o0.z1.e.b
            public void onProgress(int i2) {
                b bVar = this.f18679c;
                if (bVar != null) {
                    bVar.onProgress(i2);
                }
                d.a.o0.m0.a0.a aVar = new d.a.o0.m0.a0.a();
                aVar.f61016a = 2;
                aVar.f61017b = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
            }

            @Override // d.a.o0.z1.e.b
            public void onSuccess(String str) {
                new C0198a(str).execute(new Void[0]);
            }
        }

        public a(NewFaceGroupDownloadModel newFaceGroupDownloadModel, int i2) {
            super(i2);
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
                d.a.o0.z1.f.a data = ((GetFaceGroupInfoResponseMessage) httpResponsedMessage).getData();
                if (data != null) {
                    d.a.o0.z1.b.c(data, new C0197a(this, data, bool, bVar));
                } else if (bVar != null) {
                    bVar.onFail("group data null");
                }
            }
        }
    }

    public NewFaceGroupDownloadModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f18676e.setTag(getUniqueId());
        this.f18676e.setSelfListener(true);
        registerListener(this.f18676e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f18676e);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FACE_GROUP_INFO, TbConfig.SERVER_ADDRESS + "c/e/meme/download");
        tbHttpMessageTask.setResponsedClass(GetFaceGroupInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void w(String str, Boolean bool, b bVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);
        HashMap hashMap = new HashMap();
        hashMap.put("sync", bool);
        hashMap.put("callback", bVar);
        httpMessage.setExtra(hashMap);
        httpMessage.addParam("id", str);
        sendMessage(httpMessage);
    }
}
