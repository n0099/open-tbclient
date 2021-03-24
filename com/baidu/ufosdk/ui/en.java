package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23222a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23223b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f23224c;

    public en(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f23224c = ejVar;
        this.f23222a = feedbackInputActivity;
        this.f23223b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f23222a.getApplicationContext(), this.f23222a.f23019f, this.f23223b);
    }
}
