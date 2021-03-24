package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23300a;

    public w(FeedbackEditActivity feedbackEditActivity) {
        this.f23300a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Handler handler;
        i = this.f23300a.Y;
        handler = this.f23300a.af;
        com.baidu.ufosdk.e.a.a(0, i, handler);
    }
}
