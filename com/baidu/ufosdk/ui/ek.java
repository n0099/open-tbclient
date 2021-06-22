package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22979a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ej f22980b;

    public ek(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.f22980b = ejVar;
        this.f22979a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22979a.n = false;
    }
}
