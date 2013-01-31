package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.frs.FrsActivity;
import java.net.URI;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn extends WebViewClient {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        Button button;
        ImageView imageView3;
        ImageView imageView4;
        super.onPageFinished(webView, str);
        if (this.a.c.canGoBack()) {
            imageView4 = this.a.i;
            imageView4.setEnabled(true);
        } else {
            imageView = this.a.i;
            imageView.setEnabled(false);
        }
        if (this.a.c.canGoForward()) {
            imageView3 = this.a.j;
            imageView3.setEnabled(true);
        } else {
            imageView2 = this.a.j;
            imageView2.setEnabled(false);
        }
        progressBar = this.a.l;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        Button button;
        ImageView imageView3;
        ImageView imageView4;
        super.onPageStarted(webView, str, bitmap);
        if (this.a.c.canGoBack()) {
            imageView4 = this.a.i;
            imageView4.setEnabled(true);
        } else {
            imageView = this.a.i;
            imageView.setEnabled(false);
        }
        if (this.a.c.canGoForward()) {
            imageView3 = this.a.j;
            imageView3.setEnabled(true);
        } else {
            imageView2 = this.a.j;
            imageView2.setEnabled(false);
        }
        progressBar = this.a.l;
        progressBar.setVisibility(0);
        button = this.a.k;
        button.setVisibility(4);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006e -> B:14:0x0032). Please submit an issue!!! */
    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean shouldOverrideUrlLoading;
        if (this.a.h == null || !this.a.h.a(str)) {
            if (str != null && str.contains("jump_tieba_native=1")) {
                try {
                    for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), BdUtil.UTF8)) {
                        if (nameValuePair.getName().equalsIgnoreCase("kz")) {
                            PbActivity.a(this.a, nameValuePair.getValue(), (String) null);
                            shouldOverrideUrlLoading = true;
                            break;
                        } else if (nameValuePair.getName().equalsIgnoreCase("kw")) {
                            FrsActivity.a(this.a, nameValuePair.getValue(), (String) null);
                            shouldOverrideUrlLoading = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    com.baidu.tieba.c.af.b(getClass().getName(), "shouldOverrideUrlLoading", e.getMessage());
                }
            }
            shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, str);
            return shouldOverrideUrlLoading;
        }
        return true;
    }
}
