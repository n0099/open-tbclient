package com.baidu.tieba.service;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AsInstallService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AsInstallService asInstallService) {
        this.this$0 = asInstallService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.stopSelf();
    }
}
