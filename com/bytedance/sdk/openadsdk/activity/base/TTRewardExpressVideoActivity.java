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
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.e.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class TTRewardExpressVideoActivity extends TTRewardVideoActivity implements TTNativeExpressAd.ExpressAdInteractionListener, g {
    public FullRewardExpressView aU;
    public FrameLayout aV;
    public long aW;
    public a aX;
    public Handler aZ;
    public String aY = "rewarded_video";
    public boolean ba = false;
    public boolean bb = false;
    public boolean bg = false;

    private void Z() {
        if (this.bg) {
            return;
        }
        this.bg = true;
        final View decorView = getWindow().getDecorView();
        decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z = TTRewardExpressVideoActivity.this.s.aq() == 15;
                float[] fArr = {al.b(TTRewardExpressVideoActivity.this.getApplicationContext(), decorView.getWidth()), al.b(TTRewardExpressVideoActivity.this.getApplicationContext(), decorView.getHeight())};
                float max = Math.max(fArr[0], fArr[1]);
                float min = Math.min(fArr[0], fArr[1]);
                fArr[0] = z ? min : max;
                if (!z) {
                    max = min;
                }
                fArr[1] = max;
                if (fArr[0] < 10.0f || fArr[1] < 10.0f) {
                    u.b("TTRewardExpressVideoActivity", "get root view size error, so run backup");
                    TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                    fArr = TTBaseVideoActivity.a(z, tTRewardExpressVideoActivity, tTRewardExpressVideoActivity.aK);
                }
                TTRewardExpressVideoActivity.this.a(fArr);
            }
        });
    }

    private void g(boolean z) {
        if (this.f27014c != null) {
            if (this.s.D()) {
                if (!this.U.get()) {
                    this.f27014c.setShowSound(z);
                    if (this.s.aJ()) {
                        this.f27014c.setShowDislike(z);
                    } else {
                        this.f27014c.setShowDislike(false);
                    }
                }
            } else if (!this.U.get()) {
                this.f27014c.setShowSkip(z);
                this.f27014c.setShowSound(z);
                if (this.s.aJ()) {
                    this.f27014c.setShowDislike(z);
                } else {
                    this.f27014c.setShowDislike(false);
                }
            }
        }
        if (z) {
            al.a((View) this.f27015d, 0);
            al.a((View) this.aw, 0);
            return;
        }
        al.a((View) this.f27015d, 4);
        al.a((View) this.aw, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity
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
        TopProxyLayout topProxyLayout = this.f27014c;
        if (topProxyLayout != null) {
            topProxyLayout.a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long R() {
        u.f("TTRewardExpressVideoActivity", "onGetCurrentPlayTime mVideoCurrent:" + this.aW);
        return this.aW;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int S() {
        if (this.ba) {
            return 4;
        }
        if (this.bb) {
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

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.video.c.b
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
    public void d(int i) {
        if (i == 1) {
            if (v() || w()) {
                return;
            }
            a(0L, false);
        } else if (i == 2) {
            try {
                if (v()) {
                    this.aN = true;
                    this.D.h();
                }
            } catch (Throwable th) {
                u.f("TTRewardExpressVideoActivity", "onPause throw Exception :" + th.getMessage());
            }
        } else if (i != 3) {
            if (i != 4) {
                if (i != 5 || v() || w()) {
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
                u.f("TTRewardExpressVideoActivity", "onContinue throw Exception :" + th2.getMessage());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void f() {
        super.f();
        if (this.aZ == null) {
            this.aZ = new Handler(Looper.getMainLooper());
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
    public void onAdClicked(View view, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        FullRewardExpressView fullRewardExpressView = this.aU;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.k();
        }
        super.onDestroy();
        Handler handler = this.aZ;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        this.aG = true;
        i();
        if (this.aZ == null) {
            this.aZ = new Handler(Looper.getMainLooper());
        }
        this.aZ.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                TTRewardExpressVideoActivity.this.u();
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
        a(this.aY, hashMap);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
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
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this, this.s, new AdSlot.Builder().setCodeId(String.valueOf(ak.d(this.s.ap()))).setExpressViewAcceptedSize(fArr[0], fArr[1]).build(), this.aY);
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

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.video.c.b
    public boolean a(long j, boolean z) {
        FrameLayout videoFrameLayout = this.aU.getVideoFrameLayout();
        this.aV = videoFrameLayout;
        if (this.D == null) {
            this.D = new com.bytedance.sdk.openadsdk.component.reward.g(this.f27016e, videoFrameLayout, this.s);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dynamic_show_type", Integer.valueOf(this.aU.m() ? 1 : 0));
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        this.D.a(hashMap);
        this.D.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, int i) {
                am amVar = TTRewardExpressVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                    TTRewardExpressVideoActivity.this.N();
                }
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                tTRewardExpressVideoActivity.bb = true;
                tTRewardExpressVideoActivity.Y();
                TTRewardExpressVideoActivity.this.u();
                ((TTRewardVideoActivity) TTRewardExpressVideoActivity.this).bd = (int) (System.currentTimeMillis() / 1000);
                TTRewardExpressVideoActivity.this.V();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i) {
                am amVar = TTRewardExpressVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                }
                if (b.b()) {
                    TTRewardExpressVideoActivity.this.e("onVideoError");
                } else {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = ((TTRewardVideoActivity) TTRewardExpressVideoActivity.this).be;
                    if (rewardAdInteractionListener != null) {
                        rewardAdInteractionListener.onVideoError();
                    }
                }
                TTRewardExpressVideoActivity.this.e(true);
                if (TTRewardExpressVideoActivity.this.v()) {
                    return;
                }
                TTRewardExpressVideoActivity.this.N();
                c cVar = TTRewardExpressVideoActivity.this.D;
                if (cVar != null) {
                    cVar.m();
                }
                TTRewardExpressVideoActivity.this.V();
                TTRewardExpressVideoActivity.this.u();
                TTRewardExpressVideoActivity.this.ba = true;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 1);
                TTRewardExpressVideoActivity.this.a("rewarded_video", hashMap2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                am amVar = TTRewardExpressVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                    TTRewardExpressVideoActivity.this.N();
                }
                TTRewardExpressVideoActivity.this.u();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 0);
                TTRewardExpressVideoActivity.this.a("rewarded_video", hashMap2);
                c cVar = TTRewardExpressVideoActivity.this.D;
                if (cVar != null) {
                    cVar.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                c cVar;
                TopProxyLayout topProxyLayout;
                TopProxyLayout topProxyLayout2;
                am amVar = TTRewardExpressVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                    TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                    if (j2 != tTRewardExpressVideoActivity.aW) {
                        tTRewardExpressVideoActivity.N();
                    }
                }
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity2 = TTRewardExpressVideoActivity.this;
                tTRewardExpressVideoActivity2.aW = j2;
                tTRewardExpressVideoActivity2.a(j2, j3);
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity3 = TTRewardExpressVideoActivity.this;
                long j4 = j2 / 1000;
                tTRewardExpressVideoActivity3.Q = (int) (tTRewardExpressVideoActivity3.L() - j4);
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity4 = TTRewardExpressVideoActivity.this;
                int i = tTRewardExpressVideoActivity4.Q;
                if (i >= 0 && (topProxyLayout2 = tTRewardExpressVideoActivity4.f27014c) != null) {
                    topProxyLayout2.a(String.valueOf(i), (CharSequence) null);
                }
                int i2 = (int) j4;
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity5 = TTRewardExpressVideoActivity.this;
                int i3 = tTRewardExpressVideoActivity5.S;
                boolean z2 = false;
                if (i3 != -1 && i2 == i3 && !((TTRewardVideoActivity) tTRewardExpressVideoActivity5).bf.get()) {
                    TTRewardExpressVideoActivity.this.f27015d.setVisibility(0);
                    ((TTRewardVideoActivity) TTRewardExpressVideoActivity.this).bf.set(true);
                    TTRewardExpressVideoActivity.this.r();
                }
                int g2 = p.h().g(String.valueOf(TTRewardExpressVideoActivity.this.T));
                if (TTRewardExpressVideoActivity.this.aU.m() && g2 != -1 && g2 >= 0) {
                    z2 = true;
                }
                if (z2 && i2 >= g2) {
                    if (!TTRewardExpressVideoActivity.this.W.getAndSet(true) && (topProxyLayout = TTRewardExpressVideoActivity.this.f27014c) != null) {
                        topProxyLayout.setShowSkip(true);
                    }
                    TopProxyLayout topProxyLayout3 = TTRewardExpressVideoActivity.this.f27014c;
                    if (topProxyLayout3 != null) {
                        topProxyLayout3.a((CharSequence) null, "跳过");
                        TTRewardExpressVideoActivity.this.f27014c.setSkipEnable(true);
                    }
                }
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity6 = TTRewardExpressVideoActivity.this;
                if (tTRewardExpressVideoActivity6.Q <= 0) {
                    tTRewardExpressVideoActivity6.u();
                }
                if (!TTRewardExpressVideoActivity.this.aa.get() || (cVar = TTRewardExpressVideoActivity.this.D) == null || cVar.u() == null || !TTRewardExpressVideoActivity.this.D.u().g()) {
                    return;
                }
                TTRewardExpressVideoActivity.this.D.h();
            }
        });
        String i = this.s.X() != null ? this.s.X().i() : null;
        if (this.x != null) {
            File file = new File(this.x);
            if (file.exists() && file.length() > 0) {
                i = this.x;
                this.z = true;
            }
        }
        String str = i;
        u.f("wzj", "videoUrl:" + str);
        if (this.D == null) {
            return false;
        }
        Message message = new Message();
        message.what = 300;
        message.arg1 = 1;
        this.I.sendMessageDelayed(message, 5000L);
        boolean a2 = this.D.a(str, this.s.am(), this.aV.getWidth(), this.aV.getHeight(), null, this.s.ap(), j, this.P);
        if (a2 && !z) {
            u.e("AdEvent", "pangolin ad show " + ak.a(this.s, (View) null));
            d.a(this.f27016e, this.s, "rewarded_video", hashMap);
            U();
            ((TTRewardVideoActivity) this).bc = (int) (System.currentTimeMillis() / 1000);
        }
        return a2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void f(boolean z) {
        TopProxyLayout topProxyLayout;
        if (this.P == z || (topProxyLayout = this.f27014c) == null) {
            return;
        }
        topProxyLayout.b();
    }

    public void a(@NonNull NativeExpressView nativeExpressView, @NonNull l lVar) {
        if (nativeExpressView == null || this.s == null) {
            return;
        }
        a a2 = a(lVar);
        this.aX = a2;
        if (a2 != null) {
            a2.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.aX.a((Activity) nativeExpressView.getContext());
            }
        }
        d.a(lVar);
        EmptyView a3 = a((ViewGroup) nativeExpressView);
        if (a3 == null) {
            a3 = new EmptyView(this.f27016e, nativeExpressView);
            nativeExpressView.addView(a3);
        }
        a aVar = this.aX;
        if (aVar != null) {
            aVar.a(a3);
        }
        a3.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                a aVar2 = TTRewardExpressVideoActivity.this.aX;
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
                a aVar2 = TTRewardExpressVideoActivity.this.aX;
                if (aVar2 != null) {
                    aVar2.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                a aVar2 = TTRewardExpressVideoActivity.this.aX;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        });
        Context context = this.f27016e;
        String str = this.aY;
        e eVar = new e(context, lVar, str, ak.a(str)) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
            public void a(View view, int i, int i2, int i3, int i4) {
                super.a(view, i, i2, i3, i4);
                TTRewardExpressVideoActivity.this.a(view, i, i2, i3, i4);
            }
        };
        eVar.a(nativeExpressView);
        eVar.a(this.aX);
        if (!TextUtils.isEmpty(this.af)) {
            HashMap hashMap = new HashMap();
            hashMap.put("rit_scene", this.af);
            eVar.a(hashMap);
        }
        this.aU.setClickListener(eVar);
        Context context2 = this.f27016e;
        String str2 = this.aY;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context2, lVar, str2, ak.a(str2)) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.6
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
        dVar.a(this.aX);
        this.aU.setClickCreativeListener(dVar);
        a3.setNeedCheckingShow(false);
        a(this.aX, this.aU);
    }

    private a a(l lVar) {
        if (lVar.Z() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f27016e, lVar, this.aY);
        }
        return null;
    }

    private void a(a aVar, NativeExpressView nativeExpressView) {
        if (aVar == null || nativeExpressView == null) {
            return;
        }
        l lVar = this.s;
        final String am = lVar != null ? lVar.am() : "";
        aVar.a(new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.7
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j, long j2, String str, String str2) {
                if (j > 0) {
                    int i = (int) ((j2 * 100) / j);
                    a.C0321a.a(am, 3, i);
                    TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                    tTRewardExpressVideoActivity.c("已下载" + i + "%");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j, long j2, String str, String str2) {
                TTRewardExpressVideoActivity.this.c("下载失败");
                if (j > 0) {
                    a.C0321a.a(am, 4, (int) ((j2 * 100) / j));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j, String str, String str2) {
                TTRewardExpressVideoActivity.this.c("点击安装");
                a.C0321a.a(am, 5, 100);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j, long j2, String str, String str2) {
                TTRewardExpressVideoActivity.this.c("下载暂停");
                if (j > 0) {
                    a.C0321a.a(am, 2, (int) ((j2 * 100) / j));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                a.C0321a.a(am, 1, 0);
                TTRewardExpressVideoActivity.this.c("点击开始下载");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                TTRewardExpressVideoActivity.this.c("点击打开");
                a.C0321a.a(am, 6, 100);
            }
        });
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
