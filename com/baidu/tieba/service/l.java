package com.baidu.tieba.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ TiebaPrepareImageService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TiebaPrepareImageService tiebaPrepareImageService) {
        this.a = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        m mVar;
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
        tiebaPrepareImageService.d = new m(tiebaPrepareImageService2, i, uri);
        mVar = this.a.d;
        mVar.execute(new Object[0]);
    }
}
