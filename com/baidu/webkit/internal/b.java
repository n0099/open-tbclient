package com.baidu.webkit.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5642a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5643b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2) {
        this.f5642a = str;
        this.f5643b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.setCrashKeyValue(this.f5642a, this.f5643b);
    }
}
