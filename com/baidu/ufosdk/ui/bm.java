package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class bm implements eu {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ er f22851a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22852b;

    public bm(FeedbackInputActivity feedbackInputActivity, er erVar) {
        this.f22852b = feedbackInputActivity;
        this.f22851a = erVar;
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a() {
        this.f22851a.dismiss();
        this.f22852b.s.setVisibility(0);
        this.f22852b.s.bringToFront();
        new Thread(new bp(this)).start();
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a(String str) {
        if (str == null || str.trim().length() == 0) {
            this.f22851a.dismiss();
            FeedbackInputActivity feedbackInputActivity = this.f22852b;
            feedbackInputActivity.D = true;
            feedbackInputActivity.J.setTextColor(com.baidu.ufosdk.b.y);
            this.f22852b.E.setEnabled(false);
            this.f22852b.s.setVisibility(0);
            this.f22852b.s.bringToFront();
            new Thread(new bo(this)).start();
            return;
        }
        this.f22851a.dismiss();
        FeedbackInputActivity feedbackInputActivity2 = this.f22852b;
        feedbackInputActivity2.D = true;
        feedbackInputActivity2.J.setTextColor(com.baidu.ufosdk.b.y);
        this.f22852b.E.setEnabled(false);
        this.f22852b.s.setVisibility(0);
        this.f22852b.s.bringToFront();
        new Thread(new bn(this, str)).start();
    }
}
