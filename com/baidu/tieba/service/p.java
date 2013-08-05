package com.baidu.tieba.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaPrepareImageService f1710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TiebaPrepareImageService tiebaPrepareImageService) {
        this.f1710a = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        q qVar;
        if (TiebaPrepareImageService.f1692a) {
            handler = this.f1710a.e;
            runnable = this.f1710a.g;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.f1710a;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.f1710a;
        i = this.f1710a.b;
        uri = this.f1710a.c;
        tiebaPrepareImageService.d = new q(tiebaPrepareImageService2, i, uri);
        qVar = this.f1710a.d;
        qVar.execute(new Object[0]);
    }
}
