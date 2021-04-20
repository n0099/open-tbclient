package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.a.d;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.b;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeToast;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.f.a.f;
import com.bytedance.sdk.openadsdk.j.d;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TTPlayableWebPageActivity extends Activity implements d, am.a {
    public static d.a L = new d.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.1
        @Override // com.bytedance.sdk.openadsdk.j.d.a
        public void a(String str, String str2) {
            u.b(str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.j.d.a
        public void a(String str, String str2, Throwable th) {
            u.c(str, str2, th);
        }
    };
    public boolean A;
    public boolean B;
    public a C;
    public int E;
    public String F;
    public com.bytedance.sdk.openadsdk.preload.falconx.a.a I;
    public e J;

    /* renamed from: a  reason: collision with root package name */
    public LandingDislikeDialog f27117a;

    /* renamed from: b  reason: collision with root package name */
    public LandingCommentDialog f27118b;

    /* renamed from: c  reason: collision with root package name */
    public LandingDislikeToast f27119c;

    /* renamed from: g  reason: collision with root package name */
    public SSWebView f27123g;

    /* renamed from: h  reason: collision with root package name */
    public SSWebView f27124h;
    public RelativeLayout k;
    public View l;
    public Context m;
    public int n;
    public ProgressBar o;
    public PlayableLoadingView p;
    public String q;
    public String r;
    public x s;
    public x t;
    public int u;
    public String v;
    public String w;
    public String x;
    public l y;
    public boolean i = true;
    public boolean j = true;
    public am z = new am(Looper.getMainLooper(), this);
    public AtomicBoolean D = new AtomicBoolean(false);
    public int G = 0;
    public int H = 0;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f27120d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f27121e = new AtomicBoolean(false);
    public boolean K = false;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.g.d f27122f = new com.bytedance.sdk.openadsdk.g.d() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.5
        @Override // com.bytedance.sdk.openadsdk.g.d
        public void a() {
            if (TTPlayableWebPageActivity.this.isFinishing()) {
                return;
            }
            if ((TTPlayableWebPageActivity.this.y == null || TTPlayableWebPageActivity.this.y.A()) && TTPlayableWebPageActivity.this.y != null && TTPlayableWebPageActivity.this.y.B()) {
                TTPlayableWebPageActivity.this.z.removeMessages(2);
                TTPlayableWebPageActivity.this.z.sendMessage(TTPlayableWebPageActivity.this.a(1));
            }
        }
    };

    public static /* synthetic */ int i(TTPlayableWebPageActivity tTPlayableWebPageActivity) {
        int i = tTPlayableWebPageActivity.G;
        tTPlayableWebPageActivity.G = i + 1;
        return i;
    }

    public static /* synthetic */ int k(TTPlayableWebPageActivity tTPlayableWebPageActivity) {
        int i = tTPlayableWebPageActivity.H;
        tTPlayableWebPageActivity.H = i + 1;
        return i;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            p.a(this);
        } catch (Throwable unused) {
        }
        a(bundle);
        l lVar = this.y;
        if (lVar == null) {
            return;
        }
        this.m = this;
        this.E = lVar.aq();
        setContentView(ad.f(this, "tt_activity_ttlandingpage_playable"));
        e();
        a();
        j();
        SSWebView sSWebView = this.f27123g;
        if (sSWebView != null) {
            sSWebView.setWebViewClient(new c(this.m, this.s, this.q, null) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.6
                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    try {
                        if (TTPlayableWebPageActivity.this.K && TTPlayableWebPageActivity.this.y.D() && !TTPlayableWebPageActivity.this.isFinishing() && TTPlayableWebPageActivity.this.y.A() && !TTPlayableWebPageActivity.this.y.B()) {
                            TTPlayableWebPageActivity.this.z.sendMessageDelayed(TTPlayableWebPageActivity.this.a(0), 1000L);
                        }
                    } catch (Throwable unused2) {
                    }
                    try {
                        if (TTPlayableWebPageActivity.this.o != null && !TTPlayableWebPageActivity.this.isFinishing()) {
                            TTPlayableWebPageActivity.this.o.setVisibility(8);
                        }
                        if (TTPlayableWebPageActivity.this.i) {
                            TTPlayableWebPageActivity.this.f();
                            TTPlayableWebPageActivity.this.a("py_loading_success");
                        }
                    } catch (Throwable unused3) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    TTPlayableWebPageActivity.this.i = false;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                @RequiresApi(api = 21)
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    if (TTPlayableWebPageActivity.this.v != null && webResourceRequest != null && webResourceRequest.getUrl() != null && TTPlayableWebPageActivity.this.v.equals(webResourceRequest.getUrl().toString())) {
                        TTPlayableWebPageActivity.this.i = false;
                    }
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    try {
                        if (TextUtils.isEmpty(TTPlayableWebPageActivity.this.F)) {
                            return super.shouldInterceptRequest(webView, str);
                        }
                        TTPlayableWebPageActivity.i(TTPlayableWebPageActivity.this);
                        WebResourceResponse a2 = com.bytedance.sdk.openadsdk.d.a.a().a(TTPlayableWebPageActivity.this.I, TTPlayableWebPageActivity.this.F, str);
                        if (a2 != null) {
                            TTPlayableWebPageActivity.k(TTPlayableWebPageActivity.this);
                            Log.d("TTPWPActivity", "GeckoLog: hit++");
                            return a2;
                        }
                        return super.shouldInterceptRequest(webView, str);
                    } catch (Throwable th) {
                        Log.e("TTPWPActivity", "shouldInterceptRequest url error", th);
                        return super.shouldInterceptRequest(webView, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    super.onReceivedError(webView, i, str, str2);
                    TTPlayableWebPageActivity.this.i = false;
                }
            });
            a(this.f27123g);
            a(this.f27124h);
            g();
            this.f27123g.loadUrl(this.v);
            this.f27123g.setWebChromeClient(new b(this.s, null) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.7
                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    try {
                        if (TTPlayableWebPageActivity.this.K && TTPlayableWebPageActivity.this.y.D() && TTPlayableWebPageActivity.this.y.A() && !TTPlayableWebPageActivity.this.isFinishing() && TTPlayableWebPageActivity.this.p != null) {
                            TTPlayableWebPageActivity.this.p.setProgress(i);
                        }
                    } catch (Throwable unused2) {
                    }
                    if (TTPlayableWebPageActivity.this.o == null || TTPlayableWebPageActivity.this.isFinishing()) {
                        return;
                    }
                    if (i != 100 || !TTPlayableWebPageActivity.this.o.isShown()) {
                        TTPlayableWebPageActivity.this.o.setProgress(i);
                        return;
                    }
                    TTPlayableWebPageActivity.this.o.setVisibility(8);
                    TTPlayableWebPageActivity.this.f();
                }
            });
        }
        if (this.y.Z() == 4) {
            a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.m, this.y, this.x);
            this.C = a2;
            if (a2 != null && (a2 instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d)) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) a2).f(true);
            }
        }
        this.I = com.bytedance.sdk.openadsdk.d.a.a().b();
        com.bytedance.sdk.openadsdk.c.d.a(this.y, this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        am amVar = this.z;
        if (amVar != null) {
            amVar.removeCallbacksAndMessages(null);
        }
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.F)) {
            d.a.a(this.H, this.G, this.y);
        }
        com.bytedance.sdk.openadsdk.d.a.a().a(this.I);
        aa.a(this.m, this.f27123g);
        aa.a(this.f27123g);
        this.f27123g = null;
        x xVar = this.s;
        if (xVar != null) {
            xVar.o();
        }
        x xVar2 = this.t;
        if (xVar2 != null) {
            xVar2.o();
        }
        i();
        e eVar = this.J;
        if (eVar != null) {
            eVar.r();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.core.u.a().b(true);
        x xVar = this.s;
        if (xVar != null) {
            xVar.n();
        }
        x xVar2 = this.t;
        if (xVar2 != null) {
            xVar2.n();
        }
        e eVar = this.J;
        if (eVar != null) {
            eVar.p();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        x xVar = this.s;
        if (xVar != null) {
            xVar.m();
        }
        x xVar2 = this.t;
        if (xVar2 != null) {
            xVar2.m();
        }
        e eVar = this.J;
        if (eVar != null) {
            eVar.q();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("material_meta", this.y != null ? this.y.aL().toString() : null);
            bundle.putInt("sdk_version", this.n);
            bundle.putString(XAdRemoteAPKDownloadExtraInfo.ADID, this.q);
            bundle.putString("log_extra", this.r);
            bundle.putInt("source", this.u);
            bundle.putBoolean("ad_pending_download", this.A);
            bundle.putString("url", this.v);
            bundle.putString("web_title", this.w);
            bundle.putString("event_tag", this.x);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }

    private void d() {
        if (this.J != null) {
            return;
        }
        if (i.d().w()) {
            com.bytedance.sdk.openadsdk.j.d.a(L);
        }
        this.J = e.a(getApplicationContext(), this.f27123g, new com.bytedance.sdk.openadsdk.j.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.8
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
            }

            @Override // com.bytedance.sdk.openadsdk.j.a
            public void b(JSONObject jSONObject) {
            }

            @Override // com.bytedance.sdk.openadsdk.j.a
            public void c(JSONObject jSONObject) {
            }

            @Override // com.bytedance.sdk.openadsdk.j.a
            public void a(String str, JSONObject jSONObject) {
                TTPlayableWebPageActivity.this.s.a(str, jSONObject);
            }
        }).e(com.bytedance.sdk.openadsdk.a.a.a(p.a())).a(com.bytedance.sdk.openadsdk.a.a.a()).b(com.bytedance.sdk.openadsdk.a.a.e()).a("sdkEdition", com.bytedance.sdk.openadsdk.a.a.c()).d(com.bytedance.sdk.openadsdk.a.a.d()).c(false).a(false).b(true);
        l lVar = this.y;
        if (lVar != null && !TextUtils.isEmpty(lVar.j())) {
            this.J.c(this.y.j());
        }
        Set<String> j = this.J.j();
        final WeakReference weakReference = new WeakReference(this.J);
        for (String str : j) {
            if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str)) {
                this.s.a().a(str, (com.bytedance.sdk.openadsdk.f.a.e<?, ?>) new com.bytedance.sdk.openadsdk.f.a.e<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.9
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.f.a.e
                    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull f fVar) throws Exception {
                        try {
                            e eVar = (e) weakReference.get();
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

    private void e() {
        this.p = (PlayableLoadingView) findViewById(ad.e(this, "tt_playable_loading"));
        this.f27123g = (SSWebView) findViewById(ad.e(this, "tt_browser_webview"));
        this.f27124h = (SSWebView) findViewById(ad.e(this, "tt_browser_webview_loading"));
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(ad.e(this, "tt_playable_ad_close_layout"));
        this.k = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTPlayableWebPageActivity.this.a("playable_close");
                    TTPlayableWebPageActivity.this.k();
                    TTPlayableWebPageActivity.this.finish();
                }
            });
        }
        this.o = (ProgressBar) findViewById(ad.e(this, "tt_browser_progress"));
        View findViewById = findViewById(ad.e(this, "tt_playable_ad_dislike"));
        this.l = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTPlayableWebPageActivity.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        SSWebView sSWebView;
        if (this.D.getAndSet(true) || (sSWebView = this.f27123g) == null || this.f27124h == null) {
            return;
        }
        al.a((View) sSWebView, 0);
        al.a((View) this.f27124h, 8);
        int i = p.h().q(String.valueOf(ak.d(this.y.ap()))).r;
        if (i >= 0) {
            this.z.sendEmptyMessageDelayed(1, i * 1000);
        } else {
            al.a((View) this.k, 0);
        }
    }

    private boolean g() {
        if (this.f27124h == null) {
            return false;
        }
        String h2 = h();
        if (TextUtils.isEmpty(h2)) {
            return false;
        }
        this.f27124h.setWebViewClient(new c(this.m, this.t, this.q, null) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (TTPlayableWebPageActivity.this.j) {
                    TTPlayableWebPageActivity.this.a("loading_h5_success");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTPlayableWebPageActivity.this.j = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                TTPlayableWebPageActivity.this.j = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                TTPlayableWebPageActivity.this.j = false;
            }
        });
        this.f27124h.loadUrl(h2);
        return true;
    }

    private String h() {
        l lVar;
        String m = p.h().m();
        if (TextUtils.isEmpty(m) || (lVar = this.y) == null || lVar.an() == null) {
            return m;
        }
        String c2 = this.y.an().c();
        int e2 = this.y.an().e();
        int f2 = this.y.an().f();
        String a2 = this.y.aa().a();
        String am = this.y.am();
        String d2 = this.y.an().d();
        String b2 = this.y.an().b();
        String c3 = this.y.an().c();
        StringBuffer stringBuffer = new StringBuffer(m);
        stringBuffer.append("?appname=");
        stringBuffer.append(c2);
        stringBuffer.append("&stars=");
        stringBuffer.append(e2);
        stringBuffer.append("&comments=");
        stringBuffer.append(f2);
        stringBuffer.append("&icon=");
        stringBuffer.append(a2);
        stringBuffer.append("&downloading=");
        stringBuffer.append(false);
        stringBuffer.append("&id=");
        stringBuffer.append(am);
        stringBuffer.append("&pkg_name=");
        stringBuffer.append(d2);
        stringBuffer.append("&download_url=");
        stringBuffer.append(b2);
        stringBuffer.append("&name=");
        stringBuffer.append(c3);
        return stringBuffer.toString();
    }

    private void i() {
        a aVar;
        if (this.B || !this.A || (aVar = this.C) == null) {
            return;
        }
        aVar.g();
    }

    private void j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.y);
        x xVar = new x(this);
        this.s = xVar;
        xVar.b(this.f27123g).a(this.y).a(arrayList).b(this.q).c(this.r).a(this.u).a(this).a(this.f27122f).a(this.f27123g).d(ak.i(this.y));
        x xVar2 = new x(this);
        this.t = xVar2;
        xVar2.b(this.f27124h).a(this.y).b(this.q).c(this.r).a(this).a(this.u).c(false).a(this.f27124h).d(ak.i(this.y));
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Bitmap b2;
        l lVar = this.y;
        if (lVar == null || this.f27123g == null || !lVar.C() || (b2 = al.b((WebView) this.f27123g)) == null) {
            return;
        }
        al.a(p.a(), this.y, this.x, "playable_show_status", b2, false, 1);
    }

    private void l() {
        LandingDislikeToast landingDislikeToast = this.f27119c;
        if (landingDislikeToast == null) {
            return;
        }
        landingDislikeToast.a("您已成功提交反馈，请勿重复提交哦！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        LandingDislikeToast landingDislikeToast = this.f27119c;
        if (landingDislikeToast == null) {
            return;
        }
        landingDislikeToast.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        LandingDislikeToast landingDislikeToast = this.f27119c;
        if (landingDislikeToast == null) {
            return;
        }
        landingDislikeToast.a("输入为空或者输入特殊字符，请重新输入");
    }

    public void c() {
        if (this.f27118b == null) {
            LandingCommentDialog landingCommentDialog = new LandingCommentDialog(this, this.y);
            this.f27118b = landingCommentDialog;
            landingCommentDialog.setCallback(new LandingCommentDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.3
                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(View view) {
                    TTPlayableWebPageActivity.this.f27120d.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void b(View view) {
                    TTPlayableWebPageActivity.this.f27120d.set(false);
                    if (!TTPlayableWebPageActivity.this.f27121e.get()) {
                        TTPlayableWebPageActivity.this.f27117a.a();
                    } else {
                        TTPlayableWebPageActivity.this.f27117a.a(true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(String str, boolean z) {
                    if (!z || TTPlayableWebPageActivity.this.f27121e.get()) {
                        if (z) {
                            return;
                        }
                        TTPlayableWebPageActivity.this.n();
                        return;
                    }
                    TTPlayableWebPageActivity.this.f27120d.set(true);
                    TTPlayableWebPageActivity.this.f27121e.set(true);
                    TTPlayableWebPageActivity.this.m();
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.f27118b);
            this.f27118b.setVisibility(8);
        }
        if (this.f27117a == null) {
            LandingDislikeDialog landingDislikeDialog = new LandingDislikeDialog(this, this.y, this.x);
            this.f27117a = landingDislikeDialog;
            landingDislikeDialog.setCallback(new LandingDislikeDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.4
                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(View view) {
                    TTPlayableWebPageActivity.this.f27120d.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void b(View view) {
                    TTPlayableWebPageActivity.this.f27120d.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(int i, FilterWord filterWord) {
                    if (TTPlayableWebPageActivity.this.f27121e.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    TTPlayableWebPageActivity.this.f27121e.set(true);
                    TTPlayableWebPageActivity.this.m();
                    LandingCommentDialog landingCommentDialog2 = TTPlayableWebPageActivity.this.f27118b;
                    if (landingCommentDialog2 != null) {
                        landingCommentDialog2.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a() {
                    TTPlayableWebPageActivity.this.f27118b.b();
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.f27117a);
        }
        if (this.f27119c == null) {
            this.f27119c = new LandingDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.f27119c);
        }
    }

    public void b() {
        if (isFinishing()) {
            return;
        }
        if (this.f27121e.get()) {
            l();
            return;
        }
        if (this.f27117a == null) {
            c();
        }
        this.f27117a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message a(int i) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i;
        return obtain;
    }

    private void a(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.n = intent.getIntExtra("sdk_version", 1);
            this.q = intent.getStringExtra(XAdRemoteAPKDownloadExtraInfo.ADID);
            this.r = intent.getStringExtra("log_extra");
            this.u = intent.getIntExtra("source", -1);
            this.A = intent.getBooleanExtra("ad_pending_download", false);
            this.v = intent.getStringExtra("url");
            this.F = intent.getStringExtra("gecko_id");
            this.w = intent.getStringExtra("web_title");
            this.x = intent.getStringExtra("event_tag");
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra != null) {
                try {
                    this.y = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra));
                } catch (Exception e2) {
                    u.c("TTPWPActivity", "TTPlayableWebPageActivity - onCreate MultiGlobalInfo : ", e2);
                }
            }
        } else {
            this.y = com.bytedance.sdk.openadsdk.core.u.a().c();
            com.bytedance.sdk.openadsdk.core.u.a().g();
        }
        if (bundle != null) {
            try {
                this.n = bundle.getInt("sdk_version", 1);
                this.q = bundle.getString(XAdRemoteAPKDownloadExtraInfo.ADID);
                this.r = bundle.getString("log_extra");
                this.u = bundle.getInt("source", -1);
                this.A = bundle.getBoolean("ad_pending_download", false);
                this.v = bundle.getString("url");
                this.w = bundle.getString("web_title");
                this.x = bundle.getString("event_tag");
                String string = bundle.getString("material_meta", null);
                if (!TextUtils.isEmpty(string)) {
                    this.y = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(string));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.y == null) {
            u.f("TTPWPActivity", "material is null, no data to display");
            finish();
        }
    }

    public void a() {
        PlayableLoadingView playableLoadingView = this.p;
        if (playableLoadingView == null) {
            return;
        }
        if (!this.K) {
            playableLoadingView.a();
            return;
        }
        l lVar = this.y;
        if (lVar != null && lVar.A() && this.y.D()) {
            this.p.b();
            if (this.p.getPlayView() != null) {
                com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this, this.y, this.x, this.u) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.12
                    @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
                    public void a(View view, int i, int i2, int i3, int i4) {
                        super.a(view, i, i2, i3, i4);
                        if (TTPlayableWebPageActivity.this.y.D()) {
                            HashMap hashMap = new HashMap();
                            if (TTPlayableWebPageActivity.this.y.X() != null) {
                                hashMap.put("playable_url", TTPlayableWebPageActivity.this.y.X().j());
                            }
                            TTPlayableWebPageActivity tTPlayableWebPageActivity = TTPlayableWebPageActivity.this;
                            com.bytedance.sdk.openadsdk.c.d.k(tTPlayableWebPageActivity, tTPlayableWebPageActivity.y, this.f27705e, "click_playable_download_button_loading", hashMap);
                        }
                    }
                };
                this.p.getPlayView().setOnClickListener(aVar);
                this.p.getPlayView().setOnTouchListener(aVar);
            }
            l lVar2 = this.y;
            if (lVar2 != null && lVar2.D() && this.y.B()) {
                this.z.sendMessageDelayed(a(2), 10000L);
                return;
            }
            return;
        }
        this.p.a();
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.m).a(false).b(false).a(sSWebView);
        sSWebView.getSettings().setUserAgentString(r.a(sSWebView, this.n));
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.getSettings().setMixedContentMode(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.bytedance.sdk.openadsdk.c.d.c(this, this.y, this.x, str, (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        int i = message.what;
        if (i == 1) {
            al.a((View) this.k, 0);
        } else if (i == 2 && this.K) {
            HashMap hashMap = new HashMap();
            hashMap.put("remove_loading_page_type", Integer.valueOf(message.arg1));
            if (this.y.X() != null) {
                hashMap.put("playable_url", this.y.X().j());
            }
            com.bytedance.sdk.openadsdk.c.d.k(this, this.y, this.x, "remove_loading_page", hashMap);
            this.z.removeMessages(2);
            PlayableLoadingView playableLoadingView = this.p;
            if (playableLoadingView != null) {
                playableLoadingView.a();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.d
    public void a(boolean z) {
        a aVar;
        this.A = true;
        this.B = z;
        if (!z) {
            Toast.makeText(this.m, "稍后开始下载", 0).show();
        }
        if (!this.B || (aVar = this.C) == null) {
            return;
        }
        aVar.g();
    }
}
