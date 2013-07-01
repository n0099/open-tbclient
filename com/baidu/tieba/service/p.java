package com.baidu.tieba.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaPrepareImageService f1418a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TiebaPrepareImageService tiebaPrepareImageService) {
        this.f1418a = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        q qVar;
        if (TiebaPrepareImageService.f1401a) {
            handler = this.f1418a.e;
            runnable = this.f1418a.g;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.f1418a;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.f1418a;
        i = this.f1418a.b;
        uri = this.f1418a.c;
        tiebaPrepareImageService.d = new q(tiebaPrepareImageService2, i, uri);
        qVar = this.f1418a.d;
        qVar.execute(new Object[0]);
    }
}
