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
/* loaded from: classes6.dex */
public class b extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    public SSWebView f28625a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28626b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28627c;

    /* renamed from: d  reason: collision with root package name */
    public String f28628d;

    /* renamed from: e  reason: collision with root package name */
    public a f28629e;

    /* renamed from: f  reason: collision with root package name */
    public String f28630f;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Dialog dialog);
    }

    public b(Context context, String str) {
        super(context, ad.g(context, "tt_dialog_full"));
        this.f28626b = context;
        this.f28630f = str;
    }

    private void b() {
        if (TextUtils.isEmpty(this.f28630f)) {
            this.f28628d = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.d.c b2 = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(this.f28630f));
            if (b2 != null) {
                String d2 = b2.d();
                this.f28628d = d2;
                if (TextUtils.isEmpty(d2)) {
                    this.f28628d = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        a aVar = this.f28629e;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f28626b, "tt_app_privacy_dialog"));
        b();
        a();
    }

    public void a() {
        this.f28625a = (SSWebView) findViewById(ad.e(this.f28626b, "tt_privacy_webview"));
        TextView textView = (TextView) findViewById(ad.e(this.f28626b, "tt_app_privacy_back_tv"));
        this.f28627c = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f28629e != null) {
                    b.this.f28629e.a(b.this);
                }
            }
        });
        this.f28625a.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.f28626b, null, null) { // from class: com.bytedance.sdk.openadsdk.core.widget.b.2
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
        this.f28625a.getSettings().setJavaScriptEnabled(true);
        this.f28625a.getSettings().setDisplayZoomControls(false);
        this.f28625a.getSettings().setCacheMode(2);
        this.f28625a.loadUrl(this.f28628d);
    }

    public b a(a aVar) {
        this.f28629e = aVar;
        return this;
    }
}
