package com.baidu.ufosdk.ui;
/* loaded from: classes8.dex */
final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5850a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5851b;
    final /* synthetic */ ej c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.c = ejVar;
        this.f5850a = feedbackInputActivity;
        this.f5851b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f5850a.getApplicationContext(), this.f5850a.f, this.f5851b);
    }
}
