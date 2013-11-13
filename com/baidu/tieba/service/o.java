package com.baidu.tieba.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaPrepareImageService f2351a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TiebaPrepareImageService tiebaPrepareImageService) {
        this.f2351a = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        p pVar;
        if (TiebaPrepareImageService.f2335a) {
            handler = this.f2351a.e;
            runnable = this.f2351a.h;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.f2351a;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.f2351a;
        i = this.f2351a.b;
        uri = this.f2351a.c;
        tiebaPrepareImageService.d = new p(tiebaPrepareImageService2, i, uri);
        pVar = this.f2351a.d;
        pVar.execute(new Object[0]);
    }
}
