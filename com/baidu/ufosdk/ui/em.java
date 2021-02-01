package com.baidu.ufosdk.ui;
/* loaded from: classes8.dex */
final class em implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5568a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5569b;
    final /* synthetic */ ej c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.c = ejVar;
        this.f5568a = feedbackInputActivity;
        this.f5569b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f5568a.getApplicationContext(), this.f5568a.f, this.f5569b);
    }
}
