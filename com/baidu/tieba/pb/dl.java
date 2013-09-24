package com.baidu.tieba.pb;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class dl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1609a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(WebActivity webActivity) {
        this.f1609a = webActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.f1609a.c);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            this.f1609a.f1518a.loadUrl(guessUrl);
        }
    }
}
