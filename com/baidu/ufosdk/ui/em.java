package com.baidu.ufosdk.ui;
/* loaded from: classes22.dex */
final class em implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3858a;
    final /* synthetic */ String b;
    final /* synthetic */ ej c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.c = ejVar;
        this.f3858a = feedbackInputActivity;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f3858a.getApplicationContext(), this.f3858a.f, this.b);
    }
}
