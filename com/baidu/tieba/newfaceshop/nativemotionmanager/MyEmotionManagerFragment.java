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
import d.b.c.e.p.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MyEmotionManagerFragment extends BaseFragment implements d.b.j0.y1.h.e.a.a<Pair<List<EmotionPackageData>, Integer>> {

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.y1.h.f.d f18952e;

    /* renamed from: f  reason: collision with root package name */
    public MyEmotionManagerModel f18953f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.y1.h.c.a f18954g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f18955h = new a(2921311);
    public CustomMessageListener i = new b(2921054);
    public CustomMessageListener j = new c(2921310);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0211a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f18957e;

            public RunnableC0211a(CustomResponsedMessage customResponsedMessage) {
                this.f18957e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                String valueOf = String.valueOf(this.f18957e.getData());
                ArrayList arrayList = new ArrayList();
                arrayList.add(valueOf);
                if (!d.b.j0.y1.c.i().c(arrayList, true) || !j.z()) {
                    if (MyEmotionManagerFragment.this.f18953f != null) {
                        MyEmotionManagerFragment.this.f18953f.F();
                    }
                } else if (MyEmotionManagerFragment.this.f18953f != null) {
                    MyEmotionManagerFragment.this.f18953f.E();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
                }
            }
        }

        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            d.b.j0.y1.a.b().a(new RunnableC0211a(customResponsedMessage));
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.f18953f != null) {
                MyEmotionManagerFragment.this.f18953f.E();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.f18953f != null) {
                MyEmotionManagerFragment.this.f18953f.J();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Pair f18961e;

        public d(Pair pair) {
            this.f18961e = pair;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            if (this.f18961e == null) {
                return;
            }
            if (MyEmotionManagerFragment.this.f18952e != null) {
                MyEmotionManagerFragment.this.f18952e.n((List) this.f18961e.first);
                MyEmotionManagerFragment.this.f18952e.e();
            }
            if (MyEmotionManagerFragment.this.f18954g == null || (obj = this.f18961e.second) == null) {
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
            if (MyEmotionManagerFragment.this.f18952e != null) {
                MyEmotionManagerFragment.this.f18952e.m();
            }
            if (MyEmotionManagerFragment.this.f18954g != null) {
                MyEmotionManagerFragment.this.I0(false);
            }
        }
    }

    public final void H0() {
        this.f18953f.E();
    }

    public void I0(boolean z) {
        d.b.j0.y1.h.c.a aVar = this.f18954g;
        if (aVar != null) {
            aVar.onUpdate(Boolean.valueOf(z));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.y1.h.e.a.a
    /* renamed from: J0 */
    public void onSuccess(Pair<List<EmotionPackageData>, Integer> pair) {
        d.b.c.e.m.e.a().post(new d(pair));
    }

    public void K0(d.b.j0.y1.h.c.a aVar) {
        if (aVar != null) {
            this.f18954g = aVar;
        }
    }

    @Override // d.b.j0.y1.h.e.a.a
    public void O() {
        d.b.j0.y1.h.f.d dVar = this.f18952e;
        if (dVar != null) {
            dVar.h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.j0.y1.h.f.d dVar = this.f18952e;
        if (dVar != null) {
            dVar.g(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.b.j0.y1.h.a.b().c();
        registerListener(this.i);
        registerListener(this.j);
        registerListener(this.f18955h);
        this.f18952e = new d.b.j0.y1.h.f.d(getPageContext());
        MyEmotionManagerModel myEmotionManagerModel = new MyEmotionManagerModel(getPageContext());
        this.f18953f = myEmotionManagerModel;
        myEmotionManagerModel.L(this);
        return this.f18952e.d();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MyEmotionManagerModel myEmotionManagerModel = this.f18953f;
        if (myEmotionManagerModel != null) {
            myEmotionManagerModel.G();
        }
        if (this.i != null) {
            MessageManager.getInstance().unRegisterListener(this.i);
        }
        if (this.j != null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
        if (this.f18955h != null) {
            MessageManager.getInstance().unRegisterListener(this.f18955h);
        }
    }

    @Override // d.b.j0.y1.h.e.a.a
    public void onFail() {
        d.b.c.e.m.e.a().post(new e());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        H0();
    }
}
