package com.baidu.ufosdk.ui;
/* loaded from: classes21.dex */
final class dg implements Runnable {
    final /* synthetic */ df a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(df dfVar) {
        this.a = dfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.e(this.a.a, this.a.b, this.a.c);
    }
}
