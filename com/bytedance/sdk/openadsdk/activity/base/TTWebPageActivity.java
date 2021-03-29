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
import com.bytedance.sdk.openadsdk.downloadnew.a.f;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.preload.falconx.a.a;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
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

    /* renamed from: g  reason: collision with root package name */
    public static final String f27503g = TTWebPageActivity.class.getSimpleName();
    public x A;
    public int B;
    public String C;
    public l D;
    public String E;
    public String F;
    public a G;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a L;

    /* renamed from: a  reason: collision with root package name */
    public LandingDislikeDialog f27504a;

    /* renamed from: b  reason: collision with root package name */
    public LandingCommentDialog f27505b;

    /* renamed from: c  reason: collision with root package name */
    public LandingDislikeToast f27506c;

    /* renamed from: f  reason: collision with root package name */
    public j f27509f;

    /* renamed from: h  reason: collision with root package name */
    public SSWebView f27510h;
    public ImageView i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public LinearLayout q;
    public Context r;
    public int s;
    public ViewStub t;
    public ViewStub u;
    public ViewStub v;
    public Button w;
    public ProgressBar x;
    public String y;
    public String z;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f27507d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f27508e = new AtomicBoolean(false);
    public int H = 0;
    public int I = 0;
    public AtomicBoolean J = new AtomicBoolean(true);
    public JSONArray K = null;
    public final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> M = Collections.synchronizedMap(new HashMap());
    public String N = "立即下载";
    public TTAppDownloadListener O = new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.12
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.a("下载中...");
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
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.a("暂停");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
            tTWebPageActivity.a(tTWebPageActivity.f());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            TTWebPageActivity.this.a("点击打开");
        }
    };

    public static /* synthetic */ int c(TTWebPageActivity tTWebPageActivity) {
        int i = tTWebPageActivity.H;
        tTWebPageActivity.H = i + 1;
        return i;
    }

    public static /* synthetic */ int e(TTWebPageActivity tTWebPageActivity) {
        int i = tTWebPageActivity.I;
        tTWebPageActivity.I = i + 1;
        return i;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (i()) {
            if (al.a((WebView) this.f27510h)) {
                return;
            }
            super.onBackPressed();
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        e();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        this.r = this;
        super.onCreate(bundle);
        try {
            p.a(this);
            setContentView(ad.f(this, "tt_activity_ttlandingpage"));
        } catch (Throwable unused) {
        }
        g();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.r).a(false).b(false).a(this.f27510h);
        Intent intent = getIntent();
        this.s = intent.getIntExtra("sdk_version", 1);
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
                } catch (Exception e2) {
                    u.c(f27503g, "TTWebPageActivity - onCreate MultiGlobalInfo : ", e2);
                }
            }
        } else {
            this.D = com.bytedance.sdk.openadsdk.core.u.a().c();
            com.bytedance.sdk.openadsdk.core.u.a().g();
        }
        l lVar = this.D;
        if (lVar != null) {
            lVar.c("landing_page");
        }
        c(this.D);
        this.f27509f = new j(this, this.D, this.f27510h).a(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.y);
            jSONObject.put("url", stringExtra);
            jSONObject.put("web_title", stringExtra2);
            jSONObject.put("is_multi_process", b.b());
            jSONObject.put("event_tag", this.C);
        } catch (JSONException unused2) {
        }
        this.f27509f.a(jSONObject);
        h();
        this.f27510h.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.r, this.A, this.y, this.f27509f) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTWebPageActivity.this.x == null || TTWebPageActivity.this.isFinishing()) {
                        return;
                    }
                    TTWebPageActivity.this.x.setVisibility(8);
                } catch (Throwable unused3) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                try {
                    if (TextUtils.isEmpty(TTWebPageActivity.this.F)) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                    TTWebPageActivity.c(TTWebPageActivity.this);
                    WebResourceResponse a2 = com.bytedance.sdk.openadsdk.d.a.a().a(TTWebPageActivity.this.G, TTWebPageActivity.this.F, str);
                    if (a2 != null) {
                        TTWebPageActivity.e(TTWebPageActivity.this);
                        Log.d(TTWebPageActivity.f27503g, "GeckoLog: hit++");
                        return a2;
                    }
                    return super.shouldInterceptRequest(webView, str);
                } catch (Throwable th) {
                    Log.e(TTWebPageActivity.f27503g, "shouldInterceptRequest url error", th);
                    return super.shouldInterceptRequest(webView, str);
                }
            }
        });
        this.f27510h.getSettings().setUserAgentString(r.a(this.f27510h, this.s));
        if (Build.VERSION.SDK_INT >= 21) {
            this.f27510h.getSettings().setMixedContentMode(0);
        }
        com.bytedance.sdk.openadsdk.c.d.a(this.r, this.D);
        this.f27510h.loadUrl(stringExtra);
        this.f27510h.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.A, this.f27509f) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTWebPageActivity.this.x == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                if (i != 100 || !TTWebPageActivity.this.x.isShown()) {
                    TTWebPageActivity.this.x.setProgress(i);
                } else {
                    TTWebPageActivity.this.x.setVisibility(8);
                }
            }
        });
        this.f27510h.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.8
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
                if (TTWebPageActivity.this.D != null && TTWebPageActivity.this.D.aa() != null) {
                    TTWebPageActivity.this.D.aa().a();
                }
                TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(tTWebPageActivity, str, tTWebPageActivity.D, TTWebPageActivity.this.C);
                TTWebPageActivity.this.M.put(str, a2);
                a2.e();
            }
        });
        TextView textView = this.k;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = ad.a(this, "tt_web_title_default");
            }
            textView.setText(stringExtra2);
        }
        TextView textView2 = this.o;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                    tTWebPageActivity.a(tTWebPageActivity.D);
                }
            });
        }
        TextView textView3 = this.p;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                    tTWebPageActivity.b(tTWebPageActivity.D);
                }
            });
        }
        e();
        a(4);
        this.G = com.bytedance.sdk.openadsdk.d.a.a().b();
        com.bytedance.sdk.openadsdk.c.d.a(this.D, this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.F)) {
            d.a.a(this.I, this.H, this.D);
        }
        com.bytedance.sdk.openadsdk.d.a.a().a(this.G);
        aa.a(this.r, this.f27510h);
        aa.a(this.f27510h);
        this.f27510h = null;
        x xVar = this.A;
        if (xVar != null) {
            xVar.o();
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.L;
        if (aVar != null) {
            aVar.d();
        }
        Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> map = this.M;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().d();
                }
            }
            this.M.clear();
        }
        j jVar = this.f27509f;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.core.u.a().b(true);
        x xVar = this.A;
        if (xVar != null) {
            xVar.n();
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.L;
        if (aVar != null) {
            aVar.c();
        }
        Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> map = this.M;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().c();
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        x xVar = this.A;
        if (xVar != null) {
            xVar.m();
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.L;
        if (aVar != null) {
            aVar.b();
        }
        Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> map = this.M;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().b();
                }
            }
        }
        j jVar = this.f27509f;
        if (jVar != null) {
            jVar.b();
        }
        j();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        j jVar = this.f27509f;
        if (jVar != null) {
            jVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void d() {
        l lVar = this.D;
        if (lVar == null || lVar.Z() != 4) {
            return;
        }
        if (this.L == null) {
            com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.D, TextUtils.isEmpty(this.C) ? ak.a(this.B) : this.C);
            this.L = a2;
            a2.a(this.O, false);
        }
        this.L.a(this);
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.L;
        if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) this.L).g(false);
        }
        com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this, this.D, "embeded_ad_landingpage", this.B);
        aVar2.a(true);
        aVar2.c(true);
        this.L.g();
        aVar2.a(this.L);
    }

    private void e() {
        l lVar = this.D;
        if (lVar == null || lVar.Z() != 4) {
            return;
        }
        this.v.setVisibility(0);
        Button button = (Button) findViewById(ad.e(this, "tt_browser_download_btn"));
        this.w = button;
        if (button != null) {
            a(f());
            if (this.L == null) {
                com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.D, TextUtils.isEmpty(this.C) ? ak.a(this.B) : this.C);
                this.L = a2;
                a2.a(this.O, false);
            }
            this.L.a(this);
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.L;
            if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
            }
            com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this, this.D, "embeded_ad_landingpage", this.B);
            aVar2.a(true);
            aVar2.c(true);
            this.w.setOnClickListener(aVar2);
            this.w.setOnTouchListener(aVar2);
            aVar2.a(this.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        l lVar = this.D;
        if (lVar != null && !TextUtils.isEmpty(lVar.al())) {
            this.N = this.D.al();
        }
        return this.N;
    }

    private void g() {
        this.f27510h = (SSWebView) findViewById(ad.e(this, "tt_browser_webview"));
        this.v = (ViewStub) findViewById(ad.e(this, "tt_browser_download_btn_stub"));
        this.t = (ViewStub) findViewById(ad.e(this, "tt_browser_titlebar_view_stub"));
        this.u = (ViewStub) findViewById(ad.e(this, "tt_browser_titlebar_dark_view_stub"));
        int m = i.d().m();
        if (m == 0) {
            this.t.setVisibility(0);
        } else if (m == 1) {
            this.u.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(ad.e(this, "tt_titlebar_back"));
        this.i = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTWebPageActivity.this.f27510h != null) {
                        if (TTWebPageActivity.this.f27510h.canGoBack()) {
                            TTWebPageActivity.this.f27510h.goBack();
                        } else if (TTWebPageActivity.this.i()) {
                            TTWebPageActivity.this.onBackPressed();
                        } else {
                            TTWebPageActivity.this.finish();
                        }
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(ad.e(this, "tt_titlebar_close"));
        this.j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.finish();
                }
            });
        }
        this.k = (TextView) findViewById(ad.e(this, "tt_titlebar_title"));
        this.l = (TextView) findViewById(ad.e(this, "tt_titlebar_dislike"));
        this.m = (TextView) findViewById(ad.e(this, "tt_titlebar_developer"));
        this.n = (TextView) findViewById(ad.e(this, "tt_titlebar_app_name"));
        this.o = (TextView) findViewById(ad.e(this, "tt_titlebar_app_detail"));
        this.p = (TextView) findViewById(ad.e(this, "tt_titlebar_app_privacy"));
        this.q = (LinearLayout) findViewById(ad.e(this, "tt_titlebar_detail_layout"));
        TextView textView = this.l;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.a();
                }
            });
        }
        this.x = (ProgressBar) findViewById(ad.e(this, "tt_browser_progress"));
    }

    private void h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.D);
        x xVar = new x(this);
        this.A = xVar;
        xVar.b(this.f27510h).a(this.D).a(arrayList).b(this.y).c(this.z).a(this.B).d(ak.i(this.D)).a(this.f27510h).a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return l.f(this.D);
    }

    private void j() {
        if (this.D == null) {
            return;
        }
        JSONArray b2 = b(this.E);
        int d2 = ak.d(this.z);
        int c2 = ak.c(this.z);
        q<com.bytedance.sdk.openadsdk.c.a> f2 = p.f();
        if (b2 == null || f2 == null || d2 <= 0 || c2 <= 0) {
            return;
        }
        m mVar = new m();
        mVar.f28196d = b2;
        AdSlot p = this.D.p();
        if (p == null) {
            return;
        }
        p.setAdCount(6);
        f2.a(p, mVar, c2, new q.b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.4
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
                    } catch (Exception unused) {
                        TTWebPageActivity.this.a(0);
                    }
                }
            }
        });
    }

    private void k() {
        LandingDislikeToast landingDislikeToast = this.f27506c;
        if (landingDislikeToast == null) {
            return;
        }
        landingDislikeToast.a("您已成功提交反馈，请勿重复提交哦！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        LandingDislikeToast landingDislikeToast = this.f27506c;
        if (landingDislikeToast == null) {
            return;
        }
        landingDislikeToast.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        LandingDislikeToast landingDislikeToast = this.f27506c;
        if (landingDislikeToast == null) {
            return;
        }
        landingDislikeToast.a("输入为空或者输入特殊字符，请重新输入");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l lVar) {
        if (lVar == null) {
            return;
        }
        g.a(this.r, lVar.W());
    }

    private void c(l lVar) {
        if (lVar == null) {
            LinearLayout linearLayout = this.q;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        String W = lVar.W();
        if (TextUtils.isEmpty(W)) {
            LinearLayout linearLayout2 = this.q;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(W)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.d.c b2 = c.b(new JSONObject(W));
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
                String c2 = b2.c();
                String g2 = b2.g();
                if (TextUtils.isEmpty(g2)) {
                    g2 = f.a(lVar);
                }
                if (this.m != null) {
                    this.m.setText(String.format(ad.a(this.r, "tt_open_app_detail_developer"), c2));
                }
                if (this.n != null) {
                    this.n.setText(String.format(ad.a(this.r, "tt_open_landing_page_app_name"), g2, b3));
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        if (lVar == null) {
            return;
        }
        g.a(this.r, lVar.am(), lVar.W(), new g.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.11
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
        }, f.a(lVar), lVar.Z() == 4);
    }

    private JSONArray b(String str) {
        int i;
        JSONArray jSONArray = this.K;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.K;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("?id=");
        int indexOf2 = str.indexOf("&");
        if (indexOf == -1 || indexOf2 == -1 || (i = indexOf + 4) >= indexOf2) {
            return null;
        }
        String substring = str.substring(i, indexOf2);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(substring);
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.w) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (TTWebPageActivity.this.w == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTWebPageActivity.this.w.setText(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i()) {
            al.a((View) this.j, 4);
        } else if (this.j == null || !i()) {
        } else {
            al.a((View) this.j, i);
        }
    }

    public void b() {
        if (this.f27505b == null) {
            LandingCommentDialog landingCommentDialog = new LandingCommentDialog(this, this.D);
            this.f27505b = landingCommentDialog;
            landingCommentDialog.setCallback(new LandingCommentDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(View view) {
                    TTWebPageActivity.this.f27507d.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void b(View view) {
                    TTWebPageActivity.this.f27507d.set(false);
                    if (!TTWebPageActivity.this.f27508e.get()) {
                        TTWebPageActivity.this.f27504a.a();
                    } else {
                        TTWebPageActivity.this.f27504a.a(true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(String str, boolean z) {
                    if (!z || TTWebPageActivity.this.f27508e.get()) {
                        if (z) {
                            return;
                        }
                        TTWebPageActivity.this.m();
                        return;
                    }
                    TTWebPageActivity.this.f27507d.set(true);
                    TTWebPageActivity.this.f27508e.set(true);
                    TTWebPageActivity.this.l();
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.f27505b);
            this.f27505b.setVisibility(8);
        }
        if (this.f27504a == null) {
            LandingDislikeDialog landingDislikeDialog = new LandingDislikeDialog(this, this.D, this.C);
            this.f27504a = landingDislikeDialog;
            landingDislikeDialog.setCallback(new LandingDislikeDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.6
                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(View view) {
                    TTWebPageActivity.this.f27507d.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void b(View view) {
                    TTWebPageActivity.this.f27507d.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(int i, FilterWord filterWord) {
                    if (TTWebPageActivity.this.f27508e.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    TTWebPageActivity.this.f27508e.set(true);
                    TTWebPageActivity.this.l();
                    LandingCommentDialog landingCommentDialog2 = TTWebPageActivity.this.f27505b;
                    if (landingCommentDialog2 != null) {
                        landingCommentDialog2.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a() {
                    TTWebPageActivity.this.f27505b.b();
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.f27504a);
        }
        if (this.f27506c == null) {
            this.f27506c = new LandingDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.f27506c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.d
    public void a(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.K = jSONArray;
        j();
    }

    public void a() {
        if (this.D == null || isFinishing()) {
            return;
        }
        if (this.f27508e.get()) {
            k();
            return;
        }
        if (this.f27504a == null) {
            b();
        }
        this.f27504a.a();
    }
}
