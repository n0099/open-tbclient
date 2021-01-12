package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5562a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ej f5563b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ek(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.f5563b = ejVar;
        this.f5562a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5562a.n = false;
    }
}
