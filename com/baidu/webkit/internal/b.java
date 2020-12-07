package com.baidu.webkit.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3923a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2) {
        this.f3923a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.setCrashKeyValue(this.f3923a, this.b);
    }
}
