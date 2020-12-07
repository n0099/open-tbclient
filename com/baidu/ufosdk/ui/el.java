package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class el implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3862a;
    final /* synthetic */ ej b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.b = ejVar;
        this.f3862a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3862a.getApplicationContext();
        com.baidu.ufosdk.e.a.a(this.f3862a.f, 9);
    }
}
