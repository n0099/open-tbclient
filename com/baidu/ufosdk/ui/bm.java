package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class bm implements eu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ er f3686a;
    final /* synthetic */ FeedbackInputActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(FeedbackInputActivity feedbackInputActivity, er erVar) {
        this.b = feedbackInputActivity;
        this.f3686a = erVar;
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a() {
        this.f3686a.dismiss();
        this.b.s.setVisibility(0);
        this.b.s.bringToFront();
        new Thread(new bp(this)).start();
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a(String str) {
        if (str == null || str.trim().length() == 0) {
            this.f3686a.dismiss();
            this.b.D = true;
            this.b.J.setTextColor(com.baidu.ufosdk.b.y);
            this.b.E.setEnabled(false);
            this.b.s.setVisibility(0);
            this.b.s.bringToFront();
            new Thread(new bo(this)).start();
            return;
        }
        this.f3686a.dismiss();
        this.b.D = true;
        this.b.J.setTextColor(com.baidu.ufosdk.b.y);
        this.b.E.setEnabled(false);
        this.b.s.setVisibility(0);
        this.b.s.bringToFront();
        new Thread(new bn(this, str)).start();
    }
}
