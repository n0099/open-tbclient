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
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.sapi2.SapiContext;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.a.d;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.b;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.preload.falconx.a.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TTPlayableWebPageActivity extends Activity implements d, am.a {
    private a C;

    /* renamed from: b  reason: collision with root package name */
    private SSWebView f6452b;
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
    private am t = new am(Looper.getMainLooper(), this);
    private AtomicBoolean x = new AtomicBoolean(false);
    private int A = 0;
    private int B = 0;
    private boolean D = false;

    /* renamed from: a  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.g.d f6451a = new com.bytedance.sdk.openadsdk.g.d() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.1
        @Override // com.bytedance.sdk.openadsdk.g.d
        public void a() {
            if (!TTPlayableWebPageActivity.this.isFinishing()) {
                if ((TTPlayableWebPageActivity.this.s == null || TTPlayableWebPageActivity.this.s.q()) && TTPlayableWebPageActivity.this.s != null && TTPlayableWebPageActivity.this.s.r()) {
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
            this.y = this.s.X();
            setContentView(ac.f(this, "tt_activity_ttlandingpage_playable"));
            b();
            a();
            g();
            if (this.f6452b != null) {
                this.f6452b.setWebViewClient(new c(this.g, this.m, this.k, null) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.2
                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        try {
                            if (TTPlayableWebPageActivity.this.D && TTPlayableWebPageActivity.this.s.t() && !TTPlayableWebPageActivity.this.isFinishing() && TTPlayableWebPageActivity.this.s.q() && !TTPlayableWebPageActivity.this.s.r()) {
                                TTPlayableWebPageActivity.this.t.sendMessageDelayed(TTPlayableWebPageActivity.this.a(0), 1000L);
                            }
                        } catch (Throwable th2) {
                        }
                        try {
                            if (TTPlayableWebPageActivity.this.i != null && !TTPlayableWebPageActivity.this.isFinishing()) {
                                TTPlayableWebPageActivity.this.i.setVisibility(8);
                            }
                            if (TTPlayableWebPageActivity.this.d) {
                                TTPlayableWebPageActivity.this.c();
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
                                a2 = com.bytedance.sdk.openadsdk.preload.geckox.c.a().a(TTPlayableWebPageActivity.this.C, TTPlayableWebPageActivity.this.z, str);
                                if (a2 != null) {
                                    TTPlayableWebPageActivity.k(TTPlayableWebPageActivity.this);
                                    Log.d("TTPlayableWebPageActivity", "GeckoLog: hit++");
                                } else {
                                    a2 = super.shouldInterceptRequest(webView, str);
                                }
                            }
                            return a2;
                        } catch (Throwable th2) {
                            Log.e("TTPlayableWebPageActivity", "shouldInterceptRequest url error", th2);
                            return super.shouldInterceptRequest(webView, str);
                        }
                    }
                });
                a(this.f6452b);
                a(this.c);
                d();
                this.f6452b.loadUrl(this.p);
                this.f6452b.setWebChromeClient(new b(this.m, null) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.3
                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
                    public void onProgressChanged(WebView webView, int i) {
                        super.onProgressChanged(webView, i);
                        try {
                            if (TTPlayableWebPageActivity.this.D && TTPlayableWebPageActivity.this.s.t() && TTPlayableWebPageActivity.this.s.q() && !TTPlayableWebPageActivity.this.isFinishing() && TTPlayableWebPageActivity.this.j != null) {
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
                            TTPlayableWebPageActivity.this.c();
                        }
                    }
                });
            }
            if (this.s.H() == 4) {
                this.w = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.g, this.s, this.r);
                if (this.w != null && (this.w instanceof com.bytedance.sdk.openadsdk.downloadnew.a.b)) {
                    ((com.bytedance.sdk.openadsdk.downloadnew.a.b) this.w).d(true);
                }
            }
            this.C = com.bytedance.sdk.openadsdk.preload.geckox.c.a().b();
            com.bytedance.sdk.openadsdk.c.d.a(this.s, this);
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
                    u.c("TTPlayableWebPageActivity", "TTPlayableWebPageActivity - onCreate MultiGlobalInfo : ", e);
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
            u.f("TTPlayableWebPageActivity", "material is null, no data to display");
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("material_meta", this.s != null ? this.s.am().toString() : null);
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

    private void b() {
        this.j = (PlayableLoadingView) findViewById(ac.e(this, "tt_playable_loading"));
        this.f6452b = (SSWebView) findViewById(ac.e(this, "tt_browser_webview"));
        this.c = (SSWebView) findViewById(ac.e(this, "tt_browser_webview_loading"));
        this.f = (RelativeLayout) findViewById(ac.e(this, "tt_playable_ad_close_layout"));
        if (this.f != null) {
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTPlayableWebPageActivity.this.a("playable_close");
                    TTPlayableWebPageActivity.this.h();
                    TTPlayableWebPageActivity.this.finish();
                }
            });
        }
        this.i = (ProgressBar) findViewById(ac.e(this, "tt_browser_progress"));
    }

    protected void a() {
        if (this.j != null) {
            if (!this.D) {
                this.j.a();
            } else if (this.s == null || !this.s.q() || !this.s.t()) {
                this.j.a();
            } else {
                this.j.b();
                if (this.j.getPlayView() != null) {
                    com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this, this.s, this.r, this.o) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.5
                        @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
                        public void a(View view, int i, int i2, int i3, int i4) {
                            super.a(view, i, i2, i3, i4);
                            if (TTPlayableWebPageActivity.this.s.t()) {
                                HashMap hashMap = new HashMap();
                                if (TTPlayableWebPageActivity.this.s.F() != null) {
                                    hashMap.put("playable_url", TTPlayableWebPageActivity.this.s.F().i());
                                }
                                com.bytedance.sdk.openadsdk.c.d.k(TTPlayableWebPageActivity.this, TTPlayableWebPageActivity.this.s, this.e, "click_playable_download_button_loading", hashMap);
                            }
                        }
                    };
                    this.j.getPlayView().setOnClickListener(aVar);
                    this.j.getPlayView().setOnTouchListener(aVar);
                }
                if (this.s != null && this.s.t() && this.s.r()) {
                    this.t.sendMessageDelayed(a(2), 10000L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!this.x.getAndSet(true) && this.f6452b != null && this.c != null) {
            ak.a((View) this.f6452b, 0);
            ak.a((View) this.c, 8);
            int i = p.h().r(String.valueOf(aj.d(this.s.W()))).s;
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

    private boolean d() {
        if (this.c == null) {
            return false;
        }
        String e = e();
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        this.c.setWebViewClient(new c(this.g, this.n, this.k, null) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.6
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
        this.c.loadUrl(e);
        return true;
    }

    private String e() {
        String o = p.h().o();
        if (!TextUtils.isEmpty(o) && this.s != null && this.s.U() != null) {
            String c = this.s.U().c();
            int e = this.s.U().e();
            int f = this.s.U().f();
            String a2 = this.s.I().a();
            String T = this.s.T();
            String d = this.s.U().d();
            String b2 = this.s.U().b();
            String c2 = this.s.U().c();
            StringBuffer stringBuffer = new StringBuffer(o);
            stringBuffer.append("?appname=").append(c).append("&stars=").append(e).append("&comments=").append(f).append("&icon=").append(a2).append("&downloading=").append(false).append("&id=").append(T).append("&pkg_name=").append(d).append("&download_url=").append(b2).append("&name=").append(c2);
            return stringBuffer.toString();
        }
        return o;
    }

    private void f() {
        if (!this.v && this.u && this.w != null) {
            this.w.g();
        }
    }

    private void g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.s);
        this.m = new x(this);
        this.m.b(this.f6452b).a(this.s).a(arrayList).a(this.k).b(this.l).a(this.o).a(this).a(this.f6451a).a(this.f6452b).c(aj.h(this.s));
        this.n = new x(this);
        this.n.b(this.c).a(this.s).a(this.k).b(this.l).a(this).a(this.o).c(false).a(this.c).c(aj.h(this.s));
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.m != null) {
            this.m.g();
        }
        if (this.n != null) {
            this.n.g();
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
            this.m.h();
        }
        if (this.n != null) {
            this.n.h();
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
        com.bytedance.sdk.openadsdk.preload.geckox.c.a().a(this.C);
        aa.a(this.g, this.f6452b);
        aa.a(this.f6452b);
        this.f6452b = null;
        if (this.m != null) {
            this.m.i();
        }
        if (this.n != null) {
            this.n.i();
        }
        f();
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (message.what == 1) {
            ak.a((View) this.f, 0);
        } else if (message.what == 2 && this.D) {
            HashMap hashMap = new HashMap();
            hashMap.put("remove_loading_page_type", Integer.valueOf(message.arg1));
            if (this.s.F() != null) {
                hashMap.put("playable_url", this.s.F().i());
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
            try {
                Toast.makeText(this.g, "稍后开始下载", 0).show();
            } catch (Exception e) {
            }
        }
        if (this.v && this.w != null) {
            this.w.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Bitmap b2;
        if (this.s != null && this.f6452b != null && this.s.s() && (b2 = ak.b((WebView) this.f6452b)) != null) {
            ak.a(p.a(), this.s, this.r, "playable_show_status", b2, false, 1);
        }
    }
}
