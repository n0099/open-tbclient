package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class em implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23219a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23220b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f23221c;

    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f23221c = ejVar;
        this.f23219a = feedbackInputActivity;
        this.f23220b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f23219a.getApplicationContext(), this.f23219a.f23019f, this.f23220b);
    }
}
