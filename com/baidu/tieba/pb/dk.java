package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.frs.FrsActivity;
import java.net.URI;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk extends WebViewClient {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        WebView webView2;
        ImageView imageView;
        WebView webView3;
        ImageView imageView2;
        ProgressBar progressBar;
        Button button;
        ImageView imageView3;
        ImageView imageView4;
        super.onPageFinished(webView, str);
        webView2 = this.a.b;
        if (webView2.canGoBack()) {
            imageView4 = this.a.c;
            imageView4.setEnabled(true);
        } else {
            imageView = this.a.c;
            imageView.setEnabled(false);
        }
        webView3 = this.a.b;
        if (webView3.canGoForward()) {
            imageView3 = this.a.d;
            imageView3.setEnabled(true);
        } else {
            imageView2 = this.a.d;
            imageView2.setEnabled(false);
        }
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        button = this.a.e;
        button.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        WebView webView2;
        ImageView imageView;
        WebView webView3;
        ImageView imageView2;
        ProgressBar progressBar;
        Button button;
        ImageView imageView3;
        ImageView imageView4;
        super.onPageStarted(webView, str, bitmap);
        webView2 = this.a.b;
        if (webView2.canGoBack()) {
            imageView4 = this.a.c;
            imageView4.setEnabled(true);
        } else {
            imageView = this.a.c;
            imageView.setEnabled(false);
        }
        webView3 = this.a.b;
        if (webView3.canGoForward()) {
            imageView3 = this.a.d;
            imageView3.setEnabled(true);
        } else {
            imageView2 = this.a.d;
            imageView2.setEnabled(false);
        }
        progressBar = this.a.g;
        progressBar.setVisibility(0);
        button = this.a.e;
        button.setVisibility(8);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005c -> B:9:0x0020). Please submit an issue!!! */
    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str != null && str.contains("jump_tieba_native=1")) {
            try {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "utf-8")) {
                    if (nameValuePair.getName().equalsIgnoreCase("kz")) {
                        PbActivity.a(this.a, nameValuePair.getValue(), (String) null);
                        return true;
                    } else if (nameValuePair.getName().equalsIgnoreCase("kw")) {
                        FrsActivity.a(this.a, nameValuePair.getValue(), (String) null);
                        return true;
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "shouldOverrideUrlLoading", e.getMessage());
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
