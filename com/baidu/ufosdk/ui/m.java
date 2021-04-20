package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22973a;

    public m(FeedbackEditActivity feedbackEditActivity) {
        this.f22973a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Handler handler;
        i = this.f22973a.W;
        handler = this.f22973a.af;
        com.baidu.ufosdk.e.a.a(i, -1, handler);
    }
}
