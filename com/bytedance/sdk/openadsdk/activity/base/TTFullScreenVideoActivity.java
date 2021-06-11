package com.bytedance.sdk.openadsdk.activity.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.top.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.h.a;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.u;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    public static int aU = 5;
    public static TTFullScreenVideoAd.FullScreenVideoAdInteractionListener aW;
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener aV;
    public boolean aX = false;

    private void Q() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.v = intent.getBooleanExtra("show_download_bar", true);
        this.x = intent.getStringExtra("video_cache_url");
        this.y = intent.getIntExtra("orientation", 2);
        this.af = intent.getStringExtra("rit_scene");
        this.av = intent.getBooleanExtra("is_verity_playable", false);
    }

    private void R() {
        l lVar = this.s;
        if (lVar == null) {
            u.f("TTFullScreenVideoActivity", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
            finish();
            return;
        }
        if (lVar.C() && this.s.i() == 1) {
            a(getApplicationContext());
        }
        this.at = 8;
        this.T = ak.d(this.s.ap());
        this.R = this.s.aq();
        this.K = this.s.am();
        this.L = this.s.ap();
        this.Q = (int) L();
        this.M = 5;
        this.P = p.h().b(this.T);
        this.N = 3455;
        n();
        a(this.P);
        m();
        t();
        l();
        o();
        k();
        j();
        a("fullscreen_endcard");
        S();
        b("fullscreen_interstitial_ad");
        q();
    }

    private void S() {
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.c.p pVar = TTFullScreenVideoActivity.this.aJ;
                    if (pVar != null) {
                        pVar.i();
                    }
                    TTFullScreenVideoActivity.this.Z();
                    TTFullScreenVideoActivity.this.aa();
                    TTFullScreenVideoActivity.this.finish();
                }
            });
        }
        TopProxyLayout topProxyLayout = this.f27119c;
        if (topProxyLayout != null) {
            topProxyLayout.setListener(new b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.3
                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void a(View view) {
                    if (l.d(TTFullScreenVideoActivity.this.s)) {
                        TTFullScreenVideoActivity.this.Z();
                        TTFullScreenVideoActivity.this.aa();
                        TTFullScreenVideoActivity.this.finish();
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    if (!TextUtils.isEmpty(TTFullScreenVideoActivity.this.af)) {
                        hashMap.put("rit_scene", TTFullScreenVideoActivity.this.af);
                    }
                    TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                    hashMap.put("play_type", Integer.valueOf(ak.a(tTFullScreenVideoActivity.D, tTFullScreenVideoActivity.z)));
                    TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", "feed_break", hashMap);
                    TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", FreeSpaceBox.TYPE, (Map<String, Object>) null);
                    TTFullScreenVideoActivity.this.f27119c.setShowSkip(false);
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (TTFullScreenVideoActivity.this.aV != null) {
                            TTFullScreenVideoActivity.this.aV.onSkippedVideo();
                        }
                    } else {
                        TTFullScreenVideoActivity.this.e("onSkippedVideo");
                    }
                    if (TTFullScreenVideoActivity.this.V()) {
                        TTFullScreenVideoActivity.this.I();
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void b(View view) {
                    TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                    boolean z = !tTFullScreenVideoActivity.P;
                    tTFullScreenVideoActivity.P = z;
                    c cVar = tTFullScreenVideoActivity.D;
                    if (cVar != null) {
                        cVar.c(z);
                    }
                    if (!l.e(TTFullScreenVideoActivity.this.s) || TTFullScreenVideoActivity.this.U.get()) {
                        if (l.b(TTFullScreenVideoActivity.this.s)) {
                            TTFullScreenVideoActivity tTFullScreenVideoActivity2 = TTFullScreenVideoActivity.this;
                            tTFullScreenVideoActivity2.au.a(tTFullScreenVideoActivity2.P, true);
                        }
                        TTFullScreenVideoActivity tTFullScreenVideoActivity3 = TTFullScreenVideoActivity.this;
                        tTFullScreenVideoActivity3.c(tTFullScreenVideoActivity3.P);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void c(View view) {
                    TTFullScreenVideoActivity.this.M();
                }
            });
        }
    }

    private void T() {
        TopProxyLayout topProxyLayout = this.f27119c;
        if (topProxyLayout != null) {
            topProxyLayout.a((CharSequence) null, "跳过");
            this.f27119c.setSkipEnable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        HashMap hashMap = new HashMap();
        l lVar = this.s;
        if (lVar != null && lVar.C() && this.s.i() == 1) {
            hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.ax));
        }
        d.g(this.f27121e, this.s, "fullscreen_interstitial_ad", "click_close", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        Bitmap b2;
        l lVar = this.s;
        if (lVar == null || this.f27122f == null || !lVar.C() || (b2 = al.b((WebView) this.f27122f)) == null) {
            return;
        }
        al.a(p.a(), this.s, "fullscreen_interstitial_ad", "playable_show_status", b2, false, 1);
    }

    private void d(int i2) {
        if (this.f27119c != null) {
            this.f27119c.a((CharSequence) null, new SpannableStringBuilder(i2 + "s后可跳过"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str) {
        e.b(new g("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTFullScreenVideoActivity.this.b(1).executeFullVideoCallback(TTFullScreenVideoActivity.this.u, str);
                } catch (Throwable th) {
                    u.c("TTFullScreenVideoActivity", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    public void P() {
        l lVar = this.s;
        if (lVar == null) {
            finish();
            return;
        }
        if (lVar.n() == 0) {
            setContentView(ad.f(this, "tt_activity_full_video"));
        } else if (this.s.n() == 1) {
            setContentView(ad.f(this, "tt_activity_full_video_newstyle"));
        } else if (this.s.n() == 3) {
            setContentView(ad.f(this, "tt_activity_full_video_new_bar_3_style"));
        } else {
            setContentView(ad.f(this, "tt_activity_full_video"));
        }
        u.b("report-5", "getPlayBarStyle=" + this.s.n());
    }

    public void U() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e("onAdShow");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aV;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdShow();
        }
    }

    public boolean V() {
        return p.h().j(String.valueOf(this.T)) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void W() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e("onAdVideoBarClick");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aV;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdVideoBarClick();
        }
    }

    public void X() {
        if (this.aX) {
            return;
        }
        this.aX = true;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e("onAdClose");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aV;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdClose();
        }
    }

    public void Y() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e("onVideoComplete");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aV;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoComplete();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void f(int i2) {
        if (i2 == 10002) {
            Y();
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        aW = null;
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            if (this.av && !TextUtils.isEmpty(this.O) && this.ar != 0) {
                a.a().a(this.O, this.ar, this.as);
            }
        } catch (Throwable unused) {
        }
        try {
            if (this.av && !TextUtils.isEmpty(this.O)) {
                a.a().b(this.O);
            }
        } catch (Throwable unused2) {
        }
        X();
        super.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Q();
        if (a(bundle)) {
            b();
            P();
            f();
            R();
            d();
            z();
            D();
            l lVar = this.s;
            if (lVar != null) {
                this.T = ak.d(lVar.ap());
            }
            a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        X();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e("recycleRes");
        }
        if (this.aV != null) {
            this.aV = null;
        }
        Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> map = this.J;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().d();
                }
            }
        }
        if (TextUtils.isEmpty(this.x)) {
            com.bytedance.sdk.openadsdk.component.reward.c.a(p.a()).b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> map = this.J;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().c();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> map = this.J;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().b();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        aW = this.aV;
        try {
            bundle.putString("material_meta", this.s != null ? this.s.aL().toString() : null);
            bundle.putString("multi_process_meta_md5", this.u);
            bundle.putLong("video_current", this.D == null ? this.w : this.D.n());
            bundle.putString("video_cache_url", this.x);
            bundle.putInt("orientation", this.y);
            bundle.putBoolean("is_mute", this.P);
            bundle.putString("rit_scene", this.af);
            bundle.putBoolean("has_show_skip_btn", this.W.get());
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public com.bytedance.sdk.openadsdk.c.p s() {
        return new com.bytedance.sdk.openadsdk.c.p(l.b(this.s) ? 3 : 2, "fullscreen_interstitial_ad", this.s);
    }

    public void e(int i2) {
        TopProxyLayout topProxyLayout;
        TopProxyLayout topProxyLayout2;
        int e2 = p.h().e(this.T);
        aU = e2;
        if (e2 < 0) {
            aU = 5;
        }
        if (!p.h().b(String.valueOf(this.T))) {
            if (i2 >= aU) {
                if (!this.W.getAndSet(true) && (topProxyLayout2 = this.f27119c) != null) {
                    topProxyLayout2.setShowSkip(true);
                }
                T();
                return;
            }
            TopProxyLayout topProxyLayout3 = this.f27119c;
            if (topProxyLayout3 != null) {
                topProxyLayout3.setSkipEnable(false);
                return;
            }
            return;
        }
        if (!this.W.getAndSet(true) && (topProxyLayout = this.f27119c) != null) {
            topProxyLayout.setShowSkip(true);
        }
        int i3 = aU;
        if (i2 <= i3) {
            d(i3 - i2);
            TopProxyLayout topProxyLayout4 = this.f27119c;
            if (topProxyLayout4 != null) {
                topProxyLayout4.setSkipEnable(false);
                return;
            }
            return;
        }
        T();
    }

    private boolean a(Bundle bundle) {
        l lVar;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                this.u = intent.getStringExtra("multi_process_meta_md5");
                if (stringExtra != null) {
                    try {
                        this.s = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra));
                    } catch (Exception e2) {
                        u.c("TTFullScreenVideoActivity", "initData MultiGlobalInfo throws ", e2);
                    }
                }
            }
            l lVar2 = this.s;
            if (lVar2 != null && lVar2.Z() == 4) {
                this.E = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f27121e, this.s, "fullscreen_interstitial_ad");
            }
        } else {
            this.s = com.bytedance.sdk.openadsdk.core.u.a().c();
            this.aV = com.bytedance.sdk.openadsdk.core.u.a().e();
            this.E = com.bytedance.sdk.openadsdk.core.u.a().f();
            com.bytedance.sdk.openadsdk.core.u.a().g();
        }
        if (bundle != null) {
            if (this.aV == null) {
                this.aV = aW;
                aW = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.u = bundle.getString("multi_process_meta_md5");
                this.x = bundle.getString("video_cache_url");
                this.y = bundle.getInt("orientation", 2);
                this.P = bundle.getBoolean("is_mute");
                this.af = bundle.getString("rit_scene");
                this.s = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(string));
                this.W.set(bundle.getBoolean("has_show_skip_btn"));
                if (this.W.get()) {
                    if (this.f27119c != null) {
                        this.f27119c.setShowSkip(true);
                    }
                    T();
                }
            } catch (Throwable unused) {
            }
            if (this.E == null && (lVar = this.s) != null && lVar.Z() == 4) {
                this.E = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f27121e, this.s, "fullscreen_interstitial_ad");
            }
        }
        com.bytedance.sdk.openadsdk.core.e.a().a(this.s);
        l lVar3 = this.s;
        if (lVar3 == null) {
            u.f("TTFullScreenVideoActivity", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
            finish();
            return false;
        }
        this.ag = lVar3.n() == 1;
        this.ah = this.s.n() == 3;
        l lVar4 = this.s;
        if (lVar4 != null) {
            lVar4.X();
        }
        return true;
    }

    public boolean a(long j, boolean z) {
        HashMap hashMap;
        if (this.D == null) {
            this.D = new com.bytedance.sdk.openadsdk.component.reward.b(this.f27121e, this.o, this.s);
        }
        if (TextUtils.isEmpty(this.af)) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            hashMap.put("rit_scene", this.af);
        }
        this.D.a(hashMap);
        this.D.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, int i2) {
                am amVar = TTFullScreenVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                    TTFullScreenVideoActivity.this.N();
                }
                TTFullScreenVideoActivity.this.Y();
                if (TTFullScreenVideoActivity.this.V()) {
                    TTFullScreenVideoActivity.this.u();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i2) {
                am amVar = TTFullScreenVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                }
                TTFullScreenVideoActivity.this.e(false);
                if (TTFullScreenVideoActivity.this.v()) {
                    return;
                }
                TTFullScreenVideoActivity.this.N();
                c cVar = TTFullScreenVideoActivity.this.D;
                if (cVar != null) {
                    cVar.m();
                }
                u.f("TTFullScreenVideoActivity", "onError、、、、、、、、");
                if (TTFullScreenVideoActivity.this.V()) {
                    TTFullScreenVideoActivity.this.u();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("vbtt_skip_type", 1);
                    TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", hashMap2);
                    return;
                }
                TTFullScreenVideoActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                am amVar = TTFullScreenVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                    TTFullScreenVideoActivity.this.N();
                }
                u.b("TTFullScreenVideoActivity", "onTimeOut、、、、、、、、");
                if (TTFullScreenVideoActivity.this.V()) {
                    TTFullScreenVideoActivity.this.u();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 0);
                TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", hashMap2);
                c cVar = TTFullScreenVideoActivity.this.D;
                if (cVar != null) {
                    cVar.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                TopProxyLayout topProxyLayout;
                am amVar = TTFullScreenVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                    TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                    if (j2 != tTFullScreenVideoActivity.aL) {
                        tTFullScreenVideoActivity.N();
                    }
                }
                TTFullScreenVideoActivity tTFullScreenVideoActivity2 = TTFullScreenVideoActivity.this;
                tTFullScreenVideoActivity2.aL = j2;
                long j4 = j2 / 1000;
                tTFullScreenVideoActivity2.Q = (int) (tTFullScreenVideoActivity2.L() - j4);
                TTFullScreenVideoActivity.this.e((int) j4);
                TTFullScreenVideoActivity tTFullScreenVideoActivity3 = TTFullScreenVideoActivity.this;
                if (tTFullScreenVideoActivity3.Q >= 0 && (topProxyLayout = tTFullScreenVideoActivity3.f27119c) != null) {
                    topProxyLayout.setShowCountDown(true);
                    TTFullScreenVideoActivity tTFullScreenVideoActivity4 = TTFullScreenVideoActivity.this;
                    tTFullScreenVideoActivity4.f27119c.a(String.valueOf(tTFullScreenVideoActivity4.Q), (CharSequence) null);
                }
                if (TTFullScreenVideoActivity.this.Q <= 0) {
                    u.b("TTFullScreenVideoActivity", "onProgressUpdate、、、、、、、、");
                    if (TTFullScreenVideoActivity.this.V()) {
                        TTFullScreenVideoActivity.this.u();
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }
                if ((TTFullScreenVideoActivity.this.aa.get() || TTFullScreenVideoActivity.this.Y.get()) && TTFullScreenVideoActivity.this.v()) {
                    TTFullScreenVideoActivity.this.D.h();
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
        boolean a2 = this.D.a(str, this.s.am(), this.o.getWidth(), this.o.getHeight(), null, this.s.ap(), j, this.P);
        if (a2 && !z) {
            u.e("AdEvent", "pangolin ad show " + ak.a(this.s, (View) null));
            d.a(this.f27121e, this.s, "fullscreen_interstitial_ad", hashMap);
            U();
        }
        return a2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void a(View view, int i2, int i3, int i4, int i5) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e("onAdVideoBarClick");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aV;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdVideoBarClick();
        }
    }
}
