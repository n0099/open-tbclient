package com.baidu.tieba.pb;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class dr implements Runnable {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.a.e);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            this.a.c.loadUrl(guessUrl);
        }
    }
}
