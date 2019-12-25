package com.baidu.webkit.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class c implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.clearCrashKey(this.a);
    }
}
