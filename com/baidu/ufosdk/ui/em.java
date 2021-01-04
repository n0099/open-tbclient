package com.baidu.ufosdk.ui;
/* loaded from: classes8.dex */
final class em implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5848a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5849b;
    final /* synthetic */ ej c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.c = ejVar;
        this.f5848a = feedbackInputActivity;
        this.f5849b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f5848a.getApplicationContext(), this.f5848a.f, this.f5849b);
    }
}
