package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1524a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(WebActivity webActivity) {
        this.f1524a = webActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        super.onPageFinished(webView, str);
        if (this.f1524a.f1440a.canGoBack()) {
            imageView5 = this.f1524a.g;
            imageView5.setEnabled(true);
        } else {
            imageView = this.f1524a.g;
            imageView.setEnabled(false);
        }
        if (this.f1524a.f1440a.canGoForward()) {
            imageView4 = this.f1524a.j;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.f1524a.j;
            imageView2.setEnabled(false);
        }
        progressBar = this.f1524a.l;
        progressBar.setVisibility(8);
        imageView3 = this.f1524a.k;
        imageView3.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        super.onPageStarted(webView, str, bitmap);
        if (this.f1524a.f1440a.canGoBack()) {
            imageView5 = this.f1524a.g;
            imageView5.setEnabled(true);
        } else {
            imageView = this.f1524a.g;
            imageView.setEnabled(false);
        }
        if (this.f1524a.f1440a.canGoForward()) {
            imageView4 = this.f1524a.j;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.f1524a.j;
            imageView2.setEnabled(false);
        }
        progressBar = this.f1524a.l;
        progressBar.setVisibility(0);
        imageView3 = this.f1524a.k;
        imageView3.setVisibility(4);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if ((this.f1524a.f == null || !this.f1524a.f.a(str)) && !com.baidu.tieba.recommend.bf.a(this.f1524a, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }
}
