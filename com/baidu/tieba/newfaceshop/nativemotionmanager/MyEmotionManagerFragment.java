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
/* loaded from: classes3.dex */
public class MyEmotionManagerFragment extends BaseFragment implements d.a.j0.y1.h.e.a.a<Pair<List<EmotionPackageData>, Integer>> {

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.y1.h.f.d f19398e;

    /* renamed from: f  reason: collision with root package name */
    public MyEmotionManagerModel f19399f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.y1.h.c.a f19400g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f19401h = new a(2921311);

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f19402i = new b(2921054);
    public CustomMessageListener j = new c(2921310);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0207a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f19404e;

            public RunnableC0207a(CustomResponsedMessage customResponsedMessage) {
                this.f19404e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                String valueOf = String.valueOf(this.f19404e.getData());
                ArrayList arrayList = new ArrayList();
                arrayList.add(valueOf);
                if (!d.a.j0.y1.c.i().c(arrayList, true) || !j.z()) {
                    if (MyEmotionManagerFragment.this.f19399f != null) {
                        MyEmotionManagerFragment.this.f19399f.F();
                    }
                } else if (MyEmotionManagerFragment.this.f19399f != null) {
                    MyEmotionManagerFragment.this.f19399f.E();
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
            d.a.j0.y1.a.b().a(new RunnableC0207a(customResponsedMessage));
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.f19399f != null) {
                MyEmotionManagerFragment.this.f19399f.E();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.f19399f != null) {
                MyEmotionManagerFragment.this.f19399f.J();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Pair f19408e;

        public d(Pair pair) {
            this.f19408e = pair;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            if (this.f19408e == null) {
                return;
            }
            if (MyEmotionManagerFragment.this.f19398e != null) {
                MyEmotionManagerFragment.this.f19398e.n((List) this.f19408e.first);
                MyEmotionManagerFragment.this.f19398e.e();
            }
            if (MyEmotionManagerFragment.this.f19400g == null || (obj = this.f19408e.second) == null) {
                return;
            }
            MyEmotionManagerFragment.this.I0(((Integer) obj).intValue() > 0);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MyEmotionManagerFragment.this.f19398e != null) {
                MyEmotionManagerFragment.this.f19398e.m();
            }
            if (MyEmotionManagerFragment.this.f19400g != null) {
                MyEmotionManagerFragment.this.I0(false);
            }
        }
    }

    public final void H0() {
        this.f19399f.E();
    }

    public void I0(boolean z) {
        d.a.j0.y1.h.c.a aVar = this.f19400g;
        if (aVar != null) {
            aVar.onUpdate(Boolean.valueOf(z));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.y1.h.e.a.a
    /* renamed from: J0 */
    public void onSuccess(Pair<List<EmotionPackageData>, Integer> pair) {
        d.a.c.e.m.e.a().post(new d(pair));
    }

    public void K0(d.a.j0.y1.h.c.a aVar) {
        if (aVar != null) {
            this.f19400g = aVar;
        }
    }

    @Override // d.a.j0.y1.h.e.a.a
    public void d0() {
        d.a.j0.y1.h.f.d dVar = this.f19398e;
        if (dVar != null) {
            dVar.h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.j0.y1.h.f.d dVar = this.f19398e;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.j0.y1.h.a.b().c();
        registerListener(this.f19402i);
        registerListener(this.j);
        registerListener(this.f19401h);
        this.f19398e = new d.a.j0.y1.h.f.d(getPageContext());
        MyEmotionManagerModel myEmotionManagerModel = new MyEmotionManagerModel(getPageContext());
        this.f19399f = myEmotionManagerModel;
        myEmotionManagerModel.L(this);
        return this.f19398e.d();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MyEmotionManagerModel myEmotionManagerModel = this.f19399f;
        if (myEmotionManagerModel != null) {
            myEmotionManagerModel.G();
        }
        if (this.f19402i != null) {
            MessageManager.getInstance().unRegisterListener(this.f19402i);
        }
        if (this.j != null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
        if (this.f19401h != null) {
            MessageManager.getInstance().unRegisterListener(this.f19401h);
        }
    }

    @Override // d.a.j0.y1.h.e.a.a
    public void onFail() {
        d.a.c.e.m.e.a().post(new e());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        H0();
    }
}
