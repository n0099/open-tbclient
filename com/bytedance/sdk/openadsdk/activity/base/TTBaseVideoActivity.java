package com.bytedance.sdk.openadsdk.activity.base;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.sapi2.SapiOptions;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.video.c.b;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.f;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.g.f;
import com.bytedance.sdk.openadsdk.g.g;
import com.bytedance.sdk.openadsdk.g.h;
import com.bytedance.sdk.openadsdk.j.d;
import com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class TTBaseVideoActivity extends Activity implements b, f, HomeWatcherReceiver.a, am.a {
    public static RemoteCallbackList<ITTAppDownloadListener> ad;
    public static d.a bg = new d.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.1
        @Override // com.bytedance.sdk.openadsdk.j.d.a
        public void a(String str, String str2) {
            u.b(str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.j.d.a
        public void a(String str, String str2, Throwable th) {
            u.c(str, str2, th);
        }
    };
    public RewardDislikeDialogNew A;
    public RewardDislikeToast B;
    public c C;
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c D;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a E;
    public x F;
    public x G;
    public HomeWatcherReceiver H;
    public String K;
    public String L;
    public int M;
    public int N;
    public String O;
    public int Q;
    public int T;

    /* renamed from: a  reason: collision with root package name */
    public View f27199a;
    public String aE;
    public boolean aF;
    public boolean aG;
    public String aH;
    public String aI;
    public p aJ;
    public int aK;
    public long aL;
    public View aM;
    public boolean aN;
    public boolean aO;
    public com.bytedance.sdk.openadsdk.g.a aP;
    public e aQ;
    public com.bytedance.sdk.openadsdk.g.d aR;
    public int aS;
    public ProgressBar aT;
    public com.bytedance.sdk.openadsdk.core.a.e aU;
    public boolean aV;
    public boolean aW;
    public boolean aX;
    public final AtomicBoolean aY;
    public long aZ;
    public com.bytedance.sdk.openadsdk.core.widget.c ab;
    public IListenerManager ae;
    public String af;
    public LinearLayout aj;
    public TTRoundRectImageView ak;
    public TextView al;
    public TTRatingBar am;
    public TextView an;
    public TextView ao;
    public g au;
    public boolean av;
    public TextView aw;

    /* renamed from: b  reason: collision with root package name */
    public PlayableLoadingView f27200b;
    public long ba;
    public long bb;
    public long bc;
    public long bd;
    public long be;
    public com.bytedance.sdk.openadsdk.j.e bf;
    public boolean bh;
    public AtomicBoolean bi;
    public View.OnClickListener bj;

    /* renamed from: c  reason: collision with root package name */
    public TopProxyLayout f27201c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f27202d;

    /* renamed from: e  reason: collision with root package name */
    public Context f27203e;

    /* renamed from: f  reason: collision with root package name */
    public SSWebView f27204f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<SSWebView> f27205g;

    /* renamed from: h  reason: collision with root package name */
    public SSWebView f27206h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f27207i;
    public RelativeLayout j;
    public TTRoundRectImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public FrameLayout o;
    public FrameLayout p;
    public FrameLayout q;
    public TTRatingBar r;
    public l s;
    public j t;
    public String u;
    public long w;
    public String x;
    public int y;
    public boolean v = true;
    public boolean z = false;
    public final am I = new am(Looper.getMainLooper(), this);
    public final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> J = Collections.synchronizedMap(new HashMap());
    public boolean P = false;
    public int R = 5;
    public int S = 3;
    public final AtomicBoolean U = new AtomicBoolean(false);
    public final AtomicBoolean V = new AtomicBoolean(false);
    public final AtomicBoolean W = new AtomicBoolean(false);
    public final AtomicBoolean X = new AtomicBoolean(false);
    public final AtomicBoolean Y = new AtomicBoolean(false);
    public final AtomicBoolean Z = new AtomicBoolean(false);
    public final AtomicBoolean aa = new AtomicBoolean(false);
    public final String ac = Build.MODEL;
    public boolean ag = false;
    public boolean ah = false;
    public int ai = 0;
    public AtomicBoolean ap = new AtomicBoolean(true);
    public boolean aq = false;
    public int ar = 0;
    public String as = "";
    public int at = 7;
    public long ax = 0;
    public int ay = 0;
    public long az = 0;
    public long aA = 0;
    public int aB = 0;
    public int aC = 0;
    public AtomicBoolean aD = new AtomicBoolean(false);

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public int f27244b;

        /* renamed from: c  reason: collision with root package name */
        public int f27245c;

        /* renamed from: d  reason: collision with root package name */
        public int f27246d;

        /* renamed from: e  reason: collision with root package name */
        public int f27247e;

        /* renamed from: f  reason: collision with root package name */
        public long f27248f;

        /* renamed from: g  reason: collision with root package name */
        public long f27249g;

        public a(int i2, int i3, int i4, int i5) {
            this.f27244b = i2;
            this.f27245c = i3;
            this.f27246d = i4;
            this.f27247e = i5;
        }

        public void a(long j) {
            this.f27248f = j;
        }
    }

    public TTBaseVideoActivity() {
        this.aE = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.aF = false;
        this.aG = true;
        this.aW = false;
        this.aH = "video_player";
        this.aI = "";
        this.aK = 0;
        this.aX = false;
        this.aY = new AtomicBoolean(false);
        this.aZ = 0L;
        this.ba = 0L;
        this.bb = 0L;
        this.bc = 0L;
        this.bd = 0L;
        this.be = 0L;
        this.bh = true;
        this.bi = new AtomicBoolean(false);
        this.aM = null;
        this.bj = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTBaseVideoActivity.this.a(view);
                TTBaseVideoActivity.this.b(view, 0, 0, 0, 0);
            }
        };
        this.aN = false;
        this.aO = false;
        this.aP = new com.bytedance.sdk.openadsdk.g.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.17
            @Override // com.bytedance.sdk.openadsdk.g.a
            public int a() {
                SSWebView sSWebView = TTBaseVideoActivity.this.f27204f;
                int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
                u.c("TTAndroidObject", "mWebView>>>>height=" + measuredHeight);
                return measuredHeight <= 0 ? al.d(TTBaseVideoActivity.this.f27203e) : measuredHeight;
            }

            @Override // com.bytedance.sdk.openadsdk.g.a
            public int b() {
                SSWebView sSWebView = TTBaseVideoActivity.this.f27204f;
                int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
                u.c("TTAndroidObject", "mWebView>>>>width=" + measuredWidth);
                return measuredWidth <= 0 ? al.c(TTBaseVideoActivity.this.f27203e) : measuredWidth;
            }
        };
        this.aQ = new e() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.18
            @Override // com.bytedance.sdk.openadsdk.g.e
            public void a() {
                TTBaseVideoActivity.this.ab();
            }
        };
        this.aR = new com.bytedance.sdk.openadsdk.g.d() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.19
            @Override // com.bytedance.sdk.openadsdk.g.d
            public void a() {
                l lVar;
                if (TTBaseVideoActivity.this.isFinishing()) {
                    return;
                }
                l lVar2 = TTBaseVideoActivity.this.s;
                if ((lVar2 == null || lVar2.A()) && (lVar = TTBaseVideoActivity.this.s) != null && lVar.B()) {
                    TTBaseVideoActivity.this.I.removeMessages(800);
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.I.sendMessage(tTBaseVideoActivity.d(1));
                }
            }
        };
        this.aS = -1;
    }

    private String P() {
        l lVar;
        String n = com.bytedance.sdk.openadsdk.core.p.h().n();
        u.c("Playable", "getPlayableLoadH5Url->loadH5Url=" + n);
        if (TextUtils.isEmpty(n) || (lVar = this.s) == null || lVar.an() == null) {
            return n;
        }
        String str = this.R == 15 ? "portrait" : "landscape";
        String c2 = this.s.an().c();
        int e2 = this.s.an().e();
        int f2 = this.s.an().f();
        String a2 = this.s.aa().a();
        String am = this.s.am();
        String d2 = this.s.an().d();
        String b2 = this.s.an().b();
        String c3 = this.s.an().c();
        String aj = this.s.aj();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appname=");
        stringBuffer.append(URLEncoder.encode(c2));
        stringBuffer.append("&stars=");
        stringBuffer.append(e2);
        stringBuffer.append("&comments=");
        stringBuffer.append(f2);
        stringBuffer.append("&icon=");
        stringBuffer.append(URLEncoder.encode(a2));
        stringBuffer.append("&downloading=");
        stringBuffer.append(true);
        stringBuffer.append("&id=");
        stringBuffer.append(URLEncoder.encode(am));
        stringBuffer.append("&pkg_name=");
        stringBuffer.append(URLEncoder.encode(d2));
        stringBuffer.append("&download_url=");
        stringBuffer.append(URLEncoder.encode(b2));
        stringBuffer.append("&name=");
        stringBuffer.append(URLEncoder.encode(c3));
        stringBuffer.append("&orientation=");
        stringBuffer.append(str);
        stringBuffer.append("&apptitle=");
        stringBuffer.append(URLEncoder.encode(aj));
        String str2 = n + "?" + stringBuffer.toString();
        u.c("Playable", "Playable-loadH5Url=" + str2);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        SSWebView sSWebView;
        if (this.bi.getAndSet(true) || (sSWebView = this.f27204f) == null || this.f27206h == null) {
            return;
        }
        al.a((View) sSWebView, 0);
        al.a((View) this.f27206h, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R() {
        return this.aB == this.aC ? 900 : 950;
    }

    private void S() {
        this.aj = (LinearLayout) findViewById(ad.e(this, "tt_reward_full_endcard_backup"));
        this.ak = (TTRoundRectImageView) findViewById(ad.e(this, "tt_reward_ad_icon_backup"));
        this.al = (TextView) findViewById(ad.e(this, "tt_reward_ad_appname_backup"));
        this.am = (TTRatingBar) findViewById(ad.e(this, "tt_rb_score_backup"));
        this.an = (TextView) findViewById(ad.e(this, "tt_comment_backup"));
        this.ao = (TextView) findViewById(ad.e(this, "tt_reward_ad_download_backup"));
        TTRatingBar tTRatingBar = this.am;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.am.setStarFillNum(4);
            this.am.setStarImageWidth(al.c(this, 16.0f));
            this.am.setStarImageHeight(al.c(this, 16.0f));
            this.am.setStarImagePadding(al.c(this, 4.0f));
            this.am.a();
        }
    }

    private void T() {
        l lVar = this.s;
        if (lVar == null) {
            return;
        }
        int d2 = ak.d(lVar.ap());
        com.bytedance.sdk.openadsdk.h.a.c f2 = com.bytedance.sdk.openadsdk.h.a.c.b().a(this.at).c(String.valueOf(d2)).f(ak.h(this.s.ap()));
        f2.b(this.ar).g(this.as);
        f2.h(this.s.ap()).d(this.s.am());
        com.bytedance.sdk.openadsdk.h.a.a().l(f2);
    }

    private void V() {
        if (this.bf != null) {
            return;
        }
        if (i.d().w()) {
            d.a(bg);
        }
        this.bf = com.bytedance.sdk.openadsdk.j.e.a(getApplicationContext(), this.f27204f, new com.bytedance.sdk.openadsdk.j.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.25
            @Override // com.bytedance.sdk.openadsdk.j.a
            public com.bytedance.sdk.openadsdk.j.b a() {
                char c2;
                String f2 = com.bytedance.sdk.openadsdk.a.a.f();
                int hashCode = f2.hashCode();
                if (hashCode == 1653) {
                    if (f2.equals("2g")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else if (hashCode == 1684) {
                    if (f2.equals("3g")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else if (hashCode == 1715) {
                    if (f2.equals("4g")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                } else if (hashCode != 1746) {
                    if (hashCode == 3649301 && f2.equals("wifi")) {
                        c2 = 4;
                    }
                    c2 = 65535;
                } else {
                    if (f2.equals("5g")) {
                        c2 = 3;
                    }
                    c2 = 65535;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 != 2) {
                            if (c2 != 3) {
                                if (c2 != 4) {
                                    return com.bytedance.sdk.openadsdk.j.b.TYPE_UNKNOWN;
                                }
                                return com.bytedance.sdk.openadsdk.j.b.TYPE_WIFI;
                            }
                            return com.bytedance.sdk.openadsdk.j.b.TYPE_5G;
                        }
                        return com.bytedance.sdk.openadsdk.j.b.TYPE_4G;
                    }
                    return com.bytedance.sdk.openadsdk.j.b.TYPE_3G;
                }
                return com.bytedance.sdk.openadsdk.j.b.TYPE_2G;
            }

            @Override // com.bytedance.sdk.openadsdk.j.a
            public void a(JSONObject jSONObject) {
            }

            @Override // com.bytedance.sdk.openadsdk.j.a
            public void b() {
                TTBaseVideoActivity.this.ab();
            }

            @Override // com.bytedance.sdk.openadsdk.j.a
            public void b(JSONObject jSONObject) {
            }

            @Override // com.bytedance.sdk.openadsdk.j.a
            public void c(JSONObject jSONObject) {
            }

            @Override // com.bytedance.sdk.openadsdk.j.a
            public void a(String str, JSONObject jSONObject) {
                TTBaseVideoActivity.this.F.a(str, jSONObject);
            }
        }).e(com.bytedance.sdk.openadsdk.a.a.a(com.bytedance.sdk.openadsdk.core.p.a())).a(com.bytedance.sdk.openadsdk.a.a.a()).a("sdkEdition", com.bytedance.sdk.openadsdk.a.a.c()).b(com.bytedance.sdk.openadsdk.a.a.e()).d(com.bytedance.sdk.openadsdk.a.a.d()).c(false).a(false);
        if (l.d(this.s)) {
            this.bf.b(true);
        } else {
            this.bf.b(false);
        }
        l lVar = this.s;
        if (lVar != null && !TextUtils.isEmpty(lVar.j())) {
            this.bf.c(this.s.j());
        }
        Set<String> j = this.bf.j();
        final WeakReference weakReference = new WeakReference(this.bf);
        for (String str : j) {
            if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str)) {
                this.F.a().a(str, (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new com.bytedance.sdk.openadsdk.f.a.e<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.26
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.f.a.e
                    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.openadsdk.f.a.f fVar) throws Exception {
                        try {
                            com.bytedance.sdk.openadsdk.j.e eVar = (com.bytedance.sdk.openadsdk.j.e) weakReference.get();
                            if (eVar == null) {
                                return null;
                            }
                            return eVar.b(a(), jSONObject);
                        } catch (Throwable unused) {
                            return null;
                        }
                    }
                });
            }
        }
    }

    private void X() {
        if (this.s.aJ()) {
            this.f27201c.setShowDislike(true);
        } else {
            this.f27201c.setShowDislike(false);
        }
    }

    private void Y() {
        this.f27201c.c();
        al.a((View) this.f27207i, 0);
        al.a((View) this.j, 0);
    }

    private void Z() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        if (cVar == null || cVar.u() == null) {
            return;
        }
        this.w = this.D.n();
        if (this.D.u().h() || !this.D.u().l()) {
            this.D.h();
            this.D.l();
            this.aO = true;
        }
    }

    private void aa() {
        TopProxyLayout topProxyLayout = this.f27201c;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSound(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006c, code lost:
        if (r12.F.e() != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002c, code lost:
        if (((1.0d - (r12.Q / L())) * 100.0d) >= r0) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ab() {
        int i2 = com.bytedance.sdk.openadsdk.core.p.h().q(String.valueOf(this.T)).f28304f;
        boolean z = true;
        boolean z2 = false;
        if (!l.e(this.s)) {
            boolean z3 = (1.0f - (((float) this.ay) / ((float) com.bytedance.sdk.openadsdk.core.p.h().o(String.valueOf(this.T))))) * 100.0f >= ((float) i2);
            int m = com.bytedance.sdk.openadsdk.core.p.h().m(String.valueOf(this.T));
            if (m == 0) {
                if (z3) {
                }
                z = false;
                z2 = z;
            } else if (m == 1) {
                z2 = z3;
            }
        }
        if (z2) {
            f(10000);
        }
    }

    private void ac() {
        if ("".equals(this.aI) || this.aI.isEmpty() || v()) {
            return;
        }
        if (!this.aI.contains("playable") && !l.d(this.s)) {
            if (this.aI.contains("endcard")) {
                this.aH = "endcard";
                return;
            } else if (this.s.C() && this.aH.equals("endcard")) {
                this.aH = "playable";
                return;
            } else {
                return;
            }
        }
        this.aH = "playable";
    }

    private void ad() {
        this.B.a("您已成功提交反馈，请勿重复提交哦！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae() {
        this.B.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
    }

    public JSONObject A() {
        long j;
        int i2;
        try {
            if (this.D != null) {
                j = this.D.q();
                i2 = this.D.r();
            } else {
                j = 0;
                i2 = 0;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", j);
                jSONObject.put(SapiOptions.KEY_CACHE_PERCENT, i2);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public String B() {
        l lVar = this.s;
        if (lVar == null) {
            return "立即下载";
        }
        if (TextUtils.isEmpty(lVar.al())) {
            return this.s.Z() != 4 ? "查看详情" : "立即下载";
        }
        return this.s.al();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(1:3)|4|5|6|(2:10|(7:12|13|14|15|(1:18)|19|(1:21)(4:23|(2:25|(1:(1:28)(1:(1:30))))(2:36|(1:(1:(1:52)(1:(1:54))))(1:(1:43)(1:(1:45))))|(1:34)|35)))|59|13|14|15|(1:18)|19|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String C() {
        boolean z;
        String str;
        l lVar;
        String b2 = ak.b(this);
        if (b2 == null) {
            b2 = "";
        }
        try {
        } catch (Throwable unused) {
            z = true;
        }
        if (!b2.equals(Locale.CHINESE.getLanguage()) && !b2.equals(Locale.CHINA.getLanguage())) {
            if (!b2.equals(Locale.TRADITIONAL_CHINESE.getLanguage())) {
                z = false;
                boolean z2 = b2.equals(Locale.ENGLISH.getLanguage());
                str = "下载";
                if (!z && z2) {
                    str = "Install";
                }
                lVar = this.s;
                if (lVar == null) {
                    return str;
                }
                if (TextUtils.isEmpty(lVar.al())) {
                    if (this.s.Z() != 4) {
                        if (z) {
                            str = "查看";
                        } else if (z2) {
                            str = "View";
                        }
                    }
                } else {
                    str = this.s.al();
                    if (str == null || !ak.j(str) || str.length() <= 2) {
                        if (str != null && !ak.j(str) && str.length() > 7) {
                            if (z) {
                                str = g(true);
                            } else if (z2) {
                                str = g(false);
                            }
                        }
                    } else if (z) {
                        str = g(true);
                    } else if (z2) {
                        str = g(false);
                    }
                }
                if (z2 && !ak.j(str)) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                    layoutParams.bottomMargin = al.c(this, 4.0f);
                    this.n.setLayoutParams(layoutParams);
                }
                return str;
            }
        }
        z = true;
        boolean z22 = b2.equals(Locale.ENGLISH.getLanguage());
        str = "下载";
        if (!z) {
            str = "Install";
        }
        lVar = this.s;
        if (lVar == null) {
        }
    }

    public void D() {
        if (this.ah) {
            int[] iArr = {Color.parseColor("#0070FF")};
            com.bytedance.sdk.openadsdk.core.widget.f.a((LinearLayout) findViewById(ad.e(this, "tt_reward_ad_download_layout")), new f.a().a(iArr[0]).b(Color.parseColor("#80000000")).a(iArr).c(al.c(this, 17.0f)).d(0).e(al.c(this, 3.0f)));
        }
    }

    public void E() {
        if (this.C == null) {
            c cVar = new c(this, this.s);
            this.C = cVar;
            cVar.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.11
                @Override // com.bytedance.sdk.openadsdk.dislike.c.a
                public void a() {
                    TTBaseVideoActivity.this.Y.set(true);
                    if (TTBaseVideoActivity.this.v()) {
                        TTBaseVideoActivity.this.D.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.c.a
                public void b() {
                    try {
                        TTBaseVideoActivity.this.Y.set(false);
                        if (!TTBaseVideoActivity.this.Z.get()) {
                            TTBaseVideoActivity.this.A.a();
                        } else {
                            TTBaseVideoActivity.this.A.a(true);
                            if (TTBaseVideoActivity.this.w()) {
                                TTBaseVideoActivity.this.D.k();
                            }
                        }
                    } catch (Throwable th) {
                        u.c("TTBaseVideoActivity", "dislike callback selected error: ", th);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.c.a
                public void a(int i2, FilterWord filterWord) {
                    try {
                        if (!TTBaseVideoActivity.this.Z.get()) {
                            TTBaseVideoActivity.this.Z.set(true);
                            TTBaseVideoActivity.this.ae();
                        }
                        if (TTBaseVideoActivity.this.w()) {
                            TTBaseVideoActivity.this.D.k();
                        }
                    } catch (Throwable th) {
                        u.c("TTBaseVideoActivity", "comment callback selected error: ", th);
                    }
                }
            });
        }
        if (this.A == null) {
            RewardDislikeDialogNew rewardDislikeDialogNew = new RewardDislikeDialogNew(this, this.s, this.aE);
            this.A = rewardDislikeDialogNew;
            rewardDislikeDialogNew.setCallback(new RewardDislikeDialogNew.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.13
                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.a
                public void a(View view) {
                    TTBaseVideoActivity.this.Y.set(true);
                    if (TTBaseVideoActivity.this.v()) {
                        TTBaseVideoActivity.this.D.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.a
                public void b(View view) {
                    TTBaseVideoActivity.this.Y.set(false);
                    if (TTBaseVideoActivity.this.w()) {
                        TTBaseVideoActivity.this.D.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.a
                public void a(int i2, FilterWord filterWord) {
                    if (TTBaseVideoActivity.this.Z.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    TTBaseVideoActivity.this.Z.set(true);
                    TTBaseVideoActivity.this.ae();
                    TTBaseVideoActivity.this.C.hide();
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.a
                public void a() {
                    TTBaseVideoActivity.this.C.show();
                    TTBaseVideoActivity.this.Y.set(true);
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.A);
        }
        if (this.B == null) {
            this.B = new RewardDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.B);
        }
    }

    public void F() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        if (this.V.getAndSet(false) || (cVar = this.D) == null) {
            return;
        }
        if (cVar.u() != null) {
            com.bytedance.sdk.openadsdk.core.video.d.d u = this.D.u();
            if (u.i() || u.j()) {
                ((com.bytedance.sdk.openadsdk.core.video.c.a) this.D).y();
                a(this.w, true);
            }
        } else if (this.aO) {
            ((com.bytedance.sdk.openadsdk.core.video.c.a) this.D).y();
            a(this.w, true);
            this.aO = false;
        }
    }

    public void G() {
        am amVar = this.I;
        if (amVar != null) {
            amVar.removeMessages(900);
            this.I.removeMessages(950);
            this.I.removeMessages(600);
        }
    }

    public void H() {
        if (this.I != null) {
            Message obtain = Message.obtain();
            obtain.what = R();
            obtain.arg1 = this.ay;
            this.I.sendMessageDelayed(obtain, 1000L);
        }
    }

    public void I() {
        this.Y.set(false);
        this.Z.set(false);
        c cVar = this.C;
        if (cVar != null) {
            cVar.a();
        }
        TopProxyLayout topProxyLayout = this.f27201c;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSkip(false);
            this.f27201c.setShowCountDown(false);
            X();
            this.f27201c.setShowSound(l.b(this.s));
            if (((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) && l.b(this.s)) {
                this.f27201c.setShowSound(true);
                this.f27201c.setShowSkip(true);
            }
        }
        c();
        RewardDislikeToast rewardDislikeToast = this.B;
        if (rewardDislikeToast != null) {
            rewardDislikeToast.a();
        }
        if (this.U.getAndSet(true)) {
            return;
        }
        this.X.set(true);
        if (!l.a(this.s, this.ap.get(), this.aq) && !l.b(this.s)) {
            u.b("TTBaseVideoActivity", "showEndcardForSkip isEndCardLoadSuc=" + this.aq + " so load back up end card");
            if (this.aJ != null) {
                if (!l.g(this.s)) {
                    u.b("TTBaseVideoActivity", "TimeTrackLog report 408 from backup page after skip");
                    this.aJ.a(408, "end_card_timeout");
                }
                this.aJ.c();
                this.aJ.d();
            }
            al.a((View) this.f27204f, 8);
            al.a((View) this.aj, 0);
            Y();
            aa();
            T();
            if ((this instanceof TTFullScreenVideoActivity) && this.D != null && v() && this.X.get()) {
                this.D.j();
                this.D.m();
                return;
            }
            return;
        }
        if (this.aJ != null && !l.g(this.s) && !l.b(this.s)) {
            u.b("TTBaseVideoActivity", "TimeTrackLog report Success from Android after skip");
            this.aJ.b();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            al.a((View) this.f27204f, 0.0f);
            al.a((View) this.f27207i, 0.0f);
            al.a((View) this.j, 0.0f);
        }
        al.a((View) this.f27204f, 0);
        l lVar = this.s;
        if (lVar != null && lVar.C()) {
            int p = com.bytedance.sdk.openadsdk.core.p.h().p(String.valueOf(this.T));
            if (p == -1) {
                Y();
            } else if (p >= 0) {
                this.I.sendEmptyMessageDelayed(600, p);
            }
        } else {
            l lVar2 = this.s;
            if (lVar2 != null && !lVar2.C()) {
                int l = com.bytedance.sdk.openadsdk.core.p.h().l(String.valueOf(this.T));
                if (l == -1) {
                    Y();
                } else if (l >= 0) {
                    this.I.sendEmptyMessageDelayed(600, l);
                }
            }
        }
        this.I.sendEmptyMessageDelayed(500, 100L);
        a(this.P, true);
        x xVar = this.F;
        if (xVar != null) {
            xVar.b(true);
            b(true);
        }
        p();
        com.bytedance.sdk.openadsdk.j.e eVar = this.bf;
        if (eVar != null) {
            eVar.b(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver.a
    public void J() {
        this.aF = true;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver.a
    public void K() {
        this.aF = true;
    }

    public double L() {
        l lVar = this.s;
        if (lVar == null || lVar.X() == null) {
            return 0.0d;
        }
        return this.s.X().e();
    }

    public void M() {
        if (isFinishing()) {
            return;
        }
        if (this.Z.get()) {
            ad();
            return;
        }
        if (this.A == null) {
            E();
        }
        ac();
        this.A.a(this.aH);
        this.A.a();
    }

    public void N() {
        am amVar = this.I;
        if (amVar != null) {
            amVar.removeMessages(400);
        }
    }

    public void O() {
        if (Build.VERSION.SDK_INT < 26 && !"C8817D".equals(this.ac) && !"M5".equals(this.ac) && !"R7t".equals(this.ac)) {
            if (!w() || this.Y.get()) {
                return;
            }
            this.D.k();
        } else if (this.Y.get()) {
        } else {
            F();
        }
    }

    public void m() {
        String j = this.s.X() != null ? this.s.X().j() : null;
        this.O = j;
        if (TextUtils.isEmpty(j) || this.R != 15) {
            return;
        }
        if (this.O.contains("?")) {
            this.O += "&orientation=portrait";
            return;
        }
        this.O += "?orientation=portrait";
    }

    public void n() {
        if (this.f27200b == null) {
            return;
        }
        l lVar = this.s;
        if (lVar != null && lVar.A() && this.s.D()) {
            this.f27200b.b();
            l lVar2 = this.s;
            if (lVar2 != null && lVar2.D() && this.s.B()) {
                this.I.sendMessageDelayed(d(2), 10000L);
                return;
            }
            return;
        }
        this.f27200b.a();
    }

    public void o() {
        if (this.s.C() && this.s.i() == 1) {
            TextView textView = this.aw;
            if (textView != null) {
                al.a((View) textView, 8);
                return;
            }
            return;
        }
        TextView textView2 = this.aw;
        if (textView2 != null) {
            al.a((View) textView2, 0);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        al.a((Activity) this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.15
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i2) {
                if (i2 == 0) {
                    try {
                        if (TTBaseVideoActivity.this.isFinishing()) {
                            return;
                        }
                        TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                al.a((Activity) TTBaseVideoActivity.this);
                            }
                        }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        SSWebView sSWebView;
        if (l.f(this.s) && (sSWebView = this.f27204f) != null && sSWebView.canGoBack()) {
            this.f27204f.goBack();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.aV = bundle.getBoolean("is_bar_click_first");
        }
        super.onCreate(bundle);
        try {
            this.aK = al.b(getApplicationContext(), al.i(getApplicationContext()));
        } catch (Throwable unused) {
        }
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.p.a(this);
        } catch (Throwable unused3) {
        }
        if (bundle != null && bundle.getLong("video_current") > 0) {
            this.w = bundle.getLong("video_current", 0L);
        }
        this.f27203e = this;
        g gVar = new g(getApplicationContext());
        this.au = gVar;
        gVar.a(this);
        this.aS = this.au.g();
        u.b("onVolumeChanged", "onCreate >>>>>> mVolume = " + this.aS);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        p pVar = this.aJ;
        if (pVar != null) {
            pVar.a(true);
            this.aJ.m();
        }
        RewardDislikeToast rewardDislikeToast = this.B;
        if (rewardDislikeToast != null) {
            rewardDislikeToast.b();
        }
        am amVar = this.I;
        if (amVar != null) {
            amVar.removeCallbacksAndMessages(null);
        }
        aa.a(this.f27203e, this.f27204f);
        aa.a(this.f27204f);
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        if (cVar != null) {
            cVar.l();
            this.D = null;
        }
        this.f27204f = null;
        x xVar = this.F;
        if (xVar != null) {
            xVar.o();
        }
        this.aY.set(true);
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.E;
        if (aVar != null) {
            aVar.d();
        }
        j jVar = this.t;
        if (jVar != null) {
            jVar.d();
        }
        g gVar = this.au;
        if (gVar != null) {
            gVar.f();
            this.au.a((com.bytedance.sdk.openadsdk.g.f) null);
        }
        b(getApplicationContext());
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            try {
                a("recycleRes", 0L, 0L, "", "");
            } catch (Throwable th) {
                u.c("TTBaseVideoActivity", "remove from ITTAppDownloadListener throw Exception : ", th);
            }
        }
        com.bytedance.sdk.openadsdk.j.e eVar = this.bf;
        if (eVar != null) {
            eVar.r();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.aW = false;
        u.b("TTBaseVideoActivity", "onPause mIsActivityShow=" + this.aW + " mIsMute=" + this.P);
        SSWebView sSWebView = this.f27204f;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        if (Build.VERSION.SDK_INT < 26 && !"C8817D".equals(this.ac) && !"M5".equals(this.ac) && !"R7t".equals(this.ac)) {
            try {
                if (v() && !this.Y.get()) {
                    this.D.h();
                }
            } catch (Throwable th) {
                u.f("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
            }
        } else if (!this.Y.get()) {
            Z();
        }
        x xVar = this.F;
        if (xVar != null) {
            xVar.n();
            this.F.b(false);
            b(false);
            a(true, false);
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        l lVar = this.s;
        if (lVar != null && lVar.i() == 1 && this.s.C()) {
            this.I.removeMessages(950);
            this.I.removeMessages(900);
            this.I.removeMessages(600);
            d("go_background");
        }
        com.bytedance.sdk.openadsdk.j.e eVar = this.bf;
        if (eVar != null) {
            eVar.p();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        l lVar;
        this.aW = true;
        u.b("TTBaseVideoActivity", "onResume mIsActivityShow=" + this.aW + " mIsMute=" + this.P);
        if (this.f27201c != null && this.U.get()) {
            X();
        }
        if (l.d(this.s) || l.e(this.s)) {
            if (this.aS == 0) {
                this.P = true;
            }
            if (this.P) {
                this.au.a(true);
                a(true);
            }
        }
        if (this.R == 15) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        super.onResume();
        SSWebView sSWebView = this.f27204f;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        g gVar = this.au;
        if (gVar != null) {
            gVar.a(this);
            this.au.e();
        }
        if (!this.U.get() && !this.aN) {
            O();
        }
        x xVar = this.F;
        if (xVar != null) {
            xVar.m();
            SSWebView sSWebView2 = this.f27204f;
            if (sSWebView2 != null) {
                if (sSWebView2.getVisibility() == 0) {
                    this.F.b(true);
                    b(true);
                    a(false, true);
                } else {
                    this.F.b(false);
                    b(false);
                    a(true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.E;
        if (aVar != null) {
            aVar.a(this);
            this.E.b();
        }
        j jVar = this.t;
        if (jVar != null) {
            jVar.b();
        }
        if (this.aD.get() && (lVar = this.s) != null && lVar.i() == 1 && this.s.C()) {
            d("return_foreground");
            com.bytedance.sdk.openadsdk.core.widget.c cVar = this.ab;
            if ((cVar == null || (cVar != null && !cVar.isShowing())) && this.ay > 0) {
                Message obtain = Message.obtain();
                obtain.what = R();
                obtain.arg1 = this.ay;
                this.I.sendMessage(obtain);
            }
        }
        if (this.bf == null || !this.U.get()) {
            return;
        }
        this.bf.q();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("material_meta", this.s != null ? this.s.aL().toString() : null);
            bundle.putString("multi_process_meta_md5", this.u);
            bundle.putLong("video_current", this.D == null ? this.w : this.D.n());
            bundle.putString("video_cache_url", this.x);
            bundle.putInt("orientation", this.y);
            bundle.putBoolean("is_mute", this.P);
            bundle.putBoolean("is_bar_click_first", this.aV);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        p pVar = this.aJ;
        if (pVar != null) {
            pVar.k();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        u.b("TTBaseVideoActivity", "onStop mIsMute=" + this.P + " mLast=" + this.au.b() + " mVolume=" + this.aS);
        p pVar = this.aJ;
        if (pVar != null) {
            pVar.j();
        }
        j jVar = this.t;
        if (jVar != null) {
            jVar.c();
        }
        l lVar = this.s;
        if (lVar != null && lVar.i() == 1 && this.s.C()) {
            this.I.removeMessages(950);
            this.I.removeMessages(900);
            this.I.removeMessages(600);
            d("go_background");
        }
        if (this.P) {
            runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    if (TTBaseVideoActivity.this.au.b() > 0) {
                        TTBaseVideoActivity.this.au.a(false);
                    }
                }
            });
        }
    }

    public void p() {
        TextView textView = this.aw;
        if (textView != null) {
            al.a((View) textView, 8);
        }
    }

    public void q() {
        String str;
        if (this.ak != null) {
            if (this.s.aa() != null && !TextUtils.isEmpty(this.s.aa().a())) {
                com.bytedance.sdk.openadsdk.i.e.c().a(this.s.aa().a(), this.ak);
            } else {
                this.ak.setImageResource(ad.d(this, "tt_ad_logo_small"));
            }
        }
        if (this.al != null) {
            if (this.s.an() != null && !TextUtils.isEmpty(this.s.an().c())) {
                this.al.setText(this.s.an().c());
            } else {
                this.al.setText(this.s.aj());
            }
        }
        if (this.an != null) {
            int f2 = this.s.an() != null ? this.s.an().f() : 6870;
            String a2 = ad.a(this, "tt_comment_num_backup");
            if (f2 > 10000) {
                str = (f2 / 10000) + "万";
            } else {
                str = f2 + "";
            }
            this.an.setText(String.format(a2, str));
        }
        TextView textView = this.ao;
        if (textView != null) {
            textView.setText(B());
        }
    }

    public void r() {
        if (this.f27202d == null) {
            return;
        }
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe ofFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f27202d, PropertyValuesHolder.ofKeyframe("scaleX", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6), PropertyValuesHolder.ofKeyframe("scaleY", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6));
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.start();
    }

    public abstract p s();

    public void t() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        this.aJ = s();
        x xVar = new x(this.f27203e);
        this.F = xVar;
        xVar.b(this.f27204f).a(this.s).b(this.K).a(this.j).c(this.L).a(this.M).a(this.av).a(this.aP).a(this.aQ).a(this.aR).d(ak.i(this.s)).a(this.f27204f).a(this.aJ).a(hashMap);
        if (l.b(this.s)) {
            V();
        }
        x xVar2 = new x(this);
        this.G = xVar2;
        xVar2.b(this.f27206h).a(this.s).b(this.K).c(this.L).a(this.M).a(this.f27206h).a(this.aJ).d(ak.i(this.s));
        this.F.a(new com.bytedance.sdk.openadsdk.g.b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.g.b
            public void a(boolean z, int i2, String str) {
                u.b("end card load finish: ", "code=" + i2 + " msg=" + str + " isRenderSuc=" + z);
                if (z) {
                    TTBaseVideoActivity.this.aq = true;
                }
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                if (tTBaseVideoActivity.aJ == null || !l.g(tTBaseVideoActivity.s) || l.b(TTBaseVideoActivity.this.s)) {
                    return;
                }
                u.b("TTBaseVideoActivity", "TimeTrackLog report from js " + z);
                if (z) {
                    TTBaseVideoActivity.this.aJ.b();
                } else {
                    TTBaseVideoActivity.this.aJ.a(i2, str);
                }
            }
        });
        this.F.a(new h() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.3
            @Override // com.bytedance.sdk.openadsdk.g.h
            public void a() {
                SSWebView sSWebView = TTBaseVideoActivity.this.f27205g.get();
                if (sSWebView == null) {
                    u.b("TTBaseVideoActivity", "webView has destroy when onPauseWebView");
                    return;
                }
                sSWebView.onPause();
                u.b("TTBaseVideoActivity", "js make webView onPause OK");
            }

            @Override // com.bytedance.sdk.openadsdk.g.h
            public void b() {
                SSWebView sSWebView = TTBaseVideoActivity.this.f27205g.get();
                if (sSWebView == null) {
                    u.b("TTBaseVideoActivity", "webView has destroy when onPauseWebViewTimers");
                    return;
                }
                sSWebView.pauseTimers();
                u.b("TTBaseVideoActivity", "js make webView pauseTimers OK");
            }
        });
    }

    public void u() {
        if ((Build.VERSION.SDK_INT < 17 || !isDestroyed()) && !isFinishing()) {
            p pVar = this.aJ;
            if (pVar != null) {
                pVar.h();
            }
            this.aH = "endcard";
            this.Y.set(false);
            this.Z.set(false);
            c cVar = this.C;
            if (cVar != null) {
                cVar.a();
            }
            c();
            com.bytedance.sdk.openadsdk.core.widget.c cVar2 = this.ab;
            if (cVar2 != null && cVar2.isShowing()) {
                this.ab.dismiss();
            }
            RewardDislikeToast rewardDislikeToast = this.B;
            if (rewardDislikeToast != null) {
                rewardDislikeToast.a();
            }
            if (this.f27201c != null) {
                if (l.d(this.s)) {
                    this.f27201c.setShowSkip(true);
                } else {
                    this.f27201c.setShowSkip(false);
                }
                X();
                if (((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) && l.b(this.s)) {
                    this.f27201c.setShowSound(true);
                }
            }
            if (this.U.getAndSet(true)) {
                return;
            }
            if (!l.a(this.s, this.ap.get(), this.aq) && !l.b(this.s)) {
                u.b("TTBaseVideoActivity", "isEndCardLoadSuc=" + this.aq + " so load back up end card");
                if (this.aJ != null) {
                    if (!l.g(this.s)) {
                        u.b("TTBaseVideoActivity", "TimeTrackLog report 408 from backup page");
                        this.aJ.a(408, "end_card_timeout");
                    }
                    this.aJ.c();
                    this.aJ.d();
                }
                al.a((View) this.f27204f, 8);
                al.a((View) this.aj, 0);
                Y();
                aa();
                T();
                return;
            }
            if (this.aJ != null && !l.g(this.s) && !l.b(this.s)) {
                u.b("TTBaseVideoActivity", "TimeTrackLog report Success from Android");
                this.aJ.b();
            }
            al.a((View) this.f27204f, 0.0f);
            al.a((View) this.f27207i, 0.0f);
            al.a((View) this.j, 0.0f);
            al.a((View) this.f27204f, 0);
            l lVar = this.s;
            if (lVar != null && lVar.C()) {
                boolean z = this instanceof TTRewardVideoActivity;
                int p = com.bytedance.sdk.openadsdk.core.p.h().p(String.valueOf(this.T));
                if (this.s.i() == 1) {
                    p = (com.bytedance.sdk.openadsdk.core.p.h().o(String.valueOf(this.T)) + 1) * 1000;
                }
                if (p == -1) {
                    Y();
                } else if (p >= 0) {
                    this.I.sendEmptyMessageDelayed(600, p);
                }
            } else {
                l lVar2 = this.s;
                if (lVar2 != null && !lVar2.C()) {
                    int l = com.bytedance.sdk.openadsdk.core.p.h().l(String.valueOf(this.T));
                    if (l == -1) {
                        Y();
                    } else if (l >= 0) {
                        this.I.sendEmptyMessageDelayed(600, l);
                    }
                }
            }
            this.I.sendEmptyMessageDelayed(500, 20L);
            a(this.P, true);
            b(true);
            p();
            x xVar = this.F;
            if (xVar != null) {
                xVar.b(true);
            }
            com.bytedance.sdk.openadsdk.j.e eVar = this.bf;
            if (eVar != null) {
                eVar.b(true);
            }
        }
    }

    public boolean v() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        return (cVar == null || cVar.u() == null || !this.D.u().g()) ? false : true;
    }

    public boolean w() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        return (cVar == null || cVar.u() == null || !this.D.u().i()) ? false : true;
    }

    public boolean x() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        return cVar != null && cVar.x();
    }

    public boolean y() {
        l lVar = this.s;
        return lVar != null && lVar.I() == 1;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void z() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        l lVar;
        l lVar2;
        if (this.s == null) {
            return;
        }
        final String str = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
        com.bytedance.sdk.openadsdk.core.a.e eVar = new com.bytedance.sdk.openadsdk.core.a.e(this, this.s, str, this.M) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.a.e
            public void a_(View view, int i2, int i3, int i4, int i5) {
                TTBaseVideoActivity.this.a(view, i2, i3, i4, i5);
                TTBaseVideoActivity.this.aV = view.getId() == ad.e(TTBaseVideoActivity.this, "tt_video_reward_bar");
                TTBaseVideoActivity.this.aM = view;
                if (view.getId() == ad.e(TTBaseVideoActivity.this, "tt_playable_play") && TTBaseVideoActivity.this.s.D()) {
                    HashMap hashMap = new HashMap();
                    if (TTBaseVideoActivity.this.s.X() != null) {
                        hashMap.put("playable_url", TTBaseVideoActivity.this.s.X().j());
                    }
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    com.bytedance.sdk.openadsdk.c.d.k(tTBaseVideoActivity, tTBaseVideoActivity.s, str, "click_playable_download_button_loading", hashMap);
                }
                TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                if (tTBaseVideoActivity2.E == null) {
                    tTBaseVideoActivity2.a(view);
                } else if (view.getId() == ad.e(TTBaseVideoActivity.this, "tt_rb_score")) {
                    TTBaseVideoActivity.this.a("click_play_star_level", (JSONObject) null);
                } else if (view.getId() == ad.e(TTBaseVideoActivity.this, "tt_comment_vertical")) {
                    TTBaseVideoActivity.this.a("click_play_star_nums", (JSONObject) null);
                } else if (view.getId() == ad.e(TTBaseVideoActivity.this, "tt_reward_ad_appname")) {
                    TTBaseVideoActivity.this.a("click_play_source", (JSONObject) null);
                } else if (view.getId() == ad.e(TTBaseVideoActivity.this, "tt_reward_ad_icon")) {
                    TTBaseVideoActivity.this.a("click_play_logo", (JSONObject) null);
                }
            }
        };
        this.aU = eVar;
        eVar.a(this.f27202d);
        if (!TextUtils.isEmpty(this.af)) {
            HashMap hashMap = new HashMap();
            hashMap.put("rit_scene", this.af);
            this.aU.a(hashMap);
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.E;
        if (aVar != null) {
            this.aU.a(aVar);
            this.E.a(1, new a.InterfaceC0308a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.5
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a.InterfaceC0308a
                public boolean a(int i2, l lVar3, String str2, String str3, Object obj) {
                    if (i2 == 1 && lVar3 != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        if (str2.equals("rewarded_video") && str3.equals("click_start")) {
                            TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                            tTBaseVideoActivity.a(tTBaseVideoActivity.aM);
                            TTBaseVideoActivity.this.aM = null;
                            return true;
                        } else if (str2.equals("fullscreen_interstitial_ad") && str3.equals("click_start")) {
                            TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                            tTBaseVideoActivity2.a(tTBaseVideoActivity2.aM);
                            TTBaseVideoActivity.this.aM = null;
                            return true;
                        } else {
                            if (!str2.equals("fullscreen_interstitial_ad") && !str2.equals("rewarded_video")) {
                                if (str2.equals("rewarded_video_landingpage") && "click_open".equals(str3) && TTBaseVideoActivity.this.s.C() && TTBaseVideoActivity.this.s.i() == 1) {
                                    TTBaseVideoActivity tTBaseVideoActivity3 = TTBaseVideoActivity.this;
                                    com.bytedance.sdk.openadsdk.c.d.i(tTBaseVideoActivity3.f27203e, tTBaseVideoActivity3.s, str2, "click_play_open", null);
                                    return true;
                                }
                            } else {
                                char c2 = 65535;
                                int hashCode = str3.hashCode();
                                if (hashCode != -1297985154) {
                                    if (hashCode != -777040223) {
                                        if (hashCode == 1682049151 && str3.equals("click_pause")) {
                                            c2 = 0;
                                        }
                                    } else if (str3.equals("click_open")) {
                                        c2 = 2;
                                    }
                                } else if (str3.equals("click_continue")) {
                                    c2 = 1;
                                }
                                if (c2 == 0) {
                                    TTBaseVideoActivity tTBaseVideoActivity4 = TTBaseVideoActivity.this;
                                    com.bytedance.sdk.openadsdk.c.d.a(tTBaseVideoActivity4, tTBaseVideoActivity4.s, str2, "click_play_pause", (Map<String, Object>) null);
                                } else if (c2 == 1) {
                                    TTBaseVideoActivity tTBaseVideoActivity5 = TTBaseVideoActivity.this;
                                    com.bytedance.sdk.openadsdk.c.d.a(tTBaseVideoActivity5, tTBaseVideoActivity5.s, str2, "click_play_continue", (Map<String, Object>) null);
                                    return true;
                                } else if (c2 == 2) {
                                    TTBaseVideoActivity tTBaseVideoActivity6 = TTBaseVideoActivity.this;
                                    com.bytedance.sdk.openadsdk.c.d.i(tTBaseVideoActivity6.f27203e, tTBaseVideoActivity6.s, str2, "click_play_open", null);
                                    return true;
                                }
                            }
                            return true;
                        }
                    }
                    return true;
                }
            });
        }
        PlayableLoadingView playableLoadingView = this.f27200b;
        if (playableLoadingView != null && playableLoadingView.getPlayView() != null && (lVar2 = this.s) != null && lVar2.D()) {
            this.f27200b.getPlayView().setOnClickListener(this.aU);
            this.f27200b.getPlayView().setOnTouchListener(this.aU);
        }
        l lVar3 = this.s;
        if (lVar3 != null && lVar3.o() != null) {
            if (this.s.o().f28022e) {
                this.n.setOnClickListener(this.aU);
                this.n.setOnTouchListener(this.aU);
            } else {
                this.n.setOnClickListener(this.bj);
            }
            if (this.ag) {
                if (this.s.o().f28018a) {
                    al.a((View) this.f27202d, (View.OnClickListener) this.aU, "TTBaseVideoActivity#mRlDownloadBar");
                    al.a((View) this.f27202d, (View.OnTouchListener) this.aU, "TTBaseVideoActivity#mRlDownloadBar");
                    this.l.setOnClickListener(this.aU);
                    this.l.setOnTouchListener(this.aU);
                    this.m.setOnClickListener(this.aU);
                    this.m.setOnTouchListener(this.aU);
                    this.r.setOnClickListener(this.aU);
                    this.r.setOnTouchListener(this.aU);
                    this.k.setOnClickListener(this.aU);
                    this.k.setOnTouchListener(this.aU);
                } else {
                    al.a(this.f27202d, this.bj, "TTBaseVideoActivity#mRlDownloadBar");
                    this.l.setOnClickListener(this.bj);
                    this.m.setOnClickListener(this.bj);
                    this.r.setOnClickListener(this.bj);
                    this.k.setOnClickListener(this.bj);
                }
            } else if (this.s.o().f28020c) {
                al.a((View) this.f27202d, (View.OnClickListener) this.aU, "TTBaseVideoActivity#mRlDownloadBar");
                al.a((View) this.f27202d, (View.OnTouchListener) this.aU, "TTBaseVideoActivity#mRlDownloadBar");
            } else {
                al.a(this.f27202d, this.bj, "TTBaseVideoActivity#mRlDownloadBar");
            }
        }
        if (this.o != null && (lVar = this.s) != null && lVar.o() != null) {
            if (this.s.o().f28023f) {
                this.o.setOnClickListener(this.aU);
            } else {
                this.o.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TTBaseVideoActivity.this.a(view);
                        TTBaseVideoActivity.this.b(view, 0, 0, 0, 0);
                    }
                });
            }
        }
        if (this.ag) {
            if (this.s.o() != null && (frameLayout2 = this.p) != null) {
                al.a((View) frameLayout2, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
                layoutParams.height = this.ai;
                this.p.setLayoutParams(layoutParams);
                if (this.s.o().f28019b) {
                    this.p.setOnClickListener(this.aU);
                    this.p.setOnTouchListener(this.aU);
                } else {
                    this.p.setOnClickListener(this.bj);
                }
            }
            if (this.s.o() != null && (frameLayout = this.q) != null) {
                al.a((View) frameLayout, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                layoutParams2.height = this.ai;
                this.q.setLayoutParams(layoutParams2);
                if (this.s.o().f28021d) {
                    this.q.setOnClickListener(this.aU);
                    this.q.setOnTouchListener(this.aU);
                } else {
                    this.q.setOnClickListener(this.bj);
                }
            }
        }
        al.a(this.aj, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mLLEndCardBackup");
        this.ao.setOnClickListener(this.aU);
        this.ao.setOnTouchListener(this.aU);
        a(this.E, this.F);
    }

    public boolean g() {
        if (this.f27206h == null) {
            return false;
        }
        String P = P();
        if (TextUtils.isEmpty(P)) {
            return false;
        }
        this.f27206h.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.f27203e, this.G, this.s.am(), null) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.20
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.aI = str;
                if (tTBaseVideoActivity.bh) {
                    TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                    tTBaseVideoActivity2.a(tTBaseVideoActivity2.aE, "loading_h5_success");
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTBaseVideoActivity.this.bh = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                TTBaseVideoActivity.this.bh = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                TTBaseVideoActivity.this.bh = false;
            }
        });
        this.f27206h.loadUrl(P);
        this.f27206h.getSettings().setDisplayZoomControls(false);
        this.f27206h.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.G, this.t));
        this.f27206h.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.21
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTBaseVideoActivity.this.J.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = TTBaseVideoActivity.this.J.get(str);
                    if (aVar != null) {
                        aVar.e();
                    }
                } else {
                    l lVar = TTBaseVideoActivity.this.s;
                    if (lVar != null && lVar.aa() != null) {
                        TTBaseVideoActivity.this.s.aa().a();
                    }
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(tTBaseVideoActivity, str, tTBaseVideoActivity.s, tTBaseVideoActivity.aE);
                    TTBaseVideoActivity.this.J.put(str, a2);
                    a2.e();
                }
                TTBaseVideoActivity.this.W();
            }
        });
        return true;
    }

    public boolean h() {
        String str = this.O;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void i() {
        SSWebView sSWebView = this.f27204f;
        if (sSWebView == null || !this.aG) {
            return;
        }
        sSWebView.loadUrl(this.O);
    }

    public void j() {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(this.ah ? C() : B());
        }
    }

    public void k() {
        String str;
        if (this.m == null) {
            return;
        }
        int f2 = this.s.an() != null ? this.s.an().f() : 6870;
        String a2 = ad.a(this, "tt_comment_num");
        if (f2 > 10000) {
            str = (f2 / 10000) + "万";
        } else {
            str = f2 + "";
        }
        this.m.setText(String.format(a2, str));
    }

    public void l() {
        if (this.k != null) {
            if (this.s.aa() != null && !TextUtils.isEmpty(this.s.aa().a())) {
                com.bytedance.sdk.openadsdk.i.e.c().a(this.s.aa().a(), this.k);
            } else {
                this.k.setImageResource(ad.d(this, "tt_ad_logo_small"));
            }
        }
        if (this.l != null) {
            if (this.R == 15 && this.s.an() != null && !TextUtils.isEmpty(this.s.an().c())) {
                this.l.setText(this.s.an().c());
            } else {
                this.l.setText(this.s.aj());
            }
        }
    }

    public void d() {
        if (this.R == 15) {
            TextView textView = this.l;
            if (textView != null) {
                textView.setMaxWidth((int) al.a(this, 153.0f));
            }
        } else {
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setMaxWidth((int) al.a(this, 404.0f));
            }
            f(false);
        }
        if (this instanceof TTFullScreenVideoActivity) {
            al.a((View) this.f27202d, 0);
        }
    }

    public void e() {
        int w = this.s.w();
        this.S = w;
        if (w == -200) {
            com.bytedance.sdk.openadsdk.core.h.h h2 = com.bytedance.sdk.openadsdk.core.p.h();
            this.S = h2.k(this.T + "");
        }
        if (this.S == -1 && this.v) {
            al.a((View) this.f27202d, 0);
        }
    }

    public void f() {
        this.f27200b = (PlayableLoadingView) findViewById(ad.e(this, "tt_reward_playable_loading"));
        TopProxyLayout topProxyLayout = (TopProxyLayout) findViewById(ad.e(this, "tt_top_layout_proxy"));
        this.f27201c = topProxyLayout;
        if (topProxyLayout != null) {
            topProxyLayout.a(this instanceof TTRewardVideoActivity, this.s);
            X();
        }
        this.f27199a = findViewById(ad.e(this, "tt_reward_root"));
        this.f27206h = (SSWebView) findViewById(ad.e(this, "tt_browser_webview_loading"));
        this.f27204f = (SSWebView) findViewById(ad.e(this, "tt_reward_browser_webview"));
        this.f27205g = new WeakReference<>(this.f27204f);
        this.j = (RelativeLayout) findViewById(ad.e(this, "tt_video_ad_close_layout"));
        this.f27207i = (ImageView) findViewById(ad.e(this, "tt_video_ad_close"));
        this.aw = (TextView) findViewById(ad.e(this, "tt_ad_logo"));
        this.o = (FrameLayout) findViewById(ad.e(this, "tt_video_reward_container"));
        this.p = (FrameLayout) findViewById(ad.e(this, "tt_click_upper_non_content_layout"));
        this.q = (FrameLayout) findViewById(ad.e(this, "tt_click_lower_non_content_layout"));
        this.aj = (LinearLayout) findViewById(ad.e(this, "tt_reward_full_endcard_backup"));
        this.n = (TextView) findViewById(ad.e(this, "tt_reward_ad_download"));
        this.f27202d = (RelativeLayout) findViewById(ad.e(this, "tt_video_reward_bar"));
        this.k = (TTRoundRectImageView) findViewById(ad.e(this, "tt_reward_ad_icon"));
        this.l = (TextView) findViewById(ad.e(this, "tt_reward_ad_appname"));
        this.m = (TextView) findViewById(ad.e(this, "tt_comment_vertical"));
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(ad.e(this, "tt_rb_score"));
        this.r = tTRatingBar;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.r.setStarFillNum(4);
            this.r.setStarImageWidth(al.c(this, 15.0f));
            this.r.setStarImageHeight(al.c(this, 14.0f));
            this.r.setStarImagePadding(al.c(this, 4.0f));
            this.r.a();
        }
        l lVar = this.s;
        if (lVar != null && lVar.C()) {
            this.f27204f.setBackgroundColor(-16777216);
            this.f27206h.setBackgroundColor(-16777216);
            if (this.s.i() == 1) {
                al.a((View) this.o, 8);
                al.a((View) this.p, 8);
                al.a((View) this.q, 8);
                al.a((View) this.f27202d, 8);
                al.a((View) this.l, 8);
                al.a((View) this.k, 8);
                al.a((View) this.m, 8);
                al.a((View) this.r, 8);
                al.a((View) this.f27207i, 8);
                al.a((View) this.j, 8);
                al.a((View) this.f27204f, 4);
                al.a((View) this.f27206h, 0);
                al.a((View) this.n, 8);
                al.a((View) this.aw, 8);
            }
            TopProxyLayout topProxyLayout2 = this.f27201c;
            if (topProxyLayout2 != null) {
                topProxyLayout2.setShowSound(true);
            }
        }
        SSWebView sSWebView = this.f27204f;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.12
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                @RequiresApi(api = 16)
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 16) {
                        TTBaseVideoActivity.this.f27204f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        TTBaseVideoActivity.this.f27204f.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    int measuredWidth = TTBaseVideoActivity.this.f27204f.getMeasuredWidth();
                    int measuredHeight = TTBaseVideoActivity.this.f27204f.getMeasuredHeight();
                    if (TTBaseVideoActivity.this.f27204f.getVisibility() == 0) {
                        TTBaseVideoActivity.this.a(measuredWidth, measuredHeight);
                    }
                }
            });
        }
        S();
        if (!this.v) {
            al.a((View) this.f27202d, 4);
        }
        try {
            if (this.ag && this.s != null && this.s.aq() == 5) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams.height = (int) al.a(this, 55.0f);
                layoutParams.topMargin = (int) al.a(this, 20.0f);
                this.n.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f27202d.getLayoutParams();
                layoutParams2.bottomMargin = (int) al.a(this, 12.0f);
                this.f27202d.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        if (this.s == null || !this.ag || this.o == null) {
            return;
        }
        int c2 = al.c(this);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams3.width = c2;
        int i2 = (c2 * 9) / 16;
        layoutParams3.height = i2;
        this.o.setLayoutParams(layoutParams3);
        this.ai = (al.d(this) - i2) / 2;
        u.f("TTBaseVideoActivity", "NonContentAreaHeight:" + this.ai);
    }

    public void b() {
        com.bytedance.sdk.openadsdk.c.d.a(this.s, this);
    }

    public void c() {
        if (l.e(this.s) && this.P) {
            a(true);
            this.au.a(true);
        }
    }

    public void b(String str) {
        if (this.s.i() == 1 && this.s.C()) {
            return;
        }
        boolean a2 = a(this.w, false);
        this.V.set(true);
        if (a2) {
            return;
        }
        u();
        HashMap hashMap = new HashMap();
        hashMap.put("vbtt_skip_type", 1);
        a(str, hashMap);
    }

    public void c(final String str) {
        runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.9
            @Override // java.lang.Runnable
            public void run() {
                TextView textView;
                if (TextUtils.isEmpty(str) || (textView = TTBaseVideoActivity.this.ao) == null) {
                    return;
                }
                textView.setText(str);
            }
        });
    }

    public void e(boolean z) {
        Message message = new Message();
        message.what = 400;
        if (z) {
            f(10000);
        }
        am amVar = this.I;
        if (amVar != null) {
            amVar.sendMessageDelayed(message, 2000L);
        }
    }

    public void c(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.F.a("volumeChange", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String g(boolean z) {
        l lVar = this.s;
        if (lVar == null) {
            return null;
        }
        return z ? lVar.Z() != 4 ? "查看" : "下载" : lVar.Z() != 4 ? "View" : "Install";
    }

    public void a() {
        if ((l.d(this.s) || l.e(this.s)) && this.aS == 0) {
            this.P = true;
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message d(int i2) {
        Message obtain = Message.obtain();
        obtain.what = 800;
        obtain.arg1 = i2;
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, int i2, int i3, int i4, int i5) {
        if (y() && view != null) {
            if (view.getId() == ad.e(this, "tt_rb_score")) {
                a(i2, i3, i4, i5);
            } else if (view.getId() == ad.e(this, "tt_comment_vertical")) {
                a(i2, i3, i4, i5);
            } else if (view.getId() == ad.e(this, "tt_reward_ad_appname")) {
                a(i2, i3, i4, i5);
            } else if (view.getId() == ad.e(this, "tt_reward_ad_icon")) {
                a(i2, i3, i4, i5);
            } else if (view.getId() != ad.e(this, "tt_video_reward_bar") && view.getId() != ad.e(this, "tt_click_lower_non_content_layout") && view.getId() != ad.e(this, "tt_click_upper_non_content_layout")) {
                if (view.getId() == ad.e(this, "tt_reward_ad_download")) {
                    a(i2, i3, i4, i5);
                } else if (view.getId() == ad.e(this, "tt_video_reward_container")) {
                    a(i2, i3, i4, i5);
                } else if (view.getId() == ad.e(this, "tt_reward_ad_download_backup")) {
                    a(i2, i3, i4, i5);
                }
            } else {
                a(i2, i3, i4, i5);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.g.f
    public void c(int i2) {
        if (i2 > 0) {
            if (this.aS > 0) {
                this.aS = i2;
            } else {
                u.b("onVolumeChanged", "onVolumeChanged >>>> 变为非静音状态通知 h5");
                c(false);
                this.aS = i2;
            }
        } else if (this.aS > 0) {
            u.b("onVolumeChanged", "onVolumeChanged >>>> 变为静音状态通知 h5");
            c(true);
            this.aS = i2;
        } else {
            this.aS = i2;
        }
        if (!l.e(this.s) || this.U.get()) {
            if (l.d(this.s) || l.e(this.s)) {
                if (this.au.c()) {
                    u.b("TTBaseVideoActivity", "onVolumeChanged by SDK mIsMute=" + this.P + " mVolume=" + this.aS + " mLastVolume=" + this.au.b());
                    if (this.aS == 0) {
                        a(true);
                        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
                        if (cVar != null) {
                            cVar.c(true);
                            return;
                        }
                        return;
                    }
                    a(false);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar2 = this.D;
                    if (cVar2 != null) {
                        cVar2.c(false);
                        return;
                    }
                    return;
                }
                this.au.b(-1);
                u.b("TTBaseVideoActivity", "onVolumeChanged by User mIsMute=" + this.P + " mVolume=" + this.aS + " mLastVolume=" + this.au.b());
                if (this.aW) {
                    if (this.aS == 0) {
                        this.P = true;
                        a(true);
                        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar3 = this.D;
                        if (cVar3 != null) {
                            cVar3.c(true);
                            return;
                        }
                        return;
                    }
                    this.P = false;
                    a(false);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar4 = this.D;
                    if (cVar4 != null) {
                        cVar4.c(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        com.bytedance.sdk.openadsdk.c.d.c(this, this.s, str, str2, (JSONObject) null);
    }

    public void d(String str) {
        if (this.aF) {
            String str2 = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.ax));
            com.bytedance.sdk.openadsdk.c.d.h(this, this.s, str2, str, hashMap);
            if ("return_foreground".equals(str)) {
                this.aF = false;
            }
        }
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.f27203e).a(false).b(false).a(sSWebView);
        sSWebView.getSettings().setUserAgentString(r.a(sSWebView, this.N));
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.getSettings().setMixedContentMode(0);
        }
    }

    public void a(String str) {
        SSWebView sSWebView = this.f27204f;
        if (sSWebView == null) {
            return;
        }
        j a2 = new j(this, this.s, sSWebView).a(true);
        this.t = a2;
        a2.a(h() ? "landingpage_endcard" : str);
        this.f27204f.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.f27203e, this.F, this.K, this.t) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.22
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.aI = str2;
                p pVar = tTBaseVideoActivity.aJ;
                if (pVar != null) {
                    pVar.f();
                }
                super.onPageFinished(webView, str2);
                try {
                    if (TTBaseVideoActivity.this.s.D() && !TTBaseVideoActivity.this.isFinishing() && TTBaseVideoActivity.this.s.A() && !TTBaseVideoActivity.this.s.B()) {
                        TTBaseVideoActivity.this.I.sendMessageDelayed(TTBaseVideoActivity.this.d(0), 1000L);
                    }
                } catch (Throwable unused) {
                }
                try {
                    if (TTBaseVideoActivity.this.ap.get() && TTBaseVideoActivity.this.s.i() == 1 && TTBaseVideoActivity.this.s.C()) {
                        TTBaseVideoActivity.this.Q();
                        TTBaseVideoActivity.this.b(true);
                        if (this.f28948b != null) {
                            this.f28948b.b(true);
                        }
                        TTBaseVideoActivity.this.a(TTBaseVideoActivity.this.aE, "py_loading_success");
                    }
                } catch (Throwable unused2) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                int i2;
                HashMap hashMap;
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.aI = str2;
                p pVar = tTBaseVideoActivity.aJ;
                if (pVar != null) {
                    pVar.e();
                }
                super.onPageStarted(webView, str2, bitmap);
                if (TTBaseVideoActivity.this.aX || !l.d(TTBaseVideoActivity.this.s)) {
                    return;
                }
                TTBaseVideoActivity.this.aX = true;
                TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                boolean z = tTBaseVideoActivity2 instanceof TTRewardVideoActivity;
                tTBaseVideoActivity2.aB = com.bytedance.sdk.openadsdk.core.p.h().o(String.valueOf(TTBaseVideoActivity.this.T));
                TTBaseVideoActivity.this.aC = com.bytedance.sdk.openadsdk.core.p.h().a(String.valueOf(TTBaseVideoActivity.this.T), z);
                TTBaseVideoActivity tTBaseVideoActivity3 = TTBaseVideoActivity.this;
                long j = tTBaseVideoActivity3.aB;
                tTBaseVideoActivity3.az = j;
                tTBaseVideoActivity3.aA = j;
                tTBaseVideoActivity3.I.sendEmptyMessageDelayed(600, i2 * 1000);
                Message obtain = Message.obtain();
                obtain.what = TTBaseVideoActivity.this.R();
                TTBaseVideoActivity tTBaseVideoActivity4 = TTBaseVideoActivity.this;
                obtain.arg1 = tTBaseVideoActivity4.aB;
                tTBaseVideoActivity4.I.sendMessage(obtain);
                TTBaseVideoActivity.this.ax = System.currentTimeMillis();
                if (TextUtils.isEmpty(TTBaseVideoActivity.this.af)) {
                    hashMap = null;
                } else {
                    hashMap = new HashMap();
                    hashMap.put("rit_scene", TTBaseVideoActivity.this.af);
                }
                if (z) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.f28949c, TTBaseVideoActivity.this.s, "rewarded_video", hashMap);
                } else {
                    com.bytedance.sdk.openadsdk.c.d.a(this.f28949c, TTBaseVideoActivity.this.s, "fullscreen_interstitial_ad", hashMap);
                }
                u.e("AdEvent", "pangolin ad show " + ak.a(TTBaseVideoActivity.this.s, (View) null));
                TTBaseVideoActivity.this.U();
                TTBaseVideoActivity.this.aD.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str2, String str3) {
                TTBaseVideoActivity.this.ap.set(false);
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.ar = i2;
                tTBaseVideoActivity.as = str2;
                if (tTBaseVideoActivity.aJ != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put("code", i2);
                            jSONObject.put("msg", str2);
                        }
                        TTBaseVideoActivity.this.aJ.a(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (TTBaseVideoActivity.this.aJ != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 21) {
                            jSONObject.put("code", webResourceResponse.getStatusCode());
                            jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                        }
                        TTBaseVideoActivity.this.aJ.a(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (webResourceRequest != null && webResourceRequest.getUrl() != null && TTBaseVideoActivity.this.O.equals(webResourceRequest.getUrl().toString())) {
                    TTBaseVideoActivity.this.ap.set(false);
                    if (webResourceResponse != null) {
                        TTBaseVideoActivity.this.ar = webResourceResponse.getStatusCode();
                        TTBaseVideoActivity.this.as = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                if (TTBaseVideoActivity.this.s.C()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    WebResourceResponse a3 = com.bytedance.sdk.openadsdk.core.g.a.a().a(TTBaseVideoActivity.this.s.X().k(), TTBaseVideoActivity.this.s.X().j(), str2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (TTBaseVideoActivity.this.aJ != null) {
                        e.a a4 = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str2);
                        int i2 = a3 != null ? 1 : 2;
                        if (a4 == e.a.HTML) {
                            TTBaseVideoActivity.this.aJ.a(str2, currentTimeMillis, currentTimeMillis2, i2);
                        } else if (a4 == e.a.JS) {
                            TTBaseVideoActivity.this.aJ.b(str2, currentTimeMillis, currentTimeMillis2, i2);
                        }
                    }
                    return a3;
                }
                return super.shouldInterceptRequest(webView, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                TTBaseVideoActivity.this.ap.set(false);
                if (TTBaseVideoActivity.this.aJ != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put("code", webResourceError.getErrorCode());
                            jSONObject.put("msg", webResourceError.getDescription());
                        }
                        TTBaseVideoActivity.this.aJ.a(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (webResourceError != null && webResourceError.getDescription() != null) {
                    TTBaseVideoActivity.this.ar = webResourceError.getErrorCode();
                    TTBaseVideoActivity.this.as = webResourceError.getDescription().toString();
                }
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            @TargetApi(21)
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
                } catch (Throwable th) {
                    u.c("TTBaseVideoActivity", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }
        });
        a(this.f27204f);
        if (this.s.i() == 1 && this.s.C()) {
            a(this.f27206h);
            g();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(this.av);
            if (this.av) {
                this.f27204f.getSettings().setDomStorageEnabled(true);
            }
        }
        i();
        if ("reward_endcard".equals(str) || "fullscreen_endcard".equals(str)) {
            this.f27204f.setLayerType(1, null);
            this.f27204f.setBackgroundColor(-1);
        }
        this.f27204f.getSettings().setDisplayZoomControls(false);
        this.f27204f.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.F, this.t) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.23
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                super.onProgressChanged(webView, i2);
                try {
                    if (!TTBaseVideoActivity.this.s.D() || !TTBaseVideoActivity.this.s.A() || TTBaseVideoActivity.this.isFinishing() || TTBaseVideoActivity.this.f27200b == null) {
                        return;
                    }
                    TTBaseVideoActivity.this.f27200b.setProgress(i2);
                } catch (Throwable unused) {
                }
            }
        });
        this.f27204f.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.24
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                if (TTBaseVideoActivity.this.J.containsKey(str2)) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = TTBaseVideoActivity.this.J.get(str2);
                    if (aVar != null) {
                        aVar.e();
                    }
                } else {
                    l lVar = TTBaseVideoActivity.this.s;
                    if (lVar != null && lVar.aa() != null) {
                        TTBaseVideoActivity.this.s.aa().a();
                    }
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    com.bytedance.sdk.openadsdk.downloadnew.core.a a3 = com.bytedance.sdk.openadsdk.downloadnew.a.a(tTBaseVideoActivity, str2, tTBaseVideoActivity.s, tTBaseVideoActivity.aE);
                    TTBaseVideoActivity.this.J.put(str2, a3);
                    a3.e();
                }
                TTBaseVideoActivity.this.W();
            }
        });
    }

    public void d(boolean z) {
        if (this.aT == null) {
            this.aT = new ProgressBar(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.aT.setLayoutParams(layoutParams);
            this.aT.setIndeterminateDrawable(getResources().getDrawable(ad.d(this, "tt_video_loading_progress_bar")));
            this.o.addView(this.aT);
        }
        if (z) {
            this.aT.setVisibility(0);
        } else {
            this.aT.setVisibility(8);
        }
    }

    public IListenerManager b(int i2) {
        if (this.ae == null) {
            this.ae = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.p.a()).a(i2));
        }
        return this.ae;
    }

    public void b(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.F.a("viewableChange", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z) {
        TopProxyLayout topProxyLayout = this.f27201c;
        if (topProxyLayout != null) {
            topProxyLayout.setSoundMute(z);
        }
    }

    public void b(Context context) {
        try {
            this.H.a(null);
            context.unregisterReceiver(this.H);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, JSONObject jSONObject) {
        if (this instanceof TTFullScreenVideoActivity) {
            com.bytedance.sdk.openadsdk.c.d.a(this.f27203e, this.s, "fullscreen_interstitial_ad", str, (JSONObject) null);
        }
        if (this instanceof TTRewardVideoActivity) {
            com.bytedance.sdk.openadsdk.c.d.a(this.f27203e, this.s, "rewarded_video", str, jSONObject);
        }
    }

    public static float b(Activity activity) {
        return al.b(activity, al.h(activity));
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (y()) {
            a aVar = new a(i2, i3, i4, i5);
            aVar.a(System.currentTimeMillis());
            a(aVar, (View) this.f27202d, (View) null, true);
        }
    }

    private void a(a aVar, View view, View view2, boolean z) {
        HashMap hashMap;
        if (TextUtils.isEmpty(this.af)) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            hashMap.put("rit_scene", this.af);
        }
        HashMap hashMap2 = hashMap;
        String str = this instanceof TTFullScreenVideoActivity ? "fullscreen_interstitial_ad" : "";
        if (this instanceof TTRewardVideoActivity) {
            str = "rewarded_video";
        }
        String str2 = str;
        if (aVar == null || this.s == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.c.d.a(this.f27203e, "click_other", this.s, a(aVar.f27244b, aVar.f27245c, aVar.f27246d, aVar.f27247e, aVar.f27248f, aVar.f27249g, view, view2), str2, z, hashMap2);
    }

    public com.bytedance.sdk.openadsdk.core.d.f a(int i2, int i3, int i4, int i5, long j, long j2, View view, View view2) {
        return new f.a().e(i2).d(i3).c(i4).b(i5).b(j).a(j2).b(al.a(view)).a(al.a(view2)).c(al.c(view)).d(al.c(view2)).f(1).g(-1).h(0).a((SparseArray<c.a>) null).a(i.d().b() ? 1 : 2).a();
    }

    private void f(boolean z) {
        if (z) {
            return;
        }
        TTRoundRectImageView tTRoundRectImageView = this.ak;
        if (tTRoundRectImageView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, (int) al.a(this, 50.0f), 0, 0);
            this.ak.setLayoutParams(layoutParams);
        }
        TextView textView = this.ao;
        if (textView != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams2.setMargins(0, (int) al.a(this, 35.0f), 0, 0);
            layoutParams2.width = (int) al.a(this, 342.0f);
            this.ao.setLayoutParams(layoutParams2);
        }
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, final x xVar) {
        if (aVar == null || xVar == null) {
            return;
        }
        aVar.a(new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.8
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j, long j2, String str, String str2) {
                if (System.currentTimeMillis() - TTBaseVideoActivity.this.bb > NativeExpressView.u) {
                    TTBaseVideoActivity.this.a(xVar, j2, j, 3);
                    TTBaseVideoActivity.this.bb = System.currentTimeMillis();
                }
                if (j > 0) {
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.c("已下载" + ((int) ((100 * j2) / j)) + "%");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j, long j2, String str, String str2) {
                if (System.currentTimeMillis() - TTBaseVideoActivity.this.bc > NativeExpressView.u) {
                    TTBaseVideoActivity.this.a(xVar, j2, j, 4);
                    TTBaseVideoActivity.this.bc = System.currentTimeMillis();
                }
                TTBaseVideoActivity.this.c("下载失败");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j, String str, String str2) {
                if (System.currentTimeMillis() - TTBaseVideoActivity.this.bd > NativeExpressView.u) {
                    TTBaseVideoActivity.this.a(xVar, 5, 100);
                    TTBaseVideoActivity.this.bd = System.currentTimeMillis();
                }
                TTBaseVideoActivity.this.c("点击安装");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j, long j2, String str, String str2) {
                if (System.currentTimeMillis() - TTBaseVideoActivity.this.ba > NativeExpressView.u) {
                    TTBaseVideoActivity.this.a(xVar, j2, j, 2);
                    TTBaseVideoActivity.this.ba = System.currentTimeMillis();
                }
                TTBaseVideoActivity.this.c("下载暂停");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                if (System.currentTimeMillis() - TTBaseVideoActivity.this.aZ > NativeExpressView.u) {
                    TTBaseVideoActivity.this.a(xVar, 1, 0);
                    TTBaseVideoActivity.this.aZ = System.currentTimeMillis();
                }
                TTBaseVideoActivity.this.c("点击开始下载");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                if (System.currentTimeMillis() - TTBaseVideoActivity.this.be > NativeExpressView.u) {
                    TTBaseVideoActivity.this.a(xVar, 6, 100);
                    TTBaseVideoActivity.this.be = System.currentTimeMillis();
                }
                TTBaseVideoActivity.this.c("点击打开");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, long j, long j2, int i2) {
        if (j2 > 0) {
            a(xVar, i2, (int) ((j * 100) / j2));
        }
    }

    public void a(x xVar, int i2, int i3) {
        if (xVar == null || this.aY.get()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadStatus", i2);
            jSONObject.put("downloadProcessRate", i3);
            xVar.b("showDownloadStatus", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        if (view.getId() == ad.e(this, "tt_rb_score")) {
            a("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == ad.e(this, "tt_comment_vertical")) {
            a("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == ad.e(this, "tt_reward_ad_appname")) {
            a("click_play_source", (JSONObject) null);
        } else if (view.getId() == ad.e(this, "tt_reward_ad_icon")) {
            a("click_play_logo", (JSONObject) null);
        } else if (view.getId() != ad.e(this, "tt_video_reward_bar") && view.getId() != ad.e(this, "tt_click_lower_non_content_layout") && view.getId() != ad.e(this, "tt_click_upper_non_content_layout")) {
            if (view.getId() == ad.e(this, "tt_reward_ad_download")) {
                a("click_start_play", A());
            } else if (view.getId() == ad.e(this, "tt_video_reward_container")) {
                a("click_video", A());
            } else if (view.getId() == ad.e(this, "tt_reward_ad_download_backup")) {
                a("fallback_endcard_click", A());
            }
        } else {
            a("click_start_play_bar", A());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        int i2 = message.what;
        if (i2 == 500) {
            if (!l.b(this.s)) {
                aa();
            }
            SSWebView sSWebView = this.f27205g.get();
            if (sSWebView != null) {
                sSWebView.onResume();
                sSWebView.resumeTimers();
            }
            TopProxyLayout topProxyLayout = this.f27201c;
            if (topProxyLayout != null) {
                topProxyLayout.setShowCountDown(false);
            }
            SSWebView sSWebView2 = this.f27204f;
            if (sSWebView2 != null) {
                al.a((View) sSWebView2, 1.0f);
                al.a((View) this.f27207i, 1.0f);
                al.a((View) this.j, 1.0f);
            }
            if ((this instanceof TTFullScreenVideoActivity) && this.D != null && v() && this.X.get()) {
                this.D.j();
                this.D.m();
            }
        } else if (i2 == 600) {
            Y();
        } else if (i2 == 800) {
            HashMap hashMap = new HashMap();
            hashMap.put("remove_loading_page_type", Integer.valueOf(message.arg1));
            if (this.s.X() != null) {
                hashMap.put("playable_url", this.s.X().j());
            }
            com.bytedance.sdk.openadsdk.c.d.k(this, this.s, this.aE, "remove_loading_page", hashMap);
            this.I.removeMessages(800);
            PlayableLoadingView playableLoadingView = this.f27200b;
            if (playableLoadingView != null) {
                playableLoadingView.a();
            }
        } else if (i2 == 900) {
            if (this.s.i() != 1) {
                return;
            }
            int i3 = message.arg1;
            if (i3 > 0) {
                TopProxyLayout topProxyLayout2 = this.f27201c;
                if (topProxyLayout2 != null) {
                    topProxyLayout2.setShowSkip(true);
                    this.f27201c.a(String.valueOf(i3), (CharSequence) null);
                }
                Message obtain = Message.obtain();
                obtain.what = 900;
                int i4 = i3 - 1;
                obtain.arg1 = i4;
                this.az--;
                this.I.sendMessageDelayed(obtain, 1000L);
                this.ay = i4;
                if (i3 == 1) {
                    this.I.sendEmptyMessageDelayed(600, 1000L);
                }
            } else {
                TopProxyLayout topProxyLayout3 = this.f27201c;
                if (topProxyLayout3 != null) {
                    topProxyLayout3.setShowSkip(false);
                }
                if (this instanceof TTRewardVideoActivity) {
                    f(10001);
                } else {
                    f(10002);
                }
            }
            if (this instanceof TTRewardVideoActivity) {
                ab();
            }
        } else if (i2 != 950) {
            if (i2 != 300) {
                if (i2 == 400) {
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
                    if (cVar != null) {
                        cVar.m();
                    }
                    u();
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar2 = this.D;
            if (cVar2 != null && cVar2.u() != null) {
                this.D.u().d();
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar3 = this.D;
            if (cVar3 != null) {
                cVar3.m();
            }
            u();
            if (message.arg1 == 1) {
                f(10000);
            }
        } else if (this.s.i() != 1) {
        } else {
            int i5 = message.arg1;
            if (i5 > 0) {
                if (i5 == 1) {
                    this.I.sendEmptyMessageDelayed(600, 1000L);
                }
                int i6 = this.aC - (this.aB - i5);
                if (i6 > 0) {
                    TopProxyLayout topProxyLayout4 = this.f27201c;
                    if (topProxyLayout4 != null) {
                        topProxyLayout4.setShowSkip(true);
                        this.f27201c.a(String.valueOf(i5), "可在(" + i6 + "s)后跳过");
                    }
                } else {
                    TopProxyLayout topProxyLayout5 = this.f27201c;
                    if (topProxyLayout5 != null) {
                        topProxyLayout5.setShowSkip(true);
                        this.f27201c.a(String.valueOf(i5), "跳过");
                        this.f27201c.setSkipEnable(true);
                    }
                }
                Message obtain2 = Message.obtain();
                obtain2.what = 950;
                int i7 = i5 - 1;
                obtain2.arg1 = i7;
                this.az--;
                this.I.sendMessageDelayed(obtain2, 1000L);
                this.ay = i7;
            } else {
                TopProxyLayout topProxyLayout6 = this.f27201c;
                if (topProxyLayout6 != null) {
                    topProxyLayout6.setShowSkip(false);
                    this.f27201c.a(String.valueOf(i5), (CharSequence) null);
                }
                if (this instanceof TTRewardVideoActivity) {
                    f(10001);
                } else {
                    f(10002);
                }
            }
            if (this instanceof TTRewardVideoActivity) {
                ab();
            }
        }
    }

    private void a(final String str, final long j, final long j2, final String str2, final String str3) {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("executeMultiProcessAppDownloadCallBack") { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTBaseVideoActivity.this.a(3).executeAppDownloadCallback(TTBaseVideoActivity.this.u, str, j, j2, str2, str3);
                } catch (Throwable th) {
                    u.c("TTBaseVideoActivity", "executeAppDownloadCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    public IListenerManager a(int i2) {
        return IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.p.a()).a(i2));
    }

    public void a(boolean z, boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.F.a("endcard_control_event", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(int i2, int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i2);
            jSONObject.put("height", i3);
            this.F.a("resize", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        if (cVar != null) {
            Map<String, Object> a2 = ak.a(this.s, cVar.o(), this.D.u());
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    a2.put(entry.getKey(), entry.getValue());
                }
            }
            com.bytedance.sdk.openadsdk.c.d.a(this.f27203e, this.s, str, str2, this.D.p(), this.D.r(), a2);
            u.b("TTBaseVideoActivity", "event tag:" + str + ", TotalPlayDuration=" + this.D.p() + ",mBasevideoController.getPct()=" + this.D.r());
        }
    }

    public void a(String str, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        if (cVar != null) {
            Map<String, Object> a2 = ak.a(this.s, cVar.o(), this.D.u());
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    a2.put(entry.getKey(), entry.getValue());
                }
            }
            a2.put("play_type", Integer.valueOf(ak.a(this.D, this.z)));
            com.bytedance.sdk.openadsdk.c.d.a(this.f27203e, this.s, str, "endcard_skip", this.D.p(), this.D.r(), a2);
        }
    }

    public void a(Context context) {
        try {
            HomeWatcherReceiver homeWatcherReceiver = new HomeWatcherReceiver();
            this.H = homeWatcherReceiver;
            homeWatcherReceiver.a(this);
            context.registerReceiver(this.H, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (Throwable unused) {
        }
    }

    public static float a(Activity activity) {
        return al.b(activity, al.g(activity));
    }

    public static float[] a(boolean z, Activity activity, int i2) {
        float a2 = a(activity);
        float b2 = b(activity);
        if (z != (a2 > b2)) {
            float f2 = a2 + b2;
            b2 = f2 - b2;
            a2 = f2 - b2;
        }
        if (z) {
            a2 -= i2;
        } else {
            b2 -= i2;
        }
        return new float[]{b2, a2};
    }
}
