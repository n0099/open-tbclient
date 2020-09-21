package com.baidu.ufosdk.ui;
/* loaded from: classes21.dex */
final class em implements Runnable {
    final /* synthetic */ FeedbackInputActivity a;
    final /* synthetic */ String b;
    final /* synthetic */ ej c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.c = ejVar;
        this.a = feedbackInputActivity;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.a.getApplicationContext(), this.a.f, this.b);
    }
}
