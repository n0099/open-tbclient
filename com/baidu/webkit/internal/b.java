package com.baidu.webkit.internal;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f27369a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f27370b;

    public b(String str, String str2) {
        this.f27369a = str;
        this.f27370b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.setCrashKeyValue(this.f27369a, this.f27370b);
    }
}
