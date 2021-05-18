package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class ek implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22865a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ej f22866b;

    public ek(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.f22866b = ejVar;
        this.f22865a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22865a.n = false;
    }
}
