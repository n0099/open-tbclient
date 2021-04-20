package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class em implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22905a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22906b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22907c;

    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22907c = ejVar;
        this.f22905a = feedbackInputActivity;
        this.f22906b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.c(this.f22905a.getApplicationContext(), this.f22905a.f22705f, this.f22906b);
    }
}
