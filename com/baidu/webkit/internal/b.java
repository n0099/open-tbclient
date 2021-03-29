package com.baidu.webkit.internal;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f26869a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26870b;

    public b(String str, String str2) {
        this.f26869a = str;
        this.f26870b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.setCrashKeyValue(this.f26869a, this.f26870b);
    }
}
