package com.baidu.tieba.newfaceshop.nativemotionmanager;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel;
import d.a.c.e.p.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MyEmotionManagerFragment extends BaseFragment implements d.a.n0.z1.h.e.a.a<Pair<List<EmotionPackageData>, Integer>> {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.z1.h.f.d f18600e;

    /* renamed from: f  reason: collision with root package name */
    public MyEmotionManagerModel f18601f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.z1.h.c.a f18602g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f18603h = new a(2921311);

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f18604i = new b(2921054);
    public CustomMessageListener j = new c(2921310);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0195a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f18606e;

            public RunnableC0195a(CustomResponsedMessage customResponsedMessage) {
                this.f18606e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                String valueOf = String.valueOf(this.f18606e.getData());
                ArrayList arrayList = new ArrayList();
                arrayList.add(valueOf);
                if (!d.a.n0.z1.c.i().c(arrayList, true) || !j.z()) {
                    if (MyEmotionManagerFragment.this.f18601f != null) {
                        MyEmotionManagerFragment.this.f18601f.F();
                    }
                } else if (MyEmotionManagerFragment.this.f18601f != null) {
                    MyEmotionManagerFragment.this.f18601f.E();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
                }
            }
        }

        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            d.a.n0.z1.a.b().a(new RunnableC0195a(customResponsedMessage));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.f18601f != null) {
                MyEmotionManagerFragment.this.f18601f.E();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.f18601f != null) {
                MyEmotionManagerFragment.this.f18601f.J();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Pair f18610e;

        public d(Pair pair) {
            this.f18610e = pair;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            if (this.f18610e == null) {
                return;
            }
            if (MyEmotionManagerFragment.this.f18600e != null) {
                MyEmotionManagerFragment.this.f18600e.n((List) this.f18610e.first);
                MyEmotionManagerFragment.this.f18600e.e();
            }
            if (MyEmotionManagerFragment.this.f18602g == null || (obj = this.f18610e.second) == null) {
                return;
            }
            MyEmotionManagerFragment.this.H0(((Integer) obj).intValue() > 0);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MyEmotionManagerFragment.this.f18600e != null) {
                MyEmotionManagerFragment.this.f18600e.m();
            }
            if (MyEmotionManagerFragment.this.f18602g != null) {
                MyEmotionManagerFragment.this.H0(false);
            }
        }
    }

    public final void G0() {
        this.f18601f.E();
    }

    public void H0(boolean z) {
        d.a.n0.z1.h.c.a aVar = this.f18602g;
        if (aVar != null) {
            aVar.onUpdate(Boolean.valueOf(z));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z1.h.e.a.a
    /* renamed from: I0 */
    public void onSuccess(Pair<List<EmotionPackageData>, Integer> pair) {
        d.a.c.e.m.e.a().post(new d(pair));
    }

    public void J0(d.a.n0.z1.h.c.a aVar) {
        if (aVar != null) {
            this.f18602g = aVar;
        }
    }

    @Override // d.a.n0.z1.h.e.a.a
    public void d0() {
        d.a.n0.z1.h.f.d dVar = this.f18600e;
        if (dVar != null) {
            dVar.h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.z1.h.f.d dVar = this.f18600e;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.n0.z1.h.a.b().c();
        registerListener(this.f18604i);
        registerListener(this.j);
        registerListener(this.f18603h);
        this.f18600e = new d.a.n0.z1.h.f.d(getPageContext());
        MyEmotionManagerModel myEmotionManagerModel = new MyEmotionManagerModel(getPageContext());
        this.f18601f = myEmotionManagerModel;
        myEmotionManagerModel.L(this);
        return this.f18600e.d();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MyEmotionManagerModel myEmotionManagerModel = this.f18601f;
        if (myEmotionManagerModel != null) {
            myEmotionManagerModel.G();
        }
        if (this.f18604i != null) {
            MessageManager.getInstance().unRegisterListener(this.f18604i);
        }
        if (this.j != null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
        if (this.f18603h != null) {
            MessageManager.getInstance().unRegisterListener(this.f18603h);
        }
    }

    @Override // d.a.n0.z1.h.e.a.a
    public void onFail() {
        d.a.c.e.m.e.a().post(new e());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        G0();
    }
}
