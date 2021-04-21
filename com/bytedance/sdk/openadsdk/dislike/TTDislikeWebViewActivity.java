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
    public View f28816a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28817b;

    /* renamed from: c  reason: collision with root package name */
    public SSWebView f28818c;

    /* renamed from: d  reason: collision with root package name */
    public l f28819d;

    /* renamed from: e  reason: collision with root package name */
    public String f28820e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28821f = false;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this, "tt_activity_lite_web_layout"));
        this.f28816a = findViewById(ad.e(this, "tt_lite_web_back"));
        this.f28817b = (TextView) findViewById(ad.e(this, "tt_lite_web_title"));
        this.f28818c = (SSWebView) findViewById(ad.e(this, "tt_lite_web_view"));
        this.f28816a.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeWebViewActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTDislikeWebViewActivity.this.onBackPressed();
            }
        });
        if (getIntent() != null) {
            a();
            this.f28817b.setText(getIntent().getStringExtra("title"));
            this.f28818c.loadUrl(getIntent().getStringExtra("url"));
            this.f28820e = getIntent().getStringExtra("tag");
            try {
                String stringExtra = getIntent().getStringExtra("meta");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                this.f28819d = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra));
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        finish();
    }

    private void a() {
        this.f28818c.getSettings().setJavaScriptEnabled(true);
        this.f28818c.getSettings().setDisplayZoomControls(false);
        this.f28818c.getSettings().setCacheMode(2);
        this.f28818c.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this, null, null) { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeWebViewActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (TTDislikeWebViewActivity.this.f28819d == null || TTDislikeWebViewActivity.this.f28821f) {
                    return;
                }
                TTDislikeWebViewActivity tTDislikeWebViewActivity = TTDislikeWebViewActivity.this;
                com.bytedance.sdk.openadsdk.c.d.b(tTDislikeWebViewActivity, tTDislikeWebViewActivity.f28819d, TTDislikeWebViewActivity.this.f28820e, "ad_explation_url_show");
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTDislikeWebViewActivity.this.f28821f = true;
            }
        });
    }
}
