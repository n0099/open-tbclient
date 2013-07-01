package com.baidu.tieba.pb;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class cz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1269a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(WebActivity webActivity) {
        this.f1269a = webActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.f1269a.c);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            this.f1269a.f1190a.loadUrl(guessUrl);
        }
    }
}
