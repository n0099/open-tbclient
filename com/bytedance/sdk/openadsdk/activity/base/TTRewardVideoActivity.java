package com.bytedance.sdk.openadsdk.activity.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.component.reward.h;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.top.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.d;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    public static TTRewardVideoAd.RewardAdInteractionListener aZ;
    public q aU;
    public String aV;
    public int aW;
    public String aX;
    public String aY;
    public int bc;
    public int bd;
    public TTRewardVideoAd.RewardAdInteractionListener be;
    public AtomicBoolean ba = new AtomicBoolean(false);
    public final AtomicBoolean bf = new AtomicBoolean(false);
    public boolean bb = false;
    public int bg = -1;

    private void Q() {
        this.aU = p.f();
        l lVar = this.s;
        if (lVar == null) {
            u.f("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return;
        }
        if (lVar.C() && this.s.i() == 1) {
            a(getApplicationContext());
        }
        this.at = 7;
        this.T = ak.d(this.s.ap());
        this.P = p.h().b(this.T);
        this.R = this.s.aq();
        this.K = this.s.am();
        this.L = this.s.ap();
        this.Q = (int) L();
        this.M = 7;
        this.N = 3455;
        n();
        a(this.P);
        e();
        m();
        t();
        l();
        j();
        o();
        k();
        a("reward_endcard");
        R();
        b("rewarded_video");
        q();
    }

    private void R() {
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.c.p pVar = TTRewardVideoActivity.this.aJ;
                    if (pVar != null) {
                        pVar.i();
                    }
                    TTRewardVideoActivity.this.aa();
                    if (!l.d(TTRewardVideoActivity.this.s)) {
                        TTRewardVideoActivity.this.ab();
                        TTRewardVideoActivity.this.finish();
                        return;
                    }
                    TTRewardVideoActivity.this.f(true);
                }
            });
        }
        TopProxyLayout topProxyLayout = this.f27087c;
        if (topProxyLayout != null) {
            topProxyLayout.setListener(new b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.3
                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void a(View view) {
                    TTRewardVideoActivity.this.aa();
                    TTRewardVideoActivity.this.ab();
                    l lVar = TTRewardVideoActivity.this.s;
                    if (lVar != null && lVar.C() && TTRewardVideoActivity.this.s.i() == 1) {
                        TTRewardVideoActivity.this.f(true);
                    } else {
                        TTRewardVideoActivity.this.f(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void b(View view) {
                    TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                    tTRewardVideoActivity.P = !tTRewardVideoActivity.P;
                    u.b("TTRewardVideoActivity", "will set is Mute " + TTRewardVideoActivity.this.P + " mLastVolume=" + TTRewardVideoActivity.this.au.b());
                    TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                    c cVar = tTRewardVideoActivity2.D;
                    if (cVar != null) {
                        cVar.c(tTRewardVideoActivity2.P);
                    }
                    if (!l.e(TTRewardVideoActivity.this.s) || TTRewardVideoActivity.this.U.get()) {
                        if (l.b(TTRewardVideoActivity.this.s)) {
                            TTRewardVideoActivity tTRewardVideoActivity3 = TTRewardVideoActivity.this;
                            tTRewardVideoActivity3.au.a(tTRewardVideoActivity3.P, true);
                        }
                        TTRewardVideoActivity tTRewardVideoActivity4 = TTRewardVideoActivity.this;
                        tTRewardVideoActivity4.c(tTRewardVideoActivity4.P);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void c(View view) {
                    TTRewardVideoActivity.this.M();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        c cVar = this.D;
        if (cVar != null) {
            cVar.m();
        }
        a("rewarded_video", FreeSpaceBox.TYPE, (Map<String, Object>) null);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        hashMap.put("play_type", Integer.valueOf(ak.a(this.D, this.z)));
        a("rewarded_video", "feed_break", hashMap);
        I();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e("onSkippedVideo");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.be;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onSkippedVideo();
        }
    }

    private void T() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.aV = intent.getStringExtra("reward_name");
        this.aW = intent.getIntExtra("reward_amount", 0);
        this.aX = intent.getStringExtra("media_extra");
        this.aY = intent.getStringExtra("user_id");
        this.v = intent.getBooleanExtra("show_download_bar", true);
        this.x = intent.getStringExtra("video_cache_url");
        this.y = intent.getIntExtra("orientation", 2);
        this.af = intent.getStringExtra("rit_scene");
    }

    private JSONObject Z() {
        JSONObject jSONObject = new JSONObject();
        float f2 = d.a(this.f27089e) == null ? 0.0f : d.a(this.f27089e).f30252a;
        float f3 = d.a(this.f27089e) != null ? d.a(this.f27089e).f30253b : 0.0f;
        c cVar = this.D;
        int s = cVar != null ? (int) cVar.s() : 0;
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("reward_name", this.aV);
            jSONObject.put("reward_amount", this.aW);
            jSONObject.put("network", x.c(this.f27089e));
            jSONObject.put("latitude", f2);
            jSONObject.put("longitude", f3);
            jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, "3.4.5.5");
            jSONObject.put(com.alipay.sdk.cons.b.f1825b, ak.b());
            jSONObject.put("extra", new JSONObject(this.L));
            jSONObject.put("media_extra", this.aX);
            jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, L());
            jSONObject.put("play_start_ts", this.bc);
            jSONObject.put("play_end_ts", this.bd);
            jSONObject.put("duration", s);
            jSONObject.put("user_id", this.aY);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        HashMap hashMap = new HashMap();
        l lVar = this.s;
        if (lVar != null && lVar.i() == 1 && this.s.C()) {
            hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.ax));
        }
        com.bytedance.sdk.openadsdk.c.d.g(this.f27089e, this.s, "rewarded_video", "click_close", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab() {
        Bitmap b2;
        l lVar = this.s;
        if (lVar == null || this.f27090f == null || !lVar.C() || (b2 = al.b((WebView) this.f27090f)) == null) {
            return;
        }
        al.a(p.a(), this.s, "rewarded_video", "playable_show_status", b2, false, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final boolean z) {
        com.bytedance.sdk.openadsdk.core.x xVar;
        if (!p.h().d(String.valueOf(this.T))) {
            if (z) {
                finish();
            } else {
                S();
            }
        } else if (this.ba.get()) {
            if (z) {
                finish();
            } else {
                S();
            }
        } else {
            this.aa.set(true);
            c cVar = this.D;
            if (cVar != null) {
                cVar.h();
            }
            if (z) {
                G();
            }
            final com.bytedance.sdk.openadsdk.core.widget.c cVar2 = new com.bytedance.sdk.openadsdk.core.widget.c(this);
            this.ab = cVar2;
            if (z) {
                String str = "试玩时长达标才能领取奖励";
                if (p.h().m(String.valueOf(this.T)) != 1 && (xVar = this.F) != null && !xVar.e()) {
                    str = "试玩后才能领取奖励";
                }
                this.ab.a(str).b("继续试玩").c("放弃奖励");
            } else {
                cVar2.a("观看完整视频才能获得奖励").b("继续观看").c("放弃奖励");
            }
            this.ab.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.4
                @Override // com.bytedance.sdk.openadsdk.core.widget.c.a
                public void a() {
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar3 = TTRewardVideoActivity.this.D;
                    if (cVar3 != null) {
                        cVar3.k();
                    }
                    if (z) {
                        TTRewardVideoActivity.this.H();
                    }
                    cVar2.dismiss();
                    TTRewardVideoActivity.this.aa.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.c.a
                public void b() {
                    cVar2.dismiss();
                    TTRewardVideoActivity.this.aa.set(false);
                    TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                    tTRewardVideoActivity.ay = Integer.MAX_VALUE;
                    if (z) {
                        tTRewardVideoActivity.ab();
                        TTRewardVideoActivity.this.finish();
                        return;
                    }
                    tTRewardVideoActivity.S();
                }
            }).show();
        }
    }

    public void P() {
        l lVar = this.s;
        if (lVar == null) {
            finish();
        } else if (lVar.n() == 0) {
            setContentView(ad.f(this, "tt_activity_rewardvideo"));
        } else if (this.s.n() == 1) {
            setContentView(ad.f(this, "tt_activity_reward_video_newstyle"));
        } else if (this.s.n() == 3) {
            setContentView(ad.f(this, "tt_activity_rewardvideo_new_bar_3_style"));
        } else {
            setContentView(ad.f(this, "tt_activity_rewardvideo"));
        }
    }

    public void U() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e("onAdShow");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.be;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdShow();
        }
    }

    public void V() {
        if (this.ba.get()) {
            return;
        }
        this.ba.set(true);
        if (p.h().n(String.valueOf(this.T))) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                a("onRewardVerify", true, this.aW, this.aV, 0, "");
                return;
            }
            TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.be;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRewardVerify(true, this.aW, this.aV, 0, "");
                return;
            }
            return;
        }
        this.aU.a(Z(), new q.c() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.core.q.c
            public void a(int i2, String str) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    TTRewardVideoActivity.this.a("onRewardVerify", false, 0, "", i2, str);
                    return;
                }
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2 = TTRewardVideoActivity.this.be;
                if (rewardAdInteractionListener2 != null) {
                    rewardAdInteractionListener2.onRewardVerify(false, 0, "", i2, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.c
            public void a(r.c cVar) {
                int a2 = cVar.f28431c.a();
                String b2 = cVar.f28431c.b();
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    TTRewardVideoActivity.this.a("onRewardVerify", cVar.f28430b, a2, b2, 0, "");
                    return;
                }
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2 = TTRewardVideoActivity.this.be;
                if (rewardAdInteractionListener2 != null) {
                    rewardAdInteractionListener2.onRewardVerify(cVar.f28430b, a2, b2, 0, "");
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void W() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e("onAdVideoBarClick");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.be;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
        }
    }

    public void X() {
        if (this.bb) {
            return;
        }
        this.bb = true;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e("onAdClose");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.be;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdClose();
        }
    }

    public void Y() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e("onVideoComplete");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.be;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoComplete();
        }
    }

    public void e(String str) {
        a(str, false, 0, "", 0, "");
    }

    public void finalize() throws Throwable {
        super.finalize();
        aZ = null;
    }

    @Override // android.app.Activity
    public void finish() {
        X();
        super.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        T();
        if (a(bundle)) {
            b();
            P();
            f();
            Q();
            d();
            z();
            D();
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
        if (this.be != null) {
            this.be = null;
        }
        Map<String, a> map = this.J;
        if (map != null) {
            for (Map.Entry<String, a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().d();
                }
            }
        }
        if (TextUtils.isEmpty(this.x)) {
            h.a(p.a()).a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Map<String, a> map = this.J;
        if (map != null) {
            for (Map.Entry<String, a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().c();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Map<String, a> map = this.J;
        if (map != null) {
            for (Map.Entry<String, a> entry : map.entrySet()) {
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
        aZ = this.be;
        try {
            bundle.putString("material_meta", this.s != null ? this.s.aL().toString() : null);
            bundle.putString("multi_process_meta_md5", this.u);
            bundle.putLong("video_current", this.D == null ? this.w : this.D.n());
            bundle.putString("video_cache_url", this.x);
            bundle.putInt("orientation", this.y);
            bundle.putBoolean("is_mute", this.P);
            bundle.putBoolean("has_show_skip_btn", this.W.get());
            bundle.putString("rit_scene", this.af);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public com.bytedance.sdk.openadsdk.c.p s() {
        return new com.bytedance.sdk.openadsdk.c.p(l.b(this.s) ? 3 : 2, "rewarded_video", this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final boolean z, final int i2, final String str2, final int i3, final String str3) {
        e.b(new g("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTRewardVideoActivity.this.b(0).executeRewardVideoCallback(TTRewardVideoActivity.this.u, str, z, i2, str2, i3, str3);
                } catch (Throwable th) {
                    u.c("TTRewardVideoActivity", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
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
                        u.c("TTRewardVideoActivity", "TTRewardVideoActivity MultiGlobalInfo throw ", e2);
                    }
                }
            }
            l lVar2 = this.s;
            if (lVar2 != null && lVar2.Z() == 4) {
                this.E = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f27089e, this.s, "rewarded_video");
            }
        } else {
            this.s = com.bytedance.sdk.openadsdk.core.u.a().c();
            this.be = com.bytedance.sdk.openadsdk.core.u.a().d();
            this.E = com.bytedance.sdk.openadsdk.core.u.a().f();
            com.bytedance.sdk.openadsdk.core.u.a().g();
        }
        if (bundle != null) {
            if (this.be == null) {
                this.be = aZ;
                aZ = null;
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
                if (this.W.get() && this.f27087c != null) {
                    this.f27087c.setShowSkip(true);
                    this.f27087c.a((CharSequence) null, "跳过");
                    this.f27087c.setSkipEnable(true);
                }
            } catch (Throwable unused) {
            }
            if (this.E == null && (lVar = this.s) != null && lVar.Z() == 4) {
                this.E = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f27089e, this.s, "rewarded_video");
            }
        }
        com.bytedance.sdk.openadsdk.core.e.a().a(this.s);
        l lVar3 = this.s;
        if (lVar3 == null) {
            u.f("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
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

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void f(int i2) {
        if (i2 == 10000) {
            V();
        } else if (i2 == 10001) {
            Y();
        }
    }

    public void a(long j, long j2) {
        if (this.bg == -1) {
            this.bg = p.h().q(String.valueOf(this.T)).f28190f;
        }
        if (j2 <= 0) {
            return;
        }
        if (j2 >= StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD && j >= 27000) {
            V();
        } else if (((float) (j * 100)) / ((float) j2) >= this.bg) {
            V();
        }
    }

    public boolean a(long j, boolean z) {
        HashMap hashMap;
        if (this.D == null) {
            this.D = new com.bytedance.sdk.openadsdk.component.reward.g(this.f27089e, this.o, this.s);
        }
        if (TextUtils.isEmpty(this.af)) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            hashMap.put("rit_scene", this.af);
        }
        this.D.a(hashMap);
        this.D.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, int i2) {
                am amVar = TTRewardVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                    TTRewardVideoActivity.this.N();
                }
                TTRewardVideoActivity.this.Y();
                TTRewardVideoActivity.this.u();
                TTRewardVideoActivity.this.bd = (int) (System.currentTimeMillis() / 1000);
                TTRewardVideoActivity.this.V();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i2) {
                am amVar = TTRewardVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                }
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    TTRewardVideoActivity.this.e("onVideoError");
                } else {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = TTRewardVideoActivity.this.be;
                    if (rewardAdInteractionListener != null) {
                        rewardAdInteractionListener.onVideoError();
                    }
                }
                TTRewardVideoActivity.this.e(true);
                if (TTRewardVideoActivity.this.v()) {
                    return;
                }
                TTRewardVideoActivity.this.N();
                com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = TTRewardVideoActivity.this.D;
                if (cVar != null) {
                    cVar.m();
                }
                TTRewardVideoActivity.this.V();
                TTRewardVideoActivity.this.u();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 1);
                TTRewardVideoActivity.this.a("rewarded_video", hashMap2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                am amVar = TTRewardVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                    TTRewardVideoActivity.this.N();
                }
                TTRewardVideoActivity.this.u();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 0);
                TTRewardVideoActivity.this.a("rewarded_video", hashMap2);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = TTRewardVideoActivity.this.D;
                if (cVar != null) {
                    cVar.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                TopProxyLayout topProxyLayout;
                TopProxyLayout topProxyLayout2;
                am amVar = TTRewardVideoActivity.this.I;
                if (amVar != null) {
                    amVar.removeMessages(300);
                    TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                    if (j2 != tTRewardVideoActivity.aL) {
                        tTRewardVideoActivity.N();
                    }
                }
                TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                tTRewardVideoActivity2.aL = j2;
                tTRewardVideoActivity2.a(j2, j3);
                TTRewardVideoActivity tTRewardVideoActivity3 = TTRewardVideoActivity.this;
                long j4 = j2 / 1000;
                tTRewardVideoActivity3.Q = (int) (tTRewardVideoActivity3.L() - j4);
                TTRewardVideoActivity tTRewardVideoActivity4 = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity4.Q >= 0 && (topProxyLayout2 = tTRewardVideoActivity4.f27087c) != null) {
                    topProxyLayout2.setShowSkip(true);
                    TTRewardVideoActivity tTRewardVideoActivity5 = TTRewardVideoActivity.this;
                    tTRewardVideoActivity5.f27087c.a(String.valueOf(tTRewardVideoActivity5.Q), (CharSequence) null);
                }
                int i2 = (int) j4;
                TTRewardVideoActivity tTRewardVideoActivity6 = TTRewardVideoActivity.this;
                int i3 = tTRewardVideoActivity6.S;
                boolean z2 = false;
                if (i3 != -1 && i2 == i3 && !tTRewardVideoActivity6.bf.get()) {
                    TTRewardVideoActivity.this.f27088d.setVisibility(0);
                    TTRewardVideoActivity.this.bf.set(true);
                    TTRewardVideoActivity.this.r();
                }
                int g2 = p.h().g(String.valueOf(TTRewardVideoActivity.this.T));
                if (g2 != -1 && g2 >= 0) {
                    z2 = true;
                }
                if (z2 && i2 >= g2) {
                    if (!TTRewardVideoActivity.this.W.getAndSet(true) && (topProxyLayout = TTRewardVideoActivity.this.f27087c) != null) {
                        topProxyLayout.setShowSkip(true);
                    }
                    TopProxyLayout topProxyLayout3 = TTRewardVideoActivity.this.f27087c;
                    if (topProxyLayout3 != null) {
                        topProxyLayout3.a((CharSequence) null, "跳过");
                        TTRewardVideoActivity.this.f27087c.setSkipEnable(true);
                    }
                }
                TTRewardVideoActivity tTRewardVideoActivity7 = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity7.Q <= 0) {
                    tTRewardVideoActivity7.u();
                }
                if ((TTRewardVideoActivity.this.aa.get() || TTRewardVideoActivity.this.Y.get()) && TTRewardVideoActivity.this.v()) {
                    TTRewardVideoActivity.this.D.h();
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
        message.arg1 = 1;
        this.I.sendMessageDelayed(message, 5000L);
        boolean a2 = this.D.a(str, this.s.am(), this.o.getWidth(), this.o.getHeight(), null, this.s.ap(), j, this.P);
        if (a2 && !z) {
            u.e("AdEvent", "pangolin ad show " + ak.a(this.s, (View) null));
            com.bytedance.sdk.openadsdk.c.d.a(this.f27089e, this.s, "rewarded_video", hashMap);
            U();
            this.bc = (int) (System.currentTimeMillis() / 1000);
        }
        return a2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void a(View view, int i2, int i3, int i4, int i5) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e("onAdVideoBarClick");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.be;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
        }
    }
}
