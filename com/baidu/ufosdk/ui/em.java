package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class em implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22901a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22902b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22903c;

    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22903c = ejVar;
        this.f22901a = feedbackInputActivity;
        this.f22902b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f22901a.getApplicationContext(), this.f22901a.f22697f, this.f22902b);
    }
}
