package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3858a;
    final /* synthetic */ ej b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ek(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.b = ejVar;
        this.f3858a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3858a.n = false;
    }
}
