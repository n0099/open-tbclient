package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23223a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23224b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f23225c;

    public en(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f23225c = ejVar;
        this.f23223a = feedbackInputActivity;
        this.f23224b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f23223a.getApplicationContext(), this.f23223a.f23020f, this.f23224b);
    }
}
