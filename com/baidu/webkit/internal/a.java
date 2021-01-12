package com.baidu.webkit.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f5639a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j) {
        this.f5639a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.setMessageChannalFunctoinTable(this.f5639a);
    }
}
