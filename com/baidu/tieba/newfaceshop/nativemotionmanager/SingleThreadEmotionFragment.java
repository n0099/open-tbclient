package com.baidu.tieba.newfaceshop.nativemotionmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.SingleThreadEmotionModel;
import d.a.c.e.m.e;
import d.a.o0.z1.h.f.f;
import java.util.List;
/* loaded from: classes5.dex */
public class SingleThreadEmotionFragment extends BaseFragment implements d.a.o0.z1.h.e.a.a<List<EmotionPackageData>> {

    /* renamed from: e  reason: collision with root package name */
    public f f18771e;

    /* renamed from: f  reason: collision with root package name */
    public SingleThreadEmotionModel f18772f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f18773g = new a(2921314);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (SingleThreadEmotionFragment.this.f18772f != null) {
                SingleThreadEmotionFragment.this.f18772f.C();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f18775e;

        public b(List list) {
            this.f18775e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SingleThreadEmotionFragment.this.f18771e != null) {
                SingleThreadEmotionFragment.this.f18771e.j(this.f18775e);
                SingleThreadEmotionFragment.this.K0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SingleThreadEmotionFragment.this.f18771e != null) {
                SingleThreadEmotionFragment.this.f18771e.i();
            }
        }
    }

    public final void J0() {
        SingleThreadEmotionModel singleThreadEmotionModel = this.f18772f;
        if (singleThreadEmotionModel != null) {
            singleThreadEmotionModel.C();
        }
    }

    public final void K0() {
        f fVar = this.f18771e;
        if (fVar != null) {
            fVar.c();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z1.h.e.a.a
    /* renamed from: L0 */
    public void onSuccess(List<EmotionPackageData> list) {
        e.a().post(new b(list));
    }

    @Override // d.a.o0.z1.h.e.a.a
    public void g0() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        f fVar = this.f18771e;
        if (fVar != null) {
            fVar.e(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f18771e = new f(getPageContext());
        SingleThreadEmotionModel singleThreadEmotionModel = new SingleThreadEmotionModel();
        this.f18772f = singleThreadEmotionModel;
        singleThreadEmotionModel.F(this);
        registerListener(this.f18773g);
        J0();
        return this.f18771e.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f18773g != null) {
            MessageManager.getInstance().unRegisterListener(this.f18773g);
        }
        SingleThreadEmotionModel singleThreadEmotionModel = this.f18772f;
        if (singleThreadEmotionModel != null) {
            singleThreadEmotionModel.D();
        }
    }

    @Override // d.a.o0.z1.h.e.a.a
    public void onFail() {
        e.a().post(new c());
    }
}
