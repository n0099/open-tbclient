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
import d.a.n0.z1.h.f.f;
import java.util.List;
/* loaded from: classes4.dex */
public class SingleThreadEmotionFragment extends BaseFragment implements d.a.n0.z1.h.e.a.a<List<EmotionPackageData>> {

    /* renamed from: e  reason: collision with root package name */
    public f f18613e;

    /* renamed from: f  reason: collision with root package name */
    public SingleThreadEmotionModel f18614f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f18615g = new a(2921314);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (SingleThreadEmotionFragment.this.f18614f != null) {
                SingleThreadEmotionFragment.this.f18614f.y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f18617e;

        public b(List list) {
            this.f18617e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SingleThreadEmotionFragment.this.f18613e != null) {
                SingleThreadEmotionFragment.this.f18613e.j(this.f18617e);
                SingleThreadEmotionFragment.this.H0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SingleThreadEmotionFragment.this.f18613e != null) {
                SingleThreadEmotionFragment.this.f18613e.i();
            }
        }
    }

    public final void G0() {
        SingleThreadEmotionModel singleThreadEmotionModel = this.f18614f;
        if (singleThreadEmotionModel != null) {
            singleThreadEmotionModel.y();
        }
    }

    public final void H0() {
        f fVar = this.f18613e;
        if (fVar != null) {
            fVar.c();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z1.h.e.a.a
    /* renamed from: I0 */
    public void onSuccess(List<EmotionPackageData> list) {
        e.a().post(new b(list));
    }

    @Override // d.a.n0.z1.h.e.a.a
    public void d0() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        f fVar = this.f18613e;
        if (fVar != null) {
            fVar.e(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f18613e = new f(getPageContext());
        SingleThreadEmotionModel singleThreadEmotionModel = new SingleThreadEmotionModel();
        this.f18614f = singleThreadEmotionModel;
        singleThreadEmotionModel.B(this);
        registerListener(this.f18615g);
        G0();
        return this.f18613e.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f18615g != null) {
            MessageManager.getInstance().unRegisterListener(this.f18615g);
        }
        SingleThreadEmotionModel singleThreadEmotionModel = this.f18614f;
        if (singleThreadEmotionModel != null) {
            singleThreadEmotionModel.z();
        }
    }

    @Override // d.a.n0.z1.h.e.a.a
    public void onFail() {
        e.a().post(new c());
    }
}
