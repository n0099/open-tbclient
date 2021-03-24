package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23215a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ej f23216b;

    public ek(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.f23216b = ejVar;
        this.f23215a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23215a.n = false;
    }
}
