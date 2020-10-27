package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class el implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3857a;
    final /* synthetic */ ej b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.b = ejVar;
        this.f3857a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3857a.getApplicationContext();
        com.baidu.ufosdk.e.a.a(this.f3857a.f, 9);
    }
}
