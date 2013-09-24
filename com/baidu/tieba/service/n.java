package com.baidu.tieba.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaPrepareImageService f1797a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TiebaPrepareImageService tiebaPrepareImageService) {
        this.f1797a = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        o oVar;
        if (TiebaPrepareImageService.f1781a) {
            handler = this.f1797a.e;
            runnable = this.f1797a.g;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.f1797a;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.f1797a;
        i = this.f1797a.b;
        uri = this.f1797a.c;
        tiebaPrepareImageService.d = new o(tiebaPrepareImageService2, i, uri);
        oVar = this.f1797a.d;
        oVar.execute(new Object[0]);
    }
}
