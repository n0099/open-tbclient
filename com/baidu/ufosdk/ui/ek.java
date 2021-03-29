package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23216a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ej f23217b;

    public ek(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.f23217b = ejVar;
        this.f23216a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23216a.n = false;
    }
}
