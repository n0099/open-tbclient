package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class em implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22913a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22914b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22915c;

    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22915c = ejVar;
        this.f22913a = feedbackInputActivity;
        this.f22914b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f22913a.getApplicationContext(), this.f22913a.f22713f, this.f22914b);
    }
}
