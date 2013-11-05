package com.baidu.tieba.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaPrepareImageService f2318a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TiebaPrepareImageService tiebaPrepareImageService) {
        this.f2318a = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        p pVar;
        if (TiebaPrepareImageService.f2302a) {
            handler = this.f2318a.e;
            runnable = this.f2318a.h;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.f2318a;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.f2318a;
        i = this.f2318a.b;
        uri = this.f2318a.c;
        tiebaPrepareImageService.d = new p(tiebaPrepareImageService2, i, uri);
        pVar = this.f2318a.d;
        pVar.execute(new Object[0]);
    }
}
