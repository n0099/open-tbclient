package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class el implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5566a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ej f5567b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.f5567b = ejVar;
        this.f5566a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5566a.getApplicationContext();
        com.baidu.ufosdk.e.a.a(this.f5566a.f, 9);
    }
}
