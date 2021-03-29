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
import d.b.b.e.m.e;
import d.b.i0.x1.h.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class SingleThreadEmotionFragment extends BaseFragment implements d.b.i0.x1.h.e.a.a<List<EmotionPackageData>> {

    /* renamed from: e  reason: collision with root package name */
    public f f19279e;

    /* renamed from: f  reason: collision with root package name */
    public SingleThreadEmotionModel f19280f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f19281g = new a(2921314);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (SingleThreadEmotionFragment.this.f19280f != null) {
                SingleThreadEmotionFragment.this.f19280f.y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f19283e;

        public b(List list) {
            this.f19283e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SingleThreadEmotionFragment.this.f19279e != null) {
                SingleThreadEmotionFragment.this.f19279e.j(this.f19283e);
                SingleThreadEmotionFragment.this.I0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SingleThreadEmotionFragment.this.f19279e != null) {
                SingleThreadEmotionFragment.this.f19279e.i();
            }
        }
    }

    public final void H0() {
        SingleThreadEmotionModel singleThreadEmotionModel = this.f19280f;
        if (singleThreadEmotionModel != null) {
            singleThreadEmotionModel.y();
        }
    }

    public final void I0() {
        f fVar = this.f19279e;
        if (fVar != null) {
            fVar.c();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x1.h.e.a.a
    /* renamed from: J0 */
    public void onSuccess(List<EmotionPackageData> list) {
        e.a().post(new b(list));
    }

    @Override // d.b.i0.x1.h.e.a.a
    public void O() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        f fVar = this.f19279e;
        if (fVar != null) {
            fVar.e(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19279e = new f(getPageContext());
        SingleThreadEmotionModel singleThreadEmotionModel = new SingleThreadEmotionModel();
        this.f19280f = singleThreadEmotionModel;
        singleThreadEmotionModel.B(this);
        registerListener(this.f19281g);
        H0();
        return this.f19279e.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f19281g != null) {
            MessageManager.getInstance().unRegisterListener(this.f19281g);
        }
        SingleThreadEmotionModel singleThreadEmotionModel = this.f19280f;
        if (singleThreadEmotionModel != null) {
            singleThreadEmotionModel.z();
        }
    }

    @Override // d.b.i0.x1.h.e.a.a
    public void onFail() {
        e.a().post(new c());
    }
}
