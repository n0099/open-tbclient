package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackHotActivity f3769a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(FeedbackHotActivity feedbackHotActivity) {
        this.f3769a = feedbackHotActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.a(this.f3769a.getApplicationContext());
    }
}
