package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3685a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(FeedbackInputActivity feedbackInputActivity) {
        this.f3685a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FeedbackInputActivity.j(this.f3685a);
    }
}
