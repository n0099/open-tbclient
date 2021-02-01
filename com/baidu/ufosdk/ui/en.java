package com.baidu.ufosdk.ui;
/* loaded from: classes8.dex */
final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5570a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5571b;
    final /* synthetic */ ej c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.c = ejVar;
        this.f5570a = feedbackInputActivity;
        this.f5571b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f5570a.getApplicationContext(), this.f5570a.f, this.f5571b);
    }
}
