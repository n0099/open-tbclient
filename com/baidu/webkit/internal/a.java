package com.baidu.webkit.internal;
/* loaded from: classes5.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f26561a;

    public a(long j) {
        this.f26561a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ApisInteractWithMario.setMessageChannalFunctoinTable(this.f26561a);
    }
}
