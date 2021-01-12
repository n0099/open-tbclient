package com.baidu.webkit.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5640a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5641b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2) {
        this.f5640a = str;
        this.f5641b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.setCrashKeyValue(this.f5640a, this.f5641b);
    }
}
