package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22872a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22873b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22874c;

    public en(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22874c = ejVar;
        this.f22872a = feedbackInputActivity;
        this.f22873b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f22872a.getApplicationContext(), this.f22872a.f22665f, this.f22873b);
    }
}
