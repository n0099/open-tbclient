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
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.k.a;
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
/* loaded from: classes4.dex */
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        P();
        if (a(bundle)) {
            b();
            L();
            f();
            M();
            d();
            x();
            B();
            a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    p r() {
        return new p(l.a(this.s) ? 3 : 2, "rewarded_video", this.s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        aW = this.bb;
        try {
            bundle.putString("material_meta", this.s != null ? this.s.am().toString() : null);
            bundle.putString("multi_process_meta_md5", this.u);
            bundle.putLong("video_current", this.D == null ? this.w : this.D.m());
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
    public void d(String str) {
        a(str, false, 0, "");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        aW = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final boolean z, final int i, final String str2) {
        a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTRewardVideoActivity.this.b(0).executeRewardVideoCallback(TTRewardVideoActivity.this.u, str, z, i, str2);
                } catch (Throwable th) {
                    u.c("TTRewardVideoActivity", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L() {
        if (this.s == null) {
            finish();
        } else if (this.s.h() == 0) {
            setContentView(ac.f(this, "tt_activity_rewardvideo"));
        } else if (this.s.h() == 1) {
            setContentView(ac.f(this, "tt_activity_reward_video_newstyle"));
        } else if (this.s.h() == 3) {
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
            if (this.s != null && this.s.H() == 4) {
                this.E = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.e, this.s, "rewarded_video");
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
            if (this.E == null && this.s != null && this.s.H() == 4) {
                this.E = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.e, this.s, "rewarded_video");
            }
        }
        e.a().a(this.s);
        if (this.s == null) {
            u.f("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return false;
        }
        this.ag = this.s.h() == 1;
        this.ah = this.s.h() == 3;
        if (this.s == null || this.s.F() != null) {
        }
        return true;
    }

    private void M() {
        this.aR = com.bytedance.sdk.openadsdk.core.p.f();
        if (this.s == null) {
            u.f("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return;
        }
        if (this.s.s() && this.s.c() == 1) {
            a(getApplicationContext());
        }
        this.at = 7;
        this.T = aj.d(this.s.W());
        this.P = com.bytedance.sdk.openadsdk.core.p.h().b(this.T);
        this.R = this.s.X();
        this.K = this.s.T();
        this.L = this.s.W();
        this.Q = (int) J();
        this.M = 7;
        this.N = 3251;
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
        N();
        b("rewarded_video");
        p();
    }

    private void N() {
        if (this.j != null) {
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTRewardVideoActivity.this.aJ != null) {
                        TTRewardVideoActivity.this.aJ.i();
                    }
                    TTRewardVideoActivity.this.W();
                    l lVar = TTRewardVideoActivity.this.s;
                    if (l.b(TTRewardVideoActivity.this.s)) {
                        TTRewardVideoActivity.this.e(true);
                        return;
                    }
                    TTRewardVideoActivity.this.X();
                    TTRewardVideoActivity.this.finish();
                }
            });
        }
        if (this.c != null) {
            this.c.setListener(new com.bytedance.sdk.openadsdk.component.reward.top.b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.3
                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void a(View view) {
                    TTRewardVideoActivity.this.W();
                    TTRewardVideoActivity.this.X();
                    if (TTRewardVideoActivity.this.s != null && TTRewardVideoActivity.this.s.s() && TTRewardVideoActivity.this.s.c() == 1) {
                        TTRewardVideoActivity.this.e(true);
                    } else {
                        TTRewardVideoActivity.this.e(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void b(View view) {
                    TTRewardVideoActivity.this.P = !TTRewardVideoActivity.this.P;
                    u.b("TTRewardVideoActivity", "will set is Mute " + TTRewardVideoActivity.this.P + " mLastVolume=" + TTRewardVideoActivity.this.au.b());
                    if (TTRewardVideoActivity.this.D != null) {
                        TTRewardVideoActivity.this.D.c(TTRewardVideoActivity.this.P);
                    }
                    if (l.a(TTRewardVideoActivity.this.s)) {
                        TTRewardVideoActivity.this.au.a(TTRewardVideoActivity.this.P, true);
                    }
                    TTRewardVideoActivity.this.c(TTRewardVideoActivity.this.P);
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void c(View view) {
                    TTRewardVideoActivity.this.K();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final boolean z) {
        if (!com.bytedance.sdk.openadsdk.core.p.h().d(String.valueOf(this.T))) {
            if (z) {
                finish();
            } else {
                O();
            }
        } else if (this.aX.get()) {
            if (z) {
                finish();
            } else {
                O();
            }
        } else {
            this.aa.set(true);
            if (this.D != null) {
                this.D.h();
            }
            if (z) {
                E();
            }
            this.ab = new com.bytedance.sdk.openadsdk.core.widget.c(this);
            if (z) {
                this.ab.a("试玩后才可领取奖励").b("继续试玩").c("放弃奖励");
            } else {
                this.ab.a("观看完整视频才能获得奖励").b("继续观看").c("放弃奖励");
            }
            this.ab.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.4
                @Override // com.bytedance.sdk.openadsdk.core.widget.c.a
                public void a() {
                    if (TTRewardVideoActivity.this.D != null) {
                        TTRewardVideoActivity.this.D.j();
                    }
                    if (z) {
                        TTRewardVideoActivity.this.F();
                    }
                    TTRewardVideoActivity.this.ab.dismiss();
                    TTRewardVideoActivity.this.aa.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.c.a
                public void b() {
                    TTRewardVideoActivity.this.ab.dismiss();
                    TTRewardVideoActivity.this.aa.set(false);
                    if (z) {
                        TTRewardVideoActivity.this.X();
                        TTRewardVideoActivity.this.finish();
                        return;
                    }
                    TTRewardVideoActivity.this.O();
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.D != null) {
            this.D.l();
        }
        a("rewarded_video", FreeSpaceBox.TYPE, (Map<String, Object>) null);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        hashMap.put("play_type", Integer.valueOf(aj.a(this.D, this.z)));
        a("rewarded_video", "feed_break", hashMap);
        G();
        if (b.b()) {
            d("onSkippedVideo");
        } else if (this.bb != null) {
            this.bb.onSkippedVideo();
        }
    }

    private void P() {
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
                }
                TTRewardVideoActivity.this.U();
                TTRewardVideoActivity.this.t();
                TTRewardVideoActivity.this.ba = (int) (System.currentTimeMillis() / 1000);
                TTRewardVideoActivity.this.R();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i) {
                if (TTRewardVideoActivity.this.I != null) {
                    TTRewardVideoActivity.this.I.removeMessages(300);
                }
                if (b.b()) {
                    TTRewardVideoActivity.this.d("onVideoError");
                } else if (TTRewardVideoActivity.this.bb != null) {
                    TTRewardVideoActivity.this.bb.onVideoError();
                }
                if (!TTRewardVideoActivity.this.u()) {
                    if (TTRewardVideoActivity.this.D != null) {
                        TTRewardVideoActivity.this.D.l();
                    }
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
                }
                TTRewardVideoActivity.this.t();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 0);
                TTRewardVideoActivity.this.a("rewarded_video", hashMap2);
                if (TTRewardVideoActivity.this.D != null) {
                    TTRewardVideoActivity.this.D.l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                if (TTRewardVideoActivity.this.I != null) {
                    TTRewardVideoActivity.this.I.removeMessages(300);
                }
                int i = com.bytedance.sdk.openadsdk.core.p.h().r(String.valueOf(TTRewardVideoActivity.this.T)).g;
                if (j3 > 0 && ((float) (100 * j2)) / Float.valueOf((float) j3).floatValue() >= i) {
                    TTRewardVideoActivity.this.R();
                }
                TTRewardVideoActivity.this.Q = (int) (TTRewardVideoActivity.this.J() - (j2 / 1000));
                if (TTRewardVideoActivity.this.Q >= 0 && TTRewardVideoActivity.this.c != null) {
                    TTRewardVideoActivity.this.c.setShowSkip(true);
                    TTRewardVideoActivity.this.c.a(String.valueOf(TTRewardVideoActivity.this.Q), (CharSequence) null);
                }
                int i2 = (int) (j2 / 1000);
                if (TTRewardVideoActivity.this.S != -1 && i2 == TTRewardVideoActivity.this.S && !TTRewardVideoActivity.this.bc.get()) {
                    TTRewardVideoActivity.this.d.setVisibility(0);
                    TTRewardVideoActivity.this.bc.set(true);
                    TTRewardVideoActivity.this.q();
                }
                int g = com.bytedance.sdk.openadsdk.core.p.h().g(String.valueOf(TTRewardVideoActivity.this.T));
                if ((g != -1 && g >= 0) && i2 >= g) {
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
        message.arg1 = 1;
        this.I.sendMessageDelayed(message, 5000L);
        boolean a2 = this.D.a(str, this.s.T(), this.o.getWidth(), this.o.getHeight(), null, this.s.W(), j, this.P);
        if (a2 && !z) {
            d.a(this.e, this.s, "rewarded_video", hashMap);
            Q();
            this.aZ = (int) (System.currentTimeMillis() / 1000);
        }
        return a2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void a(View view, int i, int i2, int i3, int i4) {
        if (b.b()) {
            d("onAdVideoBarClick");
        } else if (this.bb != null) {
            this.bb.onAdVideoBarClick();
        }
    }

    public void Q() {
        if (b.b()) {
            d("onAdShow");
        } else if (this.bb != null) {
            this.bb.onAdShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R() {
        if (!this.aX.get()) {
            this.aX.set(true);
            if (com.bytedance.sdk.openadsdk.core.p.h().n(String.valueOf(this.T))) {
                if (b.b()) {
                    a("onRewardVerify", true, this.aT, this.aS);
                    return;
                } else if (this.bb != null) {
                    this.bb.onRewardVerify(true, this.aT, this.aS);
                    return;
                } else {
                    return;
                }
            }
            this.aR.a(V(), new q.c() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.6
                @Override // com.bytedance.sdk.openadsdk.core.q.c
                public void a(int i, String str) {
                    if (b.b()) {
                        TTRewardVideoActivity.this.a("onRewardVerify", false, 0, "");
                    } else if (TTRewardVideoActivity.this.bb != null) {
                        TTRewardVideoActivity.this.bb.onRewardVerify(false, 0, "");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.q.c
                public void a(r.c cVar) {
                    int a2 = cVar.c.a();
                    String b2 = cVar.c.b();
                    if (b.b()) {
                        TTRewardVideoActivity.this.a("onRewardVerify", cVar.f6976b, a2, b2);
                    } else if (TTRewardVideoActivity.this.bb != null) {
                        TTRewardVideoActivity.this.bb.onRewardVerify(cVar.f6976b, a2, b2);
                    }
                }
            });
        }
    }

    private JSONObject V() {
        JSONObject jSONObject = new JSONObject();
        float f = com.bytedance.sdk.openadsdk.utils.d.a(this.e) == null ? 0.0f : com.bytedance.sdk.openadsdk.utils.d.a(this.e).f7864a;
        float f2 = com.bytedance.sdk.openadsdk.utils.d.a(this.e) != null ? com.bytedance.sdk.openadsdk.utils.d.a(this.e).f7865b : 0.0f;
        int r = this.D != null ? (int) this.D.r() : 0;
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("reward_name", this.aS);
            jSONObject.put("reward_amount", this.aT);
            jSONObject.put("network", x.c(this.e));
            jSONObject.put("latitude", f);
            jSONObject.put("longitude", f2);
            jSONObject.put(SapiContext.KEY_SDK_VERSION, "3.2.5.1");
            jSONObject.put("user_agent", aj.a());
            jSONObject.put("extra", new JSONObject(this.L));
            jSONObject.put("media_extra", this.aU);
            jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, J());
            jSONObject.put("play_start_ts", this.aZ);
            jSONObject.put("play_end_ts", this.ba);
            jSONObject.put("duration", r);
            jSONObject.put("user_id", this.aV);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void S() {
        if (b.b()) {
            d("onAdVideoBarClick");
        } else if (this.bb != null) {
            this.bb.onAdVideoBarClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void f(int i) {
        if (i == 10000) {
            R();
        } else if (i == 10001) {
            U();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        T();
        super.finish();
    }

    public void T() {
        if (!this.aY) {
            this.aY = true;
            if (b.b()) {
                d("onAdClose");
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
        T();
        if (b.b()) {
            d("recycleRes");
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
    public void U() {
        if (b.b()) {
            d("onVideoComplete");
        } else if (this.bb != null) {
            this.bb.onVideoComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        HashMap hashMap = new HashMap();
        if (this.s != null && this.s.c() == 1 && this.s.s()) {
            hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.ax));
        }
        d.g(this.e, this.s, "rewarded_video", "click_close", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        Bitmap b2;
        if (this.s != null && this.f != null && this.s.s() && (b2 = ak.b((WebView) this.f)) != null) {
            ak.a(com.bytedance.sdk.openadsdk.core.p.a(), this.s, "rewarded_video", "playable_show_status", b2, false, 1);
        }
    }
}
