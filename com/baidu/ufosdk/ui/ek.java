package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3861a;
    final /* synthetic */ ej b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ek(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.b = ejVar;
        this.f3861a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3861a.n = false;
    }
}
