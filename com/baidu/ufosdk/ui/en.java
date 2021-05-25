package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22801a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22802b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22803c;

    public en(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22803c = ejVar;
        this.f22801a = feedbackInputActivity;
        this.f22802b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f22801a.getApplicationContext(), this.f22801a.f22594f, this.f22802b);
    }
}
