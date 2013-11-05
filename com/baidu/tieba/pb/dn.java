package com.baidu.tieba.pb;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class dn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2127a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(WebActivity webActivity) {
        this.f2127a = webActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.f2127a.c);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            this.f2127a.f2035a.loadUrl(guessUrl);
        }
    }
}
