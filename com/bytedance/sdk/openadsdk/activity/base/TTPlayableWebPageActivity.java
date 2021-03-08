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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.sapi2.SapiContext;
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
import com.bytedance.sdk.openadsdk.e.a.f;
import com.bytedance.sdk.openadsdk.playable.d;
import com.bytedance.sdk.openadsdk.playable.e;
import com.bytedance.sdk.openadsdk.preload.falconx.a.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TTPlayableWebPageActivity extends Activity implements d, al.a {
    private a C;
    private e D;
    private SSWebView b;
    private SSWebView c;
    private RelativeLayout f;
    private Context g;
    private int h;
    private ProgressBar i;
    private PlayableLoadingView j;
    private String k;
    private String l;
    private x m;
    private x n;
    private int o;
    private String p;
    private String q;
    private String r;
    private l s;
    private boolean u;
    private boolean v;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a w;
    private int y;
    private String z;
    private boolean d = true;
    private boolean e = true;
    private al t = new al(Looper.getMainLooper(), this);
    private AtomicBoolean x = new AtomicBoolean(false);
    private int A = 0;
    private int B = 0;
    private boolean E = false;

    /* renamed from: a  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.f.d f4134a = new com.bytedance.sdk.openadsdk.f.d() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.1
        @Override // com.bytedance.sdk.openadsdk.f.d
        public void a() {
            if (!TTPlayableWebPageActivity.this.isFinishing()) {
                if ((TTPlayableWebPageActivity.this.s == null || TTPlayableWebPageActivity.this.s.A()) && TTPlayableWebPageActivity.this.s != null && TTPlayableWebPageActivity.this.s.B()) {
                    TTPlayableWebPageActivity.this.t.removeMessages(2);
                    TTPlayableWebPageActivity.this.t.sendMessage(TTPlayableWebPageActivity.this.a(1));
                }
            }
        }
    };

    static /* synthetic */ int i(TTPlayableWebPageActivity tTPlayableWebPageActivity) {
        int i = tTPlayableWebPageActivity.A;
        tTPlayableWebPageActivity.A = i + 1;
        return i;
    }

    static /* synthetic */ int k(TTPlayableWebPageActivity tTPlayableWebPageActivity) {
        int i = tTPlayableWebPageActivity.B;
        tTPlayableWebPageActivity.B = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message a(int i) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i;
        return obtain;
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            p.a(this);
        } catch (Throwable th) {
        }
        a(bundle);
        if (this.s != null) {
            this.g = this;
            this.y = this.s.ak();
            setContentView(ac.f(this, "tt_activity_ttlandingpage_playable"));
            c();
            a();
            h();
            if (this.b != null) {
                this.b.setWebViewClient(new c(this.g, this.m, this.k, null) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.2
                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        try {
                            if (TTPlayableWebPageActivity.this.E && TTPlayableWebPageActivity.this.s.D() && !TTPlayableWebPageActivity.this.isFinishing() && TTPlayableWebPageActivity.this.s.A() && !TTPlayableWebPageActivity.this.s.B()) {
                                TTPlayableWebPageActivity.this.t.sendMessageDelayed(TTPlayableWebPageActivity.this.a(0), 1000L);
                            }
                        } catch (Throwable th2) {
                        }
                        try {
                            if (TTPlayableWebPageActivity.this.i != null && !TTPlayableWebPageActivity.this.isFinishing()) {
                                TTPlayableWebPageActivity.this.i.setVisibility(8);
                            }
                            if (TTPlayableWebPageActivity.this.d) {
                                TTPlayableWebPageActivity.this.d();
                                TTPlayableWebPageActivity.this.a("py_loading_success");
                            }
                        } catch (Throwable th3) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    @RequiresApi(api = 21)
                    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        if (TTPlayableWebPageActivity.this.p != null && webResourceRequest != null && webResourceRequest.getUrl() != null && TTPlayableWebPageActivity.this.p.equals(webResourceRequest.getUrl().toString())) {
                            TTPlayableWebPageActivity.this.d = false;
                        }
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        super.onReceivedError(webView, webResourceRequest, webResourceError);
                        TTPlayableWebPageActivity.this.d = false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        TTPlayableWebPageActivity.this.d = false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                        WebResourceResponse a2;
                        try {
                            if (TextUtils.isEmpty(TTPlayableWebPageActivity.this.z)) {
                                a2 = super.shouldInterceptRequest(webView, str);
                            } else {
                                TTPlayableWebPageActivity.i(TTPlayableWebPageActivity.this);
                                a2 = com.bytedance.sdk.openadsdk.gecko.a.a().a(TTPlayableWebPageActivity.this.C, TTPlayableWebPageActivity.this.z, str);
                                if (a2 != null) {
                                    TTPlayableWebPageActivity.k(TTPlayableWebPageActivity.this);
                                    Log.d("TTPWPActivity", "GeckoLog: hit++");
                                } else {
                                    a2 = super.shouldInterceptRequest(webView, str);
                                }
                            }
                            return a2;
                        } catch (Throwable th2) {
                            Log.e("TTPWPActivity", "shouldInterceptRequest url error", th2);
                            return super.shouldInterceptRequest(webView, str);
                        }
                    }
                });
                a(this.b);
                a(this.c);
                e();
                this.b.loadUrl(this.p);
                this.b.setWebChromeClient(new b(this.m, null) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.3
                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
                    public void onProgressChanged(WebView webView, int i) {
                        super.onProgressChanged(webView, i);
                        try {
                            if (TTPlayableWebPageActivity.this.E && TTPlayableWebPageActivity.this.s.D() && TTPlayableWebPageActivity.this.s.A() && !TTPlayableWebPageActivity.this.isFinishing() && TTPlayableWebPageActivity.this.j != null) {
                                TTPlayableWebPageActivity.this.j.setProgress(i);
                            }
                        } catch (Throwable th2) {
                        }
                        if (TTPlayableWebPageActivity.this.i != null && !TTPlayableWebPageActivity.this.isFinishing()) {
                            if (i != 100 || !TTPlayableWebPageActivity.this.i.isShown()) {
                                TTPlayableWebPageActivity.this.i.setProgress(i);
                                return;
                            }
                            TTPlayableWebPageActivity.this.i.setVisibility(8);
                            TTPlayableWebPageActivity.this.d();
                        }
                    }
                });
            }
            if (this.s.T() == 4) {
                this.w = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.g, this.s, this.r);
                if (this.w != null && (this.w instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d)) {
                    ((com.bytedance.sdk.openadsdk.downloadnew.a.d) this.w).f(true);
                }
            }
            this.C = com.bytedance.sdk.openadsdk.gecko.a.a().b();
            com.bytedance.sdk.openadsdk.c.d.a(this.s, this);
        }
    }

    private void b() {
        if (this.D == null) {
            if (i.d().v()) {
                com.bytedance.sdk.openadsdk.playable.d.a(new d.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.4
                    @Override // com.bytedance.sdk.openadsdk.playable.d.a
                    public void a(String str, String str2) {
                        u.b(str, str2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.playable.d.a
                    public void a(String str, String str2, Throwable th) {
                        u.c(str, str2, th);
                    }
                });
            }
            this.D = e.a(this.b, new com.bytedance.sdk.openadsdk.playable.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.playable.a
                public com.bytedance.sdk.openadsdk.playable.b a() {
                    String f = com.bytedance.sdk.openadsdk.a.a.f();
                    char c = 65535;
                    switch (f.hashCode()) {
                        case 1653:
                            if (f.equals("2g")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1684:
                            if (f.equals("3g")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1715:
                            if (f.equals("4g")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1746:
                            if (f.equals("5g")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 3649301:
                            if (f.equals("wifi")) {
                                c = 4;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            return com.bytedance.sdk.openadsdk.playable.b.TYPE_2G;
                        case 1:
                            return com.bytedance.sdk.openadsdk.playable.b.TYPE_3G;
                        case 2:
                            return com.bytedance.sdk.openadsdk.playable.b.TYPE_4G;
                        case 3:
                            return com.bytedance.sdk.openadsdk.playable.b.TYPE_5G;
                        case 4:
                            return com.bytedance.sdk.openadsdk.playable.b.TYPE_WIFI;
                        default:
                            return com.bytedance.sdk.openadsdk.playable.b.TYPE_UNKNOWN;
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public void a(String str, JSONObject jSONObject) {
                    TTPlayableWebPageActivity.this.m.a(str, jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public void a(JSONObject jSONObject) {
                }

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public void b(JSONObject jSONObject) {
                }

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public void c(JSONObject jSONObject) {
                }
            }).e(com.bytedance.sdk.openadsdk.a.a.a(p.a())).a(com.bytedance.sdk.openadsdk.a.a.a()).b(com.bytedance.sdk.openadsdk.a.a.e()).a("sdkEdition", com.bytedance.sdk.openadsdk.a.a.c()).d(com.bytedance.sdk.openadsdk.a.a.d()).c(false).a(false).b(true);
            if (this.s != null && !TextUtils.isEmpty(this.s.j())) {
                this.D.c(this.s.j());
            }
            Set<String> j = this.D.j();
            final WeakReference weakReference = new WeakReference(this.D);
            for (String str : j) {
                if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str)) {
                    this.m.a().a(str, (com.bytedance.sdk.openadsdk.e.a.e<?, ?>) new com.bytedance.sdk.openadsdk.e.a.e<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.bytedance.sdk.openadsdk.e.a.e
                        public JSONObject a(@NonNull JSONObject jSONObject, @NonNull f fVar) throws Exception {
                            try {
                                e eVar = (e) weakReference.get();
                                if (eVar == null) {
                                    return null;
                                }
                                return eVar.b(a(), jSONObject);
                            } catch (Throwable th) {
                                return null;
                            }
                        }
                    });
                }
            }
        }
    }

    private void a(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.h = intent.getIntExtra(SapiContext.KEY_SDK_VERSION, 1);
            this.k = intent.getStringExtra("adid");
            this.l = intent.getStringExtra("log_extra");
            this.o = intent.getIntExtra("source", -1);
            this.u = intent.getBooleanExtra("ad_pending_download", false);
            this.p = intent.getStringExtra("url");
            this.z = intent.getStringExtra("gecko_id");
            this.q = intent.getStringExtra("web_title");
            this.r = intent.getStringExtra("event_tag");
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra != null) {
                try {
                    this.s = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra));
                } catch (Exception e) {
                    u.c("TTPWPActivity", "TTPlayableWebPageActivity - onCreate MultiGlobalInfo : ", e);
                }
            }
        } else {
            this.s = com.bytedance.sdk.openadsdk.core.u.a().c();
            com.bytedance.sdk.openadsdk.core.u.a().g();
        }
        if (bundle != null) {
            try {
                this.h = bundle.getInt(SapiContext.KEY_SDK_VERSION, 1);
                this.k = bundle.getString("adid");
                this.l = bundle.getString("log_extra");
                this.o = bundle.getInt("source", -1);
                this.u = bundle.getBoolean("ad_pending_download", false);
                this.p = bundle.getString("url");
                this.q = bundle.getString("web_title");
                this.r = bundle.getString("event_tag");
                String string = bundle.getString("material_meta", null);
                if (!TextUtils.isEmpty(string)) {
                    this.s = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(string));
                }
            } catch (Throwable th) {
            }
        }
        if (this.s == null) {
            u.f("TTPWPActivity", "material is null, no data to display");
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("material_meta", this.s != null ? this.s.aE().toString() : null);
            bundle.putInt(SapiContext.KEY_SDK_VERSION, this.h);
            bundle.putString("adid", this.k);
            bundle.putString("log_extra", this.l);
            bundle.putInt("source", this.o);
            bundle.putBoolean("ad_pending_download", this.u);
            bundle.putString("url", this.p);
            bundle.putString("web_title", this.q);
            bundle.putString("event_tag", this.r);
        } catch (Throwable th) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void c() {
        this.j = (PlayableLoadingView) findViewById(ac.e(this, "tt_playable_loading"));
        this.b = (SSWebView) findViewById(ac.e(this, "tt_browser_webview"));
        this.c = (SSWebView) findViewById(ac.e(this, "tt_browser_webview_loading"));
        this.f = (RelativeLayout) findViewById(ac.e(this, "tt_playable_ad_close_layout"));
        if (this.f != null) {
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTPlayableWebPageActivity.this.a("playable_close");
                    TTPlayableWebPageActivity.this.i();
                    TTPlayableWebPageActivity.this.finish();
                }
            });
        }
        this.i = (ProgressBar) findViewById(ac.e(this, "tt_browser_progress"));
    }

    protected void a() {
        if (this.j != null) {
            if (!this.E) {
                this.j.a();
            } else if (this.s == null || !this.s.A() || !this.s.D()) {
                this.j.a();
            } else {
                this.j.b();
                if (this.j.getPlayView() != null) {
                    com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this, this.s, this.r, this.o) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.8
                        @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
                        public void a(View view, int i, int i2, int i3, int i4) {
                            super.a(view, i, i2, i3, i4);
                            if (TTPlayableWebPageActivity.this.s.D()) {
                                HashMap hashMap = new HashMap();
                                if (TTPlayableWebPageActivity.this.s.R() != null) {
                                    hashMap.put("playable_url", TTPlayableWebPageActivity.this.s.R().j());
                                }
                                com.bytedance.sdk.openadsdk.c.d.k(TTPlayableWebPageActivity.this, TTPlayableWebPageActivity.this.s, this.e, "click_playable_download_button_loading", hashMap);
                            }
                        }
                    };
                    this.j.getPlayView().setOnClickListener(aVar);
                    this.j.getPlayView().setOnTouchListener(aVar);
                }
                if (this.s != null && this.s.D() && this.s.B()) {
                    this.t.sendMessageDelayed(a(2), 10000L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.x.getAndSet(true) && this.b != null && this.c != null) {
            ak.a((View) this.b, 0);
            ak.a((View) this.c, 8);
            int i = p.h().r(String.valueOf(aj.d(this.s.aj()))).s;
            if (i >= 0) {
                this.t.sendEmptyMessageDelayed(1, i * 1000);
            } else {
                ak.a((View) this.f, 0);
            }
        }
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.g).a(false).b(false).a(sSWebView);
            sSWebView.getSettings().setUserAgentString(r.a(sSWebView, this.h));
            if (Build.VERSION.SDK_INT >= 21) {
                sSWebView.getSettings().setMixedContentMode(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.bytedance.sdk.openadsdk.c.d.c(this, this.s, this.r, str, (JSONObject) null);
    }

    private boolean e() {
        if (this.c == null) {
            return false;
        }
        String f = f();
        if (TextUtils.isEmpty(f)) {
            return false;
        }
        this.c.setWebViewClient(new c(this.g, this.n, this.k, null) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (TTPlayableWebPageActivity.this.e) {
                    TTPlayableWebPageActivity.this.a("loading_h5_success");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                TTPlayableWebPageActivity.this.e = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTPlayableWebPageActivity.this.e = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                TTPlayableWebPageActivity.this.e = false;
            }
        });
        this.c.loadUrl(f);
        return true;
    }

    private String f() {
        String n = p.h().n();
        if (!TextUtils.isEmpty(n) && this.s != null && this.s.ah() != null) {
            String c = this.s.ah().c();
            int e = this.s.ah().e();
            int f = this.s.ah().f();
            String a2 = this.s.U().a();
            String ag = this.s.ag();
            String d = this.s.ah().d();
            String b = this.s.ah().b();
            String c2 = this.s.ah().c();
            StringBuffer stringBuffer = new StringBuffer(n);
            stringBuffer.append("?appname=").append(c).append("&stars=").append(e).append("&comments=").append(f).append("&icon=").append(a2).append("&downloading=").append(false).append("&id=").append(ag).append("&pkg_name=").append(d).append("&download_url=").append(b).append("&name=").append(c2);
            return stringBuffer.toString();
        }
        return n;
    }

    private void g() {
        if (!this.v && this.u && this.w != null) {
            this.w.g();
        }
    }

    private void h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.s);
        this.m = new x(this);
        this.m.b(this.b).a(this.s).a(arrayList).b(this.k).c(this.l).a(this.o).a(this).a(this.f4134a).a(this.b).d(aj.i(this.s));
        this.n = new x(this);
        this.n.b(this.c).a(this.s).b(this.k).c(this.l).a(this).a(this.o).c(false).a(this.c).d(aj.i(this.s));
        b();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.m != null) {
            this.m.m();
        }
        if (this.n != null) {
            this.n.m();
        }
        if (this.D != null) {
            this.D.q();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.core.u.a().b(true);
        if (this.m != null) {
            this.m.n();
        }
        if (this.n != null) {
            this.n.n();
        }
        if (this.D != null) {
            this.D.p();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        if (this.t != null) {
            this.t.removeCallbacksAndMessages(null);
        }
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable th) {
        }
        if (!TextUtils.isEmpty(this.z)) {
            d.a.a(this.B, this.A, this.s);
        }
        com.bytedance.sdk.openadsdk.gecko.a.a().a(this.C);
        aa.a(this.g, this.b);
        aa.a(this.b);
        this.b = null;
        if (this.m != null) {
            this.m.o();
        }
        if (this.n != null) {
            this.n.o();
        }
        g();
        if (this.D != null) {
            this.D.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        if (message.what == 1) {
            ak.a((View) this.f, 0);
        } else if (message.what == 2 && this.E) {
            HashMap hashMap = new HashMap();
            hashMap.put("remove_loading_page_type", Integer.valueOf(message.arg1));
            if (this.s.R() != null) {
                hashMap.put("playable_url", this.s.R().j());
            }
            com.bytedance.sdk.openadsdk.c.d.k(this, this.s, this.r, "remove_loading_page", hashMap);
            this.t.removeMessages(2);
            if (this.j != null) {
                this.j.a();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.d
    public void a(boolean z) {
        this.u = true;
        this.v = z;
        if (!z) {
            Toast.makeText(this.g, "稍后开始下载", 0).show();
        }
        if (this.v && this.w != null) {
            this.w.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Bitmap b;
        if (this.s != null && this.b != null && this.s.C() && (b = ak.b((WebView) this.b)) != null) {
            ak.a(p.a(), this.s, this.r, "playable_show_status", b, false, 1);
        }
    }
}
