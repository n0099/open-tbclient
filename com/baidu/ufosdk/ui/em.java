package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class em implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23624a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23625b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f23626c;

    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f23626c = ejVar;
        this.f23624a = feedbackInputActivity;
        this.f23625b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f23624a.getApplicationContext(), this.f23624a.f23420f, this.f23625b);
    }
}
