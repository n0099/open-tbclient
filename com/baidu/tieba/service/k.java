package com.baidu.tieba.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ TiebaPrepareImageService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TiebaPrepareImageService tiebaPrepareImageService) {
        this.a = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        l lVar;
        if (TiebaPrepareImageService.a) {
            handler = this.a.e;
            runnable = this.a.g;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.a;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.a;
        i = this.a.b;
        uri = this.a.c;
        tiebaPrepareImageService.d = new l(tiebaPrepareImageService2, i, uri);
        lVar = this.a.d;
        lVar.execute(new Object[0]);
    }
}
