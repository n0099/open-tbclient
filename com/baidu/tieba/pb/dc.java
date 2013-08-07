package com.baidu.tieba.pb;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class dc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1521a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(WebActivity webActivity) {
        this.f1521a = webActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.f1521a.c);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            this.f1521a.f1438a.loadUrl(guessUrl);
        }
    }
}
