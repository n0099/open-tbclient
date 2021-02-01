package com.bytedance.sdk.openadsdk.activity.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;
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
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeToast;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.preload.falconx.a.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TTWebPageActivity extends Activity implements d {
    private static final String g = TTWebPageActivity.class.getSimpleName();
    private x A;
    private int B;
    private String C;
    private l D;
    private String E;
    private String F;
    private a G;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a L;

    /* renamed from: a  reason: collision with root package name */
    LandingDislikeDialog f6193a;

    /* renamed from: b  reason: collision with root package name */
    LandingCommentDialog f6194b;
    LandingDislikeToast c;
    j f;
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
    private ViewStub t;
    private ViewStub u;
    private ViewStub v;
    private Button w;
    private ProgressBar x;
    private String y;
    private String z;
    final AtomicBoolean d = new AtomicBoolean(false);
    final AtomicBoolean e = new AtomicBoolean(false);
    private int H = 0;
    private int I = 0;
    private AtomicBoolean J = new AtomicBoolean(true);
    private JSONArray K = null;
    private final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> M = Collections.synchronizedMap(new HashMap());
    private String N = "立即下载";
    private TTAppDownloadListener O = new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.12
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            TTWebPageActivity.this.a(TTWebPageActivity.this.f());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.a("下载中...");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.a("暂停");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.a("下载失败");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            TTWebPageActivity.this.a("点击安装");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            TTWebPageActivity.this.a("点击打开");
        }
    };

    static /* synthetic */ int c(TTWebPageActivity tTWebPageActivity) {
        int i = tTWebPageActivity.H;
        tTWebPageActivity.H = i + 1;
        return i;
    }

    static /* synthetic */ int e(TTWebPageActivity tTWebPageActivity) {
        int i = tTWebPageActivity.I;
        tTWebPageActivity.I = i + 1;
        return i;
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        this.r = this;
        super.onCreate(bundle);
        try {
            p.a(this);
        } catch (Throwable th) {
        }
        setContentView(ac.f(this, "tt_activity_ttlandingpage"));
        g();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.r).a(false).b(false).a(this.h);
        Intent intent = getIntent();
        this.s = intent.getIntExtra(SapiContext.KEY_SDK_VERSION, 1);
        this.y = intent.getStringExtra("adid");
        this.z = intent.getStringExtra("log_extra");
        this.B = intent.getIntExtra("source", -1);
        String stringExtra = intent.getStringExtra("url");
        this.E = stringExtra;
        String stringExtra2 = intent.getStringExtra("web_title");
        intent.getStringExtra("icon_url");
        this.F = intent.getStringExtra("gecko_id");
        this.C = intent.getStringExtra("event_tag");
        if (b.b()) {
            String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra3 != null) {
                try {
                    this.D = c.a(new JSONObject(stringExtra3));
                } catch (Exception e) {
                    u.c(g, "TTWebPageActivity - onCreate MultiGlobalInfo : ", e);
                }
            }
        } else {
            this.D = com.bytedance.sdk.openadsdk.core.u.a().c();
            com.bytedance.sdk.openadsdk.core.u.a().g();
        }
        if (this.D != null) {
            this.D.b("landing_page");
        }
        c(this.D);
        this.f = new j(this, this.D, this.h).a(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.y);
            jSONObject.put("url", stringExtra);
            jSONObject.put("web_title", stringExtra2);
            jSONObject.put("is_multi_process", b.b());
            jSONObject.put("event_tag", this.C);
        } catch (JSONException e2) {
        }
        this.f.a(jSONObject);
        h();
        this.h.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.r, this.A, this.y, this.f) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTWebPageActivity.this.x != null && !TTWebPageActivity.this.isFinishing()) {
                        TTWebPageActivity.this.x.setVisibility(8);
                    }
                } catch (Throwable th2) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse a2;
                try {
                    if (TextUtils.isEmpty(TTWebPageActivity.this.F)) {
                        a2 = super.shouldInterceptRequest(webView, str);
                    } else {
                        TTWebPageActivity.c(TTWebPageActivity.this);
                        a2 = com.bytedance.sdk.openadsdk.preload.geckox.c.a().a(TTWebPageActivity.this.G, TTWebPageActivity.this.F, str);
                        if (a2 != null) {
                            TTWebPageActivity.e(TTWebPageActivity.this);
                            Log.d(TTWebPageActivity.g, "GeckoLog: hit++");
                        } else {
                            a2 = super.shouldInterceptRequest(webView, str);
                        }
                    }
                    return a2;
                } catch (Throwable th2) {
                    Log.e(TTWebPageActivity.g, "shouldInterceptRequest url error", th2);
                    return super.shouldInterceptRequest(webView, str);
                }
            }
        });
        this.h.getSettings().setUserAgentString(r.a(this.h, this.s));
        if (Build.VERSION.SDK_INT >= 21) {
            this.h.getSettings().setMixedContentMode(0);
        }
        this.h.loadUrl(stringExtra);
        this.h.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.A, this.f) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTWebPageActivity.this.x != null && !TTWebPageActivity.this.isFinishing()) {
                    if (i != 100 || !TTWebPageActivity.this.x.isShown()) {
                        TTWebPageActivity.this.x.setProgress(i);
                    } else {
                        TTWebPageActivity.this.x.setVisibility(8);
                    }
                }
            }
        });
        this.h.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.8
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTWebPageActivity.this.M.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = (com.bytedance.sdk.openadsdk.downloadnew.core.a) TTWebPageActivity.this.M.get(str);
                    if (aVar != null) {
                        aVar.e();
                        return;
                    }
                    return;
                }
                if (TTWebPageActivity.this.D != null && TTWebPageActivity.this.D.I() != null) {
                    TTWebPageActivity.this.D.I().a();
                }
                com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(TTWebPageActivity.this, str, TTWebPageActivity.this.D, TTWebPageActivity.this.C);
                TTWebPageActivity.this.M.put(str, a2);
                a2.e();
            }
        });
        if (this.k != null) {
            this.k.setText(TextUtils.isEmpty(stringExtra2) ? ac.a(this, "tt_web_title_default") : stringExtra2);
        }
        if (this.o != null) {
            this.o.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.a(TTWebPageActivity.this.D);
                }
            });
        }
        if (this.p != null) {
            this.p.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.b(TTWebPageActivity.this.D);
                }
            });
        }
        e();
        a(4);
        this.G = com.bytedance.sdk.openadsdk.preload.geckox.c.a().b();
        com.bytedance.sdk.openadsdk.c.d.a(this.D, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        if (lVar != null) {
            g.a(lVar.T(), lVar.E(), new g.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.11
                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    TTWebPageActivity.this.d();
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
    public void b(l lVar) {
        if (lVar != null) {
            g.a(lVar.E());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void d() {
        if (this.D != null && this.D.H() == 4) {
            if (this.L == null) {
                this.L = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.D, TextUtils.isEmpty(this.C) ? aj.a(this.B) : this.C);
                this.L.a(this.O, false);
            }
            this.L.a(this);
            if (this.L instanceof com.bytedance.sdk.openadsdk.downloadnew.a.b) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.b) this.L).d(true);
                ((com.bytedance.sdk.openadsdk.downloadnew.a.b) this.L).e(false);
            }
            com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this, this.D, "embeded_ad_landingpage", this.B);
            aVar.a(true);
            aVar.c(true);
            this.L.g();
            aVar.a(this.L);
        }
    }

    private void e() {
        if (this.D != null && this.D.H() == 4) {
            this.v.setVisibility(0);
            this.w = (Button) findViewById(ac.e(this, "tt_browser_download_btn"));
            if (this.w != null) {
                a(f());
                if (this.L == null) {
                    this.L = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.D, TextUtils.isEmpty(this.C) ? aj.a(this.B) : this.C);
                    this.L.a(this.O, false);
                }
                this.L.a(this);
                if (this.L instanceof com.bytedance.sdk.openadsdk.downloadnew.a.b) {
                    ((com.bytedance.sdk.openadsdk.downloadnew.a.b) this.L).d(true);
                }
                com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this, this.D, "embeded_ad_landingpage", this.B);
                aVar.a(true);
                aVar.c(true);
                this.w.setOnClickListener(aVar);
                this.w.setOnTouchListener(aVar);
                aVar.a(this.L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        if (this.D != null && !TextUtils.isEmpty(this.D.S())) {
            this.N = this.D.S();
        }
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        if (!TextUtils.isEmpty(str) && this.w != null) {
            this.w.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.13
                @Override // java.lang.Runnable
                public void run() {
                    if (TTWebPageActivity.this.w != null && !TTWebPageActivity.this.isFinishing()) {
                        TTWebPageActivity.this.w.setText(str);
                    }
                }
            });
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        e();
    }

    private void g() {
        this.h = (SSWebView) findViewById(ac.e(this, "tt_browser_webview"));
        this.v = (ViewStub) findViewById(ac.e(this, "tt_browser_download_btn_stub"));
        this.t = (ViewStub) findViewById(ac.e(this, "tt_browser_titlebar_view_stub"));
        this.u = (ViewStub) findViewById(ac.e(this, "tt_browser_titlebar_dark_view_stub"));
        switch (i.c().j()) {
            case 0:
                this.t.setVisibility(0);
                break;
            case 1:
                this.u.setVisibility(0);
                break;
        }
        this.i = (ImageView) findViewById(ac.e(this, "tt_titlebar_back"));
        if (this.i != null) {
            this.i.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTWebPageActivity.this.h != null) {
                        if (TTWebPageActivity.this.h.canGoBack()) {
                            TTWebPageActivity.this.h.goBack();
                        } else if (TTWebPageActivity.this.i()) {
                            TTWebPageActivity.this.onBackPressed();
                        } else {
                            TTWebPageActivity.this.finish();
                        }
                    }
                }
            });
        }
        this.j = (ImageView) findViewById(ac.e(this, "tt_titlebar_close"));
        if (this.j != null) {
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.finish();
                }
            });
        }
        this.k = (TextView) findViewById(ac.e(this, "tt_titlebar_title"));
        this.l = (TextView) findViewById(ac.e(this, "tt_titlebar_dislike"));
        this.m = (TextView) findViewById(ac.e(this, "tt_titlebar_developer"));
        this.n = (TextView) findViewById(ac.e(this, "tt_titlebar_app_name"));
        this.o = (TextView) findViewById(ac.e(this, "tt_titlebar_app_detail"));
        this.p = (TextView) findViewById(ac.e(this, "tt_titlebar_app_privacy"));
        this.q = (LinearLayout) findViewById(ac.e(this, "tt_titlebar_detail_layout"));
        if (this.l != null) {
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.a();
                }
            });
        }
        this.x = (ProgressBar) findViewById(ac.e(this, "tt_browser_progress"));
    }

    private void h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.D);
        this.A = new x(this);
        this.A.b(this.h).a(this.D).a(arrayList).a(this.y).b(this.z).a(this.B).c(aj.h(this.D)).a(this.h).a(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.A != null) {
            this.A.g();
        }
        if (this.L != null) {
            this.L.b();
        }
        if (this.M != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : this.M.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().b();
                }
            }
        }
        if (this.f != null) {
            this.f.b();
        }
        j();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.f != null) {
            this.f.c();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.core.u.a().b(true);
        if (this.A != null) {
            this.A.h();
        }
        if (this.L != null) {
            this.L.c();
        }
        if (this.M != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : this.M.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().c();
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (i()) {
            if (!ak.a((WebView) this.h)) {
                super.onBackPressed();
                return;
            }
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return l.d(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i()) {
            ak.a((View) this.j, 4);
        } else if (this.j != null && i()) {
            ak.a((View) this.j, i);
        }
    }

    private void j() {
        if (this.D != null) {
            JSONArray b2 = b(this.E);
            int d = aj.d(this.z);
            int c = aj.c(this.z);
            q<com.bytedance.sdk.openadsdk.c.a> f = p.f();
            if (b2 != null && f != null && d > 0 && c > 0) {
                m mVar = new m();
                mVar.d = b2;
                AdSlot j = this.D.j();
                if (j != null) {
                    j.setAdCount(6);
                    f.a(j, mVar, c, new q.b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.4
                        @Override // com.bytedance.sdk.openadsdk.core.q.b
                        public void a(int i, String str) {
                            TTWebPageActivity.this.a(0);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.q.b
                        public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                            if (aVar != null) {
                                try {
                                    TTWebPageActivity.this.J.set(false);
                                    TTWebPageActivity.this.A.b(new JSONObject(aVar.d()));
                                } catch (Exception e) {
                                    TTWebPageActivity.this.a(0);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    private JSONArray b(String str) {
        if (this.K != null && this.K.length() > 0) {
            return this.K;
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

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable th) {
        }
        if (!TextUtils.isEmpty(this.F)) {
            d.a.a(this.I, this.H, this.D);
        }
        com.bytedance.sdk.openadsdk.preload.geckox.c.a().a(this.G);
        aa.a(this.r, this.h);
        aa.a(this.h);
        this.h = null;
        if (this.A != null) {
            this.A.i();
        }
        if (this.L != null) {
            this.L.d();
        }
        if (this.M != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : this.M.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().d();
                }
            }
            this.M.clear();
        }
        if (this.f != null) {
            this.f.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.d
    public void a(boolean z, JSONArray jSONArray) {
        if (z && jSONArray != null && jSONArray.length() > 0) {
            this.K = jSONArray;
            j();
        }
    }

    protected void a() {
        if (!isFinishing()) {
            if (this.e.get()) {
                k();
                return;
            }
            if (this.f6193a == null) {
                b();
            }
            this.f6193a.a();
        }
    }

    void b() {
        if (this.f6194b == null) {
            this.f6194b = new LandingCommentDialog(this, this.D);
            this.f6194b.setCallback(new LandingCommentDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(View view) {
                    TTWebPageActivity.this.d.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void b(View view) {
                    TTWebPageActivity.this.d.set(false);
                    if (!TTWebPageActivity.this.e.get()) {
                        TTWebPageActivity.this.f6193a.a();
                    } else {
                        TTWebPageActivity.this.f6193a.a(true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(String str, boolean z) {
                    if (z && !TTWebPageActivity.this.e.get()) {
                        TTWebPageActivity.this.d.set(true);
                        TTWebPageActivity.this.e.set(true);
                        TTWebPageActivity.this.l();
                    } else if (!z) {
                        TTWebPageActivity.this.m();
                    }
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.f6194b);
            this.f6194b.setVisibility(8);
        }
        if (this.f6193a == null) {
            this.f6193a = new LandingDislikeDialog(this, this.D);
            this.f6193a.setCallback(new LandingDislikeDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.6
                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(View view) {
                    TTWebPageActivity.this.d.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void b(View view) {
                    TTWebPageActivity.this.d.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(int i, FilterWord filterWord) {
                    if (!TTWebPageActivity.this.e.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                        TTWebPageActivity.this.e.set(true);
                        TTWebPageActivity.this.l();
                        if (TTWebPageActivity.this.f6194b != null) {
                            TTWebPageActivity.this.f6194b.a();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a() {
                    TTWebPageActivity.this.f6194b.b();
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.f6193a);
        }
        if (this.c == null) {
            this.c = new LandingDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.c);
        }
    }

    private void k() {
        if (this.c != null) {
            this.c.a("您已成功提交反馈，请勿重复提交哦！");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.c != null) {
            this.c.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.c != null) {
            this.c.a("输入为空或者输入特殊字符，请重新输入");
        }
    }

    private void c(l lVar) {
        if (lVar == null) {
            if (this.q != null) {
                this.q.setVisibility(8);
                return;
            }
            return;
        }
        String E = lVar.E();
        if (TextUtils.isEmpty(E)) {
            if (this.q != null) {
                this.q.setVisibility(8);
                return;
            }
            return;
        }
        try {
            if (!TextUtils.isEmpty(E)) {
                com.bytedance.sdk.openadsdk.core.d.c b2 = c.b(new JSONObject(E));
                if (b2 == null) {
                    if (this.q != null) {
                        this.q.setVisibility(8);
                    }
                } else if (TextUtils.isEmpty(b2.f())) {
                    if (this.q != null) {
                        this.q.setVisibility(8);
                    }
                } else {
                    if (this.q != null) {
                        this.q.setVisibility(0);
                    }
                    String b3 = b2.b();
                    String c = b2.c();
                    String g2 = b2.g();
                    if (TextUtils.isEmpty(g2)) {
                        g2 = com.bytedance.sdk.openadsdk.downloadnew.a.d.a(lVar);
                    }
                    if (this.m != null) {
                        this.m.setText(String.format(ac.a(this.r, "tt_open_app_detail_developer"), c));
                    }
                    if (this.n != null) {
                        this.n.setText(String.format(ac.a(this.r, "tt_open_landing_page_app_name"), g2, b3));
                    }
                }
            }
        } catch (Throwable th) {
        }
    }
}
