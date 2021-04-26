package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23707a;

    public w(FeedbackEditActivity feedbackEditActivity) {
        this.f23707a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        Handler handler;
        i2 = this.f23707a.Y;
        handler = this.f23707a.af;
        com.baidu.ufosdk.e.a.a(0, i2, handler);
    }
}
