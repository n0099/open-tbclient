package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22794a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ej f22795b;

    public ek(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.f22795b = ejVar;
        this.f22794a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22794a.n = false;
    }
}
