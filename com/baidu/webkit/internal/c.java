package com.baidu.webkit.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3938a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.f3938a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.clearCrashKey(this.f3938a);
    }
}
