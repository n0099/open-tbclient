package com.baidu.webkit.internal;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f26868a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26869b;

    public b(String str, String str2) {
        this.f26868a = str;
        this.f26869b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.setCrashKeyValue(this.f26868a, this.f26869b);
    }
}
