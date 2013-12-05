package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eq extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2263a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(WebActivity webActivity) {
        this.f2263a = webActivity;
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
        if (this.f2263a.f2146a.canGoBack()) {
            imageView5 = this.f2263a.g;
            imageView5.setEnabled(true);
        } else {
            imageView = this.f2263a.g;
            imageView.setEnabled(false);
        }
        if (this.f2263a.f2146a.canGoForward()) {
            imageView4 = this.f2263a.h;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.f2263a.h;
            imageView2.setEnabled(false);
        }
        progressBar = this.f2263a.j;
        progressBar.setVisibility(8);
        imageView3 = this.f2263a.i;
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
        if (this.f2263a.f2146a.canGoBack()) {
            imageView5 = this.f2263a.g;
            imageView5.setEnabled(true);
        } else {
            imageView = this.f2263a.g;
            imageView.setEnabled(false);
        }
        if (this.f2263a.f2146a.canGoForward()) {
            imageView4 = this.f2263a.h;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.f2263a.h;
            imageView2.setEnabled(false);
        }
        progressBar = this.f2263a.j;
        progressBar.setVisibility(0);
        imageView3 = this.f2263a.i;
        imageView3.setVisibility(4);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if ((this.f2263a.f == null || !this.f2263a.f.a(str)) && !com.baidu.tieba.recommend.ab.a(this.f2263a, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }
}
