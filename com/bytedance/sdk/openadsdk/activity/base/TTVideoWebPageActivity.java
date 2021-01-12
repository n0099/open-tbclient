package com.bytedance.sdk.openadsdk.activity.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.baidu.sapi2.SapiContext;
import com.baidu.webkit.internal.ETAG;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeToast;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TTVideoWebPageActivity extends Activity implements d {
    private l A;
    private c B;
    private RelativeLayout G;
    private TextView H;
    private RoundImageView I;
    private TextView J;
    private TextView K;
    private ViewStub L;
    private Button M;
    private ProgressBar N;
    private a O;
    private i R;
    private String S;
    private int X;
    private com.bytedance.sdk.openadsdk.multipro.b.a Y;
    private j Z;

    /* renamed from: a  reason: collision with root package name */
    LandingDislikeDialog f6172a;
    private String ac;
    private com.bytedance.sdk.openadsdk.preload.falconx.a.a ad;

    /* renamed from: b  reason: collision with root package name */
    LandingCommentDialog f6173b;
    LandingDislikeToast c;
    private SSWebView f;
    private ImageView g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private LinearLayout o;
    private Context p;
    private int q;
    private String r;
    private String s;
    private x t;
    private int u;
    private RelativeLayout v;
    private FrameLayout w;
    private NativeVideoTsView y;
    private long z;
    final AtomicBoolean d = new AtomicBoolean(false);
    final AtomicBoolean e = new AtomicBoolean(false);
    private int x = -1;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private final Map<String, a> P = Collections.synchronizedMap(new HashMap());
    private boolean Q = false;
    private boolean T = false;
    private boolean U = true;
    private boolean V = false;
    private String W = null;
    private AtomicBoolean aa = new AtomicBoolean(true);
    private JSONArray ab = null;
    private int ae = 0;
    private int af = 0;
    private String ag = "立即下载";
    private TTAppDownloadListener ah = new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.14
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            TTVideoWebPageActivity.this.a(TTVideoWebPageActivity.this.h());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.a("下载中...");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.a("暂停");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.a("下载失败");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            TTVideoWebPageActivity.this.a("点击安装");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            TTVideoWebPageActivity.this.a("点击打开");
        }
    };
    private com.bytedance.sdk.openadsdk.core.a.a ai = null;
    private final e aj = new e() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.4
        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
        public void a(boolean z) {
            TTVideoWebPageActivity.this.Q = z;
            if (!TTVideoWebPageActivity.this.isFinishing()) {
                if (z) {
                    ak.a((View) TTVideoWebPageActivity.this.f, 8);
                    ak.a((View) TTVideoWebPageActivity.this.v, 8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.w.getLayoutParams();
                    TTVideoWebPageActivity.this.D = marginLayoutParams.leftMargin;
                    TTVideoWebPageActivity.this.C = marginLayoutParams.topMargin;
                    TTVideoWebPageActivity.this.E = marginLayoutParams.width;
                    TTVideoWebPageActivity.this.F = marginLayoutParams.height;
                    marginLayoutParams.width = -1;
                    marginLayoutParams.height = -1;
                    marginLayoutParams.topMargin = 0;
                    marginLayoutParams.leftMargin = 0;
                    TTVideoWebPageActivity.this.w.setLayoutParams(marginLayoutParams);
                    return;
                }
                ak.a((View) TTVideoWebPageActivity.this.f, 0);
                ak.a((View) TTVideoWebPageActivity.this.v, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.w.getLayoutParams();
                marginLayoutParams2.width = TTVideoWebPageActivity.this.E;
                marginLayoutParams2.height = TTVideoWebPageActivity.this.F;
                marginLayoutParams2.leftMargin = TTVideoWebPageActivity.this.D;
                marginLayoutParams2.topMargin = TTVideoWebPageActivity.this.C;
                TTVideoWebPageActivity.this.w.setLayoutParams(marginLayoutParams2);
            }
        }
    };
    private boolean ak = false;
    private final BroadcastReceiver al = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                int c = com.bytedance.sdk.openadsdk.utils.x.c(TTVideoWebPageActivity.this.getApplicationContext());
                if (TTVideoWebPageActivity.this.X == 0 && c != 0 && TTVideoWebPageActivity.this.f != null && TTVideoWebPageActivity.this.W != null) {
                    TTVideoWebPageActivity.this.f.loadUrl(TTVideoWebPageActivity.this.W);
                }
                if (TTVideoWebPageActivity.this.y != null && TTVideoWebPageActivity.this.y.getNativeVideoController() != null && !TTVideoWebPageActivity.this.T && TTVideoWebPageActivity.this.X != c) {
                    ((f) TTVideoWebPageActivity.this.y.getNativeVideoController()).a(context);
                }
                TTVideoWebPageActivity.this.X = c;
            }
        }
    };

    static /* synthetic */ int c(TTVideoWebPageActivity tTVideoWebPageActivity) {
        int i = tTVideoWebPageActivity.ae;
        tTVideoWebPageActivity.ae = i + 1;
        return i;
    }

    static /* synthetic */ int e(TTVideoWebPageActivity tTVideoWebPageActivity) {
        int i = tTVideoWebPageActivity.af;
        tTVideoWebPageActivity.af = i + 1;
        return i;
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable th) {
        }
        try {
            p.a(this);
        } catch (Throwable th2) {
        }
        this.X = com.bytedance.sdk.openadsdk.utils.x.c(getApplicationContext());
        setContentView(ac.f(this, "tt_activity_videolandingpage"));
        this.p = this;
        Intent intent = getIntent();
        this.q = intent.getIntExtra(SapiContext.KEY_SDK_VERSION, 1);
        this.r = intent.getStringExtra("adid");
        this.s = intent.getStringExtra("log_extra");
        this.u = intent.getIntExtra("source", -1);
        this.W = intent.getStringExtra("url");
        this.ac = intent.getStringExtra("gecko_id");
        String stringExtra = intent.getStringExtra("web_title");
        this.S = intent.getStringExtra("event_tag");
        this.V = intent.getBooleanExtra("video_is_auto_play", true);
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.z = bundle.getLong("video_play_position", 0L);
        }
        String stringExtra2 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_DATA);
        if (b.b()) {
            String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra3 != null) {
                try {
                    this.A = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra3));
                } catch (Exception e) {
                }
            }
            if (this.A != null) {
                this.x = this.A.X();
            }
        } else {
            this.A = u.a().c();
            if (this.A != null) {
                this.x = this.A.X();
            }
            u.a().g();
        }
        if (stringExtra2 != null) {
            try {
                this.Y = com.bytedance.sdk.openadsdk.multipro.b.a.a(new JSONObject(stringExtra2));
            } catch (Exception e2) {
            }
            if (this.Y != null) {
                this.z = this.Y.g;
                this.T = this.Y.f7400a;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.A == null) {
                try {
                    this.A = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(string));
                } catch (Throwable th3) {
                }
            }
            long j = bundle.getLong("video_play_position");
            boolean z = bundle.getBoolean("is_complete");
            if (j > 0) {
                this.z = j;
            }
            if (z) {
                this.T = z;
            }
        }
        this.R = new i(this.A, this.S);
        i();
        a(this.A);
        n();
        p();
        a(4);
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.p).a(Build.VERSION.SDK_INT >= 16).b(false).a(this.f);
        this.Z = new j(this, this.A, this.f).a(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.r);
            jSONObject.put("url", this.W);
            jSONObject.put("web_title", stringExtra);
            jSONObject.put("is_multi_process", b.b());
            jSONObject.put("event_tag", this.S);
        } catch (JSONException e3) {
        }
        this.Z.a(jSONObject);
        this.f.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.p, this.t, this.r, this.Z) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoWebPageActivity.this.N != null && !TTVideoWebPageActivity.this.isFinishing()) {
                        TTVideoWebPageActivity.this.N.setVisibility(8);
                    }
                } catch (Throwable th4) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse a2;
                try {
                    if (TextUtils.isEmpty(TTVideoWebPageActivity.this.ac)) {
                        a2 = super.shouldInterceptRequest(webView, str);
                    } else {
                        TTVideoWebPageActivity.c(TTVideoWebPageActivity.this);
                        a2 = com.bytedance.sdk.openadsdk.preload.geckox.c.a().a(TTVideoWebPageActivity.this.ad, TTVideoWebPageActivity.this.ac, str);
                        if (a2 != null) {
                            TTVideoWebPageActivity.e(TTVideoWebPageActivity.this);
                            Log.d("TTVideoWebPageActivity", "GeckoLog: hit++");
                        } else {
                            a2 = super.shouldInterceptRequest(webView, str);
                        }
                    }
                    return a2;
                } catch (Throwable th4) {
                    Log.e("TTVideoWebPageActivity", "shouldInterceptRequest url error", th4);
                    return super.shouldInterceptRequest(webView, str);
                }
            }
        });
        this.f.getSettings().setUserAgentString(r.a(this.f, this.q));
        if (Build.VERSION.SDK_INT >= 21) {
            this.f.getSettings().setMixedContentMode(0);
        }
        this.f.loadUrl(this.W);
        this.f.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.t, this.Z) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoWebPageActivity.this.N != null && !TTVideoWebPageActivity.this.isFinishing()) {
                    if (i != 100 || !TTVideoWebPageActivity.this.N.isShown()) {
                        TTVideoWebPageActivity.this.N.setProgress(i);
                    } else {
                        TTVideoWebPageActivity.this.N.setVisibility(8);
                    }
                }
            }
        });
        this.f.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.10
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (TTVideoWebPageActivity.this.P.containsKey(str)) {
                    a aVar = (a) TTVideoWebPageActivity.this.P.get(str);
                    if (aVar != null) {
                        aVar.e();
                        return;
                    }
                    return;
                }
                if (TTVideoWebPageActivity.this.A != null && TTVideoWebPageActivity.this.A.I() != null) {
                    TTVideoWebPageActivity.this.A.I().a();
                }
                a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(TTVideoWebPageActivity.this, str, TTVideoWebPageActivity.this.A, TTVideoWebPageActivity.this.S);
                TTVideoWebPageActivity.this.P.put(str, a2);
                a2.e();
            }
        });
        if (this.i != null) {
            this.i.setText(TextUtils.isEmpty(stringExtra) ? ac.a(this, "tt_web_title_default") : stringExtra);
        }
        if (this.m != null) {
            this.m.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.b(TTVideoWebPageActivity.this.A);
                }
            });
        }
        if (this.n != null) {
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.c(TTVideoWebPageActivity.this.A);
                }
            });
        }
        a();
        j();
        g();
        this.ad = com.bytedance.sdk.openadsdk.preload.geckox.c.a().b();
        com.bytedance.sdk.openadsdk.c.d.a(this.A, this);
    }

    private void a(l lVar) {
        if (lVar != null) {
            String E = lVar.E();
            if (TextUtils.isEmpty(E)) {
                if (this.o != null) {
                    this.o.setVisibility(8);
                    return;
                }
                return;
            }
            try {
                if (!TextUtils.isEmpty(E)) {
                    com.bytedance.sdk.openadsdk.core.d.c b2 = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(E));
                    if (b2 == null) {
                        if (this.o != null) {
                            this.o.setVisibility(8);
                        }
                    } else if (TextUtils.isEmpty(b2.f())) {
                        if (this.o != null) {
                            this.o.setVisibility(8);
                        }
                    } else {
                        if (this.o != null) {
                            this.o.setVisibility(0);
                        }
                        String b3 = b2.b();
                        String c = b2.c();
                        String g = b2.g();
                        if (TextUtils.isEmpty(g)) {
                            g = com.bytedance.sdk.openadsdk.downloadnew.a.d.a(lVar);
                        }
                        if (this.k != null) {
                            this.k.setText(String.format(ac.a(this.p, "tt_open_app_detail_developer"), c));
                        }
                        if (this.l != null) {
                            this.l.setText(String.format(ac.a(this.p, "tt_open_landing_page_app_name"), g, b3));
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l lVar) {
        if (lVar != null) {
            g.a(lVar.T(), lVar.E(), new g.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.13
                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    TTVideoWebPageActivity.this.o();
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void c() {
                }
            }, com.bytedance.sdk.openadsdk.downloadnew.a.d.a(lVar), lVar.H() == 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(l lVar) {
        if (lVar != null) {
            g.a(lVar.E());
        }
    }

    private void g() {
        if (this.A != null && this.A.H() == 4) {
            this.L.setVisibility(0);
            this.M = (Button) findViewById(ac.e(this, "tt_browser_download_btn"));
            if (this.M != null) {
                a(h());
                if (this.O != null) {
                    if (TextUtils.isEmpty(this.S)) {
                        aj.a(this.u);
                    } else {
                        String str = this.S;
                    }
                    this.O.a(this.ah, false);
                }
                this.M.setOnClickListener(this.ai);
                this.M.setOnTouchListener(this.ai);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h() {
        if (this.A != null && !TextUtils.isEmpty(this.A.S())) {
            this.ag = this.A.S();
        }
        return this.ag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        if (!TextUtils.isEmpty(str) && this.M != null) {
            this.M.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.15
                @Override // java.lang.Runnable
                public void run() {
                    if (TTVideoWebPageActivity.this.M != null && !TTVideoWebPageActivity.this.isFinishing()) {
                        TTVideoWebPageActivity.this.M.setText(str);
                    }
                }
            });
        }
    }

    private void i() {
        this.N = (ProgressBar) findViewById(ac.e(this, "tt_browser_progress"));
        this.L = (ViewStub) findViewById(ac.e(this, "tt_browser_download_btn_stub"));
        this.f = (SSWebView) findViewById(ac.e(this, "tt_browser_webview"));
        this.g = (ImageView) findViewById(ac.e(this, "tt_titlebar_back"));
        if (this.A != null) {
            this.A.b("landing_page");
        }
        if (this.g != null) {
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoWebPageActivity.this.f != null) {
                        if (TTVideoWebPageActivity.this.f.canGoBack()) {
                            TTVideoWebPageActivity.this.f.goBack();
                        } else if (TTVideoWebPageActivity.this.s()) {
                            TTVideoWebPageActivity.this.onBackPressed();
                        } else {
                            Map<String, Object> map = null;
                            if (TTVideoWebPageActivity.this.y != null && TTVideoWebPageActivity.this.y.getNativeVideoController() != null) {
                                map = aj.a(TTVideoWebPageActivity.this.A, TTVideoWebPageActivity.this.y.getNativeVideoController().n(), TTVideoWebPageActivity.this.y.getNativeVideoController().t());
                            }
                            com.bytedance.sdk.openadsdk.c.d.a(TTVideoWebPageActivity.this, TTVideoWebPageActivity.this.A, "embeded_ad", "detail_back", TTVideoWebPageActivity.this.k(), TTVideoWebPageActivity.this.l(), map);
                            TTVideoWebPageActivity.this.finish();
                        }
                    }
                }
            });
        }
        this.h = (ImageView) findViewById(ac.e(this, "tt_titlebar_close"));
        if (this.h != null) {
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoWebPageActivity.this.y != null) {
                        Map<String, Object> map = null;
                        if (TTVideoWebPageActivity.this.y.getNativeVideoController() != null) {
                            map = aj.a(TTVideoWebPageActivity.this.A, TTVideoWebPageActivity.this.y.getNativeVideoController().n(), TTVideoWebPageActivity.this.y.getNativeVideoController().t());
                        }
                        com.bytedance.sdk.openadsdk.c.d.a(TTVideoWebPageActivity.this, TTVideoWebPageActivity.this.A, "embeded_ad", "detail_skip", TTVideoWebPageActivity.this.k(), TTVideoWebPageActivity.this.l(), map);
                    }
                    TTVideoWebPageActivity.this.finish();
                }
            });
        }
        this.j = (TextView) findViewById(ac.e(this, "tt_titlebar_dislike"));
        if (this.j != null) {
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.c();
                }
            });
        }
        this.i = (TextView) findViewById(ac.e(this, "tt_titlebar_title"));
        this.k = (TextView) findViewById(ac.e(this, "tt_video_developer"));
        this.l = (TextView) findViewById(ac.e(this, "tt_video_app_name"));
        this.m = (TextView) findViewById(ac.e(this, "tt_video_app_detail"));
        this.n = (TextView) findViewById(ac.e(this, "tt_video_app_privacy"));
        this.o = (LinearLayout) findViewById(ac.e(this, "tt_video_app_detail_layout"));
        this.w = (FrameLayout) findViewById(ac.e(this, "tt_native_video_container"));
        this.v = (RelativeLayout) findViewById(ac.e(this, "tt_native_video_titlebar"));
        this.G = (RelativeLayout) findViewById(ac.e(this, "tt_rl_download"));
        this.H = (TextView) findViewById(ac.e(this, "tt_video_btn_ad_image_tv"));
        this.J = (TextView) findViewById(ac.e(this, "tt_video_ad_name"));
        this.K = (TextView) findViewById(ac.e(this, "tt_video_ad_button"));
        this.I = (RoundImageView) findViewById(ac.e(this, "tt_video_ad_logo_image"));
        m();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g();
    }

    private void j() {
        if (this.x == 5) {
            try {
                this.y = new NativeVideoTsView(this.p, this.A, true);
                if (this.y.getNativeVideoController() != null) {
                    this.y.getNativeVideoController().b(false);
                }
                if (this.T) {
                    this.w.setVisibility(0);
                    this.w.removeAllViews();
                    this.w.addView(this.y);
                    this.y.b(true);
                } else {
                    if (!this.V) {
                        this.z = 0L;
                    }
                    if (this.Y != null && this.y.getNativeVideoController() != null) {
                        this.y.getNativeVideoController().b(this.Y.g);
                        this.y.getNativeVideoController().c(this.Y.e);
                    }
                    if (this.y.a(this.z, this.U, this.T)) {
                        this.w.setVisibility(0);
                        this.w.removeAllViews();
                        this.w.addView(this.y);
                    }
                    if (this.y.getNativeVideoController() != null) {
                        this.y.getNativeVideoController().b(false);
                        this.y.getNativeVideoController().a(this.aj);
                        this.y.setIsQuiet(false);
                    }
                }
                this.B = this.y.getNativeVideoController();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (com.bytedance.sdk.openadsdk.utils.x.c(this) == 0) {
                try {
                    Toast.makeText(this, ac.b(this, "tt_no_network"), 0).show();
                } catch (Exception e2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long k() {
        if (this.y == null || this.y.getNativeVideoController() == null) {
            return 0L;
        }
        return this.y.getNativeVideoController().o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l() {
        if (this.y == null || this.y.getNativeVideoController() == null) {
            return 0;
        }
        return this.y.getNativeVideoController().q();
    }

    private void m() {
        if (this.A != null && this.A.H() == 4) {
            ak.a((View) this.G, 0);
            String str = "";
            if (!TextUtils.isEmpty(this.A.Q())) {
                str = this.A.Q();
            } else if (!TextUtils.isEmpty(this.A.R())) {
                str = this.A.R();
            } else if (!TextUtils.isEmpty(this.A.G())) {
                str = this.A.G();
            }
            if (this.A.I() != null && this.A.I().a() != null) {
                ak.a((View) this.I, 0);
                ak.a((View) this.H, 4);
                com.bytedance.sdk.openadsdk.i.e.a(this.p).a(this.A.I().a(), this.I);
            } else if (!TextUtils.isEmpty(str)) {
                ak.a((View) this.I, 4);
                ak.a((View) this.H, 0);
                this.H.setText(str.substring(0, 1));
            }
            if (!TextUtils.isEmpty(str)) {
                this.J.setText(str);
            }
            ak.a((View) this.J, 0);
            ak.a((View) this.K, 0);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void n() {
        if (this.A != null && this.A.H() == 4) {
            this.O = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.A, this.S);
            this.O.a(this);
            if (this.O instanceof com.bytedance.sdk.openadsdk.downloadnew.a.b) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.b) this.O).d(true);
            }
            this.ai = new com.bytedance.sdk.openadsdk.core.a.a(this, this.A, "embeded_ad_landingpage", this.u);
            this.ai.a(true);
            this.ai.c(true);
            this.K.setOnClickListener(this.ai);
            this.K.setOnTouchListener(this.ai);
            this.ai.a(this.O);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void o() {
        if (this.A != null && this.A.H() == 4) {
            this.O = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.A, this.S);
            this.O.a(this);
            if (this.O instanceof com.bytedance.sdk.openadsdk.downloadnew.a.b) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.b) this.O).d(true);
                ((com.bytedance.sdk.openadsdk.downloadnew.a.b) this.O).e(false);
            }
            this.ai = new com.bytedance.sdk.openadsdk.core.a.a(this, this.A, "embeded_ad_landingpage", this.u);
            this.ai.a(true);
            this.ai.c(true);
            this.O.g();
            this.ai.a(this.O);
        }
    }

    private void p() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.A);
        this.t = new x(this);
        this.t.b(this.f).a(this.A).a(arrayList).a(this.r).b(this.s).a(this.u).a(this.f).c(aj.h(this.A));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.Q && this.y != null && this.y.getNativeVideoController() != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) this.y.getNativeVideoController()).e(null, null);
            this.Q = false;
        } else if (s()) {
            if (!ak.a((WebView) this.f)) {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("material_meta", this.A != null ? this.A.am().toString() : null);
        bundle.putLong("video_play_position", this.z);
        bundle.putBoolean("is_complete", this.T);
        long j = this.z;
        if (this.y != null && this.y.getNativeVideoController() != null) {
            j = this.y.getNativeVideoController().m();
        }
        bundle.putLong("video_play_position", j);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.U = false;
        if (f() && !this.d.get()) {
            q();
        }
        if (this.t != null) {
            this.t.g();
        }
        if (this.O != null) {
            this.O.b();
        }
        if (this.P != null) {
            for (Map.Entry<String, a> entry : this.P.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().b();
                }
            }
        }
        if (this.Z != null) {
            this.Z.b();
        }
        t();
    }

    private void q() {
        if (this.y != null && this.y.getNativeVideoController() != null) {
            this.y.setIsQuiet(false);
            com.bytedance.sdk.openadsdk.core.video.c.d t = this.y.getNativeVideoController().t();
            if (t != null && t.i()) {
                this.y.a(this.z, this.U, this.T);
            } else if ((t == null && this.ak) || (t != null && t.j())) {
                this.ak = false;
                this.y.a(this.z, this.U, this.T);
            }
            this.B = this.y.getNativeVideoController();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        try {
            if (e() && !this.d.get()) {
                r();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.u.f("TTVideoWebPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        if (this.t != null) {
            this.t.h();
        }
        if (this.O != null) {
            this.O.c();
        }
        if (this.P != null) {
            for (Map.Entry<String, a> entry : this.P.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().c();
                }
            }
        }
        if (this.T || (this.y != null && this.y.getNativeVideoController() != null && this.y.getNativeVideoController().v())) {
            this.T = true;
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", (Boolean) true);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
        }
        if (!this.T && this.y != null && this.y.getNativeVideoController() != null) {
            a(this.y.getNativeVideoController());
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.Z != null) {
            this.Z.c();
        }
    }

    private void a(c cVar) {
        com.bytedance.sdk.openadsdk.utils.u.f("mutilproces", "initFeedNaitiveControllerData-isComplete=" + cVar.v() + ",position=" + cVar.m() + ",totalPlayDuration=" + cVar.o() + ",duration=" + cVar.r());
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(cVar.v()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(cVar.m()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(cVar.o()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", Long.valueOf(cVar.r()));
    }

    private void r() {
        if (this.y != null) {
            com.bytedance.sdk.openadsdk.core.video.c.d t = this.y.getNativeVideoController().t();
            if (t != null && t.h()) {
                this.ak = true;
                ((f) this.y.getNativeVideoController()).e(this.y.getNativeVideoController().o());
                this.y.getNativeVideoController().a(false);
            } else if (t != null && !t.l()) {
                ((f) this.y.getNativeVideoController()).e(this.y.getNativeVideoController().o());
                this.y.getNativeVideoController().a(false);
            }
            this.B = this.y.getNativeVideoController();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        b();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable th) {
        }
        if (!TextUtils.isEmpty(this.ac)) {
            d.a.a(this.af, this.ae, this.A);
        }
        com.bytedance.sdk.openadsdk.preload.geckox.c.a().a(this.ad);
        aa.a(this.p, this.f);
        aa.a(this.f);
        this.f = null;
        if (this.O != null) {
            this.O.d();
        }
        if (this.P != null) {
            for (Map.Entry<String, a> entry : this.P.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().d();
                }
            }
            this.P.clear();
        }
        if (this.t != null) {
            this.t.i();
        }
        if (this.y != null && this.y.getNativeVideoController() != null) {
            this.y.getNativeVideoController().l();
        }
        this.y = null;
        this.A = null;
        if (this.Z != null) {
            this.Z.d();
        }
    }

    protected void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.p.registerReceiver(this.al, intentFilter);
        } catch (Exception e) {
        }
    }

    protected void b() {
        try {
            this.p.unregisterReceiver(this.al);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        return l.d(this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (s()) {
            ak.a((View) this.h, 4);
        } else if (this.h != null && s()) {
            ak.a((View) this.h, i);
        }
    }

    private void t() {
        if (this.A != null) {
            JSONArray b2 = b(this.W);
            int d = aj.d(this.s);
            int c = aj.c(this.s);
            q<com.bytedance.sdk.openadsdk.c.a> f = p.f();
            if (b2 != null && f != null && d > 0 && c > 0) {
                m mVar = new m();
                mVar.d = b2;
                AdSlot j = this.A.j();
                if (j != null) {
                    j.setAdCount(6);
                    f.a(j, mVar, c, new q.b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.6
                        @Override // com.bytedance.sdk.openadsdk.core.q.b
                        public void a(int i, String str) {
                            TTVideoWebPageActivity.this.a(0);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.q.b
                        public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                            if (aVar != null) {
                                try {
                                    TTVideoWebPageActivity.this.aa.set(false);
                                    TTVideoWebPageActivity.this.t.b(new JSONObject(aVar.d()));
                                } catch (Exception e) {
                                    TTVideoWebPageActivity.this.a(0);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    private JSONArray b(String str) {
        if (this.ab != null && this.ab.length() > 0) {
            return this.ab;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("?id=");
        int indexOf2 = str.indexOf(ETAG.ITEM_SEPARATOR);
        if (indexOf == -1 || indexOf2 == -1 || indexOf + 4 >= indexOf2) {
            return null;
        }
        String substring = str.substring(indexOf + 4, indexOf2);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(substring);
        return jSONArray;
    }

    @Override // com.bytedance.sdk.openadsdk.e.d
    public void a(boolean z, JSONArray jSONArray) {
        if (z && jSONArray != null && jSONArray.length() > 0) {
            this.ab = jSONArray;
            t();
        }
    }

    protected void c() {
        if (!isFinishing()) {
            if (this.e.get()) {
                u();
                return;
            }
            if (this.f6172a == null) {
                d();
            }
            this.f6172a.a();
        }
    }

    void d() {
        if (this.f6173b == null) {
            this.f6173b = new LandingCommentDialog(this, this.A);
            this.f6173b.setCallback(new LandingCommentDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.7
                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(View view) {
                    TTVideoWebPageActivity.this.d.set(true);
                    if (TTVideoWebPageActivity.this.e()) {
                        TTVideoWebPageActivity.this.B.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void b(View view) {
                    TTVideoWebPageActivity.this.d.set(false);
                    if (!TTVideoWebPageActivity.this.e.get()) {
                        TTVideoWebPageActivity.this.f6172a.a();
                        return;
                    }
                    TTVideoWebPageActivity.this.f6172a.a(true);
                    if (TTVideoWebPageActivity.this.f()) {
                        TTVideoWebPageActivity.this.B.j();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(String str, boolean z) {
                    if (z && !TTVideoWebPageActivity.this.e.get()) {
                        TTVideoWebPageActivity.this.e.set(true);
                        TTVideoWebPageActivity.this.v();
                    } else if (!z) {
                        TTVideoWebPageActivity.this.w();
                    }
                    if (TTVideoWebPageActivity.this.f()) {
                        TTVideoWebPageActivity.this.B.j();
                    }
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.f6173b);
            this.f6173b.setVisibility(8);
        }
        if (this.f6172a == null) {
            this.f6172a = new LandingDislikeDialog(this, this.A);
            this.f6172a.setCallback(new LandingDislikeDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.8
                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(View view) {
                    TTVideoWebPageActivity.this.d.set(true);
                    if (TTVideoWebPageActivity.this.e()) {
                        TTVideoWebPageActivity.this.B.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void b(View view) {
                    TTVideoWebPageActivity.this.d.set(false);
                    if (TTVideoWebPageActivity.this.f()) {
                        TTVideoWebPageActivity.this.B.j();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(int i, FilterWord filterWord) {
                    if (!TTVideoWebPageActivity.this.e.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                        TTVideoWebPageActivity.this.e.set(true);
                        TTVideoWebPageActivity.this.v();
                        TTVideoWebPageActivity.this.f6173b.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a() {
                    TTVideoWebPageActivity.this.f6173b.b();
                    TTVideoWebPageActivity.this.d.set(true);
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.f6172a);
        }
        if (this.c == null) {
            this.c = new LandingDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.c);
        }
    }

    private void u() {
        if (this.c != null) {
            this.c.a("您已成功提交反馈，请勿重复提交哦！");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.c != null) {
            this.c.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.c != null) {
            this.c.a("输入为空或者输入特殊字符，请重新输入");
        }
    }

    boolean e() {
        return (this.B == null || this.B.t() == null || !this.B.t().g()) ? false : true;
    }

    protected boolean f() {
        return (this.B == null || this.B.t() == null || !this.B.t().i()) ? false : true;
    }
}
