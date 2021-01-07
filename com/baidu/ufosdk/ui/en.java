package com.baidu.ufosdk.ui;
/* loaded from: classes8.dex */
final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5851a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5852b;
    final /* synthetic */ ej c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.c = ejVar;
        this.f5851a = feedbackInputActivity;
        this.f5852b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f5851a.getApplicationContext(), this.f5851a.f, this.f5852b);
    }
}
