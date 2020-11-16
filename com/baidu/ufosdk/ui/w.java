package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes21.dex */
final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3892a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FeedbackEditActivity feedbackEditActivity) {
        this.f3892a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Handler handler;
        i = this.f3892a.Y;
        handler = this.f3892a.af;
        com.baidu.ufosdk.e.a.a(0, i, handler);
    }
}
