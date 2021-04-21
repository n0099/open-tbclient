package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22909a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ej f22910b;

    public ek(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.f22910b = ejVar;
        this.f22909a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22909a.n = false;
    }
}
