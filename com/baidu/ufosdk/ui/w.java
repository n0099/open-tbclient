package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes7.dex */
final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f5615a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FeedbackEditActivity feedbackEditActivity) {
        this.f5615a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Handler handler;
        i = this.f5615a.Y;
        handler = this.f5615a.af;
        com.baidu.ufosdk.e.a.a(0, i, handler);
    }
}
