package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.ad;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TTDislikeWebViewActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public View f28808a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28809b;

    /* renamed from: c  reason: collision with root package name */
    public SSWebView f28810c;

    /* renamed from: d  reason: collision with root package name */
    public l f28811d;

    /* renamed from: e  reason: collision with root package name */
    public String f28812e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28813f = false;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this, "tt_activity_lite_web_layout"));
        this.f28808a = findViewById(ad.e(this, "tt_lite_web_back"));
        this.f28809b = (TextView) findViewById(ad.e(this, "tt_lite_web_title"));
        this.f28810c = (SSWebView) findViewById(ad.e(this, "tt_lite_web_view"));
        this.f28808a.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeWebViewActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTDislikeWebViewActivity.this.onBackPressed();
            }
        });
        if (getIntent() != null) {
            a();
            this.f28809b.setText(getIntent().getStringExtra("title"));
            this.f28810c.loadUrl(getIntent().getStringExtra("url"));
            this.f28812e = getIntent().getStringExtra("tag");
            try {
                String stringExtra = getIntent().getStringExtra("meta");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                this.f28811d = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra));
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        finish();
    }

    private void a() {
        this.f28810c.getSettings().setJavaScriptEnabled(true);
        this.f28810c.getSettings().setDisplayZoomControls(false);
        this.f28810c.getSettings().setCacheMode(2);
        this.f28810c.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this, null, null) { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeWebViewActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (TTDislikeWebViewActivity.this.f28811d == null || TTDislikeWebViewActivity.this.f28813f) {
                    return;
                }
                TTDislikeWebViewActivity tTDislikeWebViewActivity = TTDislikeWebViewActivity.this;
                com.bytedance.sdk.openadsdk.c.d.b(tTDislikeWebViewActivity, tTDislikeWebViewActivity.f28811d, TTDislikeWebViewActivity.this.f28812e, "ad_explation_url_show");
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTDislikeWebViewActivity.this.f28813f = true;
            }
        });
    }
}
