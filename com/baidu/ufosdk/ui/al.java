package com.baidu.ufosdk.ui;
/* loaded from: classes21.dex */
final class al implements Runnable {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.a = akVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.a(this.a.a.getApplicationContext());
    }
}
