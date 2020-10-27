package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes22.dex */
final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3880a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FeedbackEditActivity feedbackEditActivity) {
        this.f3880a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Handler handler;
        i = this.f3880a.W;
        handler = this.f3880a.af;
        com.baidu.ufosdk.e.a.a(i, -1, handler);
    }
}
