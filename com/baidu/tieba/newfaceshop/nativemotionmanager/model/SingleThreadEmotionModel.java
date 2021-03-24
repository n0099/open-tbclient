package com.baidu.tieba.newfaceshop.nativemotionmanager.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.data.NativeManageEmotionModel;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.data.SingleThreadEmotionResponseMessage;
import d.b.b.e.m.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class SingleThreadEmotionModel extends NativeManageEmotionModel {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.x1.h.e.a.a f19307e;

    /* renamed from: g  reason: collision with root package name */
    public final HttpMessageListener f19309g = new a(CmdConfigHttp.CMD_GET_EMOTION_SINGLE_THREAD);

    /* renamed from: f  reason: collision with root package name */
    public List<String> f19308f = new ArrayList();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003386 && (httpResponsedMessage instanceof SingleThreadEmotionResponseMessage)) {
                SingleThreadEmotionResponseMessage singleThreadEmotionResponseMessage = (SingleThreadEmotionResponseMessage) httpResponsedMessage;
                if (SingleThreadEmotionModel.this.f19307e != null) {
                    if (singleThreadEmotionResponseMessage.data != null) {
                        SingleThreadEmotionModel.this.f19307e.onSuccess(SingleThreadEmotionModel.this.w(singleThreadEmotionResponseMessage.data.pkg_list));
                    } else {
                        SingleThreadEmotionModel.this.f19307e.onFail();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SingleThreadEmotionModel.this.A();
            List<MyEmotionGroupData> f2 = d.b.i0.x1.c.i().f();
            JSONArray jSONArray = new JSONArray();
            if (f2 != null && !f2.isEmpty()) {
                for (MyEmotionGroupData myEmotionGroupData : f2) {
                    if (myEmotionGroupData != null) {
                        jSONArray.put(myEmotionGroupData.getGroupId());
                        SingleThreadEmotionModel.this.C(myEmotionGroupData.getGroupId());
                    }
                }
            }
            SingleThreadEmotionModel singleThreadEmotionModel = SingleThreadEmotionModel.this;
            e.a().post(new c(singleThreadEmotionModel, singleThreadEmotionModel));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<SingleThreadEmotionModel> f19312e;

        public c(SingleThreadEmotionModel singleThreadEmotionModel, SingleThreadEmotionModel singleThreadEmotionModel2) {
            this.f19312e = new WeakReference<>(singleThreadEmotionModel2);
        }

        @Override // java.lang.Runnable
        public void run() {
            SingleThreadEmotionModel singleThreadEmotionModel = this.f19312e.get();
            if (singleThreadEmotionModel != null) {
                singleThreadEmotionModel.sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_SINGLE_THREAD));
            }
        }
    }

    public SingleThreadEmotionModel() {
        registerTask();
        this.f19309g.setTag(getUniqueId());
        this.f19309g.setSelfListener(true);
        registerListener(this.f19309g);
    }

    public final synchronized void A() {
        this.f19308f.clear();
    }

    public void B(d.b.i0.x1.h.e.a.a aVar) {
        this.f19307e = aVar;
    }

    public final synchronized void C(String str) {
        this.f19308f.add(str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        d.b.i0.x1.a.b().a(new b());
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_EMOTION_SINGLE_THREAD, TbConfig.SERVER_ADDRESS + "c/e/meme/getMyForumPackage");
        tbHttpMessageTask.setResponsedClass(SingleThreadEmotionResponseMessage.class);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final List<EmotionPackageData> w(List<EmotionPackageData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            List<String> x = x();
            for (EmotionPackageData emotionPackageData : list) {
                int i = emotionPackageData.status;
                if (i == 5 || i == 1) {
                    if (emotionPackageData.status == 1 && x.contains(String.valueOf(emotionPackageData.id))) {
                        emotionPackageData.ishasdownload = true;
                    }
                    arrayList.add(emotionPackageData);
                }
            }
        }
        return arrayList;
    }

    public final synchronized List<String> x() {
        return new ArrayList(this.f19308f);
    }

    public void y() {
        LoadData();
    }

    public void z() {
        if (this.f19309g != null) {
            MessageManager.getInstance().unRegisterListener(this.f19309g);
        }
    }
}
