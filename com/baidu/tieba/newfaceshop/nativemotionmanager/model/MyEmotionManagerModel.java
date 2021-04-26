package com.baidu.tieba.newfaceshop.nativemotionmanager.model;

import android.util.Pair;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.data.EmotionManageResponseMessage;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.data.NativeManageEmotionModel;
import d.a.c.e.p.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class MyEmotionManagerModel extends NativeManageEmotionModel {

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.y1.h.e.a.a f19429e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f19430f;

    /* renamed from: g  reason: collision with root package name */
    public List<EmotionPackageData> f19431g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f19432h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f19433i;
    public final HttpMessageListener j;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Pair)) {
                return;
            }
            Pair pair = (Pair) customResponsedMessage.getData();
            MyEmotionManagerModel.this.I(((Integer) pair.first).intValue(), ((Integer) pair.second).intValue());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003385 && (httpResponsedMessage instanceof EmotionManageResponseMessage)) {
                EmotionManageResponseMessage emotionManageResponseMessage = (EmotionManageResponseMessage) httpResponsedMessage;
                if (MyEmotionManagerModel.this.f19429e != null) {
                    if (emotionManageResponseMessage.data != null) {
                        MyEmotionManagerModel.this.f19431g.clear();
                        if (emotionManageResponseMessage.data.data != null) {
                            MyEmotionManagerModel.this.f19431g.addAll(emotionManageResponseMessage.data.data);
                        }
                        Pair A = MyEmotionManagerModel.this.A(emotionManageResponseMessage.data.data);
                        MyEmotionManagerModel.this.f19429e.onSuccess(new Pair(A.first, A.second));
                        return;
                    }
                    MyEmotionManagerModel.this.f19429e.onFail();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MyEmotionManagerModel.this.K();
            List<MyEmotionGroupData> f2 = d.a.j0.y1.c.i().f();
            JSONArray jSONArray = new JSONArray();
            if (f2 != null && !f2.isEmpty()) {
                for (MyEmotionGroupData myEmotionGroupData : f2) {
                    if (myEmotionGroupData != null) {
                        jSONArray.put(myEmotionGroupData.getGroupId());
                        MyEmotionManagerModel.this.M(myEmotionGroupData.getGroupId());
                    }
                }
            }
            MyEmotionManagerModel myEmotionManagerModel = MyEmotionManagerModel.this;
            d.a.c.e.m.e.a().post(new g(myEmotionManagerModel, myEmotionManagerModel, jSONArray));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MyEmotionManagerModel.this.K();
            List<MyEmotionGroupData> f2 = d.a.j0.y1.c.i().f();
            JSONArray jSONArray = new JSONArray();
            if (f2 != null && !f2.isEmpty()) {
                for (MyEmotionGroupData myEmotionGroupData : f2) {
                    if (myEmotionGroupData != null) {
                        jSONArray.put(myEmotionGroupData.getGroupId());
                        MyEmotionManagerModel.this.M(myEmotionGroupData.getGroupId());
                    }
                }
            }
            if (MyEmotionManagerModel.this.f19429e != null) {
                MyEmotionManagerModel myEmotionManagerModel = MyEmotionManagerModel.this;
                Pair A = myEmotionManagerModel.A(myEmotionManagerModel.f19431g);
                MyEmotionManagerModel.this.f19429e.onSuccess(new Pair(A.first, A.second));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MyEmotionManagerModel.this.f19429e != null) {
                MyEmotionManagerModel.this.f19429e.d0();
                if (d.a.j0.y1.h.a.b().a()) {
                    return;
                }
                MyEmotionManagerModel.this.H();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.j0.y1.c.i().j(MyEmotionManagerModel.this.C(), true);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<MyEmotionManagerModel> f19440e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f19441f;

        public g(MyEmotionManagerModel myEmotionManagerModel, MyEmotionManagerModel myEmotionManagerModel2, JSONArray jSONArray) {
            this.f19440e = new WeakReference<>(myEmotionManagerModel2);
            this.f19441f = jSONArray;
            if (jSONArray == null) {
                this.f19441f = new JSONArray();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            MyEmotionManagerModel myEmotionManagerModel = this.f19440e.get();
            if (myEmotionManagerModel != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_MINE_MANAGER);
                httpMessage.addParam("ids", this.f19441f);
                myEmotionManagerModel.sendMessage(httpMessage);
            }
        }
    }

    public MyEmotionManagerModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        this.f19433i = new a(2921312);
        this.j = new b(CmdConfigHttp.CMD_GET_EMOTION_MINE_MANAGER);
        this.f19432h = tbPageContext;
        this.f19430f = new ArrayList();
        this.f19431g = new ArrayList();
        registerTask();
        this.j.setTag(getUniqueId());
        this.j.setSelfListener(true);
        registerListener(this.j);
        registerListener(this.f19433i);
    }

    public final Pair<List<EmotionPackageData>, Integer> A(List<EmotionPackageData> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null) {
            return new Pair<>(arrayList, 0);
        }
        int size = list.size();
        String id = TbadkCoreApplication.getCurrentAccountObj().getID();
        if (id == null) {
            id = "";
        }
        List<String> C = C();
        for (String str : C) {
            EmotionPackageData B = B(str, list);
            if (B != null) {
                B.ishasdownload = true;
                B.typeofemotion = D(B, id);
                arrayList.add(B);
            }
        }
        int size2 = arrayList.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            EmotionPackageData emotionPackageData = list.get(i2);
            if (emotionPackageData.status == 1 && !C.contains(String.valueOf(emotionPackageData.id))) {
                if (!z) {
                    emotionPackageData.isUndownloadheader = true;
                    z = true;
                }
                emotionPackageData.ishasdownload = false;
                int D = D(emotionPackageData, id);
                emotionPackageData.typeofemotion = D;
                if (D == 1) {
                    arrayList2.add(emotionPackageData);
                }
            }
        }
        arrayList.addAll(arrayList2);
        return new Pair<>(arrayList, Integer.valueOf(size2));
    }

    public final synchronized EmotionPackageData B(String str, List<EmotionPackageData> list) {
        if (str != null) {
            if (list != null) {
                try {
                    for (EmotionPackageData emotionPackageData : list) {
                        if (Integer.valueOf(str).intValue() == emotionPackageData.id) {
                            return emotionPackageData;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return null;
    }

    public final synchronized List<String> C() {
        return new ArrayList(this.f19430f);
    }

    public final synchronized int D(EmotionPackageData emotionPackageData, String str) {
        if (emotionPackageData == null) {
            return 0;
        }
        if (str.equals(emotionPackageData.owner)) {
            return 1;
        }
        return emotionPackageData.forum_id > 0 ? 2 : 0;
    }

    public void E() {
        LoadData();
    }

    public void F() {
        d.a.j0.y1.a.b().a(new d());
    }

    public void G() {
        if (this.j != null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
        if (this.f19433i != null) {
            MessageManager.getInstance().unRegisterListener(this.f19433i);
        }
    }

    public final void H() {
        if (d.a.j0.y1.d.m().o()) {
            l.L(this.f19432h.getPageActivity(), R.string.face_group_is_syncing);
        } else {
            d.a.j0.y1.a.b().a(new f());
        }
    }

    public final synchronized void I(int i2, int i3) {
        try {
            this.f19430f.add(i3, this.f19430f.remove(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void J() {
        d.a.c.e.m.e.a().post(new e());
    }

    public final synchronized void K() {
        this.f19430f.clear();
    }

    public void L(d.a.j0.y1.h.e.a.a aVar) {
        this.f19429e = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        d.a.j0.y1.a.b().a(new c());
        return false;
    }

    public final synchronized void M(String str) {
        this.f19430f.add(str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_EMOTION_MINE_MANAGER, TbConfig.SERVER_ADDRESS + "c/e/meme/mgetmeme");
        tbHttpMessageTask.setResponsedClass(EmotionManageResponseMessage.class);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
