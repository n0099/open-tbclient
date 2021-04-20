package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22901a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ej f22902b;

    public ek(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.f22902b = ejVar;
        this.f22901a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22901a.n = false;
    }
}
