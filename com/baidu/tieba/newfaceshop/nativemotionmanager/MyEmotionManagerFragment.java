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
import d.b.b.e.p.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MyEmotionManagerFragment extends BaseFragment implements d.b.i0.x1.h.e.a.a<Pair<List<EmotionPackageData>, Integer>> {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.x1.h.f.d f19267e;

    /* renamed from: f  reason: collision with root package name */
    public MyEmotionManagerModel f19268f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.x1.h.c.a f19269g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f19270h = new a(2921311);
    public CustomMessageListener i = new b(2921054);
    public CustomMessageListener j = new c(2921310);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0207a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f19272e;

            public RunnableC0207a(CustomResponsedMessage customResponsedMessage) {
                this.f19272e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                String valueOf = String.valueOf(this.f19272e.getData());
                ArrayList arrayList = new ArrayList();
                arrayList.add(valueOf);
                if (!d.b.i0.x1.c.i().c(arrayList, true) || !j.z()) {
                    if (MyEmotionManagerFragment.this.f19268f != null) {
                        MyEmotionManagerFragment.this.f19268f.F();
                    }
                } else if (MyEmotionManagerFragment.this.f19268f != null) {
                    MyEmotionManagerFragment.this.f19268f.E();
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
            d.b.i0.x1.a.b().a(new RunnableC0207a(customResponsedMessage));
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
            if (MyEmotionManagerFragment.this.f19268f != null) {
                MyEmotionManagerFragment.this.f19268f.E();
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
            if (MyEmotionManagerFragment.this.f19268f != null) {
                MyEmotionManagerFragment.this.f19268f.J();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Pair f19276e;

        public d(Pair pair) {
            this.f19276e = pair;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            if (this.f19276e == null) {
                return;
            }
            if (MyEmotionManagerFragment.this.f19267e != null) {
                MyEmotionManagerFragment.this.f19267e.n((List) this.f19276e.first);
                MyEmotionManagerFragment.this.f19267e.e();
            }
            if (MyEmotionManagerFragment.this.f19269g == null || (obj = this.f19276e.second) == null) {
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
            if (MyEmotionManagerFragment.this.f19267e != null) {
                MyEmotionManagerFragment.this.f19267e.m();
            }
            if (MyEmotionManagerFragment.this.f19269g != null) {
                MyEmotionManagerFragment.this.I0(false);
            }
        }
    }

    public final void H0() {
        this.f19268f.E();
    }

    public void I0(boolean z) {
        d.b.i0.x1.h.c.a aVar = this.f19269g;
        if (aVar != null) {
            aVar.onUpdate(Boolean.valueOf(z));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x1.h.e.a.a
    /* renamed from: J0 */
    public void onSuccess(Pair<List<EmotionPackageData>, Integer> pair) {
        d.b.b.e.m.e.a().post(new d(pair));
    }

    public void K0(d.b.i0.x1.h.c.a aVar) {
        if (aVar != null) {
            this.f19269g = aVar;
        }
    }

    @Override // d.b.i0.x1.h.e.a.a
    public void O() {
        d.b.i0.x1.h.f.d dVar = this.f19267e;
        if (dVar != null) {
            dVar.h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.x1.h.f.d dVar = this.f19267e;
        if (dVar != null) {
            dVar.g(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.b.i0.x1.h.a.b().c();
        registerListener(this.i);
        registerListener(this.j);
        registerListener(this.f19270h);
        this.f19267e = new d.b.i0.x1.h.f.d(getPageContext());
        MyEmotionManagerModel myEmotionManagerModel = new MyEmotionManagerModel(getPageContext());
        this.f19268f = myEmotionManagerModel;
        myEmotionManagerModel.L(this);
        return this.f19267e.d();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MyEmotionManagerModel myEmotionManagerModel = this.f19268f;
        if (myEmotionManagerModel != null) {
            myEmotionManagerModel.G();
        }
        if (this.i != null) {
            MessageManager.getInstance().unRegisterListener(this.i);
        }
        if (this.j != null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
        if (this.f19270h != null) {
            MessageManager.getInstance().unRegisterListener(this.f19270h);
        }
    }

    @Override // d.b.i0.x1.h.e.a.a
    public void onFail() {
        d.b.b.e.m.e.a().post(new e());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        H0();
    }
}
