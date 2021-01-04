package com.bytedance.sdk.openadsdk.activity.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.k.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    private static int aR = 5;
    private static TTFullScreenVideoAd.FullScreenVideoAdInteractionListener aT;
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener aS;
    private boolean aU = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        M();
        if (a(bundle)) {
            b();
            L();
            f();
            N();
            d();
            x();
            B();
            if (this.s != null) {
                this.T = aj.d(this.s.W());
            }
            a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    p r() {
        return new p(l.a(this.s) ? 3 : 2, "fullscreen_interstitial_ad", this.s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L() {
        if (this.s == null) {
            finish();
            return;
        }
        if (this.s.h() == 0) {
            setContentView(ac.f(this, "tt_activity_full_video"));
        } else if (this.s.h() == 1) {
            setContentView(ac.f(this, "tt_activity_full_video_newstyle"));
        } else if (this.s.h() == 3) {
            setContentView(ac.f(this, "tt_activity_full_video_new_bar_3_style"));
        } else {
            setContentView(ac.f(this, "tt_activity_full_video"));
        }
        u.b("report-5", "getPlayBarStyle=" + this.s.h());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        aT = this.aS;
        try {
            bundle.putString("material_meta", this.s != null ? this.s.am().toString() : null);
            bundle.putString("multi_process_meta_md5", this.u);
            bundle.putLong("video_current", this.D == null ? this.w : this.D.m());
            bundle.putString("video_cache_url", this.x);
            bundle.putInt("orientation", this.y);
            bundle.putBoolean("is_mute", this.P);
            bundle.putString("rit_scene", this.af);
            bundle.putBoolean("has_show_skip_btn", this.W.get());
        } catch (Throwable th) {
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.1
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

    private void M() {
        Intent intent = getIntent();
        if (intent != null) {
            this.v = intent.getBooleanExtra("show_download_bar", true);
            this.x = intent.getStringExtra("video_cache_url");
            this.y = intent.getIntExtra("orientation", 2);
            this.af = intent.getStringExtra("rit_scene");
            this.av = intent.getBooleanExtra("is_verity_playable", false);
        }
    }

    private boolean a(Bundle bundle) {
        if (b.b()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                this.u = intent.getStringExtra("multi_process_meta_md5");
                if (stringExtra != null) {
                    try {
                        this.s = c.a(new JSONObject(stringExtra));
                    } catch (Exception e) {
                        u.c("TTFullScreenVideoActivity", "initData MultiGlobalInfo throws ", e);
                    }
                }
            }
            if (this.s != null && this.s.H() == 4) {
                this.E = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.e, this.s, "fullscreen_interstitial_ad");
            }
        } else {
            this.s = com.bytedance.sdk.openadsdk.core.u.a().c();
            this.aS = com.bytedance.sdk.openadsdk.core.u.a().e();
            this.E = com.bytedance.sdk.openadsdk.core.u.a().f();
            com.bytedance.sdk.openadsdk.core.u.a().g();
        }
        if (bundle != null) {
            if (this.aS == null) {
                this.aS = aT;
                aT = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.u = bundle.getString("multi_process_meta_md5");
                this.x = bundle.getString("video_cache_url");
                this.y = bundle.getInt("orientation", 2);
                this.P = bundle.getBoolean("is_mute");
                this.af = bundle.getString("rit_scene");
                this.s = c.a(new JSONObject(string));
                this.W.set(bundle.getBoolean("has_show_skip_btn"));
                if (this.W.get()) {
                    if (this.c != null) {
                        this.c.setShowSkip(true);
                    }
                    P();
                }
            } catch (Throwable th) {
            }
            if (this.E == null && this.s != null && this.s.H() == 4) {
                this.E = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.e, this.s, "fullscreen_interstitial_ad");
            }
        }
        e.a().a(this.s);
        if (this.s == null) {
            u.f("TTFullScreenVideoActivity", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
            finish();
            return false;
        }
        this.ag = this.s.h() == 1;
        this.ah = this.s.h() == 3;
        if (this.s == null || this.s.F() != null) {
        }
        return true;
    }

    private void N() {
        if (this.s == null) {
            u.f("TTFullScreenVideoActivity", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
            finish();
            return;
        }
        if (this.s.s() && this.s.c() == 1) {
            a(getApplicationContext());
        }
        this.at = 8;
        this.T = aj.d(this.s.W());
        this.R = this.s.X();
        this.K = this.s.T();
        this.L = this.s.W();
        this.Q = (int) J();
        this.M = 5;
        this.P = com.bytedance.sdk.openadsdk.core.p.h().b(this.T);
        this.N = 3251;
        m();
        a(this.P);
        l();
        s();
        k();
        n();
        j();
        i();
        a("fullscreen_endcard");
        O();
        b("fullscreen_interstitial_ad");
        p();
    }

    private void O() {
        if (this.j != null) {
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTFullScreenVideoActivity.this.aJ != null) {
                        TTFullScreenVideoActivity.this.aJ.i();
                    }
                    TTFullScreenVideoActivity.this.V();
                    TTFullScreenVideoActivity.this.W();
                    TTFullScreenVideoActivity.this.finish();
                }
            });
        }
        if (this.c != null) {
            this.c.setListener(new com.bytedance.sdk.openadsdk.component.reward.top.b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.3
                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void a(View view) {
                    l lVar = TTFullScreenVideoActivity.this.s;
                    if (l.b(TTFullScreenVideoActivity.this.s)) {
                        TTFullScreenVideoActivity.this.V();
                        TTFullScreenVideoActivity.this.W();
                        TTFullScreenVideoActivity.this.finish();
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    if (!TextUtils.isEmpty(TTFullScreenVideoActivity.this.af)) {
                        hashMap.put("rit_scene", TTFullScreenVideoActivity.this.af);
                    }
                    hashMap.put("play_type", Integer.valueOf(aj.a(TTFullScreenVideoActivity.this.D, TTFullScreenVideoActivity.this.z)));
                    TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", "feed_break", hashMap);
                    TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", FreeSpaceBox.TYPE, (Map<String, Object>) null);
                    TTFullScreenVideoActivity.this.c.setShowSkip(false);
                    if (b.b()) {
                        TTFullScreenVideoActivity.this.d("onSkippedVideo");
                    } else if (TTFullScreenVideoActivity.this.aS != null) {
                        TTFullScreenVideoActivity.this.aS.onSkippedVideo();
                    }
                    if (TTFullScreenVideoActivity.this.R()) {
                        TTFullScreenVideoActivity.this.G();
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void b(View view) {
                    TTFullScreenVideoActivity.this.P = !TTFullScreenVideoActivity.this.P;
                    if (TTFullScreenVideoActivity.this.D != null) {
                        TTFullScreenVideoActivity.this.D.c(TTFullScreenVideoActivity.this.P);
                    }
                    if (l.a(TTFullScreenVideoActivity.this.s)) {
                        TTFullScreenVideoActivity.this.au.a(TTFullScreenVideoActivity.this.P, true);
                    }
                    TTFullScreenVideoActivity.this.c(TTFullScreenVideoActivity.this.P);
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void c(View view) {
                    TTFullScreenVideoActivity.this.K();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean R() {
        return com.bytedance.sdk.openadsdk.core.p.h().j(String.valueOf(this.T)) == 2;
    }

    public boolean a(long j, boolean z) {
        HashMap hashMap;
        if (this.D == null) {
            this.D = new com.bytedance.sdk.openadsdk.component.reward.b(this.e, this.o, this.s);
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
            public void a(long j2, int i) {
                if (TTFullScreenVideoActivity.this.I != null) {
                    TTFullScreenVideoActivity.this.I.removeMessages(300);
                }
                TTFullScreenVideoActivity.this.U();
                if (TTFullScreenVideoActivity.this.R()) {
                    TTFullScreenVideoActivity.this.t();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i) {
                if (TTFullScreenVideoActivity.this.I != null) {
                    TTFullScreenVideoActivity.this.I.removeMessages(300);
                }
                if (!TTFullScreenVideoActivity.this.u()) {
                    if (TTFullScreenVideoActivity.this.D != null) {
                        TTFullScreenVideoActivity.this.D.l();
                    }
                    u.f("TTFullScreenVideoActivity", "onError、、、、、、、、");
                    if (TTFullScreenVideoActivity.this.R()) {
                        TTFullScreenVideoActivity.this.t();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("vbtt_skip_type", 1);
                        TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", hashMap2);
                        return;
                    }
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                if (TTFullScreenVideoActivity.this.I != null) {
                    TTFullScreenVideoActivity.this.I.removeMessages(300);
                }
                u.b("TTFullScreenVideoActivity", "onTimeOut、、、、、、、、");
                if (TTFullScreenVideoActivity.this.R()) {
                    TTFullScreenVideoActivity.this.t();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 0);
                TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", hashMap2);
                if (TTFullScreenVideoActivity.this.D != null) {
                    TTFullScreenVideoActivity.this.D.l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                if (TTFullScreenVideoActivity.this.I != null) {
                    TTFullScreenVideoActivity.this.I.removeMessages(300);
                }
                TTFullScreenVideoActivity.this.Q = (int) (TTFullScreenVideoActivity.this.J() - (j2 / 1000));
                TTFullScreenVideoActivity.this.e((int) (j2 / 1000));
                if (TTFullScreenVideoActivity.this.Q >= 0 && TTFullScreenVideoActivity.this.c != null) {
                    TTFullScreenVideoActivity.this.c.setShowCountDown(true);
                    TTFullScreenVideoActivity.this.c.a(String.valueOf(TTFullScreenVideoActivity.this.Q), (CharSequence) null);
                }
                if (TTFullScreenVideoActivity.this.Q <= 0) {
                    u.b("TTFullScreenVideoActivity", "onProgressUpdate、、、、、、、、");
                    if (TTFullScreenVideoActivity.this.R()) {
                        TTFullScreenVideoActivity.this.t();
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }
                if ((TTFullScreenVideoActivity.this.aa.get() || TTFullScreenVideoActivity.this.Y.get()) && TTFullScreenVideoActivity.this.u()) {
                    TTFullScreenVideoActivity.this.D.h();
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
        if (this.D == null) {
            return false;
        }
        Message message = new Message();
        message.what = 300;
        message.arg1 = 0;
        this.I.sendMessageDelayed(message, 5000L);
        boolean a2 = this.D.a(str, this.s.T(), this.o.getWidth(), this.o.getHeight(), null, this.s.W(), j, this.P);
        if (a2 && !z) {
            d.a(this.e, this.s, "fullscreen_interstitial_ad", hashMap);
            Q();
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i) {
        aR = com.bytedance.sdk.openadsdk.core.p.h().e(this.T);
        if (aR < 0) {
            aR = 5;
        }
        if (!com.bytedance.sdk.openadsdk.core.p.h().b(String.valueOf(this.T))) {
            if (i >= aR) {
                if (!this.W.getAndSet(true) && this.c != null) {
                    this.c.setShowSkip(true);
                }
                P();
                return;
            }
            return;
        }
        if (!this.W.getAndSet(true) && this.c != null) {
            this.c.setShowSkip(true);
        }
        if (i <= aR) {
            d(aR - i);
            if (this.c != null) {
                this.c.setSkipEnable(false);
                return;
            }
            return;
        }
        P();
    }

    private void P() {
        if (this.c != null) {
            this.c.a((CharSequence) null, "跳过");
            this.c.setSkipEnable(true);
        }
    }

    private void d(int i) {
        if (this.c != null) {
            this.c.a((CharSequence) null, new SpannableStringBuilder(i + "s后可跳过"));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void a(View view, int i, int i2, int i3, int i4) {
        if (b.b()) {
            d("onAdVideoBarClick");
        } else if (this.aS != null) {
            this.aS.onAdVideoBarClick();
        }
    }

    public void Q() {
        if (b.b()) {
            d("onAdShow");
        } else if (this.aS != null) {
            this.aS.onAdShow();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void S() {
        if (b.b()) {
            d("onAdVideoBarClick");
        } else if (this.aS != null) {
            this.aS.onAdVideoBarClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void f(int i) {
        if (i == 10002) {
            U();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            if (this.av && !TextUtils.isEmpty(this.O) && this.ar != 0) {
                com.bytedance.sdk.openadsdk.h.a.a().a(this.O, this.ar, this.as);
            }
        } catch (Throwable th) {
        }
        try {
            if (this.av && !TextUtils.isEmpty(this.O)) {
                com.bytedance.sdk.openadsdk.h.a.a().b(this.O);
            }
        } catch (Throwable th2) {
        }
        T();
        super.finish();
    }

    public void T() {
        if (!this.aU) {
            this.aU = true;
            if (b.b()) {
                d("onAdClose");
            } else if (this.aS != null) {
                this.aS.onAdClose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.J != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : this.J.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().b();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.J != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : this.J.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().c();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        T();
        if (b.b()) {
            d("recycleRes");
        }
        if (this.aS != null) {
            this.aS = null;
        }
        if (this.J != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : this.J.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().d();
                }
            }
        }
        if (TextUtils.isEmpty(this.x)) {
            com.bytedance.sdk.openadsdk.component.reward.c.a(com.bytedance.sdk.openadsdk.core.p.a()).b();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        aT = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        if (b.b()) {
            d("onVideoComplete");
        } else if (this.aS != null) {
            this.aS.onVideoComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        HashMap hashMap = new HashMap();
        if (this.s != null && this.s.s() && this.s.c() == 1) {
            hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.ax));
        }
        d.g(this.e, this.s, "fullscreen_interstitial_ad", "click_close", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        Bitmap b2;
        if (this.s != null && this.f != null && this.s.s() && (b2 = ak.b((WebView) this.f)) != null) {
            ak.a(com.bytedance.sdk.openadsdk.core.p.a(), this.s, "fullscreen_interstitial_ad", "playable_show_status", b2, false, 1);
        }
    }
}
