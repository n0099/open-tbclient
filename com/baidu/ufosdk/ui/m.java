package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23694a;

    public m(FeedbackEditActivity feedbackEditActivity) {
        this.f23694a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        Handler handler;
        i2 = this.f23694a.W;
        handler = this.f23694a.af;
        com.baidu.ufosdk.e.a.a(i2, -1, handler);
    }
}
