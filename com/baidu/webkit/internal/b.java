package com.baidu.webkit.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.setCrashKeyValue(this.a, this.b);
    }
}
