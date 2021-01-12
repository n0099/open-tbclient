package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5463a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(FeedbackInputActivity feedbackInputActivity) {
        this.f5463a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FeedbackInputActivity.j(this.f5463a);
    }
}
