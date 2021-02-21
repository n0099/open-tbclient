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
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.text.TextUtils;
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
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.baidu.live.tbadk.img.effect.ResizeImageAction;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.video.b.b;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.f;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.g.f;
import com.bytedance.sdk.openadsdk.g.g;
import com.bytedance.sdk.openadsdk.g.h;
import com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class TTBaseVideoActivity extends Activity implements b, f, HomeWatcherReceiver.a, am.a {
    protected static RemoteCallbackList<ITTAppDownloadListener> ad = null;
    RewardDislikeDialogNew A;
    RewardDislikeToast B;
    c C;
    com.bytedance.sdk.openadsdk.core.video.nativevideo.c D;
    a E;
    x F;
    x G;
    HomeWatcherReceiver H;
    String K;
    String L;
    int M;
    int N;
    protected String O;
    int Q;
    int T;

    /* renamed from: a  reason: collision with root package name */
    View f6096a;
    String aE;
    boolean aF;
    protected boolean aG;
    String aH;
    String aI;
    protected p aJ;
    protected int aK;
    View aL;
    protected com.bytedance.sdk.openadsdk.g.a aM;
    protected e aN;
    protected d aO;
    protected int aP;
    ProgressBar aQ;
    private com.bytedance.sdk.openadsdk.core.a.e aR;
    private boolean aS;
    private boolean aT;
    private boolean aU;
    private boolean aV;
    private AtomicBoolean aW;
    private View.OnClickListener aX;
    private boolean aY;
    protected com.bytedance.sdk.openadsdk.core.widget.c ab;
    protected IListenerManager ae;
    protected String af;
    LinearLayout aj;
    TTRoundRectImageView ak;
    TextView al;
    TTRatingBar am;
    TextView an;
    TextView ao;
    protected g au;
    boolean av;
    TextView aw;

    /* renamed from: b  reason: collision with root package name */
    PlayableLoadingView f6097b;
    TopProxyLayout c;
    RelativeLayout d;
    Context e;
    protected SSWebView f;
    protected WeakReference<SSWebView> g;
    SSWebView h;
    ImageView i;
    RelativeLayout j;
    TTRoundRectImageView k;
    TextView l;
    TextView m;
    TextView n;
    FrameLayout o;
    FrameLayout p;
    FrameLayout q;
    TTRatingBar r;
    l s;
    j t;
    String u;
    long w;
    String x;
    int y;
    boolean v = true;
    boolean z = false;
    final am I = new am(Looper.getMainLooper(), this);
    final Map<String, a> J = Collections.synchronizedMap(new HashMap());
    boolean P = false;
    int R = 5;
    int S = 3;
    final AtomicBoolean U = new AtomicBoolean(false);
    final AtomicBoolean V = new AtomicBoolean(false);
    final AtomicBoolean W = new AtomicBoolean(false);
    final AtomicBoolean X = new AtomicBoolean(false);
    final AtomicBoolean Y = new AtomicBoolean(false);
    final AtomicBoolean Z = new AtomicBoolean(false);
    protected final AtomicBoolean aa = new AtomicBoolean(false);
    protected final String ac = Build.MODEL;
    protected boolean ag = false;
    protected boolean ah = false;
    protected int ai = 0;
    AtomicBoolean ap = new AtomicBoolean(true);
    boolean aq = false;
    int ar = 0;
    String as = "";
    int at = 7;
    long ax = 0;
    int ay = 0;
    long az = 0;
    long aA = 0;
    int aB = 0;
    int aC = 0;
    AtomicBoolean aD = new AtomicBoolean(false);

    abstract p r();

    public TTBaseVideoActivity() {
        this.aE = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.aF = false;
        this.aG = true;
        this.aT = false;
        this.aH = "video_player";
        this.aI = "";
        this.aK = 0;
        this.aU = false;
        this.aV = true;
        this.aW = new AtomicBoolean(false);
        this.aL = null;
        this.aX = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTBaseVideoActivity.this.a(view);
            }
        };
        this.aY = false;
        this.aM = new com.bytedance.sdk.openadsdk.g.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.10
            @Override // com.bytedance.sdk.openadsdk.g.a
            public int a() {
                int i = -1;
                if (TTBaseVideoActivity.this.f != null) {
                    i = TTBaseVideoActivity.this.f.getMeasuredHeight();
                }
                u.c("TTAndroidObject", "mWebView>>>>height=" + i);
                if (i <= 0) {
                    return ak.d(TTBaseVideoActivity.this.e);
                }
                return i;
            }

            @Override // com.bytedance.sdk.openadsdk.g.a
            public int b() {
                int i = -1;
                if (TTBaseVideoActivity.this.f != null) {
                    i = TTBaseVideoActivity.this.f.getMeasuredWidth();
                }
                u.c("TTAndroidObject", "mWebView>>>>width=" + i);
                if (i <= 0) {
                    return ak.c(TTBaseVideoActivity.this.e);
                }
                return i;
            }
        };
        this.aN = new e() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.11
            @Override // com.bytedance.sdk.openadsdk.g.e
            public void a() {
                TTBaseVideoActivity.this.V();
            }
        };
        this.aO = new d() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.13
            @Override // com.bytedance.sdk.openadsdk.g.d
            public void a() {
                if (!TTBaseVideoActivity.this.isFinishing()) {
                    if ((TTBaseVideoActivity.this.s == null || TTBaseVideoActivity.this.s.q()) && TTBaseVideoActivity.this.s != null && TTBaseVideoActivity.this.s.r()) {
                        TTBaseVideoActivity.this.I.removeMessages(800);
                        TTBaseVideoActivity.this.I.sendMessage(TTBaseVideoActivity.this.d(1));
                    }
                }
            }
        };
        this.aP = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.aS = bundle.getBoolean("is_bar_click_first");
        }
        super.onCreate(bundle);
        try {
            this.aK = ak.b(getApplicationContext(), ak.i(getApplicationContext()));
        } catch (Throwable th) {
        }
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
        } catch (Throwable th2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.p.a(this);
        } catch (Throwable th3) {
        }
        if (bundle != null && bundle.getLong("video_current") > 0) {
            this.w = bundle.getLong("video_current", 0L);
        }
        this.e = this;
        this.au = new g(getApplicationContext());
        this.au.a(this);
        this.aP = this.au.g();
        u.b("onVolumeChanged", "onCreate >>>>>> mVolume = " + this.aP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if ((l.b(this.s) || l.c(this.s)) && this.aP == 0) {
            this.P = true;
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        com.bytedance.sdk.openadsdk.c.d.a(this.s, this);
    }

    void c() {
        if (l.c(this.s) && this.P) {
            a(true);
            this.au.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.R == 15) {
            if (this.l != null) {
                this.l.setMaxWidth((int) ak.a(this, 153.0f));
            }
        } else {
            if (this.l != null) {
                this.l.setMaxWidth((int) ak.a(this, 404.0f));
            }
            e(false);
        }
        if (this instanceof TTFullScreenVideoActivity) {
            ak.a((View) this.d, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.S = this.s.m();
        if (this.S == -200) {
            this.S = com.bytedance.sdk.openadsdk.core.p.h().k(this.T + "");
        }
        if (this.S == -1 && this.v) {
            ak.a((View) this.d, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        this.f6097b = (PlayableLoadingView) findViewById(ac.e(this, "tt_reward_playable_loading"));
        this.c = (TopProxyLayout) findViewById(ac.e(this, "tt_top_layout_proxy"));
        if (this.c != null) {
            this.c.a(this instanceof TTRewardVideoActivity, this.s);
            P();
        }
        this.f6096a = findViewById(ac.e(this, "tt_reward_root"));
        this.h = (SSWebView) findViewById(ac.e(this, "tt_browser_webview_loading"));
        this.f = (SSWebView) findViewById(ac.e(this, "tt_reward_browser_webview"));
        this.g = new WeakReference<>(this.f);
        this.j = (RelativeLayout) findViewById(ac.e(this, "tt_video_ad_close_layout"));
        this.i = (ImageView) findViewById(ac.e(this, "tt_video_ad_close"));
        this.aw = (TextView) findViewById(ac.e(this, "tt_ad_logo"));
        this.o = (FrameLayout) findViewById(ac.e(this, "tt_video_reward_container"));
        this.p = (FrameLayout) findViewById(ac.e(this, "tt_click_upper_non_content_layout"));
        this.q = (FrameLayout) findViewById(ac.e(this, "tt_click_lower_non_content_layout"));
        this.aj = (LinearLayout) findViewById(ac.e(this, "tt_reward_full_endcard_backup"));
        this.n = (TextView) findViewById(ac.e(this, "tt_reward_ad_download"));
        this.d = (RelativeLayout) findViewById(ac.e(this, "tt_video_reward_bar"));
        this.k = (TTRoundRectImageView) findViewById(ac.e(this, "tt_reward_ad_icon"));
        this.l = (TextView) findViewById(ac.e(this, "tt_reward_ad_appname"));
        this.m = (TextView) findViewById(ac.e(this, "tt_comment_vertical"));
        this.r = (TTRatingBar) findViewById(ac.e(this, "tt_rb_score"));
        if (this.r != null) {
            this.r.setStarEmptyNum(1);
            this.r.setStarFillNum(4);
            this.r.setStarImageWidth(ak.c(this, 15.0f));
            this.r.setStarImageHeight(ak.c(this, 14.0f));
            this.r.setStarImagePadding(ak.c(this, 4.0f));
            this.r.a();
        }
        if (this.s != null && this.s.s()) {
            this.f.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.h.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            if (this.s.c() == 1) {
                ak.a((View) this.o, 8);
                ak.a((View) this.p, 8);
                ak.a((View) this.q, 8);
                ak.a((View) this.d, 8);
                ak.a((View) this.l, 8);
                ak.a((View) this.k, 8);
                ak.a((View) this.m, 8);
                ak.a((View) this.r, 8);
                ak.a((View) this.i, 8);
                ak.a((View) this.j, 8);
                ak.a((View) this.f, 4);
                ak.a((View) this.h, 0);
                ak.a((View) this.n, 8);
                ak.a((View) this.aw, 8);
            }
            if (this.c != null) {
                this.c.setShowSound(true);
            }
        }
        if (this.f != null) {
            this.f.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                @RequiresApi(api = 16)
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 16) {
                        TTBaseVideoActivity.this.f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        TTBaseVideoActivity.this.f.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    int measuredWidth = TTBaseVideoActivity.this.f.getMeasuredWidth();
                    int measuredHeight = TTBaseVideoActivity.this.f.getMeasuredHeight();
                    if (TTBaseVideoActivity.this.f.getVisibility() == 0) {
                        TTBaseVideoActivity.this.a(measuredWidth, measuredHeight);
                    }
                }
            });
        }
        N();
        if (!this.v) {
            ak.a((View) this.d, 4);
        }
        try {
            if (this.ag && this.s != null && this.s.X() == 5) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams.height = (int) ak.a(this, 55.0f);
                layoutParams.topMargin = (int) ak.a(this, 20.0f);
                this.n.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
                layoutParams2.bottomMargin = (int) ak.a(this, 12.0f);
                this.d.setLayoutParams(layoutParams2);
            }
        } catch (Throwable th) {
        }
        if (this.s != null && this.ag && this.o != null) {
            int c = ak.c(this);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams3.width = c;
            int i = (c * 9) / 16;
            layoutParams3.height = i;
            this.o.setLayoutParams(layoutParams3);
            this.ai = (ak.d(this) - i) / 2;
            u.f("TTBaseVideoActivity", "NonContentAreaHeight:" + this.ai);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        com.bytedance.sdk.openadsdk.c.d.c(this, this.s, str, str2, (JSONObject) null);
    }

    private String L() {
        String str;
        StringBuffer stringBuffer;
        String p = com.bytedance.sdk.openadsdk.core.p.h().p();
        u.c("Playable", "getPlayableLoadH5Url->loadH5Url=" + p);
        if (TextUtils.isEmpty(p) || this.s == null || this.s.U() == null) {
            return p;
        }
        if (this.R == 15) {
            str = "portrait";
        } else {
            str = "landscape";
        }
        String c = this.s.U().c();
        int e = this.s.U().e();
        int f = this.s.U().f();
        String a2 = this.s.I().a();
        String T = this.s.T();
        String d = this.s.U().d();
        String b2 = this.s.U().b();
        String c2 = this.s.U().c();
        String Q = this.s.Q();
        new StringBuffer().append("appname=").append(URLEncoder.encode(c)).append("&stars=").append(e).append("&comments=").append(f).append("&icon=").append(URLEncoder.encode(a2)).append("&downloading=").append(true).append("&id=").append(URLEncoder.encode(T)).append("&pkg_name=").append(URLEncoder.encode(d)).append("&download_url=").append(URLEncoder.encode(b2)).append("&name=").append(URLEncoder.encode(c2)).append("&orientation=").append(str).append("&apptitle=").append(URLEncoder.encode(Q));
        String str2 = p + "?" + stringBuffer.toString();
        u.c("Playable", "Playable-loadH5Url=" + str2);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (!this.aW.getAndSet(true) && this.f != null && this.h != null) {
            ak.a((View) this.f, 0);
            ak.a((View) this.h, 8);
        }
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.e).a(false).b(false).a(sSWebView);
            sSWebView.getSettings().setUserAgentString(r.a(sSWebView, this.N));
            if (Build.VERSION.SDK_INT >= 21) {
                sSWebView.getSettings().setMixedContentMode(0);
            }
        }
    }

    protected boolean g() {
        if (this.h == null) {
            return false;
        }
        String L = L();
        if (TextUtils.isEmpty(L)) {
            return false;
        }
        this.h.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.e, this.G, this.s.T(), null) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.12
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                TTBaseVideoActivity.this.aI = str;
                if (TTBaseVideoActivity.this.aV) {
                    TTBaseVideoActivity.this.a(TTBaseVideoActivity.this.aE, "loading_h5_success");
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                TTBaseVideoActivity.this.aV = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTBaseVideoActivity.this.aV = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                TTBaseVideoActivity.this.aV = false;
            }
        });
        this.h.loadUrl(L);
        this.h.getSettings().setDisplayZoomControls(false);
        this.h.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.G, this.t));
        this.h.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.14
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTBaseVideoActivity.this.J.containsKey(str)) {
                    a aVar = TTBaseVideoActivity.this.J.get(str);
                    if (aVar != null) {
                        aVar.e();
                    }
                } else {
                    if (TTBaseVideoActivity.this.s != null && TTBaseVideoActivity.this.s.I() != null) {
                        TTBaseVideoActivity.this.s.I().a();
                    }
                    a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(TTBaseVideoActivity.this, str, TTBaseVideoActivity.this.s, TTBaseVideoActivity.this.aE);
                    TTBaseVideoActivity.this.J.put(str, a2);
                    a2.e();
                }
                TTBaseVideoActivity.this.S();
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        if (this.f != null) {
            this.t = new j(this, this.s, this.f).a(true);
            this.t.a(str);
            this.f.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.e, this.F, this.K, this.t) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.15
                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                    if (TTBaseVideoActivity.this.s.s()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        WebResourceResponse a2 = com.bytedance.sdk.openadsdk.core.g.a.a().a(TTBaseVideoActivity.this.s.F().j(), TTBaseVideoActivity.this.s.F().i(), str2);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (TTBaseVideoActivity.this.aJ != null) {
                            e.a a3 = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str2);
                            int i = a2 != null ? 1 : 2;
                            if (a3 == e.a.HTML) {
                                TTBaseVideoActivity.this.aJ.a(str2, currentTimeMillis, currentTimeMillis2, i);
                            } else if (a3 == e.a.JS) {
                                TTBaseVideoActivity.this.aJ.b(str2, currentTimeMillis, currentTimeMillis2, i);
                            }
                        }
                        return a2;
                    }
                    return super.shouldInterceptRequest(webView, str2);
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

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str2, String str3) {
                    TTBaseVideoActivity.this.ap.set(false);
                    TTBaseVideoActivity.this.ar = i;
                    TTBaseVideoActivity.this.as = str2;
                    if (TTBaseVideoActivity.this.aJ != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (Build.VERSION.SDK_INT >= 23) {
                                jSONObject.put("code", i);
                                jSONObject.put("msg", str2);
                            }
                            TTBaseVideoActivity.this.aJ.a(jSONObject);
                        } catch (JSONException e) {
                        }
                    }
                    super.onReceivedError(webView, i, str2, str3);
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
                        } catch (JSONException e) {
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
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    if (TTBaseVideoActivity.this.aJ != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (Build.VERSION.SDK_INT >= 21) {
                                jSONObject.put("code", webResourceResponse.getStatusCode());
                                jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                            }
                            TTBaseVideoActivity.this.aJ.a(jSONObject);
                        } catch (JSONException e) {
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
                public void onPageFinished(WebView webView, String str2) {
                    TTBaseVideoActivity.this.aI = str2;
                    if (TTBaseVideoActivity.this.aJ != null) {
                        TTBaseVideoActivity.this.aJ.f();
                    }
                    super.onPageFinished(webView, str2);
                    try {
                        if (TTBaseVideoActivity.this.s.t() && !TTBaseVideoActivity.this.isFinishing() && TTBaseVideoActivity.this.s.q() && !TTBaseVideoActivity.this.s.r()) {
                            TTBaseVideoActivity.this.I.sendMessageDelayed(TTBaseVideoActivity.this.d(0), 1000L);
                        }
                    } catch (Throwable th) {
                    }
                    try {
                        if (TTBaseVideoActivity.this.ap.get() && TTBaseVideoActivity.this.s.c() == 1 && TTBaseVideoActivity.this.s.s()) {
                            TTBaseVideoActivity.this.M();
                            TTBaseVideoActivity.this.b(true);
                            if (this.f6843b != null) {
                                this.f6843b.b(true);
                            }
                            TTBaseVideoActivity.this.a(TTBaseVideoActivity.this.aE, "py_loading_success");
                        }
                    } catch (Throwable th2) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                    TTBaseVideoActivity.this.aI = str2;
                    if (TTBaseVideoActivity.this.aJ != null) {
                        TTBaseVideoActivity.this.aJ.e();
                    }
                    super.onPageStarted(webView, str2, bitmap);
                    if (!TTBaseVideoActivity.this.aU && l.b(TTBaseVideoActivity.this.s)) {
                        TTBaseVideoActivity.this.aU = true;
                        boolean z = TTBaseVideoActivity.this instanceof TTRewardVideoActivity;
                        TTBaseVideoActivity.this.aB = com.bytedance.sdk.openadsdk.core.p.h().o(String.valueOf(TTBaseVideoActivity.this.T));
                        TTBaseVideoActivity.this.aC = com.bytedance.sdk.openadsdk.core.p.h().a(String.valueOf(TTBaseVideoActivity.this.T), z);
                        TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                        TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                        long j = TTBaseVideoActivity.this.aB;
                        tTBaseVideoActivity2.az = j;
                        tTBaseVideoActivity.aA = j;
                        TTBaseVideoActivity.this.I.sendEmptyMessageDelayed(600, TTBaseVideoActivity.this.aB * 1000);
                        Message obtain = Message.obtain();
                        if (TTBaseVideoActivity.this.aB == TTBaseVideoActivity.this.aC) {
                            obtain.what = 900;
                        } else {
                            obtain.what = 950;
                        }
                        obtain.arg1 = TTBaseVideoActivity.this.aB;
                        obtain.arg2 = TTBaseVideoActivity.this.aC;
                        TTBaseVideoActivity.this.I.sendMessage(obtain);
                        TTBaseVideoActivity.this.ax = System.currentTimeMillis();
                        HashMap hashMap = null;
                        if (!TextUtils.isEmpty(TTBaseVideoActivity.this.af)) {
                            hashMap = new HashMap();
                            hashMap.put("rit_scene", TTBaseVideoActivity.this.af);
                        }
                        if (z) {
                            com.bytedance.sdk.openadsdk.c.d.a(this.c, TTBaseVideoActivity.this.s, "rewarded_video", hashMap);
                        } else {
                            com.bytedance.sdk.openadsdk.c.d.a(this.c, TTBaseVideoActivity.this.s, "fullscreen_interstitial_ad", hashMap);
                        }
                        TTBaseVideoActivity.this.Q();
                        TTBaseVideoActivity.this.aD.set(true);
                    }
                }
            });
            a(this.f);
            if (this.s.c() == 1 && this.s.s()) {
                a(this.h);
                g();
            }
            if (Build.VERSION.SDK_INT >= 19) {
                SSWebView sSWebView = this.f;
                SSWebView.setWebContentsDebuggingEnabled(this.av);
                if (this.av) {
                    this.f.getSettings().setDomStorageEnabled(true);
                }
            }
            h();
            if ("reward_endcard".equals(str) || "fullscreen_endcard".equals(str)) {
                this.f.setLayerType(1, null);
                this.f.setBackgroundColor(-1);
            }
            this.f.getSettings().setDisplayZoomControls(false);
            this.f.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.F, this.t) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.16
                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    try {
                        if (TTBaseVideoActivity.this.s.t() && TTBaseVideoActivity.this.s.q() && !TTBaseVideoActivity.this.isFinishing() && TTBaseVideoActivity.this.f6097b != null) {
                            TTBaseVideoActivity.this.f6097b.setProgress(i);
                        }
                    } catch (Throwable th) {
                    }
                }
            });
            this.f.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.17
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                    if (TTBaseVideoActivity.this.J.containsKey(str2)) {
                        a aVar = TTBaseVideoActivity.this.J.get(str2);
                        if (aVar != null) {
                            aVar.e();
                        }
                    } else {
                        if (TTBaseVideoActivity.this.s != null && TTBaseVideoActivity.this.s.I() != null) {
                            TTBaseVideoActivity.this.s.I().a();
                        }
                        a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(TTBaseVideoActivity.this, str2, TTBaseVideoActivity.this.s, TTBaseVideoActivity.this.aE);
                        TTBaseVideoActivity.this.J.put(str2, a2);
                        a2.e();
                    }
                    TTBaseVideoActivity.this.S();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        if (this.aG) {
            this.f.loadUrl(this.O);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.s.c() != 1 || !this.s.s()) {
            boolean a2 = a(this.w, false);
            this.V.set(true);
            if (!a2) {
                t();
                HashMap hashMap = new HashMap();
                hashMap.put("vbtt_skip_type", 1);
                a(str, hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        if (this.n != null) {
            this.n.setText(this.ah ? A() : z());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        if (this.m != null) {
            int i = 6870;
            if (this.s.U() != null) {
                i = this.s.U().f();
            }
            this.m.setText(String.format(ac.a(this, "tt_comment_num"), i > 10000 ? (i / 10000) + "万" : i + ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        if (this.k != null) {
            if (this.s.I() != null && !TextUtils.isEmpty(this.s.I().a())) {
                com.bytedance.sdk.openadsdk.i.e.a(this.e).a(this.s.I().a(), this.k);
            } else {
                this.k.setImageResource(ac.d(this, "tt_ad_logo_small"));
            }
        }
        if (this.l != null) {
            if (this.R == 15 && this.s.U() != null && !TextUtils.isEmpty(this.s.U().c())) {
                this.l.setText(this.s.U().c());
            } else {
                this.l.setText(this.s.Q());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        this.O = this.s.F() != null ? this.s.F().i() : null;
        if (!TextUtils.isEmpty(this.O) && this.R == 15) {
            if (this.O.contains("?")) {
                this.O += "&orientation=portrait";
            } else {
                this.O += "?orientation=portrait";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (this.f6097b != null) {
            if (this.s == null || !this.s.q() || !this.s.t()) {
                this.f6097b.a();
                return;
            }
            this.f6097b.b();
            if (this.s != null && this.s.t() && this.s.r()) {
                this.I.sendMessageDelayed(d(2), 10000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message d(int i) {
        Message obtain = Message.obtain();
        obtain.what = 800;
        obtain.arg1 = i;
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        if (this.c != null) {
            this.c.setSoundMute(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        if (this.s.s() && this.s.c() == 1) {
            if (this.aw != null) {
                ak.a((View) this.aw, 8);
            }
        } else if (this.aw != null) {
            ak.a((View) this.aw, 0);
        }
    }

    protected void o() {
        if (this.aw != null) {
            ak.a((View) this.aw, 8);
        }
    }

    private void N() {
        this.aj = (LinearLayout) findViewById(ac.e(this, "tt_reward_full_endcard_backup"));
        this.ak = (TTRoundRectImageView) findViewById(ac.e(this, "tt_reward_ad_icon_backup"));
        this.al = (TextView) findViewById(ac.e(this, "tt_reward_ad_appname_backup"));
        this.am = (TTRatingBar) findViewById(ac.e(this, "tt_rb_score_backup"));
        this.an = (TextView) findViewById(ac.e(this, "tt_comment_backup"));
        this.ao = (TextView) findViewById(ac.e(this, "tt_reward_ad_download_backup"));
        if (this.am != null) {
            this.am.setStarEmptyNum(1);
            this.am.setStarFillNum(4);
            this.am.setStarImageWidth(ak.c(this, 16.0f));
            this.am.setStarImageHeight(ak.c(this, 16.0f));
            this.am.setStarImagePadding(ak.c(this, 4.0f));
            this.am.a();
        }
    }

    private void e(boolean z) {
        if (!z) {
            if (this.ak != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ak.getLayoutParams();
                layoutParams.setMargins(0, (int) ak.a(this, 50.0f), 0, 0);
                this.ak.setLayoutParams(layoutParams);
            }
            if (this.ao != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ao.getLayoutParams();
                layoutParams2.setMargins(0, (int) ak.a(this, 35.0f), 0, 0);
                layoutParams2.width = (int) ak.a(this, 342.0f);
                this.ao.setLayoutParams(layoutParams2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        if (this.ak != null) {
            if (this.s.I() != null && !TextUtils.isEmpty(this.s.I().a())) {
                com.bytedance.sdk.openadsdk.i.e.a(this.e).a(this.s.I().a(), this.ak);
            } else {
                this.ak.setImageResource(ac.d(this, "tt_ad_logo_small"));
            }
        }
        if (this.al != null) {
            if (this.s.U() != null && !TextUtils.isEmpty(this.s.U().c())) {
                this.al.setText(this.s.U().c());
            } else {
                this.al.setText(this.s.Q());
            }
        }
        if (this.an != null) {
            int i = 6870;
            if (this.s.U() != null) {
                i = this.s.U().f();
            }
            this.an.setText(String.format(ac.a(this, "tt_comment_num_backup"), i > 10000 ? (i / 10000) + "万" : i + ""));
        }
        if (this.ao != null) {
            this.ao.setText(z());
        }
    }

    private void O() {
        if (this.s != null) {
            int d = aj.d(this.s.W());
            com.bytedance.sdk.openadsdk.h.a.d f = com.bytedance.sdk.openadsdk.h.a.d.b().a(this.at).c(String.valueOf(d)).f(aj.h(this.s.W()));
            f.b(this.ar).g(this.as);
            f.h(this.s.W()).d(this.s.T());
            com.bytedance.sdk.openadsdk.h.a.a().l(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        if (this.d != null) {
            Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
            Keyframe ofFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
            Keyframe ofFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
            Keyframe ofFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
            Keyframe ofFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
            Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.d, PropertyValuesHolder.ofKeyframe("scaleX", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6), PropertyValuesHolder.ofKeyframe("scaleY", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6));
            ofPropertyValuesHolder.setDuration(1000L);
            ofPropertyValuesHolder.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        this.aJ = r();
        this.F = new x(this.e);
        this.F.b(this.f).a(this.s).a(this.K).a(this.j).b(this.L).a(this.M).a(this.av).a(this.aM).a(this.aN).a(this.aO).c(aj.h(this.s)).a(this.f).a(this.aJ).a(hashMap);
        this.G = new x(this);
        this.G.b(this.h).a(this.s).a(this.K).b(this.L).a(this.M).a(this.h).a(this.aJ).c(aj.h(this.s));
        this.F.a(new com.bytedance.sdk.openadsdk.g.b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.18
            @Override // com.bytedance.sdk.openadsdk.g.b
            public void a(boolean z, int i, String str) {
                u.b("end card load finish: ", "code=" + i + " msg=" + str + " isRenderSuc=" + z);
                if (z) {
                    TTBaseVideoActivity.this.aq = true;
                }
                if (TTBaseVideoActivity.this.aJ != null && l.e(TTBaseVideoActivity.this.s) && !l.a(TTBaseVideoActivity.this.s)) {
                    u.b("TTBaseVideoActivity", "TimeTrackLog report from js " + z);
                    if (z) {
                        TTBaseVideoActivity.this.aJ.b();
                    } else {
                        TTBaseVideoActivity.this.aJ.a(i, str);
                    }
                }
            }
        });
        this.F.a(new h() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.19
            @Override // com.bytedance.sdk.openadsdk.g.h
            public void a() {
                SSWebView sSWebView = TTBaseVideoActivity.this.g.get();
                if (sSWebView == null) {
                    u.b("TTBaseVideoActivity", "webView has destroy when onPauseWebView");
                    return;
                }
                sSWebView.onPause();
                u.b("TTBaseVideoActivity", "js make webView onPause OK");
            }

            @Override // com.bytedance.sdk.openadsdk.g.h
            public void b() {
                SSWebView sSWebView = TTBaseVideoActivity.this.g.get();
                if (sSWebView == null) {
                    u.b("TTBaseVideoActivity", "webView has destroy when onPauseWebViewTimers");
                    return;
                }
                sSWebView.pauseTimers();
                u.b("TTBaseVideoActivity", "js make webView pauseTimers OK");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        if ((Build.VERSION.SDK_INT < 17 || !isDestroyed()) && !isFinishing()) {
            if (this.aJ != null) {
                this.aJ.h();
            }
            this.aH = "endcard";
            this.Y.set(false);
            this.Z.set(false);
            if (this.C != null) {
                this.C.a();
            }
            c();
            if (this.ab != null && this.ab.isShowing()) {
                this.ab.dismiss();
            }
            if (this.B != null) {
                this.B.a();
            }
            if (this.c != null) {
                if (l.b(this.s)) {
                    this.c.setShowSkip(true);
                } else {
                    this.c.setShowSkip(false);
                }
                P();
                if (((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) && l.a(this.s)) {
                    this.c.setShowSound(true);
                }
            }
            if (!this.U.getAndSet(true)) {
                if (!l.a(this.s, this.ap.get(), this.aq) && !l.a(this.s)) {
                    u.b("TTBaseVideoActivity", "isEndCardLoadSuc=" + this.aq + " so load back up end card");
                    if (this.aJ != null) {
                        if (!l.e(this.s)) {
                            u.b("TTBaseVideoActivity", "TimeTrackLog report 408 from backup page");
                            this.aJ.a(408, "end_card_timeout");
                        }
                        this.aJ.c();
                        this.aJ.d();
                    }
                    ak.a((View) this.f, 8);
                    ak.a((View) this.aj, 0);
                    R();
                    U();
                    O();
                    return;
                }
                if (this.aJ != null && !l.e(this.s) && !l.a(this.s)) {
                    u.b("TTBaseVideoActivity", "TimeTrackLog report Success from Android");
                    this.aJ.b();
                }
                ak.a((View) this.f, 0.0f);
                ak.a((View) this.i, 0.0f);
                ak.a((View) this.j, 0.0f);
                ak.a((View) this.f, 0);
                if (this.s != null && this.s.s()) {
                    boolean z = this instanceof TTRewardVideoActivity;
                    int p = com.bytedance.sdk.openadsdk.core.p.h().p(String.valueOf(this.T));
                    if (this.s.c() == 1) {
                        p = (com.bytedance.sdk.openadsdk.core.p.h().o(String.valueOf(this.T)) + 1) * 1000;
                    }
                    if (p == -1) {
                        R();
                    } else if (p >= 0) {
                        this.I.sendEmptyMessageDelayed(600, p);
                    }
                } else if (this.s != null && !this.s.s()) {
                    int l = com.bytedance.sdk.openadsdk.core.p.h().l(String.valueOf(this.T));
                    if (l == -1) {
                        R();
                    } else if (l >= 0) {
                        this.I.sendEmptyMessageDelayed(600, l);
                    }
                }
                this.I.sendEmptyMessageDelayed(500, 20L);
                a(this.P, true);
                b(true);
                o();
                if (this.F != null) {
                    this.F.b(true);
                }
            }
        }
    }

    private void P() {
        if (this.s.ak()) {
            this.c.setShowDislike(true);
        } else {
            this.c.setShowDislike(false);
        }
    }

    private void R() {
        this.c.c();
        ak.a((View) this.i, 0);
        ak.a((View) this.j, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        return (this.D == null || this.D.t() == null || !this.D.t().g()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v() {
        return (this.D == null || this.D.t() == null || !this.D.t().i()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w() {
        return this.D != null && this.D.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, JSONObject jSONObject) {
        if (this instanceof TTFullScreenVideoActivity) {
            com.bytedance.sdk.openadsdk.c.d.a(this.e, this.s, "fullscreen_interstitial_ad", str, (JSONObject) null);
        }
        if (this instanceof TTRewardVideoActivity) {
            com.bytedance.sdk.openadsdk.c.d.a(this.e, this.s, "rewarded_video", str, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void x() {
        if (this.s != null) {
            String str = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
            final String str2 = str;
            this.aR = new com.bytedance.sdk.openadsdk.core.a.e(this, this.s, str, this.M) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.20
                @Override // com.bytedance.sdk.openadsdk.core.a.e
                public void a_(View view, int i, int i2, int i3, int i4) {
                    TTBaseVideoActivity.this.a(view, i, i2, i3, i4);
                    TTBaseVideoActivity.this.aS = view.getId() == ac.e(TTBaseVideoActivity.this, "tt_video_reward_bar");
                    TTBaseVideoActivity.this.aL = view;
                    if (view.getId() == ac.e(TTBaseVideoActivity.this, "tt_playable_play") && TTBaseVideoActivity.this.s.t()) {
                        HashMap hashMap = new HashMap();
                        if (TTBaseVideoActivity.this.s.F() != null) {
                            hashMap.put("playable_url", TTBaseVideoActivity.this.s.F().i());
                        }
                        com.bytedance.sdk.openadsdk.c.d.k(TTBaseVideoActivity.this, TTBaseVideoActivity.this.s, str2, "click_playable_download_button_loading", hashMap);
                    }
                    if (TTBaseVideoActivity.this.E == null) {
                        TTBaseVideoActivity.this.a(view);
                    } else if (view.getId() == ac.e(TTBaseVideoActivity.this, "tt_rb_score")) {
                        TTBaseVideoActivity.this.a("click_play_star_level", (JSONObject) null);
                    } else if (view.getId() == ac.e(TTBaseVideoActivity.this, "tt_comment_vertical")) {
                        TTBaseVideoActivity.this.a("click_play_star_nums", (JSONObject) null);
                    } else if (view.getId() == ac.e(TTBaseVideoActivity.this, "tt_reward_ad_appname")) {
                        TTBaseVideoActivity.this.a("click_play_source", (JSONObject) null);
                    } else if (view.getId() == ac.e(TTBaseVideoActivity.this, "tt_reward_ad_icon")) {
                        TTBaseVideoActivity.this.a("click_play_logo", (JSONObject) null);
                    }
                }
            };
            this.aR.a(this.d);
            if (!TextUtils.isEmpty(this.af)) {
                HashMap hashMap = new HashMap();
                hashMap.put("rit_scene", this.af);
                this.aR.a(hashMap);
            }
            if (this.E != null) {
                this.aR.a(this.E);
                this.E.a(1, new a.InterfaceC1019a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a.InterfaceC1019a
                    public boolean a(int i, l lVar, String str3, String str4, Object obj) {
                        if (i == 1 && lVar != null && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                            if (str3.equals("rewarded_video") && str4.equals("click_start")) {
                                TTBaseVideoActivity.this.a(TTBaseVideoActivity.this.aL);
                                TTBaseVideoActivity.this.aL = null;
                            } else if (str3.equals("fullscreen_interstitial_ad") && str4.equals("click_start")) {
                                TTBaseVideoActivity.this.a(TTBaseVideoActivity.this.aL);
                                TTBaseVideoActivity.this.aL = null;
                            } else if (str3.equals("fullscreen_interstitial_ad") || str3.equals("rewarded_video")) {
                                char c = 65535;
                                switch (str4.hashCode()) {
                                    case -1297985154:
                                        if (str4.equals("click_continue")) {
                                            c = 1;
                                            break;
                                        }
                                        break;
                                    case -777040223:
                                        if (str4.equals("click_open")) {
                                            c = 2;
                                            break;
                                        }
                                        break;
                                    case 1682049151:
                                        if (str4.equals("click_pause")) {
                                            c = 0;
                                            break;
                                        }
                                        break;
                                }
                                switch (c) {
                                    case 0:
                                        com.bytedance.sdk.openadsdk.c.d.a(TTBaseVideoActivity.this, TTBaseVideoActivity.this.s, str3, "click_play_pause", (Map<String, Object>) null);
                                        break;
                                    case 1:
                                        com.bytedance.sdk.openadsdk.c.d.a(TTBaseVideoActivity.this, TTBaseVideoActivity.this.s, str3, "click_play_continue", (Map<String, Object>) null);
                                        break;
                                    case 2:
                                        com.bytedance.sdk.openadsdk.c.d.i(TTBaseVideoActivity.this.e, TTBaseVideoActivity.this.s, str3, "click_play_open", null);
                                        break;
                                }
                            } else if (str3.equals("rewarded_video_landingpage") && "click_open".equals(str4) && TTBaseVideoActivity.this.s.s() && TTBaseVideoActivity.this.s.c() == 1) {
                                com.bytedance.sdk.openadsdk.c.d.i(TTBaseVideoActivity.this.e, TTBaseVideoActivity.this.s, str3, "click_play_open", null);
                            }
                        }
                        return true;
                    }
                });
            }
            if (this.f6097b != null && this.f6097b.getPlayView() != null && this.s != null && this.s.t()) {
                this.f6097b.getPlayView().setOnClickListener(this.aR);
                this.f6097b.getPlayView().setOnTouchListener(this.aR);
            }
            if (this.s != null && this.s.i() != null) {
                if (this.s.i().e) {
                    this.n.setOnClickListener(this.aR);
                    this.n.setOnTouchListener(this.aR);
                } else {
                    this.n.setOnClickListener(this.aX);
                }
                if (this.ag) {
                    if (this.s.i().f6493a) {
                        ak.a((View) this.d, (View.OnClickListener) this.aR, "TTBaseVideoActivity#mRlDownloadBar");
                        ak.a((View) this.d, (View.OnTouchListener) this.aR, "TTBaseVideoActivity#mRlDownloadBar");
                        this.l.setOnClickListener(this.aR);
                        this.l.setOnTouchListener(this.aR);
                        this.m.setOnClickListener(this.aR);
                        this.m.setOnTouchListener(this.aR);
                        this.r.setOnClickListener(this.aR);
                        this.r.setOnTouchListener(this.aR);
                        this.k.setOnClickListener(this.aR);
                        this.k.setOnTouchListener(this.aR);
                    } else {
                        ak.a(this.d, this.aX, "TTBaseVideoActivity#mRlDownloadBar");
                        this.l.setOnClickListener(this.aX);
                        this.m.setOnClickListener(this.aX);
                        this.r.setOnClickListener(this.aX);
                        this.k.setOnClickListener(this.aX);
                    }
                } else if (this.s.i().c) {
                    ak.a((View) this.d, (View.OnClickListener) this.aR, "TTBaseVideoActivity#mRlDownloadBar");
                    ak.a((View) this.d, (View.OnTouchListener) this.aR, "TTBaseVideoActivity#mRlDownloadBar");
                } else {
                    ak.a(this.d, this.aX, "TTBaseVideoActivity#mRlDownloadBar");
                }
            }
            if (this.o != null && this.s != null && this.s.i() != null) {
                if (this.s.i().f) {
                    this.o.setOnClickListener(this.aR);
                } else {
                    this.o.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            TTBaseVideoActivity.this.a(view);
                        }
                    });
                }
            }
            if (this.ag) {
                if (this.s.i() != null && this.p != null) {
                    ak.a((View) this.p, 0);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
                    layoutParams.height = this.ai;
                    this.p.setLayoutParams(layoutParams);
                    if (this.s.i().f6494b) {
                        this.p.setOnClickListener(this.aR);
                        this.p.setOnTouchListener(this.aR);
                    } else {
                        this.p.setOnClickListener(this.aX);
                    }
                }
                if (this.s.i() != null && this.q != null) {
                    ak.a((View) this.q, 0);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                    layoutParams2.height = this.ai;
                    this.q.setLayoutParams(layoutParams2);
                    if (this.s.i().d) {
                        this.q.setOnClickListener(this.aR);
                        this.q.setOnTouchListener(this.aR);
                    } else {
                        this.q.setOnClickListener(this.aX);
                    }
                }
            }
            ak.a(this.aj, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            }, "TTBaseVideoActivity#mLLEndCardBackup");
            this.ao.setOnClickListener(this.aR);
            this.ao.setOnTouchListener(this.aR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view != null) {
            if (view.getId() == ac.e(this, "tt_rb_score")) {
                a("click_play_star_level", (JSONObject) null);
            } else if (view.getId() == ac.e(this, "tt_comment_vertical")) {
                a("click_play_star_nums", (JSONObject) null);
            } else if (view.getId() == ac.e(this, "tt_reward_ad_appname")) {
                a("click_play_source", (JSONObject) null);
            } else if (view.getId() == ac.e(this, "tt_reward_ad_icon")) {
                a("click_play_logo", (JSONObject) null);
            } else if (view.getId() == ac.e(this, "tt_video_reward_bar") || view.getId() == ac.e(this, "tt_click_lower_non_content_layout") || view.getId() == ac.e(this, "tt_click_upper_non_content_layout")) {
                a("click_start_play_bar", y());
            } else if (view.getId() == ac.e(this, "tt_reward_ad_download")) {
                a("click_start_play", y());
            } else if (view.getId() == ac.e(this, "tt_video_reward_container")) {
                a("click_video", y());
            } else if (view.getId() == ac.e(this, "tt_reward_ad_download_backup")) {
                a("fallback_endcard_click", y());
            }
        }
    }

    protected JSONObject y() {
        int i;
        long j = 0;
        try {
            if (this.D == null) {
                i = 0;
            } else {
                j = this.D.p();
                i = this.D.q();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", j);
                jSONObject.put("percent", i);
                return jSONObject;
            } catch (Throwable th) {
                return jSONObject;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    protected String z() {
        if (this.s == null) {
            return "立即下载";
        }
        if (TextUtils.isEmpty(this.s.S())) {
            if (this.s.H() == 4) {
                return "立即下载";
            }
            return "查看详情";
        }
        return this.s.S();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(1:3)(1:63)|4|5|(2:9|(6:11|12|13|(1:15)(1:(1:55))|16|(1:18)(5:20|(3:22|(1:(1:25)(1:(1:33)))|34)(2:35|(2:(1:(1:51)(1:(1:53)))|34)(1:(1:42)(2:(1:44)|34)))|(1:29)|30|31)))|60|12|13|(0)(0)|16|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String A() {
        boolean z;
        String f;
        String str = "下载";
        String b2 = aj.b(this);
        String str2 = b2 == null ? "" : b2;
        try {
        } catch (Throwable th) {
            z = true;
        }
        if (!str2.equals(Locale.CHINESE.getLanguage()) && !str2.equals(Locale.CHINA.getLanguage())) {
            if (!str2.equals(Locale.TRADITIONAL_CHINESE.getLanguage())) {
                z = false;
                boolean z2 = str2.equals(Locale.ENGLISH.getLanguage());
                if (z) {
                    str = "下载";
                } else if (z2) {
                    str = "Install";
                }
                if (this.s != null) {
                    if (TextUtils.isEmpty(this.s.S())) {
                        if (this.s.H() != 4) {
                            if (z) {
                                f = "查看";
                            } else if (z2) {
                                f = "View";
                            }
                        }
                        f = str;
                    } else {
                        str = this.s.S();
                        if (str != null && aj.j(str) && str.length() > 2) {
                            if (z) {
                                f = f(true);
                            } else {
                                if (z2) {
                                    f = f(false);
                                }
                                f = str;
                            }
                        } else {
                            if (str != null && !aj.j(str) && str.length() > 7) {
                                if (z) {
                                    f = f(true);
                                } else if (z2) {
                                    f = f(false);
                                }
                            }
                            f = str;
                        }
                    }
                    if (z2 && !aj.j(f)) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                        layoutParams.bottomMargin = ak.c(this, 4.0f);
                        this.n.setLayoutParams(layoutParams);
                    }
                    return f;
                }
                return str;
            }
        }
        z = true;
        boolean z22 = str2.equals(Locale.ENGLISH.getLanguage());
        if (z) {
        }
        if (this.s != null) {
        }
    }

    private String f(boolean z) {
        if (this.s == null) {
            return null;
        }
        if (z) {
            if (this.s.H() != 4) {
                return "查看";
            }
            return "下载";
        } else if (this.s.H() != 4) {
            return "View";
        } else {
            return "Install";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        if (this.ah) {
            int[] iArr = {Color.parseColor("#0070FF")};
            com.bytedance.sdk.openadsdk.core.widget.f.a((LinearLayout) findViewById(ac.e(this, "tt_reward_ad_download_layout")), new f.a().a(iArr[0]).b(Color.parseColor("#80000000")).a(iArr).c(ak.c(this, 17.0f)).d(0).e(ak.c(this, 3.0f)));
        }
    }

    void C() {
        if (this.C == null) {
            this.C = new c(this, this.s);
            this.C.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.6
                @Override // com.bytedance.sdk.openadsdk.dislike.c.a
                public void a() {
                    TTBaseVideoActivity.this.Y.set(true);
                    if (TTBaseVideoActivity.this.u()) {
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
                            if (TTBaseVideoActivity.this.v()) {
                                TTBaseVideoActivity.this.D.j();
                            }
                        }
                    } catch (Throwable th) {
                        u.c("TTBaseVideoActivity", "dislike callback selected error: ", th);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.c.a
                public void a(int i, FilterWord filterWord) {
                    try {
                        if (!TTBaseVideoActivity.this.Z.get()) {
                            TTBaseVideoActivity.this.Z.set(true);
                            TTBaseVideoActivity.this.Y();
                        }
                        if (TTBaseVideoActivity.this.v()) {
                            TTBaseVideoActivity.this.D.j();
                        }
                    } catch (Throwable th) {
                        u.c("TTBaseVideoActivity", "comment callback selected error: ", th);
                    }
                }
            });
        }
        if (this.A == null) {
            this.A = new RewardDislikeDialogNew(this, this.s);
            this.A.setCallback(new RewardDislikeDialogNew.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.7
                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.a
                public void a(View view) {
                    TTBaseVideoActivity.this.Y.set(true);
                    if (TTBaseVideoActivity.this.u()) {
                        TTBaseVideoActivity.this.D.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.a
                public void b(View view) {
                    TTBaseVideoActivity.this.Y.set(false);
                    if (TTBaseVideoActivity.this.v()) {
                        TTBaseVideoActivity.this.D.j();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.a
                public void a(int i, FilterWord filterWord) {
                    if (!TTBaseVideoActivity.this.Z.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                        TTBaseVideoActivity.this.Z.set(true);
                        TTBaseVideoActivity.this.Y();
                        TTBaseVideoActivity.this.C.hide();
                    }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        this.aT = true;
        u.b("TTBaseVideoActivity", "onResume mIsActivityShow=" + this.aT + " mIsMute=" + this.P);
        if (this.c != null && this.U.get()) {
            P();
        }
        if (l.b(this.s) || l.c(this.s)) {
            if (this.aP == 0) {
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
        if (this.f != null) {
            this.f.onResume();
        }
        if (this.au != null) {
            this.au.a(this);
            this.au.e();
        }
        if (!this.U.get()) {
            if (Build.VERSION.SDK_INT >= 26 || "C8817D".equals(this.ac) || "M5".equals(this.ac) || "R7t".equals(this.ac)) {
                if (!this.Y.get()) {
                    D();
                }
            } else if (v() && !this.Y.get()) {
                this.D.j();
            }
        }
        if (this.F != null) {
            this.F.g();
            if (this.f != null) {
                if (this.f.getVisibility() == 0) {
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
        if (this.E != null) {
            this.E.a(this);
            this.E.b();
        }
        if (this.t != null) {
            this.t.b();
        }
        if (this.aD.get() && this.s != null && this.s.c() == 1 && this.s.s()) {
            c("return_foreground");
            if ((this.ab == null || (this.ab != null && !this.ab.isShowing())) && this.ay > 0) {
                Message obtain = Message.obtain();
                if (this.aB == this.aC) {
                    obtain.what = 900;
                } else {
                    obtain.what = 950;
                }
                obtain.arg1 = this.ay;
                obtain.arg2 = this.aC;
                this.I.sendMessage(obtain);
            }
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.aJ != null) {
            this.aJ.k();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        u.b("TTBaseVideoActivity", "onStop mIsMute=" + this.P + " mLast=" + this.au.b() + " mVolume=" + this.aP);
        if (this.aJ != null) {
            this.aJ.j();
        }
        if (this.t != null) {
            this.t.c();
        }
        if (this.s != null && this.s.c() == 1 && this.s.s()) {
            this.I.removeMessages(700);
            this.I.removeMessages(950);
            this.I.removeMessages(900);
            this.I.removeMessages(600);
            c("go_background");
        }
        if (this.P) {
            runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (TTBaseVideoActivity.this.au.b() > 0) {
                        TTBaseVideoActivity.this.au.a(false);
                    }
                }
            });
        }
    }

    protected void D() {
        if (!this.V.getAndSet(false) && this.D != null) {
            if (this.D.t() != null) {
                com.bytedance.sdk.openadsdk.core.video.c.d t = this.D.t();
                if (t.i() || t.j()) {
                    ((com.bytedance.sdk.openadsdk.core.video.b.a) this.D).x();
                    a(this.w, true);
                }
            } else if (this.aY) {
                ((com.bytedance.sdk.openadsdk.core.video.b.a) this.D).x();
                a(this.w, true);
                this.aY = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.aT = false;
        u.b("TTBaseVideoActivity", "onPause mIsActivityShow=" + this.aT + " mIsMute=" + this.P);
        if (this.f != null) {
            this.f.onPause();
        }
        if (Build.VERSION.SDK_INT >= 26 || "C8817D".equals(this.ac) || "M5".equals(this.ac) || "R7t".equals(this.ac)) {
            if (!this.Y.get()) {
                T();
            }
        } else {
            try {
                if (u() && !this.Y.get()) {
                    this.D.h();
                }
            } catch (Throwable th) {
                u.f("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
            }
        }
        if (this.F != null) {
            this.F.h();
            this.F.b(false);
            b(false);
            a(true, false);
        }
        if (this.E != null) {
            this.E.c();
        }
        if (this.s != null && this.s.c() == 1 && this.s.s()) {
            this.I.removeMessages(700);
            this.I.removeMessages(950);
            this.I.removeMessages(900);
            this.I.removeMessages(600);
            c("go_background");
        }
    }

    private void T() {
        if (this.D != null && this.D.t() != null) {
            this.w = this.D.m();
            if (this.D.t().h() || !this.D.t().l()) {
                this.D.h();
                this.D.k();
                this.aY = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aJ != null) {
            this.aJ.a(true);
            this.aJ.m();
        }
        if (this.B != null) {
            this.B.b();
        }
        if (this.I != null) {
            this.I.removeCallbacksAndMessages(null);
        }
        aa.a(this.e, this.f);
        aa.a(this.f);
        if (this.D != null) {
            this.D.k();
            this.D = null;
        }
        this.f = null;
        if (this.F != null) {
            this.F.i();
        }
        if (this.E != null) {
            this.E.d();
        }
        if (this.t != null) {
            this.t.d();
        }
        if (this.au != null) {
            this.au.f();
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("material_meta", this.s != null ? this.s.am().toString() : null);
            bundle.putString("multi_process_meta_md5", this.u);
            bundle.putLong("video_current", this.D == null ? this.w : this.D.m());
            bundle.putString("video_cache_url", this.x);
            bundle.putInt("orientation", this.y);
            bundle.putBoolean("is_mute", this.P);
            bundle.putBoolean("is_bar_click_first", this.aS);
        } catch (Throwable th) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (l.d(this.s) && this.f != null && this.f.canGoBack()) {
            this.f.goBack();
        }
    }

    private void U() {
        if (this.c != null) {
            this.c.setShowSound(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (message.what == 500) {
            if (!l.a(this.s)) {
                U();
            }
            SSWebView sSWebView = this.g.get();
            if (sSWebView != null) {
                sSWebView.onResume();
                sSWebView.resumeTimers();
            }
            if (this.c != null) {
                this.c.setShowCountDown(false);
            }
            if (this.f != null) {
                ak.a((View) this.f, 1.0f);
                ak.a((View) this.i, 1.0f);
                ak.a((View) this.j, 1.0f);
            }
            if ((this instanceof TTFullScreenVideoActivity) && this.D != null && u() && this.X.get()) {
                this.D.i();
                this.D.l();
            }
        } else if (message.what == 600) {
            R();
        } else if (message.what == 700) {
            if (this.s.c() == 1) {
                int i = message.arg1;
                if (i > 0) {
                    if (this.c != null) {
                        this.c.setShowCountDown(true);
                        this.c.a(String.valueOf(i), (CharSequence) null);
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 700;
                    obtain.arg1 = i - 1;
                    this.az--;
                    this.I.sendMessageDelayed(obtain, 1000L);
                    this.ay = i - 1;
                    if (i == 1) {
                        this.I.sendEmptyMessageDelayed(600, 1000L);
                    }
                } else {
                    if (this.c != null) {
                        this.c.setShowCountDown(false);
                    }
                    if (this instanceof TTRewardVideoActivity) {
                        f(10001);
                    } else {
                        f(10002);
                    }
                }
                if (this instanceof TTRewardVideoActivity) {
                    V();
                }
            }
        } else if (message.what == 800) {
            HashMap hashMap = new HashMap();
            hashMap.put("remove_loading_page_type", Integer.valueOf(message.arg1));
            if (this.s.F() != null) {
                hashMap.put("playable_url", this.s.F().i());
            }
            com.bytedance.sdk.openadsdk.c.d.k(this, this.s, this.aE, "remove_loading_page", hashMap);
            this.I.removeMessages(800);
            if (this.f6097b != null) {
                this.f6097b.a();
            }
        } else if (message.what == 900) {
            if (this.s.c() == 1) {
                int i2 = message.arg1;
                if (i2 > 0) {
                    if (this.c != null) {
                        this.c.setShowSkip(true);
                        this.c.a(String.valueOf(i2), (CharSequence) null);
                    }
                    Message obtain2 = Message.obtain();
                    obtain2.what = 900;
                    obtain2.arg1 = i2 - 1;
                    this.az--;
                    this.I.sendMessageDelayed(obtain2, 1000L);
                    this.ay = i2 - 1;
                    if (i2 == 1) {
                        this.I.sendEmptyMessageDelayed(600, 1000L);
                    }
                } else {
                    if (this.c != null) {
                        this.c.setShowSkip(false);
                    }
                    if (this instanceof TTRewardVideoActivity) {
                        f(10001);
                    } else {
                        f(10002);
                    }
                }
                if (this instanceof TTRewardVideoActivity) {
                    V();
                }
            }
        } else if (message.what == 950) {
            if (this.s.c() == 1) {
                int i3 = message.arg1;
                int i4 = message.arg2;
                if (i3 > 0) {
                    if (i3 == 1) {
                        this.I.sendEmptyMessageDelayed(600, 1000L);
                    }
                    if (this.aB - i3 < i4) {
                        int i5 = i4 - (this.aB - i3);
                        if (this.c != null) {
                            this.c.setShowSkip(true);
                            this.c.a(String.valueOf(i3), "可在(" + i5 + "s)后跳过");
                        }
                        Message obtain3 = Message.obtain();
                        obtain3.what = 950;
                        obtain3.arg1 = i3 - 1;
                        obtain3.arg2 = i4;
                        this.az--;
                        this.I.sendMessageDelayed(obtain3, 1000L);
                        this.ay = i3 - 1;
                    } else {
                        if (this.c != null) {
                            this.c.setShowSkip(true);
                            this.c.a(String.valueOf(i3), "跳过");
                            this.c.setSkipEnable(true);
                        }
                        Message obtain4 = Message.obtain();
                        obtain4.what = 950;
                        obtain4.arg1 = i3 - 1;
                        this.az--;
                        this.I.sendMessageDelayed(obtain4, 1000L);
                        this.ay = i3 - 1;
                    }
                } else {
                    if (this.c != null) {
                        this.c.setShowSkip(false);
                        this.c.a(String.valueOf(i3), (CharSequence) null);
                    }
                    if (this instanceof TTRewardVideoActivity) {
                        f(10001);
                    } else {
                        f(10002);
                    }
                }
                if (this instanceof TTRewardVideoActivity) {
                    V();
                }
            }
        } else if (message.what == 300) {
            if (this.D != null && this.D.t() != null) {
                this.D.t().d();
            }
            if (this.D != null) {
                this.D.l();
            }
            t();
            if (message.arg1 == 1) {
                f(10000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
        if (this.I != null) {
            this.I.removeMessages(700);
            this.I.removeMessages(900);
            this.I.removeMessages(950);
            this.I.removeMessages(600);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
        if (this.I != null) {
            Message obtain = Message.obtain();
            if (this.aB == this.aC) {
                obtain.what = 900;
            } else {
                obtain.what = 950;
            }
            obtain.arg1 = this.ay;
            this.I.sendMessageDelayed(obtain, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        boolean z = true;
        int i = com.bytedance.sdk.openadsdk.core.p.h().r(String.valueOf(this.T)).g;
        if (l.c(this.s)) {
            if ((1.0d - (this.Q / J())) * 100.0d < i) {
                z = false;
            }
        } else {
            boolean z2 = (1.0f - (((float) this.ay) / ((float) com.bytedance.sdk.openadsdk.core.p.h().o(String.valueOf(this.T))))) * 100.0f >= ((float) i);
            int m = com.bytedance.sdk.openadsdk.core.p.h().m(String.valueOf(this.T));
            if (m == 0) {
                if (!z2 || !this.F.c()) {
                    z = false;
                }
            } else {
                z = m == 1 ? z2 : false;
            }
        }
        if (z) {
            f(10000);
        }
    }

    private void a(final String str, final long j, final long j2, final String str2, final String str3) {
        com.bytedance.sdk.openadsdk.k.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.9
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

    protected IListenerManager a(int i) {
        return com.bytedance.sdk.openadsdk.multipro.aidl.a.a.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.p.a()).a(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IListenerManager b(int i) {
        if (this.ae == null) {
            this.ae = com.bytedance.sdk.openadsdk.multipro.aidl.a.a.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.p.a()).a(i));
        }
        return this.ae;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        this.Y.set(false);
        this.Z.set(false);
        if (this.C != null) {
            this.C.a();
        }
        if (this.c != null) {
            this.c.setShowSkip(false);
            this.c.setShowCountDown(false);
            P();
            this.c.setShowSound(l.a(this.s));
            if (((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) && l.a(this.s)) {
                this.c.setShowSound(true);
                this.c.setShowSkip(true);
            }
        }
        c();
        if (this.B != null) {
            this.B.a();
        }
        if (!this.U.getAndSet(true)) {
            this.X.set(true);
            if (!l.a(this.s, this.ap.get(), this.aq) && !l.a(this.s)) {
                u.b("TTBaseVideoActivity", "showEndcardForSkip isEndCardLoadSuc=" + this.aq + " so load back up end card");
                if (this.aJ != null) {
                    if (!l.e(this.s)) {
                        u.b("TTBaseVideoActivity", "TimeTrackLog report 408 from backup page after skip");
                        this.aJ.a(408, "end_card_timeout");
                    }
                    this.aJ.c();
                    this.aJ.d();
                }
                ak.a((View) this.f, 8);
                ak.a((View) this.aj, 0);
                R();
                U();
                O();
                if ((this instanceof TTFullScreenVideoActivity) && this.D != null && u() && this.X.get()) {
                    this.D.i();
                    this.D.l();
                    return;
                }
                return;
            }
            if (this.aJ != null && !l.e(this.s) && !l.a(this.s)) {
                u.b("TTBaseVideoActivity", "TimeTrackLog report Success from Android after skip");
                this.aJ.b();
            }
            if (Build.VERSION.SDK_INT >= 11) {
                ak.a((View) this.f, 0.0f);
                ak.a((View) this.i, 0.0f);
                ak.a((View) this.j, 0.0f);
            }
            ak.a((View) this.f, 0);
            if (this.s != null && this.s.s()) {
                int p = com.bytedance.sdk.openadsdk.core.p.h().p(String.valueOf(this.T));
                if (p == -1) {
                    R();
                } else if (p >= 0) {
                    this.I.sendEmptyMessageDelayed(600, p);
                }
            } else if (this.s != null && !this.s.s()) {
                int l = com.bytedance.sdk.openadsdk.core.p.h().l(String.valueOf(this.T));
                if (l == -1) {
                    R();
                } else if (l >= 0) {
                    this.I.sendEmptyMessageDelayed(600, l);
                }
            }
            this.I.sendEmptyMessageDelayed(500, 100L);
            a(this.P, true);
            if (this.F != null) {
                this.F.b(true);
                b(true);
            }
            o();
        }
    }

    protected void a(boolean z, boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.F.a("endcard_control_event", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void b(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.F.a("viewableChange", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.F.a("volumeChange", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void a(int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.F.a(ResizeImageAction.ACTION_NAME, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, String str2, Map<String, Object> map) {
        if (this.D != null) {
            Map<String, Object> a2 = aj.a(this.s, this.D.n(), this.D.t());
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    a2.put(entry.getKey(), entry.getValue());
                }
            }
            com.bytedance.sdk.openadsdk.c.d.a(this.e, this.s, str, str2, this.D.o(), this.D.q(), a2);
            u.b("TTBaseVideoActivity", "event tag:" + str + ", TotalPlayDuration=" + this.D.o() + ",mBasevideoController.getPct()=" + this.D.q());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Map<String, Object> map) {
        if (this.D != null) {
            Map<String, Object> a2 = aj.a(this.s, this.D.n(), this.D.t());
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    a2.put(entry.getKey(), entry.getValue());
                }
            }
            a2.put("play_type", Integer.valueOf(aj.a(this.D, this.z)));
            com.bytedance.sdk.openadsdk.c.d.a(this.e, this.s, str, "endcard_skip", this.D.o(), this.D.q(), a2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.g.f
    public void c(int i) {
        if (i > 0) {
            if (this.aP > 0) {
                this.aP = i;
            } else {
                u.b("onVolumeChanged", "onVolumeChanged >>>> 变为非静音状态通知 h5");
                c(false);
                this.aP = i;
            }
        } else if (this.aP > 0) {
            u.b("onVolumeChanged", "onVolumeChanged >>>> 变为静音状态通知 h5");
            c(true);
            this.aP = i;
        } else {
            this.aP = i;
        }
        if (l.b(this.s) || l.c(this.s)) {
            if (this.au.c()) {
                u.b("TTBaseVideoActivity", "onVolumeChanged by SDK mIsMute=" + this.P + " mVolume=" + this.aP + " mLastVolume=" + this.au.b());
                if (this.aP == 0) {
                    a(true);
                    if (this.D != null) {
                        this.D.c(true);
                        return;
                    }
                    return;
                }
                a(false);
                if (this.D != null) {
                    this.D.c(false);
                    return;
                }
                return;
            }
            this.au.b(-1);
            u.b("TTBaseVideoActivity", "onVolumeChanged by User mIsMute=" + this.P + " mVolume=" + this.aP + " mLastVolume=" + this.au.b());
            if (this.aT) {
                if (this.aP == 0) {
                    this.P = true;
                    a(true);
                    if (this.D != null) {
                        this.D.c(true);
                        return;
                    }
                    return;
                }
                this.P = false;
                a(false);
                if (this.D != null) {
                    this.D.c(false);
                }
            }
        }
    }

    void c(String str) {
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

    @Override // com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver.a
    public void H() {
        this.aF = true;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver.a
    public void I() {
        this.aF = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context) {
        try {
            this.H = new HomeWatcherReceiver();
            this.H.a(this);
            context.registerReceiver(this.H, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (Throwable th) {
        }
    }

    protected void b(Context context) {
        try {
            this.H.a(null);
            context.unregisterReceiver(this.H);
        } catch (Throwable th) {
        }
    }

    public double J() {
        if (this.s == null || this.s.F() == null) {
            return 0.0d;
        }
        return this.s.F().e();
    }

    protected static float a(Activity activity) {
        return ak.b(activity, ak.g(activity));
    }

    protected static float b(Activity activity) {
        return ak.b(activity, ak.h(activity));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K() {
        if (!isFinishing()) {
            if (this.Z.get()) {
                X();
                return;
            }
            if (this.A == null) {
                C();
            }
            W();
            this.A.a(this.aH);
            this.A.a();
        }
    }

    private void W() {
        if (!"".equals(this.aI) && !this.aI.isEmpty() && !u()) {
            if (!this.aI.contains("playable")) {
                l lVar = this.s;
                if (!l.b(this.s)) {
                    if (this.aI.contains("endcard")) {
                        this.aH = "endcard";
                        return;
                    } else if (this.s.s() && this.aH.equals("endcard")) {
                        this.aH = "playable";
                        return;
                    } else {
                        return;
                    }
                }
            }
            this.aH = "playable";
        }
    }

    private void X() {
        this.B.a("您已成功提交反馈，请勿重复提交哦！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        this.B.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(boolean z) {
        if (this.aQ == null) {
            this.aQ = new ProgressBar(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.aQ.setLayoutParams(layoutParams);
            this.aQ.setIndeterminateDrawable(getResources().getDrawable(ac.d(this, "tt_video_loading_progress_bar")));
            this.o.addView(this.aQ);
        }
        if (z) {
            this.aQ.setVisibility(0);
        } else {
            this.aQ.setVisibility(8);
        }
    }

    public static float[] a(l lVar, Activity activity, int i) {
        float f;
        boolean z = lVar.X() == 15;
        float a2 = a(activity);
        float b2 = b(activity);
        if (z != (a2 > b2)) {
            float f2 = a2 + b2;
            b2 = f2 - b2;
            a2 = f2 - b2;
        }
        if (z) {
            a2 -= i;
            f = b2;
        } else {
            f = b2 - i;
        }
        return new float[]{f, a2};
    }
}
