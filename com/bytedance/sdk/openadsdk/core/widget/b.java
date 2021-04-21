package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.ad;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    public SSWebView f28574a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28575b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28576c;

    /* renamed from: d  reason: collision with root package name */
    public String f28577d;

    /* renamed from: e  reason: collision with root package name */
    public a f28578e;

    /* renamed from: f  reason: collision with root package name */
    public String f28579f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(Dialog dialog);
    }

    public b(Context context, String str) {
        super(context, ad.g(context, "tt_dialog_full"));
        this.f28575b = context;
        this.f28579f = str;
    }

    private void b() {
        if (TextUtils.isEmpty(this.f28579f)) {
            this.f28577d = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.d.c b2 = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(this.f28579f));
            if (b2 != null) {
                String d2 = b2.d();
                this.f28577d = d2;
                if (TextUtils.isEmpty(d2)) {
                    this.f28577d = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        a aVar = this.f28578e;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f28575b, "tt_app_privacy_dialog"));
        b();
        a();
    }

    public void a() {
        this.f28574a = (SSWebView) findViewById(ad.e(this.f28575b, "tt_privacy_webview"));
        TextView textView = (TextView) findViewById(ad.e(this.f28575b, "tt_app_privacy_back_tv"));
        this.f28576c = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f28578e != null) {
                    b.this.f28578e.a(b.this);
                }
            }
        });
        this.f28574a.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.f28575b, null, null) { // from class: com.bytedance.sdk.openadsdk.core.widget.b.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView != null) {
                    try {
                        if (TextUtils.isEmpty(str)) {
                            return true;
                        }
                        String scheme = Uri.parse(str).getScheme();
                        if (TextUtils.isEmpty(scheme)) {
                            return true;
                        }
                        String lowerCase = scheme.toLowerCase();
                        if (lowerCase.contains("http") || lowerCase.contains("https")) {
                            webView.loadUrl(str);
                            return true;
                        }
                        return true;
                    } catch (Exception unused) {
                        return true;
                    }
                }
                return true;
            }
        });
        this.f28574a.getSettings().setJavaScriptEnabled(true);
        this.f28574a.getSettings().setDisplayZoomControls(false);
        this.f28574a.getSettings().setCacheMode(2);
        this.f28574a.loadUrl(this.f28577d);
    }

    public b a(a aVar) {
        this.f28578e = aVar;
        return this;
    }
}
