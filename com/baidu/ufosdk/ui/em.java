package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class em implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22798a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22799b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22800c;

    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22800c = ejVar;
        this.f22798a = feedbackInputActivity;
        this.f22799b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f22798a.getApplicationContext(), this.f22798a.f22594f, this.f22799b);
    }
}
