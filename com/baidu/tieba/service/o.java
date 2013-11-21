package com.baidu.tieba.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaPrepareImageService f2336a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TiebaPrepareImageService tiebaPrepareImageService) {
        this.f2336a = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        p pVar;
        if (TiebaPrepareImageService.f2320a) {
            handler = this.f2336a.e;
            runnable = this.f2336a.h;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.f2336a;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.f2336a;
        i = this.f2336a.b;
        uri = this.f2336a.c;
        tiebaPrepareImageService.d = new p(tiebaPrepareImageService2, i, uri);
        pVar = this.f2336a.d;
        pVar.execute(new Object[0]);
    }
}
