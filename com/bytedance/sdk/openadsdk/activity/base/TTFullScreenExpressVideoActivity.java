package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.content.Context;
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
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.e.a;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity implements TTNativeExpressAd.ExpressAdInteractionListener, g {
    public FullRewardExpressView aU;
    public FrameLayout aV;
    public a aW;
    public Handler aY;
    public String aX = "fullscreen_interstitial_ad";
    public boolean aZ = false;
    public boolean ba = false;
    public boolean bb = false;

    private void Z() {
        if (this.bb) {
            return;
        }
        this.bb = true;
        final View decorView = getWindow().getDecorView();
        decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z = TTFullScreenExpressVideoActivity.this.s.aq() == 15;
                float[] fArr = {al.b(TTFullScreenExpressVideoActivity.this.getApplicationContext(), decorView.getWidth()), al.b(TTFullScreenExpressVideoActivity.this.getApplicationContext(), decorView.getHeight())};
                float max = Math.max(fArr[0], fArr[1]);
                float min = Math.min(fArr[0], fArr[1]);
                fArr[0] = z ? min : max;
                if (!z) {
                    max = min;
                }
                fArr[1] = max;
                if (fArr[0] < 10.0f || fArr[1] < 10.0f) {
                    u.b("TTFullScreenExpressVideoActivity", "get root view size error, so run backup");
                    TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                    fArr = TTBaseVideoActivity.a(z, tTFullScreenExpressVideoActivity, tTFullScreenExpressVideoActivity.aK);
                }
                TTFullScreenExpressVideoActivity.this.a(fArr);
            }
        });
    }

    private void g(boolean z) {
        if (this.f27016c != null) {
            if (this.s.D()) {
                if (!this.U.get()) {
                    this.f27016c.setShowSound(z);
                    if (this.s.aJ()) {
                        this.f27016c.setShowDislike(z);
                    } else {
                        this.f27016c.setShowDislike(false);
                    }
                }
            } else if (!this.U.get()) {
                this.f27016c.setShowSkip(z);
                this.f27016c.setShowSound(z);
                if (this.s.aJ()) {
                    this.f27016c.setShowDislike(z);
                } else {
                    this.f27016c.setShowDislike(false);
                }
            }
        }
        if (z) {
            al.a((View) this.f27017d, 0);
            al.a((View) this.aw, 0);
            return;
        }
        al.a((View) this.f27017d, 4);
        al.a((View) this.aw, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity
    public void P() {
        if (this.s == null) {
            finish();
            return;
        }
        this.aG = false;
        super.P();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void Q() {
        TopProxyLayout topProxyLayout = this.f27016c;
        if (topProxyLayout != null) {
            topProxyLayout.a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long R() {
        return this.aL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int S() {
        if (this.aZ) {
            return 4;
        }
        if (this.ba) {
            return 5;
        }
        if (x()) {
            return 1;
        }
        if (v()) {
            return 2;
        }
        if (w()) {
        }
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void T() {
        M();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.video.c.b
    public void U() {
        super.U();
        FullRewardExpressView fullRewardExpressView = this.aU;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void b(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void d(int i2) {
        if (i2 == 1) {
            if (v() || w()) {
                return;
            }
            a(0L, false);
        } else if (i2 == 2) {
            try {
                if (v()) {
                    this.aN = true;
                    this.D.h();
                }
            } catch (Throwable th) {
                u.f("TTFullScreenExpressVideoActivity", "onPause throw Exception :" + th.getMessage());
            }
        } else if (i2 != 3) {
            if (i2 != 4) {
                if (i2 != 5 || v() || w()) {
                    return;
                }
                a(0L, false);
                return;
            }
            c cVar = this.D;
            if (cVar != null) {
                cVar.l();
                this.D = null;
            }
        } else {
            try {
                this.aN = false;
                if (this.aO) {
                    O();
                }
                if (w()) {
                    this.D.k();
                }
            } catch (Throwable th2) {
                u.f("TTFullScreenExpressVideoActivity", "onContinue throw Exception :" + th2.getMessage());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void f() {
        super.f();
        if (this.aY == null) {
            this.aY = new Handler(Looper.getMainLooper());
        }
        n();
        a(this.P);
        m();
        t();
        l();
        a("reward_endcard");
        q();
        if (l.d(this.s)) {
            this.aG = true;
            this.T = ak.d(this.s.ap());
            i();
            u();
            return;
        }
        d(true);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        FullRewardExpressView fullRewardExpressView = this.aU;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.k();
        }
        super.onDestroy();
        Handler handler = this.aY;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        this.aG = true;
        i();
        if (this.aY == null) {
            this.aY = new Handler(Looper.getMainLooper());
        }
        u.b("TTFullScreenExpressVideoActivity", "onRenderFail、、、code:" + i2);
        this.aY.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                TTFullScreenExpressVideoActivity.this.u();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        if (this.s.i() == 1 && this.s.C()) {
            return;
        }
        if (this.aU.m()) {
            g(true);
        }
        d(false);
        this.aG = true;
        i();
        if (a(this.w, false)) {
            return;
        }
        u();
        HashMap hashMap = new HashMap();
        hashMap.put("vbtt_skip_type", 1);
        a(this.aX, hashMap);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Z();
        FullRewardExpressView fullRewardExpressView = this.aU;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr) {
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this, this.s, new AdSlot.Builder().setCodeId(String.valueOf(ak.d(this.s.ap()))).setExpressViewAcceptedSize(fArr[0], fArr[1]).build(), this.aX);
        this.aU = fullRewardExpressView;
        fullRewardExpressView.setExpressVideoListenerProxy(this);
        this.aU.setExpressInteractionListener(this);
        a(this.aU, this.s);
        this.aV = this.aU.getVideoFrameLayout();
        this.o.addView(this.aU, new FrameLayout.LayoutParams(-1, -1));
        this.aU.h();
        if (!this.aU.m()) {
            g(false);
        }
        this.aU.i();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.video.c.b
    public boolean a(long j, boolean z) {
        FrameLayout videoFrameLayout = this.aU.getVideoFrameLayout();
        this.aV = videoFrameLayout;
        if (this.D == null) {
            this.D = new b(this.f27018e, videoFrameLayout, this.s);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dynamic_show_type", Integer.valueOf(this.aU.m() ? 1 : 0));
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        this.D.a(hashMap);
        this.D.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, int i2) {
                am amVar = TTFullScreenExpressVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                    TTFullScreenExpressVideoActivity.this.N();
                }
                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                tTFullScreenExpressVideoActivity.ba = true;
                tTFullScreenExpressVideoActivity.Y();
                if (TTFullScreenExpressVideoActivity.this.V()) {
                    TTFullScreenExpressVideoActivity.this.u();
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i2) {
                am amVar = TTFullScreenExpressVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                }
                TTFullScreenExpressVideoActivity.this.e(false);
                if (TTFullScreenExpressVideoActivity.this.v()) {
                    return;
                }
                TTFullScreenExpressVideoActivity.this.N();
                c cVar = TTFullScreenExpressVideoActivity.this.D;
                if (cVar != null) {
                    cVar.m();
                }
                u.f("TTFullScreenExpressVideoActivity", "onError、、、、、、、、");
                if (TTFullScreenExpressVideoActivity.this.V()) {
                    TTFullScreenExpressVideoActivity.this.u();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("vbtt_skip_type", 1);
                    TTFullScreenExpressVideoActivity.this.a("fullscreen_interstitial_ad", hashMap2);
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                TTFullScreenExpressVideoActivity.this.aZ = true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                am amVar = TTFullScreenExpressVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                    TTFullScreenExpressVideoActivity.this.N();
                }
                u.b("TTFullScreenExpressVideoActivity", "onTimeOut、、、、、、、、");
                if (TTFullScreenExpressVideoActivity.this.V()) {
                    TTFullScreenExpressVideoActivity.this.u();
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 0);
                TTFullScreenExpressVideoActivity.this.a("fullscreen_interstitial_ad", hashMap2);
                c cVar = TTFullScreenExpressVideoActivity.this.D;
                if (cVar != null) {
                    cVar.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                TopProxyLayout topProxyLayout;
                am amVar = TTFullScreenExpressVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                    TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                    if (j2 != tTFullScreenExpressVideoActivity.aL) {
                        tTFullScreenExpressVideoActivity.N();
                    }
                }
                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity2 = TTFullScreenExpressVideoActivity.this;
                tTFullScreenExpressVideoActivity2.aL = j2;
                long j4 = j2 / 1000;
                tTFullScreenExpressVideoActivity2.Q = (int) (tTFullScreenExpressVideoActivity2.L() - j4);
                if (TTFullScreenExpressVideoActivity.this.aU.m()) {
                    TTFullScreenExpressVideoActivity.this.e((int) j4);
                    TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity3 = TTFullScreenExpressVideoActivity.this;
                    if (tTFullScreenExpressVideoActivity3.Q >= 0 && (topProxyLayout = tTFullScreenExpressVideoActivity3.f27016c) != null) {
                        topProxyLayout.setShowSkip(true);
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity4 = TTFullScreenExpressVideoActivity.this;
                        tTFullScreenExpressVideoActivity4.f27016c.a(String.valueOf(tTFullScreenExpressVideoActivity4.Q), (CharSequence) null);
                    }
                }
                if (TTFullScreenExpressVideoActivity.this.Q <= 0) {
                    u.b("TTFullScreenExpressVideoActivity", "onProgressUpdate、、、、、、、、");
                    if (TTFullScreenExpressVideoActivity.this.V()) {
                        TTFullScreenExpressVideoActivity.this.u();
                    } else {
                        TTFullScreenExpressVideoActivity.this.finish();
                    }
                }
                if ((TTFullScreenExpressVideoActivity.this.aa.get() || TTFullScreenExpressVideoActivity.this.Y.get()) && TTFullScreenExpressVideoActivity.this.v()) {
                    TTFullScreenExpressVideoActivity.this.D.h();
                }
            }
        });
        String i2 = this.s.X() != null ? this.s.X().i() : null;
        if (this.x != null) {
            File file = new File(this.x);
            if (file.exists() && file.length() > 0) {
                i2 = this.x;
                this.z = true;
            }
        }
        String str = i2;
        u.f("wzj", "videoUrl:" + str);
        if (this.D == null) {
            return false;
        }
        Message message = new Message();
        message.what = 300;
        message.arg1 = 0;
        this.I.sendMessageDelayed(message, 5000L);
        boolean a2 = this.D.a(str, this.s.am(), this.aV.getWidth(), this.aV.getHeight(), null, this.s.ap(), j, this.P);
        if (a2 && !z) {
            u.e("AdEvent", "pangolin ad show " + ak.a(this.s, (View) null));
            d.a(this.f27018e, this.s, "fullscreen_interstitial_ad", hashMap);
            U();
        }
        return a2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void f(boolean z) {
        TopProxyLayout topProxyLayout;
        if (this.P == z || (topProxyLayout = this.f27016c) == null) {
            return;
        }
        topProxyLayout.b();
    }

    public void a(@NonNull NativeExpressView nativeExpressView, @NonNull l lVar) {
        if (nativeExpressView == null || this.s == null) {
            return;
        }
        a a2 = a(lVar);
        this.aW = a2;
        if (a2 != null) {
            a2.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.aW.a((Activity) nativeExpressView.getContext());
            }
        }
        d.a(lVar);
        EmptyView a3 = a((ViewGroup) nativeExpressView);
        if (a3 == null) {
            a3 = new EmptyView(this.f27018e, nativeExpressView);
            nativeExpressView.addView(a3);
        }
        a aVar = this.aW;
        if (aVar != null) {
            aVar.a(a3);
        }
        a3.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                a aVar2 = TTFullScreenExpressVideoActivity.this.aW;
                if (aVar2 != null) {
                    if (z) {
                        if (aVar2 != null) {
                            aVar2.b();
                        }
                    } else if (aVar2 != null) {
                        aVar2.c();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                a aVar2 = TTFullScreenExpressVideoActivity.this.aW;
                if (aVar2 != null) {
                    aVar2.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                a aVar2 = TTFullScreenExpressVideoActivity.this.aW;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        });
        Context context = this.f27018e;
        String str = this.aX;
        e eVar = new e(context, lVar, str, ak.a(str)) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
            public void a(View view, int i2, int i3, int i4, int i5) {
                super.a(view, i2, i3, i4, i5);
                TTFullScreenExpressVideoActivity.this.a(view, i2, i3, i4, i5);
            }
        };
        eVar.a(nativeExpressView);
        eVar.a(this.aW);
        if (!TextUtils.isEmpty(this.af)) {
            HashMap hashMap = new HashMap();
            hashMap.put("rit_scene", this.af);
            eVar.a(hashMap);
        }
        this.aU.setClickListener(eVar);
        Context context2 = this.f27018e;
        String str2 = this.aX;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context2, lVar, str2, ak.a(str2)) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
            public void a(View view, int i2, int i3, int i4, int i5) {
                super.a(view, i2, i3, i4, i5);
                TTFullScreenExpressVideoActivity.this.a(view, i2, i3, i4, i5);
            }
        };
        dVar.a(nativeExpressView);
        dVar.a(this.aW);
        if (!TextUtils.isEmpty(this.af)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("rit_scene", this.af);
            dVar.a(hashMap2);
        }
        this.aU.setClickCreativeListener(dVar);
        a3.setNeedCheckingShow(false);
        a(this.aW, this.aU);
    }

    private void a(a aVar, NativeExpressView nativeExpressView) {
        if (aVar == null || nativeExpressView == null) {
            return;
        }
        l lVar = this.s;
        final String am = lVar != null ? lVar.am() : "";
        aVar.a(new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.7
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j, long j2, String str, String str2) {
                if (j > 0) {
                    int i2 = (int) ((j2 * 100) / j);
                    TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                    tTFullScreenExpressVideoActivity.c("已下载" + i2 + "%");
                    a.C0304a.a(am, 3, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j, long j2, String str, String str2) {
                TTFullScreenExpressVideoActivity.this.c("下载失败");
                if (j > 0) {
                    a.C0304a.a(am, 4, (int) ((j2 * 100) / j));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j, String str, String str2) {
                TTFullScreenExpressVideoActivity.this.c("点击安装");
                a.C0304a.a(am, 5, 100);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j, long j2, String str, String str2) {
                TTFullScreenExpressVideoActivity.this.c("下载暂停");
                if (j > 0) {
                    a.C0304a.a(am, 2, (int) ((j2 * 100) / j));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                TTFullScreenExpressVideoActivity.this.c("点击开始下载");
                a.C0304a.a(am, 1, 0);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                TTFullScreenExpressVideoActivity.this.c("点击打开");
                a.C0304a.a(am, 6, 100);
            }
        });
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(l lVar) {
        if (lVar.Z() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f27018e, lVar, this.aX);
        }
        return null;
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
