package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class bm implements eu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ er f5464a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5465b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(FeedbackInputActivity feedbackInputActivity, er erVar) {
        this.f5465b = feedbackInputActivity;
        this.f5464a = erVar;
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a() {
        this.f5464a.dismiss();
        this.f5465b.s.setVisibility(0);
        this.f5465b.s.bringToFront();
        new Thread(new bp(this)).start();
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a(String str) {
        if (str == null || str.trim().length() == 0) {
            this.f5464a.dismiss();
            this.f5465b.D = true;
            this.f5465b.J.setTextColor(com.baidu.ufosdk.b.y);
            this.f5465b.E.setEnabled(false);
            this.f5465b.s.setVisibility(0);
            this.f5465b.s.bringToFront();
            new Thread(new bo(this)).start();
            return;
        }
        this.f5464a.dismiss();
        this.f5465b.D = true;
        this.f5465b.J.setTextColor(com.baidu.ufosdk.b.y);
        this.f5465b.E.setEnabled(false);
        this.f5465b.s.setVisibility(0);
        this.f5465b.s.bringToFront();
        new Thread(new bn(this, str)).start();
    }
}
