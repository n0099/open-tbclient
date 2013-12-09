package com.baidu.tieba.pb;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class ep implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2263a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ep(WebActivity webActivity) {
        this.f2263a = webActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.f2263a.c);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            this.f2263a.f2147a.loadUrl(guessUrl);
        }
    }
}
