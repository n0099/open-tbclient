package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes5.dex */
public class FullRewardExpressView extends NativeExpressView implements g {

    /* renamed from: a  reason: collision with root package name */
    public g f27548a;

    /* renamed from: b  reason: collision with root package name */
    public FullRewardExpressBackupView f27549b;

    public FullRewardExpressView(@NonNull Context context, l lVar, AdSlot adSlot, String str) {
        super(context, lVar, adSlot, str);
    }

    private void c() {
        setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView, int i) {
                try {
                    nativeExpressView.l();
                    FullRewardExpressView.this.f27549b = new FullRewardExpressBackupView(nativeExpressView.getContext());
                    FullRewardExpressView.this.f27549b.a(FullRewardExpressView.this.l, nativeExpressView, null);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void Q() {
        u.b("FullRewardExpressView", "onSkipVideo");
        g gVar = this.f27548a;
        if (gVar != null) {
            gVar.Q();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long R() {
        u.b("FullRewardExpressView", "onGetCurrentPlayTime");
        g gVar = this.f27548a;
        if (gVar != null) {
            return gVar.R();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int S() {
        u.b("FullRewardExpressView", "onGetVideoState");
        g gVar = this.f27548a;
        if (gVar != null) {
            return gVar.S();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void T() {
        g gVar = this.f27548a;
        if (gVar != null) {
            gVar.T();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void b() {
        super.b();
        this.i.a((g) this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void d(int i) {
        u.b("FullRewardExpressView", "onChangeVideoState,stateType:" + i);
        g gVar = this.f27548a;
        if (gVar != null) {
            gVar.d(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void f(boolean z) {
        u.b("FullRewardExpressView", "onMuteVideo,mute:" + z);
        g gVar = this.f27548a;
        if (gVar != null) {
            gVar.f(z);
        }
    }

    public FrameLayout getVideoFrameLayout() {
        if (m()) {
            return this.f27549b.getVideoContainer();
        }
        return this.n;
    }

    public void setExpressVideoListenerProxy(g gVar) {
        this.f27548a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(o oVar) {
        if (oVar == null) {
            return;
        }
        double e2 = oVar.e();
        double f2 = oVar.f();
        double g2 = oVar.g();
        double h2 = oVar.h();
        int a2 = (int) al.a(this.f28196g, (float) e2);
        int a3 = (int) al.a(this.f28196g, (float) f2);
        int a4 = (int) al.a(this.f28196g, (float) g2);
        int a5 = (int) al.a(this.f28196g, (float) h2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(a4, a5);
        }
        layoutParams.width = a4;
        layoutParams.height = a5;
        layoutParams.topMargin = a3;
        layoutParams.leftMargin = a2;
        this.n.setLayoutParams(layoutParams);
        this.n.removeAllViews();
    }

    private void b(final o oVar) {
        if (oVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(oVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    FullRewardExpressView.this.c(oVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void a() {
        this.p = true;
        FrameLayout frameLayout = new FrameLayout(this.f28196g);
        this.n = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        super.a();
        getWebView().setBackgroundColor(0);
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(o oVar) {
        if (oVar != null && oVar.b()) {
            b(oVar);
        }
        super.a(oVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i, j jVar) {
        if (i != -1 && jVar != null && i == 3) {
            T();
        } else {
            super.a(i, jVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i, j jVar, boolean z) {
        if (i != -1 && jVar != null && i == 3) {
            T();
        }
        super.a(i, jVar, z);
    }
}
