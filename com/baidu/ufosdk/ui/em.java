package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class em implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22983a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22984b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22985c;

    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22985c = ejVar;
        this.f22983a = feedbackInputActivity;
        this.f22984b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f22983a.getApplicationContext(), this.f22983a.f22779f, this.f22984b);
    }
}
