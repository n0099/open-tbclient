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
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.f;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TTRewardExpressVideoActivity extends TTRewardVideoActivity implements TTNativeExpressAd.ExpressAdInteractionListener, g {
    FullRewardExpressView aR;
    FrameLayout aS;
    long aT;
    a aU;
    Handler aW;
    String aV = "rewarded_video";
    boolean aX = false;
    boolean aY = false;
    private boolean bd = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity
    public void L() {
        if (this.s == null) {
            finish();
            return;
        }
        this.aG = false;
        super.L();
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
        if (l.b(this.s)) {
            this.aG = true;
            this.T = aj.d(this.s.W());
            h();
            t();
            return;
        }
        d(true);
    }

    private void V() {
        if (!this.bd) {
            this.bd = true;
            View decorView = getWindow().getDecorView();
            float[] fArr = {ak.b(getApplicationContext(), decorView.getWidth()), ak.b(getApplicationContext(), decorView.getHeight())};
            if (fArr[0] < 10.0f || fArr[1] < 10.0f) {
                u.b("TTRewardExpressVideoActivity", "get root view size error, so run backup");
                fArr = TTBaseVideoActivity.a(this.s, this, this.aK);
            }
            a(fArr);
        }
    }

    private void a(float[] fArr) {
        this.aR = new FullRewardExpressView(this, this.s, new AdSlot.Builder().setCodeId(String.valueOf(aj.d(this.s.W()))).setExpressViewAcceptedSize(fArr[0], fArr[1]).build(), this.aV);
        this.aR.setExpressVideoListenerProxy(this);
        this.aR.setExpressInteractionListener(this);
        a(this.aR, this.s);
        this.aS = this.aR.getVideoFrameLayout();
        this.o.addView(this.aR, new FrameLayout.LayoutParams(-1, -1));
        this.aR.h();
        if (!this.aR.m()) {
            f(false);
        }
        this.aR.i();
    }

    private void f(boolean z) {
        if (this.c != null) {
            if (this.s.t()) {
                if (!this.U.get()) {
                    this.c.setShowSound(z);
                    if (this.s.ak()) {
                        this.c.setShowDislike(z);
                    } else {
                        this.c.setShowDislike(false);
                    }
                }
            } else if (!this.U.get()) {
                this.c.setShowSkip(z);
                this.c.setShowSound(z);
                if (this.s.ak()) {
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

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.video.b.b
    public boolean a(long j, boolean z) {
        boolean z2 = false;
        this.aS = this.aR.getVideoFrameLayout();
        if (this.D == null) {
            this.D = new f(this.e, this.aS, this.s);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dynamic_show_type", Integer.valueOf(this.aR.m() ? 1 : 0));
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        this.D.a(hashMap);
        this.D.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, int i) {
                if (TTRewardExpressVideoActivity.this.I != null) {
                    TTRewardExpressVideoActivity.this.I.removeMessages(300);
                }
                TTRewardExpressVideoActivity.this.aY = true;
                TTRewardExpressVideoActivity.this.U();
                TTRewardExpressVideoActivity.this.t();
                TTRewardExpressVideoActivity.this.ba = (int) (System.currentTimeMillis() / 1000);
                TTRewardExpressVideoActivity.this.R();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i) {
                if (TTRewardExpressVideoActivity.this.I != null) {
                    TTRewardExpressVideoActivity.this.I.removeMessages(300);
                }
                if (b.b()) {
                    TTRewardExpressVideoActivity.this.d("onVideoError");
                } else if (TTRewardExpressVideoActivity.this.bb != null) {
                    TTRewardExpressVideoActivity.this.bb.onVideoError();
                }
                if (!TTRewardExpressVideoActivity.this.u()) {
                    if (TTRewardExpressVideoActivity.this.D != null) {
                        TTRewardExpressVideoActivity.this.D.l();
                    }
                    TTRewardExpressVideoActivity.this.t();
                    TTRewardExpressVideoActivity.this.aX = true;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("vbtt_skip_type", 1);
                    TTRewardExpressVideoActivity.this.a("rewarded_video", hashMap2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                if (TTRewardExpressVideoActivity.this.I != null) {
                    TTRewardExpressVideoActivity.this.I.removeMessages(300);
                }
                TTRewardExpressVideoActivity.this.t();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 0);
                TTRewardExpressVideoActivity.this.a("rewarded_video", hashMap2);
                if (TTRewardExpressVideoActivity.this.D != null) {
                    TTRewardExpressVideoActivity.this.D.l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                if (TTRewardExpressVideoActivity.this.I != null) {
                    TTRewardExpressVideoActivity.this.I.removeMessages(300);
                }
                TTRewardExpressVideoActivity.this.aT = j2;
                int i = p.h().r(String.valueOf(TTRewardExpressVideoActivity.this.T)).g;
                if (j3 > 0 && ((float) (100 * j2)) / Float.valueOf((float) j3).floatValue() >= i) {
                    TTRewardExpressVideoActivity.this.R();
                }
                TTRewardExpressVideoActivity.this.Q = (int) (TTRewardExpressVideoActivity.this.J() - (j2 / 1000));
                if (TTRewardExpressVideoActivity.this.Q >= 0 && TTRewardExpressVideoActivity.this.c != null) {
                    TTRewardExpressVideoActivity.this.c.a(String.valueOf(TTRewardExpressVideoActivity.this.Q), (CharSequence) null);
                }
                int i2 = (int) (j2 / 1000);
                if (TTRewardExpressVideoActivity.this.S != -1 && i2 == TTRewardExpressVideoActivity.this.S && !TTRewardExpressVideoActivity.this.bc.get()) {
                    TTRewardExpressVideoActivity.this.d.setVisibility(0);
                    TTRewardExpressVideoActivity.this.bc.set(true);
                    TTRewardExpressVideoActivity.this.q();
                }
                int g = p.h().g(String.valueOf(TTRewardExpressVideoActivity.this.T));
                if ((TTRewardExpressVideoActivity.this.aR.m() && g != -1 && g >= 0) && i2 >= g) {
                    if (!TTRewardExpressVideoActivity.this.W.getAndSet(true) && TTRewardExpressVideoActivity.this.c != null) {
                        TTRewardExpressVideoActivity.this.c.setShowSkip(true);
                    }
                    if (TTRewardExpressVideoActivity.this.c != null) {
                        TTRewardExpressVideoActivity.this.c.a((CharSequence) null, "跳过");
                        TTRewardExpressVideoActivity.this.c.setSkipEnable(true);
                    }
                }
                if (TTRewardExpressVideoActivity.this.Q <= 0) {
                    TTRewardExpressVideoActivity.this.t();
                }
                if (TTRewardExpressVideoActivity.this.aa.get() && TTRewardExpressVideoActivity.this.D != null && TTRewardExpressVideoActivity.this.D.t() != null && TTRewardExpressVideoActivity.this.D.t().g()) {
                    TTRewardExpressVideoActivity.this.D.h();
                }
            }
        });
        String h = this.s.F() != null ? this.s.F().h() : null;
        if (this.x != null) {
            File file = new File(this.x);
            if (file.exists() && file.length() > 0) {
                h = this.x;
                this.z = true;
            }
        }
        String str = h;
        u.f("wzj", "videoUrl:" + str);
        if (this.D != null) {
            Message message = new Message();
            message.what = 300;
            message.arg1 = 1;
            this.I.sendMessageDelayed(message, 5000L);
            z2 = this.D.a(str, this.s.T(), this.aS.getWidth(), this.aS.getHeight(), null, this.s.W(), j, this.P);
            if (z2 && !z) {
                d.a(this.e, this.s, "rewarded_video", hashMap);
                Q();
                this.aZ = (int) (System.currentTimeMillis() / 1000);
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void b(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void e(boolean z) {
        if (this.P != z && this.c != null) {
            this.c.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void M() {
        if (this.c != null) {
            this.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        V();
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
                    u.f("TTRewardExpressVideoActivity", "onPause throw Exception :" + th.getMessage());
                    return;
                }
            case 3:
                try {
                    if (v()) {
                        this.D.j();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    u.f("TTRewardExpressVideoActivity", "onPause throw Exception :" + th2.getMessage());
                    return;
                }
            case 4:
                if (this.D != null) {
                    this.D.k();
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
    public long N() {
        u.f("TTRewardExpressVideoActivity", "onGetCurrentPlayTime mVideoCurrent:" + this.aT);
        return this.aT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int O() {
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
    public void P() {
        K();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.video.b.b
    public void Q() {
        super.Q();
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
        this.aW.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                TTRewardExpressVideoActivity.this.t();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        if (this.s.c() != 1 || !this.s.s()) {
            if (this.aR.m()) {
                f(true);
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
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aW != null) {
            this.aW.removeCallbacksAndMessages(null);
        }
        if (this.aR != null) {
            this.aR.k();
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
            emptyView.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.3
                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    if (TTRewardExpressVideoActivity.this.aU != null) {
                        if (z) {
                            if (TTRewardExpressVideoActivity.this.aU != null) {
                                TTRewardExpressVideoActivity.this.aU.b();
                            }
                        } else if (TTRewardExpressVideoActivity.this.aU != null) {
                            TTRewardExpressVideoActivity.this.aU.c();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    if (TTRewardExpressVideoActivity.this.aU != null) {
                        TTRewardExpressVideoActivity.this.aU.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    if (TTRewardExpressVideoActivity.this.aU != null) {
                        TTRewardExpressVideoActivity.this.aU.d();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(View view) {
                }
            });
            e eVar = new e(this.e, lVar, this.aV, aj.a(this.aV)) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.4
                @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
                public void a(View view, int i, int i2, int i3, int i4) {
                    super.a(view, i, i2, i3, i4);
                    TTRewardExpressVideoActivity.this.a(view, i, i2, i3, i4);
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
            com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.e, lVar, this.aV, aj.a(this.aV)) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
                public void a(View view, int i, int i2, int i3, int i4) {
                    super.a(view, i, i2, i3, i4);
                    TTRewardExpressVideoActivity.this.a(view, i, i2, i3, i4);
                }
            };
            dVar.a(nativeExpressView);
            if (!TextUtils.isEmpty(this.af)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("rit_scene", this.af);
                dVar.a(hashMap2);
            }
            dVar.a(this.aU);
            this.aR.setClickCreativeListener(dVar);
            emptyView.setNeedCheckingShow(false);
        }
    }

    private a a(l lVar) {
        if (lVar.H() == 4) {
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
