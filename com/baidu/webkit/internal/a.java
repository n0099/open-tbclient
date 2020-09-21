package com.baidu.webkit.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class a implements Runnable {
    final /* synthetic */ long a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j) {
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.setMessageChannalFunctoinTable(this.a);
    }
}
