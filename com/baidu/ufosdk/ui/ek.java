package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5844a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ej f5845b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ek(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.f5845b = ejVar;
        this.f5844a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5844a.n = false;
    }
}
