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
import com.bytedance.sdk.openadsdk.d.d;
import com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeToast;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
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
/* loaded from: classes6.dex */
public class TTVideoWebPageActivity extends Activity implements d {
    private long A;
    private l B;
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
    LandingDislikeDialog f4158a;
    private String ac;
    private com.bytedance.sdk.openadsdk.preload.falconx.a.a ad;
    LandingCommentDialog b;
    LandingDislikeToast c;
    protected NativeVideoTsView f;
    protected c g;
    private SSWebView h;
    private ImageView i;
    private ImageView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private LinearLayout q;
    private Context r;
    private int s;
    private String t;
    private String u;
    private x v;
    private int w;
    private RelativeLayout x;
    private FrameLayout y;
    final AtomicBoolean d = new AtomicBoolean(false);
    final AtomicBoolean e = new AtomicBoolean(false);
    private int z = -1;
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
                    ak.a((View) TTVideoWebPageActivity.this.h, 8);
                    ak.a((View) TTVideoWebPageActivity.this.x, 8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.y.getLayoutParams();
                    TTVideoWebPageActivity.this.D = marginLayoutParams.leftMargin;
                    TTVideoWebPageActivity.this.C = marginLayoutParams.topMargin;
                    TTVideoWebPageActivity.this.E = marginLayoutParams.width;
                    TTVideoWebPageActivity.this.F = marginLayoutParams.height;
                    marginLayoutParams.width = -1;
                    marginLayoutParams.height = -1;
                    marginLayoutParams.topMargin = 0;
                    marginLayoutParams.leftMargin = 0;
                    TTVideoWebPageActivity.this.y.setLayoutParams(marginLayoutParams);
                    return;
                }
                ak.a((View) TTVideoWebPageActivity.this.h, 0);
                ak.a((View) TTVideoWebPageActivity.this.x, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.y.getLayoutParams();
                marginLayoutParams2.width = TTVideoWebPageActivity.this.E;
                marginLayoutParams2.height = TTVideoWebPageActivity.this.F;
                marginLayoutParams2.leftMargin = TTVideoWebPageActivity.this.D;
                marginLayoutParams2.topMargin = TTVideoWebPageActivity.this.C;
                TTVideoWebPageActivity.this.y.setLayoutParams(marginLayoutParams2);
            }
        }
    };
    private boolean ak = false;
    private final BroadcastReceiver al = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                int c = com.bytedance.sdk.openadsdk.utils.x.c(TTVideoWebPageActivity.this.getApplicationContext());
                if (TTVideoWebPageActivity.this.X == 0 && c != 0 && TTVideoWebPageActivity.this.h != null && TTVideoWebPageActivity.this.W != null) {
                    TTVideoWebPageActivity.this.h.loadUrl(TTVideoWebPageActivity.this.W);
                }
                if (TTVideoWebPageActivity.this.f != null && TTVideoWebPageActivity.this.f.getNativeVideoController() != null && !TTVideoWebPageActivity.this.v() && TTVideoWebPageActivity.this.X != c) {
                    ((f) TTVideoWebPageActivity.this.f.getNativeVideoController()).a(context);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
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
        this.r = this;
        Intent intent = getIntent();
        this.s = intent.getIntExtra(SapiContext.KEY_SDK_VERSION, 1);
        this.t = intent.getStringExtra("adid");
        this.u = intent.getStringExtra("log_extra");
        this.w = intent.getIntExtra("source", -1);
        this.W = intent.getStringExtra("url");
        this.ac = intent.getStringExtra("gecko_id");
        String stringExtra = intent.getStringExtra("web_title");
        this.S = intent.getStringExtra("event_tag");
        this.V = intent.getBooleanExtra("video_is_auto_play", true);
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.A = bundle.getLong("video_play_position", 0L);
        }
        String stringExtra2 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_DATA);
        if (b.b()) {
            String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra3 != null) {
                try {
                    this.B = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra3));
                } catch (Exception e) {
                }
            }
            if (this.B != null) {
                this.z = this.B.ak();
            }
        } else {
            this.B = u.a().c();
            if (this.B != null) {
                this.z = this.B.ak();
            }
            u.a().g();
        }
        if (stringExtra2 != null) {
            try {
                this.Y = com.bytedance.sdk.openadsdk.multipro.b.a.a(new JSONObject(stringExtra2));
            } catch (Exception e2) {
            }
            if (this.Y != null) {
                this.A = this.Y.g;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.B == null) {
                try {
                    this.B = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(string));
                } catch (Throwable th3) {
                }
            }
            long j = bundle.getLong("video_play_position");
            if (j > 0) {
                this.A = j;
            }
        }
        this.R = new i(this.B, this.S);
        i();
        a(this.B);
        n();
        p();
        a(4);
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.r).a(Build.VERSION.SDK_INT >= 16).b(false).a(this.h);
        this.Z = new j(this, this.B, this.h).a(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.t);
            jSONObject.put("url", this.W);
            jSONObject.put("web_title", stringExtra);
            jSONObject.put("is_multi_process", b.b());
            jSONObject.put("event_tag", this.S);
        } catch (JSONException e3) {
        }
        this.Z.a(jSONObject);
        this.h.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.r, this.v, this.t, this.Z) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.1
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
                        a2 = com.bytedance.sdk.openadsdk.gecko.a.a().a(TTVideoWebPageActivity.this.ad, TTVideoWebPageActivity.this.ac, str);
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
        this.h.getSettings().setUserAgentString(r.a(this.h, this.s));
        if (Build.VERSION.SDK_INT >= 21) {
            this.h.getSettings().setMixedContentMode(0);
        }
        this.h.loadUrl(this.W);
        this.h.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.v, this.Z) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.9
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
        this.h.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.10
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
                if (TTVideoWebPageActivity.this.B != null && TTVideoWebPageActivity.this.B.U() != null) {
                    TTVideoWebPageActivity.this.B.U().a();
                }
                a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(TTVideoWebPageActivity.this, str, TTVideoWebPageActivity.this.B, TTVideoWebPageActivity.this.S);
                TTVideoWebPageActivity.this.P.put(str, a2);
                a2.e();
            }
        });
        if (this.k != null) {
            this.k.setText(TextUtils.isEmpty(stringExtra) ? ac.a(this, "tt_web_title_default") : stringExtra);
        }
        if (this.o != null) {
            this.o.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.b(TTVideoWebPageActivity.this.B);
                }
            });
        }
        if (this.p != null) {
            this.p.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.c(TTVideoWebPageActivity.this.B);
                }
            });
        }
        a();
        j();
        g();
        this.ad = com.bytedance.sdk.openadsdk.gecko.a.a().b();
        com.bytedance.sdk.openadsdk.c.d.a(this.B, this);
    }

    private void a(l lVar) {
        if (lVar != null) {
            String Q = lVar.Q();
            if (TextUtils.isEmpty(Q)) {
                if (this.q != null) {
                    this.q.setVisibility(8);
                    return;
                }
                return;
            }
            try {
                if (!TextUtils.isEmpty(Q)) {
                    com.bytedance.sdk.openadsdk.core.d.c b = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(Q));
                    if (b == null) {
                        if (this.q != null) {
                            this.q.setVisibility(8);
                        }
                    } else if (TextUtils.isEmpty(b.f())) {
                        if (this.q != null) {
                            this.q.setVisibility(8);
                        }
                    } else {
                        if (this.q != null) {
                            this.q.setVisibility(0);
                        }
                        String b2 = b.b();
                        String c = b.c();
                        String g = b.g();
                        if (TextUtils.isEmpty(g)) {
                            g = com.bytedance.sdk.openadsdk.downloadnew.a.f.a(lVar);
                        }
                        if (this.m != null) {
                            this.m.setText(String.format(ac.a(this.r, "tt_open_app_detail_developer"), c));
                        }
                        if (this.n != null) {
                            this.n.setText(String.format(ac.a(this.r, "tt_open_landing_page_app_name"), g, b2));
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
            g.a(lVar.ag(), lVar.Q(), new g.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.13
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
            }, com.bytedance.sdk.openadsdk.downloadnew.a.f.a(lVar), lVar.T() == 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(l lVar) {
        if (lVar != null) {
            g.a(lVar.Q());
        }
    }

    private void g() {
        if (this.B != null && this.B.T() == 4) {
            this.L.setVisibility(0);
            this.M = (Button) findViewById(ac.e(this, "tt_browser_download_btn"));
            if (this.M != null) {
                a(h());
                if (this.O != null) {
                    if (TextUtils.isEmpty(this.S)) {
                        aj.a(this.w);
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
        if (this.B != null && !TextUtils.isEmpty(this.B.af())) {
            this.ag = this.B.af();
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
        this.h = (SSWebView) findViewById(ac.e(this, "tt_browser_webview"));
        this.i = (ImageView) findViewById(ac.e(this, "tt_titlebar_back"));
        if (this.B != null) {
            this.B.c("landing_page");
        }
        if (this.i != null) {
            this.i.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoWebPageActivity.this.h != null) {
                        if (TTVideoWebPageActivity.this.h.canGoBack()) {
                            TTVideoWebPageActivity.this.h.goBack();
                        } else if (TTVideoWebPageActivity.this.q()) {
                            TTVideoWebPageActivity.this.onBackPressed();
                        } else {
                            Map<String, Object> map = null;
                            if (TTVideoWebPageActivity.this.f != null && TTVideoWebPageActivity.this.f.getNativeVideoController() != null) {
                                map = aj.a(TTVideoWebPageActivity.this.B, TTVideoWebPageActivity.this.f.getNativeVideoController().o(), TTVideoWebPageActivity.this.f.getNativeVideoController().u());
                            }
                            com.bytedance.sdk.openadsdk.c.d.a(TTVideoWebPageActivity.this, TTVideoWebPageActivity.this.B, "embeded_ad", "detail_back", TTVideoWebPageActivity.this.k(), TTVideoWebPageActivity.this.l(), map);
                            TTVideoWebPageActivity.this.finish();
                        }
                    }
                }
            });
        }
        this.j = (ImageView) findViewById(ac.e(this, "tt_titlebar_close"));
        if (this.j != null) {
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoWebPageActivity.this.f != null) {
                        Map<String, Object> map = null;
                        if (TTVideoWebPageActivity.this.f.getNativeVideoController() != null) {
                            map = aj.a(TTVideoWebPageActivity.this.B, TTVideoWebPageActivity.this.f.getNativeVideoController().o(), TTVideoWebPageActivity.this.f.getNativeVideoController().u());
                        }
                        com.bytedance.sdk.openadsdk.c.d.a(TTVideoWebPageActivity.this, TTVideoWebPageActivity.this.B, "embeded_ad", "detail_skip", TTVideoWebPageActivity.this.k(), TTVideoWebPageActivity.this.l(), map);
                    }
                    TTVideoWebPageActivity.this.finish();
                }
            });
        }
        this.l = (TextView) findViewById(ac.e(this, "tt_titlebar_dislike"));
        if (this.l != null) {
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.c();
                }
            });
        }
        this.k = (TextView) findViewById(ac.e(this, "tt_titlebar_title"));
        this.m = (TextView) findViewById(ac.e(this, "tt_video_developer"));
        this.n = (TextView) findViewById(ac.e(this, "tt_video_app_name"));
        this.o = (TextView) findViewById(ac.e(this, "tt_video_app_detail"));
        this.p = (TextView) findViewById(ac.e(this, "tt_video_app_privacy"));
        this.q = (LinearLayout) findViewById(ac.e(this, "tt_video_app_detail_layout"));
        this.y = (FrameLayout) findViewById(ac.e(this, "tt_native_video_container"));
        this.x = (RelativeLayout) findViewById(ac.e(this, "tt_native_video_titlebar"));
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
        if (l.c(this.B)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    this.f = new NativeVideoTsView(this.r, this.B, true, true);
                } else {
                    this.f = new NativeVideoTsView(this.r, this.B, true, false);
                }
                if (this.f.getNativeVideoController() != null) {
                    this.f.getNativeVideoController().b(false);
                }
                if (!this.V) {
                    this.A = 0L;
                }
                if (this.Y != null && this.f.getNativeVideoController() != null) {
                    this.f.getNativeVideoController().b(this.Y.g);
                    this.f.getNativeVideoController().c(this.Y.e);
                }
                if (this.f.a(this.A, this.U, v())) {
                    this.y.setVisibility(0);
                    this.y.removeAllViews();
                    this.y.addView(this.f);
                }
                if (this.f.getNativeVideoController() != null) {
                    this.f.getNativeVideoController().b(false);
                    this.f.getNativeVideoController().a(this.aj);
                    this.f.setIsQuiet(false);
                }
                if (v()) {
                    this.f.b(true);
                }
                this.g = this.f.getNativeVideoController();
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
        if (this.f == null || this.f.getNativeVideoController() == null) {
            return 0L;
        }
        return this.f.getNativeVideoController().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l() {
        if (this.f == null || this.f.getNativeVideoController() == null) {
            return 0;
        }
        return this.f.getNativeVideoController().r();
    }

    private void m() {
        if (this.B != null && this.B.T() == 4) {
            ak.a((View) this.G, 0);
            String str = "";
            if (!TextUtils.isEmpty(this.B.ad())) {
                str = this.B.ad();
            } else if (!TextUtils.isEmpty(this.B.ae())) {
                str = this.B.ae();
            } else if (!TextUtils.isEmpty(this.B.S())) {
                str = this.B.S();
            }
            if (this.B.U() != null && this.B.U().a() != null) {
                ak.a((View) this.I, 0);
                ak.a((View) this.H, 4);
                com.bytedance.sdk.openadsdk.h.d.a(this.r).a(this.B.U().a(), this.I);
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
        if (this.B != null && this.B.T() == 4) {
            this.O = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.B, this.S);
            this.O.a(this);
            if (this.O instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) this.O).f(true);
            }
            this.ai = new com.bytedance.sdk.openadsdk.core.a.a(this, this.B, "embeded_ad_landingpage", this.w);
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
        if (this.B != null && this.B.T() == 4) {
            this.O = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.B, this.S);
            this.O.a(this);
            if (this.O instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) this.O).f(true);
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) this.O).g(false);
            }
            this.ai = new com.bytedance.sdk.openadsdk.core.a.a(this, this.B, "embeded_ad_landingpage", this.w);
            this.ai.a(true);
            this.ai.c(true);
            this.O.g();
            this.ai.a(this.O);
        }
    }

    private void p() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.B);
        this.v = new x(this);
        this.v.b(this.h).a(this.B).a(arrayList).b(this.t).c(this.u).a(this.w).a(this.h).d(aj.i(this.B));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.Q && this.f != null && this.f.getNativeVideoController() != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) this.f.getNativeVideoController()).e(null, null);
            this.Q = false;
        } else if (q()) {
            if (!ak.a((WebView) this.h)) {
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
        bundle.putString("material_meta", this.B != null ? this.B.aE().toString() : null);
        bundle.putLong("video_play_position", this.A);
        bundle.putBoolean("is_complete", v());
        long j = this.A;
        if (this.f != null && this.f.getNativeVideoController() != null) {
            j = this.f.getNativeVideoController().n();
        }
        bundle.putLong("video_play_position", j);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.U = false;
        if (this.T && f() && !this.d.get()) {
            this.T = false;
            this.g.k();
        }
        if (this.v != null) {
            this.v.m();
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
        r();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        try {
            if (e() && !this.d.get()) {
                this.T = true;
                this.g.i();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.u.f("TTVideoWebPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        if (this.v != null) {
            this.v.n();
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
        if (v() || (this.f != null && this.f.getNativeVideoController() != null && this.f.getNativeVideoController().w())) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", (Boolean) true);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
        }
        if (!v() && this.f != null && this.f.getNativeVideoController() != null) {
            a(this.f.getNativeVideoController());
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
        com.bytedance.sdk.openadsdk.utils.u.f("mutilproces", "initFeedNaitiveControllerData-isComplete=" + cVar.w() + ",position=" + cVar.n() + ",totalPlayDuration=" + cVar.p() + ",duration=" + cVar.s());
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(cVar.w()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(cVar.n()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(cVar.p()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", Long.valueOf(cVar.s()));
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
            d.a.a(this.af, this.ae, this.B);
        }
        com.bytedance.sdk.openadsdk.gecko.a.a().a(this.ad);
        aa.a(this.r, this.h);
        aa.a(this.h);
        this.h = null;
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
        if (this.v != null) {
            this.v.o();
        }
        if (this.f != null && this.f.getNativeVideoController() != null) {
            this.f.getNativeVideoController().m();
        }
        this.f = null;
        this.B = null;
        if (this.Z != null) {
            this.Z.d();
        }
    }

    protected void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.r.registerReceiver(this.al, intentFilter);
        } catch (Exception e) {
        }
    }

    protected void b() {
        try {
            this.r.unregisterReceiver(this.al);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        return l.f(this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (q()) {
            ak.a((View) this.j, 4);
        } else if (this.j != null && q()) {
            ak.a((View) this.j, i);
        }
    }

    private void r() {
        if (this.B != null) {
            JSONArray b = b(this.W);
            int d = aj.d(this.u);
            int c = aj.c(this.u);
            q<com.bytedance.sdk.openadsdk.c.a> f = p.f();
            if (b != null && f != null && d > 0 && c > 0) {
                m mVar = new m();
                mVar.d = b;
                AdSlot p = this.B.p();
                if (p != null) {
                    p.setAdCount(6);
                    f.a(p, mVar, c, new q.b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.6
                        @Override // com.bytedance.sdk.openadsdk.core.q.b
                        public void a(int i, String str) {
                            TTVideoWebPageActivity.this.a(0);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.q.b
                        public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                            if (aVar != null) {
                                try {
                                    TTVideoWebPageActivity.this.aa.set(false);
                                    TTVideoWebPageActivity.this.v.b(new JSONObject(aVar.d()));
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

    @Override // com.bytedance.sdk.openadsdk.d.d
    public void a(boolean z, JSONArray jSONArray) {
        if (z && jSONArray != null && jSONArray.length() > 0) {
            this.ab = jSONArray;
            r();
        }
    }

    protected void c() {
        if (!isFinishing()) {
            if (this.e.get()) {
                s();
                return;
            }
            if (this.f4158a == null) {
                d();
            }
            this.f4158a.a();
        }
    }

    void d() {
        if (this.b == null) {
            this.b = new LandingCommentDialog(this, this.B);
            this.b.setCallback(new LandingCommentDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.7
                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(View view) {
                    TTVideoWebPageActivity.this.d.set(true);
                    if (TTVideoWebPageActivity.this.e()) {
                        TTVideoWebPageActivity.this.g.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void b(View view) {
                    TTVideoWebPageActivity.this.d.set(false);
                    if (!TTVideoWebPageActivity.this.e.get()) {
                        TTVideoWebPageActivity.this.f4158a.a();
                        return;
                    }
                    TTVideoWebPageActivity.this.f4158a.a(true);
                    if (TTVideoWebPageActivity.this.f()) {
                        TTVideoWebPageActivity.this.g.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(String str, boolean z) {
                    if (z && !TTVideoWebPageActivity.this.e.get()) {
                        TTVideoWebPageActivity.this.e.set(true);
                        TTVideoWebPageActivity.this.t();
                    } else if (!z) {
                        TTVideoWebPageActivity.this.u();
                    }
                    if (TTVideoWebPageActivity.this.f()) {
                        TTVideoWebPageActivity.this.g.k();
                    }
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.b);
            this.b.setVisibility(8);
        }
        if (this.f4158a == null) {
            this.f4158a = new LandingDislikeDialog(this, this.B);
            this.f4158a.setCallback(new LandingDislikeDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.8
                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(View view) {
                    TTVideoWebPageActivity.this.d.set(true);
                    if (TTVideoWebPageActivity.this.e()) {
                        TTVideoWebPageActivity.this.g.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void b(View view) {
                    TTVideoWebPageActivity.this.d.set(false);
                    if (TTVideoWebPageActivity.this.f()) {
                        TTVideoWebPageActivity.this.g.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(int i, FilterWord filterWord) {
                    if (!TTVideoWebPageActivity.this.e.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                        TTVideoWebPageActivity.this.e.set(true);
                        TTVideoWebPageActivity.this.t();
                        TTVideoWebPageActivity.this.b.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a() {
                    TTVideoWebPageActivity.this.b.b();
                    TTVideoWebPageActivity.this.d.set(true);
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.f4158a);
        }
        if (this.c == null) {
            this.c = new LandingDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.c);
        }
    }

    private void s() {
        if (this.c != null) {
            this.c.a("您已成功提交反馈，请勿重复提交哦！");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.c != null) {
            this.c.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.c != null) {
            this.c.a("输入为空或者输入特殊字符，请重新输入");
        }
    }

    boolean e() {
        return (this.g == null || this.g.u() == null || !this.g.u().g()) ? false : true;
    }

    protected boolean f() {
        return (this.g == null || this.g.u() == null || !this.g.u().i()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        if (this.f == null || this.f.getNativeVideoController() == null) {
            return true;
        }
        return this.f.getNativeVideoController().w();
    }

    public static boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            if (intent.getComponent() != null) {
                return TTVideoWebPageActivity.class.getName().equals(intent.getComponent().getClassName());
            }
            return false;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.u.a("TTVideoWebPageActivity", "isThisClass error", th);
            return false;
        }
    }
}
