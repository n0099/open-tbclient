package com.baidu.webkit.internal;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f26910a;

    public c(String str) {
        this.f26910a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.clearCrashKey(this.f26910a);
    }
}
