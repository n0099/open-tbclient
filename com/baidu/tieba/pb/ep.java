package com.baidu.tieba.pb;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class ep implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2155a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ep(WebActivity webActivity) {
        this.f2155a = webActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.f2155a.c);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            this.f2155a.f2039a.loadUrl(guessUrl);
        }
    }
}
