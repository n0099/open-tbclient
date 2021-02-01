package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackHotActivity f5455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(FeedbackHotActivity feedbackHotActivity) {
        this.f5455a = feedbackHotActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.a(this.f5455a.getApplicationContext());
    }
}
