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
/* loaded from: classes5.dex */
public class MyEmotionManagerFragment extends BaseFragment implements d.a.o0.z1.h.e.a.a<Pair<List<EmotionPackageData>, Integer>> {

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.z1.h.f.d f18758e;

    /* renamed from: f  reason: collision with root package name */
    public MyEmotionManagerModel f18759f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.z1.h.c.a f18760g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f18761h = new a(2921311);

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f18762i = new b(2921054);
    public CustomMessageListener j = new c(2921310);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0199a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f18764e;

            public RunnableC0199a(CustomResponsedMessage customResponsedMessage) {
                this.f18764e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                String valueOf = String.valueOf(this.f18764e.getData());
                ArrayList arrayList = new ArrayList();
                arrayList.add(valueOf);
                if (!d.a.o0.z1.c.i().c(arrayList, true) || !j.z()) {
                    if (MyEmotionManagerFragment.this.f18759f != null) {
                        MyEmotionManagerFragment.this.f18759f.J();
                    }
                } else if (MyEmotionManagerFragment.this.f18759f != null) {
                    MyEmotionManagerFragment.this.f18759f.I();
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
            d.a.o0.z1.a.b().a(new RunnableC0199a(customResponsedMessage));
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.f18759f != null) {
                MyEmotionManagerFragment.this.f18759f.I();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.f18759f != null) {
                MyEmotionManagerFragment.this.f18759f.N();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Pair f18768e;

        public d(Pair pair) {
            this.f18768e = pair;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            if (this.f18768e == null) {
                return;
            }
            if (MyEmotionManagerFragment.this.f18758e != null) {
                MyEmotionManagerFragment.this.f18758e.n((List) this.f18768e.first);
                MyEmotionManagerFragment.this.f18758e.e();
            }
            if (MyEmotionManagerFragment.this.f18760g == null || (obj = this.f18768e.second) == null) {
                return;
            }
            MyEmotionManagerFragment.this.K0(((Integer) obj).intValue() > 0);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MyEmotionManagerFragment.this.f18758e != null) {
                MyEmotionManagerFragment.this.f18758e.m();
            }
            if (MyEmotionManagerFragment.this.f18760g != null) {
                MyEmotionManagerFragment.this.K0(false);
            }
        }
    }

    public final void J0() {
        this.f18759f.I();
    }

    public void K0(boolean z) {
        d.a.o0.z1.h.c.a aVar = this.f18760g;
        if (aVar != null) {
            aVar.onUpdate(Boolean.valueOf(z));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z1.h.e.a.a
    /* renamed from: L0 */
    public void onSuccess(Pair<List<EmotionPackageData>, Integer> pair) {
        d.a.c.e.m.e.a().post(new d(pair));
    }

    public void M0(d.a.o0.z1.h.c.a aVar) {
        if (aVar != null) {
            this.f18760g = aVar;
        }
    }

    @Override // d.a.o0.z1.h.e.a.a
    public void g0() {
        d.a.o0.z1.h.f.d dVar = this.f18758e;
        if (dVar != null) {
            dVar.h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.o0.z1.h.f.d dVar = this.f18758e;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.o0.z1.h.a.b().c();
        registerListener(this.f18762i);
        registerListener(this.j);
        registerListener(this.f18761h);
        this.f18758e = new d.a.o0.z1.h.f.d(getPageContext());
        MyEmotionManagerModel myEmotionManagerModel = new MyEmotionManagerModel(getPageContext());
        this.f18759f = myEmotionManagerModel;
        myEmotionManagerModel.P(this);
        return this.f18758e.d();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MyEmotionManagerModel myEmotionManagerModel = this.f18759f;
        if (myEmotionManagerModel != null) {
            myEmotionManagerModel.K();
        }
        if (this.f18762i != null) {
            MessageManager.getInstance().unRegisterListener(this.f18762i);
        }
        if (this.j != null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
        if (this.f18761h != null) {
            MessageManager.getInstance().unRegisterListener(this.f18761h);
        }
    }

    @Override // d.a.o0.z1.h.e.a.a
    public void onFail() {
        d.a.c.e.m.e.a().post(new e());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        J0();
    }
}
