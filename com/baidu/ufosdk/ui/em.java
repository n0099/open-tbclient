package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class em implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23220a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23221b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f23222c;

    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f23222c = ejVar;
        this.f23220a = feedbackInputActivity;
        this.f23221b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f23220a.getApplicationContext(), this.f23220a.f23020f, this.f23221b);
    }
}
