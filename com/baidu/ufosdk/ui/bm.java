package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class bm implements eu {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ er f23089a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23090b;

    public bm(FeedbackInputActivity feedbackInputActivity, er erVar) {
        this.f23090b = feedbackInputActivity;
        this.f23089a = erVar;
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a() {
        this.f23089a.dismiss();
        this.f23090b.s.setVisibility(0);
        this.f23090b.s.bringToFront();
        new Thread(new bp(this)).start();
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a(String str) {
        if (str == null || str.trim().length() == 0) {
            this.f23089a.dismiss();
            FeedbackInputActivity feedbackInputActivity = this.f23090b;
            feedbackInputActivity.D = true;
            feedbackInputActivity.J.setTextColor(com.baidu.ufosdk.b.y);
            this.f23090b.E.setEnabled(false);
            this.f23090b.s.setVisibility(0);
            this.f23090b.s.bringToFront();
            new Thread(new bo(this)).start();
            return;
        }
        this.f23089a.dismiss();
        FeedbackInputActivity feedbackInputActivity2 = this.f23090b;
        feedbackInputActivity2.D = true;
        feedbackInputActivity2.J.setTextColor(com.baidu.ufosdk.b.y);
        this.f23090b.E.setEnabled(false);
        this.f23090b.s.setVisibility(0);
        this.f23090b.s.bringToFront();
        new Thread(new bn(this, str)).start();
    }
}
