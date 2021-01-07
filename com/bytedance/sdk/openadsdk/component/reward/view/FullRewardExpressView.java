package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes4.dex */
public class FullRewardExpressView extends NativeExpressView implements g {

    /* renamed from: a  reason: collision with root package name */
    g f6656a;

    /* renamed from: b  reason: collision with root package name */
    FullRewardExpressBackupView f6657b;

    public FullRewardExpressView(@NonNull Context context, l lVar, AdSlot adSlot, String str) {
        super(context, lVar, adSlot, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void a() {
        this.o = true;
        this.m = new FrameLayout(this.f);
        addView(this.m, new FrameLayout.LayoutParams(-1, -1));
        super.a();
        getWebView().setBackgroundColor(0);
        c();
    }

    private void c() {
        setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView, int i) {
                try {
                    nativeExpressView.l();
                    FullRewardExpressView.this.f6657b = new FullRewardExpressBackupView(nativeExpressView.getContext());
                    FullRewardExpressView.this.f6657b.a(FullRewardExpressView.this.k, nativeExpressView, null);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void b() {
        super.b();
        this.h.a((g) this);
    }

    public void setExpressVideoListenerProxy(g gVar) {
        this.f6656a = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(n nVar) {
        if (nVar != null && nVar.a()) {
            b(nVar);
        }
        super.a(nVar);
    }

    private void b(final n nVar) {
        if (nVar != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c(nVar);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FullRewardExpressView.this.c(nVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(n nVar) {
        if (nVar != null) {
            double d = nVar.d();
            double e = nVar.e();
            double f = nVar.f();
            double g = nVar.g();
            int a2 = (int) ak.a(this.f, (float) d);
            int a3 = (int) ak.a(this.f, (float) e);
            int a4 = (int) ak.a(this.f, (float) f);
            int a5 = (int) ak.a(this.f, (float) g);
            u.b("ExpressView", "videoWidth:" + f);
            u.b("ExpressView", "videoHeight:" + g);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(a4, a5);
            }
            layoutParams.width = a4;
            layoutParams.height = a5;
            layoutParams.topMargin = a3;
            layoutParams.leftMargin = a2;
            this.m.setLayoutParams(layoutParams);
            this.m.removeAllViews();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void e(boolean z) {
        u.b("FullRewardExpressView", "onMuteVideo,mute:" + z);
        if (this.f6656a != null) {
            this.f6656a.e(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void M() {
        u.b("FullRewardExpressView", "onSkipVideo");
        if (this.f6656a != null) {
            this.f6656a.M();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void d(int i) {
        u.b("FullRewardExpressView", "onChangeVideoState,stateType:" + i);
        if (this.f6656a != null) {
            this.f6656a.d(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long N() {
        u.b("FullRewardExpressView", "onGetCurrentPlayTime");
        if (this.f6656a != null) {
            return this.f6656a.N();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int O() {
        u.b("FullRewardExpressView", "onGetVideoState");
        if (this.f6656a != null) {
            return this.f6656a.O();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void P() {
        if (this.f6656a != null) {
            this.f6656a.P();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i, j jVar) {
        if (i != -1 && jVar != null && i == 3) {
            P();
        }
        super.a(i, jVar);
    }

    public FrameLayout getVideoFrameLayout() {
        return m() ? this.f6657b.getVideoContainer() : this.m;
    }
}
