package com.baidu.tieba.util;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends WebChromeClient {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        ProgressBar progressBar;
        super.onProgressChanged(webView, i);
        if (i == 100) {
            this.a.m = false;
            progressBar = this.a.j;
            progressBar.setVisibility(8);
        }
    }
}
