package com.baidu.tieba.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaPrepareImageService f1725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TiebaPrepareImageService tiebaPrepareImageService) {
        this.f1725a = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        q qVar;
        if (TiebaPrepareImageService.f1707a) {
            handler = this.f1725a.e;
            runnable = this.f1725a.g;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.f1725a;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.f1725a;
        i = this.f1725a.b;
        uri = this.f1725a.c;
        tiebaPrepareImageService.d = new q(tiebaPrepareImageService2, i, uri);
        qVar = this.f1725a.d;
        qVar.execute(new Object[0]);
    }
}
