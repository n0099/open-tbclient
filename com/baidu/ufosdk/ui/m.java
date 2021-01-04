package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes8.dex */
final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f5885a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FeedbackEditActivity feedbackEditActivity) {
        this.f5885a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Handler handler;
        i = this.f5885a.W;
        handler = this.f5885a.af;
        com.baidu.ufosdk.e.a.a(i, -1, handler);
    }
}
