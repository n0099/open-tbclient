package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3782a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(FeedbackInputActivity feedbackInputActivity) {
        this.f3782a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FeedbackInputActivity.j(this.f3782a);
    }
}
