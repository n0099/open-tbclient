package com.baidu.ufosdk.ui;
/* loaded from: classes21.dex */
final class bh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3775a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(FeedbackInputActivity feedbackInputActivity) {
        this.f3775a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FeedbackInputActivity.g(this.f3775a);
    }
}
