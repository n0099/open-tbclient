package com.baidu.ufosdk.ui;
/* loaded from: classes21.dex */
final class aj implements Runnable {
    final /* synthetic */ ai a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.a = aiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.a(this.a.a.getApplicationContext());
    }
}
