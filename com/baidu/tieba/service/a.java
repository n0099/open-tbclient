package com.baidu.tieba.service;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AsInstallService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AsInstallService asInstallService) {
        this.a = asInstallService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.stopSelf();
    }
}
