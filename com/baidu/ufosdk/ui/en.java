package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22916a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22917b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22918c;

    public en(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22918c = ejVar;
        this.f22916a = feedbackInputActivity;
        this.f22917b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f22916a.getApplicationContext(), this.f22916a.f22713f, this.f22917b);
    }
}
