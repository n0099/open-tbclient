package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class em implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22869a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22870b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22871c;

    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22871c = ejVar;
        this.f22869a = feedbackInputActivity;
        this.f22870b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f22869a.getApplicationContext(), this.f22869a.f22665f, this.f22870b);
    }
}
