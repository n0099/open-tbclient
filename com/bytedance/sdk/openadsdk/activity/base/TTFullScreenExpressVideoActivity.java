package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.b;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.d.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity implements TTNativeExpressAd.ExpressAdInteractionListener, g {
    FullRewardExpressView aR;
    FrameLayout aS;
    long aT;
    a aU;
    Handler aW;
    String aV = "fullscreen_interstitial_ad";
    boolean aX = false;
    boolean aY = false;
    private boolean aZ = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity
    public void N() {
        if (this.s == null) {
            finish();
            return;
        }
        this.aG = false;
        super.N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void f() {
        super.f();
        if (this.aW == null) {
            this.aW = new Handler(Looper.getMainLooper());
        }
        m();
        a(this.P);
        l();
        s();
        k();
        a("reward_endcard");
        p();
        l lVar = this.s;
        if (l.d(this.s)) {
            this.aG = true;
            this.T = aj.d(this.s.aj());
            h();
            t();
            return;
        }
        d(true);
    }

    private void X() {
        if (!this.aZ) {
            this.aZ = true;
            View decorView = getWindow().getDecorView();
            float[] fArr = {ak.b(getApplicationContext(), decorView.getWidth()), ak.b(getApplicationContext(), decorView.getHeight())};
            if (fArr[0] < 10.0f || fArr[1] < 10.0f) {
                u.b("TTFullScreenExpressVideoActivity", "get root view size error, so run backup");
                fArr = TTBaseVideoActivity.a(this.s, this, this.aK);
            }
            a(fArr);
        }
    }

    private void a(float[] fArr) {
        this.aR = new FullRewardExpressView(this, this.s, new AdSlot.Builder().setCodeId(String.valueOf(aj.d(this.s.aj()))).setExpressViewAcceptedSize(fArr[0], fArr[1]).build(), this.aV);
        this.aR.setExpressVideoListenerProxy(this);
        this.aR.setExpressInteractionListener(this);
        a(this.aR, this.s);
        this.aS = this.aR.getVideoFrameLayout();
        this.o.addView(this.aR, new FrameLayout.LayoutParams(-1, -1));
        this.aR.h();
        if (!this.aR.m()) {
            g(false);
        }
        this.aR.i();
    }

    private void g(boolean z) {
        if (this.c != null) {
            if (this.s.D()) {
                if (!this.U.get()) {
                    this.c.setShowSound(z);
                    if (this.s.aC()) {
                        this.c.setShowDislike(z);
                    } else {
                        this.c.setShowDislike(false);
                    }
                }
            } else if (!this.U.get()) {
                this.c.setShowSkip(z);
                this.c.setShowSound(z);
                if (this.s.aC()) {
                    this.c.setShowDislike(z);
                } else {
                    this.c.setShowDislike(false);
                }
            }
        }
        if (z) {
            ak.a((View) this.d, 0);
            ak.a((View) this.aw, 0);
            return;
        }
        ak.a((View) this.d, 4);
        ak.a((View) this.aw, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.video.c.b
    public boolean a(long j, boolean z) {
        boolean z2 = false;
        this.aS = this.aR.getVideoFrameLayout();
        if (this.D == null) {
            this.D = new b(this.e, this.aS, this.s);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dynamic_show_type", Integer.valueOf(this.aR.m() ? 1 : 0));
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        this.D.a(hashMap);
        this.D.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, int i) {
                if (TTFullScreenExpressVideoActivity.this.I != null) {
                    TTFullScreenExpressVideoActivity.this.I.removeMessages(300);
                    TTFullScreenExpressVideoActivity.this.M();
                }
                TTFullScreenExpressVideoActivity.this.aY = true;
                TTFullScreenExpressVideoActivity.this.W();
                if (TTFullScreenExpressVideoActivity.this.T()) {
                    TTFullScreenExpressVideoActivity.this.t();
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i) {
                if (TTFullScreenExpressVideoActivity.this.I != null) {
                    TTFullScreenExpressVideoActivity.this.I.removeMessages(300);
                }
                TTFullScreenExpressVideoActivity.this.e(false);
                if (!TTFullScreenExpressVideoActivity.this.u()) {
                    TTFullScreenExpressVideoActivity.this.M();
                    if (TTFullScreenExpressVideoActivity.this.D != null) {
                        TTFullScreenExpressVideoActivity.this.D.m();
                    }
                    u.f("TTFullScreenExpressVideoActivity", "onError、、、、、、、、");
                    if (TTFullScreenExpressVideoActivity.this.T()) {
                        TTFullScreenExpressVideoActivity.this.t();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("vbtt_skip_type", 1);
                        TTFullScreenExpressVideoActivity.this.a("fullscreen_interstitial_ad", hashMap2);
                    } else {
                        TTFullScreenExpressVideoActivity.this.finish();
                    }
                    TTFullScreenExpressVideoActivity.this.aX = true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                if (TTFullScreenExpressVideoActivity.this.I != null) {
                    TTFullScreenExpressVideoActivity.this.I.removeMessages(300);
                    TTFullScreenExpressVideoActivity.this.M();
                }
                u.b("TTFullScreenExpressVideoActivity", "onTimeOut、、、、、、、、");
                if (TTFullScreenExpressVideoActivity.this.T()) {
                    TTFullScreenExpressVideoActivity.this.t();
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 0);
                TTFullScreenExpressVideoActivity.this.a("fullscreen_interstitial_ad", hashMap2);
                if (TTFullScreenExpressVideoActivity.this.D != null) {
                    TTFullScreenExpressVideoActivity.this.D.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                if (TTFullScreenExpressVideoActivity.this.I != null) {
                    TTFullScreenExpressVideoActivity.this.I.removeMessages(300);
                    TTFullScreenExpressVideoActivity.this.M();
                }
                TTFullScreenExpressVideoActivity.this.aT = j2;
                TTFullScreenExpressVideoActivity.this.Q = (int) (TTFullScreenExpressVideoActivity.this.K() - (j2 / 1000));
                if (TTFullScreenExpressVideoActivity.this.aR.m()) {
                    TTFullScreenExpressVideoActivity.this.e((int) (j2 / 1000));
                    if (TTFullScreenExpressVideoActivity.this.Q >= 0 && TTFullScreenExpressVideoActivity.this.c != null) {
                        TTFullScreenExpressVideoActivity.this.c.setShowSkip(true);
                        TTFullScreenExpressVideoActivity.this.c.a(String.valueOf(TTFullScreenExpressVideoActivity.this.Q), (CharSequence) null);
                    }
                }
                if (TTFullScreenExpressVideoActivity.this.Q <= 0) {
                    u.b("TTFullScreenExpressVideoActivity", "onProgressUpdate、、、、、、、、");
                    if (TTFullScreenExpressVideoActivity.this.T()) {
                        TTFullScreenExpressVideoActivity.this.t();
                    } else {
                        TTFullScreenExpressVideoActivity.this.finish();
                    }
                }
                if ((TTFullScreenExpressVideoActivity.this.aa.get() || TTFullScreenExpressVideoActivity.this.Y.get()) && TTFullScreenExpressVideoActivity.this.u()) {
                    TTFullScreenExpressVideoActivity.this.D.h();
                }
            }
        });
        String i = this.s.R() != null ? this.s.R().i() : null;
        if (this.x != null) {
            File file = new File(this.x);
            if (file.exists() && file.length() > 0) {
                i = this.x;
                this.z = true;
            }
        }
        String str = i;
        u.f("wzj", "videoUrl:" + str);
        if (this.D != null) {
            Message message = new Message();
            message.what = 300;
            message.arg1 = 0;
            this.I.sendMessageDelayed(message, 5000L);
            z2 = this.D.a(str, this.s.ag(), this.aS.getWidth(), this.aS.getHeight(), null, this.s.aj(), j, this.P);
            if (z2 && !z) {
                u.e("AdEvent", "pangolin ad show " + aj.a(this.s, (View) null));
                d.a(this.e, this.s, "fullscreen_interstitial_ad", hashMap);
                S();
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void b(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void f(boolean z) {
        if (this.P != z && this.c != null) {
            this.c.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void O() {
        if (this.c != null) {
            this.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        X();
        ak.a((Activity) this);
        if (this.aR != null) {
            this.aR.i();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void d(int i) {
        switch (i) {
            case 1:
                if (!u() && !v()) {
                    a(0L, false);
                    return;
                }
                return;
            case 2:
                try {
                    if (u()) {
                        this.D.h();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    u.f("TTFullScreenExpressVideoActivity", "onPause throw Exception :" + th.getMessage());
                    return;
                }
            case 3:
                try {
                    if (v()) {
                        this.D.k();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    u.f("TTFullScreenExpressVideoActivity", "onPause throw Exception :" + th2.getMessage());
                    return;
                }
            case 4:
                if (this.D != null) {
                    this.D.l();
                    this.D = null;
                    return;
                }
                return;
            case 5:
                if (!u() && !v()) {
                    a(0L, false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long P() {
        return this.aT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int Q() {
        if (this.aX) {
            return 4;
        }
        if (this.aY) {
            return 5;
        }
        if (w()) {
            return 1;
        }
        if (u()) {
            return 2;
        }
        if (v()) {
        }
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void R() {
        L();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.video.c.b
    public void S() {
        super.S();
        if (this.aR != null) {
            this.aR.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        this.aG = true;
        h();
        if (this.aW == null) {
            this.aW = new Handler(Looper.getMainLooper());
        }
        u.b("TTFullScreenExpressVideoActivity", "onRenderFail、、、code:" + i);
        this.aW.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                TTFullScreenExpressVideoActivity.this.t();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        if (this.s.i() != 1 || !this.s.C()) {
            if (this.aR.m()) {
                g(true);
            }
            d(false);
            this.aG = true;
            h();
            if (!a(this.w, false)) {
                t();
                HashMap hashMap = new HashMap();
                hashMap.put("vbtt_skip_type", 1);
                a(this.aV, hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        if (this.aR != null) {
            this.aR.k();
        }
        super.onDestroy();
        if (this.aW != null) {
            this.aW.removeCallbacksAndMessages(null);
        }
    }

    protected void a(@NonNull NativeExpressView nativeExpressView, @NonNull l lVar) {
        EmptyView emptyView;
        if (nativeExpressView != null && this.s != null) {
            this.aU = a(lVar);
            if (this.aU != null) {
                this.aU.b();
                if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                    this.aU.a((Activity) nativeExpressView.getContext());
                }
            }
            d.a(lVar);
            EmptyView a2 = a((ViewGroup) nativeExpressView);
            if (a2 == null) {
                EmptyView emptyView2 = new EmptyView(this.e, nativeExpressView);
                nativeExpressView.addView(emptyView2);
                emptyView = emptyView2;
            } else {
                emptyView = a2;
            }
            if (this.aU != null) {
                this.aU.a(emptyView);
            }
            emptyView.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.3
                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    if (TTFullScreenExpressVideoActivity.this.aU != null) {
                        if (z) {
                            if (TTFullScreenExpressVideoActivity.this.aU != null) {
                                TTFullScreenExpressVideoActivity.this.aU.b();
                            }
                        } else if (TTFullScreenExpressVideoActivity.this.aU != null) {
                            TTFullScreenExpressVideoActivity.this.aU.c();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    if (TTFullScreenExpressVideoActivity.this.aU != null) {
                        TTFullScreenExpressVideoActivity.this.aU.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    if (TTFullScreenExpressVideoActivity.this.aU != null) {
                        TTFullScreenExpressVideoActivity.this.aU.d();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(View view) {
                }
            });
            e eVar = new e(this.e, lVar, this.aV, aj.a(this.aV)) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.4
                @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
                public void a(View view, int i, int i2, int i3, int i4) {
                    super.a(view, i, i2, i3, i4);
                    TTFullScreenExpressVideoActivity.this.a(view, i, i2, i3, i4);
                }
            };
            eVar.a(nativeExpressView);
            eVar.a(this.aU);
            if (!TextUtils.isEmpty(this.af)) {
                HashMap hashMap = new HashMap();
                hashMap.put("rit_scene", this.af);
                eVar.a(hashMap);
            }
            this.aR.setClickListener(eVar);
            com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.e, lVar, this.aV, aj.a(this.aV)) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
                public void a(View view, int i, int i2, int i3, int i4) {
                    super.a(view, i, i2, i3, i4);
                    TTFullScreenExpressVideoActivity.this.a(view, i, i2, i3, i4);
                }
            };
            dVar.a(nativeExpressView);
            dVar.a(this.aU);
            if (!TextUtils.isEmpty(this.af)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("rit_scene", this.af);
                dVar.a(hashMap2);
            }
            this.aR.setClickCreativeListener(dVar);
            emptyView.setNeedCheckingShow(false);
            a(this.aU, this.aR);
        }
    }

    private void a(a aVar, NativeExpressView nativeExpressView) {
        if (aVar != null && nativeExpressView != null) {
            final String str = "";
            if (this.s != null) {
                str = this.s.ag();
            }
            aVar.a(new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.6
                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    TTFullScreenExpressVideoActivity.this.c("点击开始下载");
                    a.C1028a.a(str, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        int i = (int) ((100 * j2) / j);
                        TTFullScreenExpressVideoActivity.this.c("已下载" + i + "%");
                        a.C1028a.a(str, 3, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long j, long j2, String str2, String str3) {
                    TTFullScreenExpressVideoActivity.this.c("下载暂停");
                    if (j > 0) {
                        a.C1028a.a(str, 2, (int) ((100 * j2) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long j, long j2, String str2, String str3) {
                    TTFullScreenExpressVideoActivity.this.c("下载失败");
                    if (j > 0) {
                        a.C1028a.a(str, 4, (int) ((100 * j2) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long j, String str2, String str3) {
                    TTFullScreenExpressVideoActivity.this.c("点击安装");
                    a.C1028a.a(str, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String str2, String str3) {
                    TTFullScreenExpressVideoActivity.this.c("点击打开");
                    a.C1028a.a(str, 6, 100);
                }
            });
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(l lVar) {
        if (lVar.T() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.e, lVar, this.aV);
        }
        return null;
    }

    private EmptyView a(ViewGroup viewGroup) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i2);
                if (!(childAt instanceof EmptyView)) {
                    i = i2 + 1;
                } else {
                    return (EmptyView) childAt;
                }
            } else {
                return null;
            }
        }
    }
}
