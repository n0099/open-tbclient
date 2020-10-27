package com.baidu.ufosdk.ui;
/* loaded from: classes22.dex */
final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3859a;
    final /* synthetic */ String b;
    final /* synthetic */ ej c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.c = ejVar;
        this.f3859a = feedbackInputActivity;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f3859a.getApplicationContext(), this.f3859a.f, this.b);
    }
}
