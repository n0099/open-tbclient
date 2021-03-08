package com.bytedance.sdk.openadsdk.activity.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.sapi2.SapiContext;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.component.reward.f;
import com.bytedance.sdk.openadsdk.component.reward.g;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static TTRewardVideoAd.RewardAdInteractionListener aW;
    private q aR;
    private String aS;
    private int aT;
    private String aU;
    private String aV;
    protected int aZ;
    protected int ba;
    protected TTRewardVideoAd.RewardAdInteractionListener bb;
    private AtomicBoolean aX = new AtomicBoolean(false);
    protected final AtomicBoolean bc = new AtomicBoolean(false);
    private boolean aY = false;
    private int bd = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        R();
        if (a(bundle)) {
            b();
            N();
            f();
            O();
            d();
            y();
            C();
            a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    p r() {
        return new p(l.b(this.s) ? 3 : 2, "rewarded_video", this.s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        aW = this.bb;
        try {
            bundle.putString("material_meta", this.s != null ? this.s.aE().toString() : null);
            bundle.putString("multi_process_meta_md5", this.u);
            bundle.putLong("video_current", this.D == null ? this.w : this.D.n());
            bundle.putString("video_cache_url", this.x);
            bundle.putInt("orientation", this.y);
            bundle.putBoolean("is_mute", this.P);
            bundle.putBoolean("has_show_skip_btn", this.W.get());
            bundle.putString("rit_scene", this.af);
        } catch (Throwable th) {
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str) {
        a(str, false, 0, "", 0, "");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        aW = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final boolean z, final int i, final String str2, final int i2, final String str3) {
        e.b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTRewardVideoActivity.this.b(0).executeRewardVideoCallback(TTRewardVideoActivity.this.u, str, z, i, str2, i2, str3);
                } catch (Throwable th) {
                    u.c("TTRewardVideoActivity", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N() {
        if (this.s == null) {
            finish();
        } else if (this.s.n() == 0) {
            setContentView(ac.f(this, "tt_activity_rewardvideo"));
        } else if (this.s.n() == 1) {
            setContentView(ac.f(this, "tt_activity_reward_video_newstyle"));
        } else if (this.s.n() == 3) {
            setContentView(ac.f(this, "tt_activity_rewardvideo_new_bar_3_style"));
        } else {
            setContentView(ac.f(this, "tt_activity_rewardvideo"));
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
                        u.c("TTRewardVideoActivity", "TTRewardVideoActivity MultiGlobalInfo throw ", e);
                    }
                }
            }
            if (this.s != null && this.s.T() == 4) {
                this.E = a.a(this.e, this.s, "rewarded_video");
            }
        } else {
            this.s = com.bytedance.sdk.openadsdk.core.u.a().c();
            this.bb = com.bytedance.sdk.openadsdk.core.u.a().d();
            this.E = com.bytedance.sdk.openadsdk.core.u.a().f();
            com.bytedance.sdk.openadsdk.core.u.a().g();
        }
        if (bundle != null) {
            if (this.bb == null) {
                this.bb = aW;
                aW = null;
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
                if (this.W.get() && this.c != null) {
                    this.c.setShowSkip(true);
                    this.c.a((CharSequence) null, "跳过");
                    this.c.setSkipEnable(true);
                }
            } catch (Throwable th) {
            }
            if (this.E == null && this.s != null && this.s.T() == 4) {
                this.E = a.a(this.e, this.s, "rewarded_video");
            }
        }
        com.bytedance.sdk.openadsdk.core.e.a().a(this.s);
        if (this.s == null) {
            u.f("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return false;
        }
        this.ag = this.s.n() == 1;
        this.ah = this.s.n() == 3;
        if (this.s == null || this.s.R() != null) {
        }
        return true;
    }

    private void O() {
        this.aR = com.bytedance.sdk.openadsdk.core.p.f();
        if (this.s == null) {
            u.f("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return;
        }
        if (this.s.C() && this.s.i() == 1) {
            a(getApplicationContext());
        }
        this.at = 7;
        this.T = aj.d(this.s.aj());
        this.P = com.bytedance.sdk.openadsdk.core.p.h().b(this.T);
        this.R = this.s.ak();
        this.K = this.s.ag();
        this.L = this.s.aj();
        this.Q = (int) K();
        this.M = 7;
        this.N = 3401;
        m();
        a(this.P);
        e();
        l();
        s();
        k();
        i();
        n();
        j();
        a("reward_endcard");
        P();
        b("rewarded_video");
        p();
    }

    private void P() {
        if (this.j != null) {
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTRewardVideoActivity.this.aJ != null) {
                        TTRewardVideoActivity.this.aJ.i();
                    }
                    TTRewardVideoActivity.this.Y();
                    l lVar = TTRewardVideoActivity.this.s;
                    if (l.d(TTRewardVideoActivity.this.s)) {
                        TTRewardVideoActivity.this.f(true);
                        return;
                    }
                    TTRewardVideoActivity.this.Z();
                    TTRewardVideoActivity.this.finish();
                }
            });
        }
        if (this.c != null) {
            this.c.setListener(new com.bytedance.sdk.openadsdk.component.reward.top.b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.3
                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void a(View view) {
                    TTRewardVideoActivity.this.Y();
                    TTRewardVideoActivity.this.Z();
                    if (TTRewardVideoActivity.this.s != null && TTRewardVideoActivity.this.s.C() && TTRewardVideoActivity.this.s.i() == 1) {
                        TTRewardVideoActivity.this.f(true);
                    } else {
                        TTRewardVideoActivity.this.f(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void b(View view) {
                    TTRewardVideoActivity.this.P = !TTRewardVideoActivity.this.P;
                    u.b("TTRewardVideoActivity", "will set is Mute " + TTRewardVideoActivity.this.P + " mLastVolume=" + TTRewardVideoActivity.this.au.b());
                    if (TTRewardVideoActivity.this.D != null) {
                        TTRewardVideoActivity.this.D.c(TTRewardVideoActivity.this.P);
                    }
                    if (!l.e(TTRewardVideoActivity.this.s) || TTRewardVideoActivity.this.U.get()) {
                        if (l.b(TTRewardVideoActivity.this.s)) {
                            TTRewardVideoActivity.this.au.a(TTRewardVideoActivity.this.P, true);
                        }
                        TTRewardVideoActivity.this.c(TTRewardVideoActivity.this.P);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void c(View view) {
                    TTRewardVideoActivity.this.L();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final boolean z) {
        String str;
        if (!com.bytedance.sdk.openadsdk.core.p.h().d(String.valueOf(this.T))) {
            if (z) {
                finish();
            } else {
                Q();
            }
        } else if (this.aX.get()) {
            if (z) {
                finish();
            } else {
                Q();
            }
        } else {
            this.aa.set(true);
            if (this.D != null) {
                this.D.h();
            }
            if (z) {
                F();
            }
            this.ab = new com.bytedance.sdk.openadsdk.core.widget.c(this);
            if (z) {
                if (com.bytedance.sdk.openadsdk.core.p.h().m(String.valueOf(this.T)) == 1) {
                    str = "试玩时长达标才能领取奖励";
                } else if (this.F != null && !this.F.e()) {
                    str = "试玩后才能领取奖励";
                } else {
                    str = "试玩时长达标才能领取奖励";
                }
                this.ab.a(str).b("继续试玩").c("放弃奖励");
            } else {
                this.ab.a("观看完整视频才能获得奖励").b("继续观看").c("放弃奖励");
            }
            this.ab.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.4
                @Override // com.bytedance.sdk.openadsdk.core.widget.c.a
                public void a() {
                    if (TTRewardVideoActivity.this.D != null) {
                        TTRewardVideoActivity.this.D.k();
                    }
                    if (z) {
                        TTRewardVideoActivity.this.G();
                    }
                    TTRewardVideoActivity.this.ab.dismiss();
                    TTRewardVideoActivity.this.aa.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.c.a
                public void b() {
                    TTRewardVideoActivity.this.ab.dismiss();
                    TTRewardVideoActivity.this.aa.set(false);
                    TTRewardVideoActivity.this.ay = Integer.MAX_VALUE;
                    if (z) {
                        TTRewardVideoActivity.this.Z();
                        TTRewardVideoActivity.this.finish();
                        return;
                    }
                    TTRewardVideoActivity.this.Q();
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (this.D != null) {
            this.D.m();
        }
        a("rewarded_video", FreeSpaceBox.TYPE, (Map<String, Object>) null);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        hashMap.put("play_type", Integer.valueOf(aj.a(this.D, this.z)));
        a("rewarded_video", "feed_break", hashMap);
        H();
        if (b.b()) {
            e("onSkippedVideo");
        } else if (this.bb != null) {
            this.bb.onSkippedVideo();
        }
    }

    private void R() {
        Intent intent = getIntent();
        if (intent != null) {
            this.aS = intent.getStringExtra("reward_name");
            this.aT = intent.getIntExtra("reward_amount", 0);
            this.aU = intent.getStringExtra("media_extra");
            this.aV = intent.getStringExtra("user_id");
            this.v = intent.getBooleanExtra("show_download_bar", true);
            this.x = intent.getStringExtra("video_cache_url");
            this.y = intent.getIntExtra("orientation", 2);
            this.af = intent.getStringExtra("rit_scene");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(long j, long j2) {
        if (this.bd == -1) {
            this.bd = com.bytedance.sdk.openadsdk.core.p.h().r(String.valueOf(this.T)).g;
        }
        if (j2 > 0) {
            if (j2 >= 30000 && j >= 27000) {
                T();
            } else if (((float) (100 * j)) / ((float) j2) >= this.bd) {
                T();
            }
        }
    }

    public boolean a(long j, boolean z) {
        HashMap hashMap;
        if (this.D == null) {
            this.D = new f(this.e, this.o, this.s);
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
            public void a(long j2, int i) {
                if (TTRewardVideoActivity.this.I != null) {
                    TTRewardVideoActivity.this.I.removeMessages(300);
                    TTRewardVideoActivity.this.M();
                }
                TTRewardVideoActivity.this.W();
                TTRewardVideoActivity.this.t();
                TTRewardVideoActivity.this.ba = (int) (System.currentTimeMillis() / 1000);
                TTRewardVideoActivity.this.T();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i) {
                if (TTRewardVideoActivity.this.I != null) {
                    TTRewardVideoActivity.this.I.removeMessages(300);
                }
                if (b.b()) {
                    TTRewardVideoActivity.this.e("onVideoError");
                } else if (TTRewardVideoActivity.this.bb != null) {
                    TTRewardVideoActivity.this.bb.onVideoError();
                }
                TTRewardVideoActivity.this.e(true);
                if (!TTRewardVideoActivity.this.u()) {
                    TTRewardVideoActivity.this.M();
                    if (TTRewardVideoActivity.this.D != null) {
                        TTRewardVideoActivity.this.D.m();
                    }
                    TTRewardVideoActivity.this.T();
                    TTRewardVideoActivity.this.t();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("vbtt_skip_type", 1);
                    TTRewardVideoActivity.this.a("rewarded_video", hashMap2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                if (TTRewardVideoActivity.this.I != null) {
                    TTRewardVideoActivity.this.I.removeMessages(300);
                    TTRewardVideoActivity.this.M();
                }
                TTRewardVideoActivity.this.t();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 0);
                TTRewardVideoActivity.this.a("rewarded_video", hashMap2);
                if (TTRewardVideoActivity.this.D != null) {
                    TTRewardVideoActivity.this.D.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                if (TTRewardVideoActivity.this.I != null) {
                    TTRewardVideoActivity.this.I.removeMessages(300);
                    TTRewardVideoActivity.this.M();
                }
                TTRewardVideoActivity.this.a(j2, j3);
                TTRewardVideoActivity.this.Q = (int) (TTRewardVideoActivity.this.K() - (j2 / 1000));
                if (TTRewardVideoActivity.this.Q >= 0 && TTRewardVideoActivity.this.c != null) {
                    TTRewardVideoActivity.this.c.setShowSkip(true);
                    TTRewardVideoActivity.this.c.a(String.valueOf(TTRewardVideoActivity.this.Q), (CharSequence) null);
                }
                int i = (int) (j2 / 1000);
                if (TTRewardVideoActivity.this.S != -1 && i == TTRewardVideoActivity.this.S && !TTRewardVideoActivity.this.bc.get()) {
                    TTRewardVideoActivity.this.d.setVisibility(0);
                    TTRewardVideoActivity.this.bc.set(true);
                    TTRewardVideoActivity.this.q();
                }
                int g = com.bytedance.sdk.openadsdk.core.p.h().g(String.valueOf(TTRewardVideoActivity.this.T));
                if ((g != -1 && g >= 0) && i >= g) {
                    if (!TTRewardVideoActivity.this.W.getAndSet(true) && TTRewardVideoActivity.this.c != null) {
                        TTRewardVideoActivity.this.c.setShowSkip(true);
                    }
                    if (TTRewardVideoActivity.this.c != null) {
                        TTRewardVideoActivity.this.c.a((CharSequence) null, "跳过");
                        TTRewardVideoActivity.this.c.setSkipEnable(true);
                    }
                }
                if (TTRewardVideoActivity.this.Q <= 0) {
                    TTRewardVideoActivity.this.t();
                }
                if ((TTRewardVideoActivity.this.aa.get() || TTRewardVideoActivity.this.Y.get()) && TTRewardVideoActivity.this.u()) {
                    TTRewardVideoActivity.this.D.h();
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
        if (this.D == null) {
            return false;
        }
        Message message = new Message();
        message.what = 300;
        message.arg1 = 1;
        this.I.sendMessageDelayed(message, 5000L);
        boolean a2 = this.D.a(str, this.s.ag(), this.o.getWidth(), this.o.getHeight(), null, this.s.aj(), j, this.P);
        if (a2 && !z) {
            u.e("AdEvent", "pangolin ad show " + aj.a(this.s, (View) null));
            d.a(this.e, this.s, "rewarded_video", hashMap);
            S();
            this.aZ = (int) (System.currentTimeMillis() / 1000);
        }
        return a2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void a(View view, int i, int i2, int i3, int i4) {
        if (b.b()) {
            e("onAdVideoBarClick");
        } else if (this.bb != null) {
            this.bb.onAdVideoBarClick();
        }
    }

    public void S() {
        if (b.b()) {
            e("onAdShow");
        } else if (this.bb != null) {
            this.bb.onAdShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        if (!this.aX.get()) {
            this.aX.set(true);
            if (com.bytedance.sdk.openadsdk.core.p.h().n(String.valueOf(this.T))) {
                if (b.b()) {
                    a("onRewardVerify", true, this.aT, this.aS, 0, "");
                    return;
                } else if (this.bb != null) {
                    this.bb.onRewardVerify(true, this.aT, this.aS, 0, "");
                    return;
                } else {
                    return;
                }
            }
            this.aR.a(X(), new q.c() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.6
                @Override // com.bytedance.sdk.openadsdk.core.q.c
                public void a(int i, String str) {
                    if (b.b()) {
                        TTRewardVideoActivity.this.a("onRewardVerify", false, 0, "", i, str);
                    } else if (TTRewardVideoActivity.this.bb != null) {
                        TTRewardVideoActivity.this.bb.onRewardVerify(false, 0, "", i, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.q.c
                public void a(r.c cVar) {
                    int a2 = cVar.c.a();
                    String b = cVar.c.b();
                    if (b.b()) {
                        TTRewardVideoActivity.this.a("onRewardVerify", cVar.b, a2, b, 0, "");
                    } else if (TTRewardVideoActivity.this.bb != null) {
                        TTRewardVideoActivity.this.bb.onRewardVerify(cVar.b, a2, b, 0, "");
                    }
                }
            });
        }
    }

    private JSONObject X() {
        JSONObject jSONObject = new JSONObject();
        float f = com.bytedance.sdk.openadsdk.utils.d.a(this.e) == null ? 0.0f : com.bytedance.sdk.openadsdk.utils.d.a(this.e).f5126a;
        float f2 = com.bytedance.sdk.openadsdk.utils.d.a(this.e) != null ? com.bytedance.sdk.openadsdk.utils.d.a(this.e).b : 0.0f;
        int s = this.D != null ? (int) this.D.s() : 0;
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("reward_name", this.aS);
            jSONObject.put("reward_amount", this.aT);
            jSONObject.put("network", x.c(this.e));
            jSONObject.put("latitude", f);
            jSONObject.put("longitude", f2);
            jSONObject.put(SapiContext.KEY_SDK_VERSION, "3.4.0.1");
            jSONObject.put("user_agent", aj.b());
            jSONObject.put("extra", new JSONObject(this.L));
            jSONObject.put("media_extra", this.aU);
            jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, K());
            jSONObject.put("play_start_ts", this.aZ);
            jSONObject.put("play_end_ts", this.ba);
            jSONObject.put("duration", s);
            jSONObject.put("user_id", this.aV);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void U() {
        if (b.b()) {
            e("onAdVideoBarClick");
        } else if (this.bb != null) {
            this.bb.onAdVideoBarClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void f(int i) {
        if (i == 10000) {
            T();
        } else if (i == 10001) {
            W();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        V();
        super.finish();
    }

    public void V() {
        if (!this.aY) {
            this.aY = true;
            if (b.b()) {
                e("onAdClose");
            } else if (this.bb != null) {
                this.bb.onAdClose();
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
        V();
        if (b.b()) {
            e("recycleRes");
        }
        if (this.bb != null) {
            this.bb = null;
        }
        if (this.J != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : this.J.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().d();
                }
            }
        }
        if (TextUtils.isEmpty(this.x)) {
            g.a(com.bytedance.sdk.openadsdk.core.p.a()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W() {
        if (b.b()) {
            e("onVideoComplete");
        } else if (this.bb != null) {
            this.bb.onVideoComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        HashMap hashMap = new HashMap();
        if (this.s != null && this.s.i() == 1 && this.s.C()) {
            hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.ax));
        }
        d.g(this.e, this.s, "rewarded_video", "click_close", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        Bitmap b;
        if (this.s != null && this.f != null && this.s.C() && (b = ak.b((WebView) this.f)) != null) {
            ak.a(com.bytedance.sdk.openadsdk.core.p.a(), this.s, "rewarded_video", "playable_show_status", b, false, 1);
        }
    }
}
