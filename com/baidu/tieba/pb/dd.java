package com.baidu.tieba.pb;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class dd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1559a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(WebActivity webActivity) {
        this.f1559a = webActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.f1559a.c);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            this.f1559a.f1475a.loadUrl(guessUrl);
        }
    }
}
