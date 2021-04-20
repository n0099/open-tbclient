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
import d.b.c.e.m.e;
import d.b.i0.y1.h.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class SingleThreadEmotionFragment extends BaseFragment implements d.b.i0.y1.h.e.a.a<List<EmotionPackageData>> {

    /* renamed from: e  reason: collision with root package name */
    public f f18956e;

    /* renamed from: f  reason: collision with root package name */
    public SingleThreadEmotionModel f18957f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f18958g = new a(2921314);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (SingleThreadEmotionFragment.this.f18957f != null) {
                SingleThreadEmotionFragment.this.f18957f.y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f18960e;

        public b(List list) {
            this.f18960e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SingleThreadEmotionFragment.this.f18956e != null) {
                SingleThreadEmotionFragment.this.f18956e.j(this.f18960e);
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
            if (SingleThreadEmotionFragment.this.f18956e != null) {
                SingleThreadEmotionFragment.this.f18956e.i();
            }
        }
    }

    public final void H0() {
        SingleThreadEmotionModel singleThreadEmotionModel = this.f18957f;
        if (singleThreadEmotionModel != null) {
            singleThreadEmotionModel.y();
        }
    }

    public final void I0() {
        f fVar = this.f18956e;
        if (fVar != null) {
            fVar.c();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.y1.h.e.a.a
    /* renamed from: J0 */
    public void onSuccess(List<EmotionPackageData> list) {
        e.a().post(new b(list));
    }

    @Override // d.b.i0.y1.h.e.a.a
    public void O() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        f fVar = this.f18956e;
        if (fVar != null) {
            fVar.e(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f18956e = new f(getPageContext());
        SingleThreadEmotionModel singleThreadEmotionModel = new SingleThreadEmotionModel();
        this.f18957f = singleThreadEmotionModel;
        singleThreadEmotionModel.B(this);
        registerListener(this.f18958g);
        H0();
        return this.f18956e.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f18958g != null) {
            MessageManager.getInstance().unRegisterListener(this.f18958g);
        }
        SingleThreadEmotionModel singleThreadEmotionModel = this.f18957f;
        if (singleThreadEmotionModel != null) {
            singleThreadEmotionModel.z();
        }
    }

    @Override // d.b.i0.y1.h.e.a.a
    public void onFail() {
        e.a().post(new c());
    }
}
