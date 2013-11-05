package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.pb.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(WebActivity webActivity) {
        this.f2128a = webActivity;
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
        if (this.f2128a.f2035a.canGoBack()) {
            imageView5 = this.f2128a.g;
            imageView5.setEnabled(true);
        } else {
            imageView = this.f2128a.g;
            imageView.setEnabled(false);
        }
        if (this.f2128a.f2035a.canGoForward()) {
            imageView4 = this.f2128a.j;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.f2128a.j;
            imageView2.setEnabled(false);
        }
        progressBar = this.f2128a.l;
        progressBar.setVisibility(8);
        imageView3 = this.f2128a.k;
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
        if (this.f2128a.f2035a.canGoBack()) {
            imageView5 = this.f2128a.g;
            imageView5.setEnabled(true);
        } else {
            imageView = this.f2128a.g;
            imageView.setEnabled(false);
        }
        if (this.f2128a.f2035a.canGoForward()) {
            imageView4 = this.f2128a.j;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.f2128a.j;
            imageView2.setEnabled(false);
        }
        progressBar = this.f2128a.l;
        progressBar.setVisibility(0);
        imageView3 = this.f2128a.k;
        imageView3.setVisibility(4);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if ((this.f2128a.f == null || !this.f2128a.f.a(str)) && !com.baidu.tieba.recommend.ae.a(this.f2128a, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }
}
