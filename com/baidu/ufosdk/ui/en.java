package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23627a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23628b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f23629c;

    public en(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f23629c = ejVar;
        this.f23627a = feedbackInputActivity;
        this.f23628b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f23627a.getApplicationContext(), this.f23627a.f23420f, this.f23628b);
    }
}
