package com.baidu.tieba.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ TiebaPrepareImageService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TiebaPrepareImageService tiebaPrepareImageService) {
        this.a = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        o oVar;
        if (TiebaPrepareImageService.a) {
            handler = this.a.e;
            runnable = this.a.h;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.a;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.a;
        i = this.a.b;
        uri = this.a.c;
        tiebaPrepareImageService.d = new o(tiebaPrepareImageService2, i, uri);
        oVar = this.a.d;
        oVar.execute(new Object[0]);
    }
}
