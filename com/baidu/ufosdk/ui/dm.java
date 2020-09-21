package com.baidu.ufosdk.ui;
/* loaded from: classes21.dex */
final class dm implements Runnable {
    final /* synthetic */ dl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dl dlVar) {
        this.a = dlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.a(this.a.a.getApplicationContext());
    }
}
