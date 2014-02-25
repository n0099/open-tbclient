package com.baidu.tieba.pb;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class eq implements Runnable {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.a.c);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            this.a.a.loadUrl(guessUrl);
        }
    }
}
