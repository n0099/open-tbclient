package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22904a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22905b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22906c;

    public en(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22906c = ejVar;
        this.f22904a = feedbackInputActivity;
        this.f22905b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f22904a.getApplicationContext(), this.f22904a.f22697f, this.f22905b);
    }
}
