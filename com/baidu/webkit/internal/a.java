package com.baidu.webkit.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f3922a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j) {
        this.f3922a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.setMessageChannalFunctoinTable(this.f3922a);
    }
}
