package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class bj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3777a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(FeedbackInputActivity feedbackInputActivity) {
        this.f3777a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.a(this.f3777a.getApplicationContext());
    }
}
