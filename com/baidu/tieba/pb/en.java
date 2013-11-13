package com.baidu.tieba.pb;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2170a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(WebActivity webActivity) {
        this.f2170a = webActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.f2170a.c);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            this.f2170a.f2056a.loadUrl(guessUrl);
        }
    }
}
