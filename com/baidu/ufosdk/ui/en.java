package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class en implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22908a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22909b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22910c;

    public en(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22910c = ejVar;
        this.f22908a = feedbackInputActivity;
        this.f22909b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f22908a.getApplicationContext(), this.f22908a.f22705f, this.f22909b);
    }
}
