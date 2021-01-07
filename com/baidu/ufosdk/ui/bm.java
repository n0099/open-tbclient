package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class bm implements eu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ er f5747a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5748b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(FeedbackInputActivity feedbackInputActivity, er erVar) {
        this.f5748b = feedbackInputActivity;
        this.f5747a = erVar;
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a() {
        this.f5747a.dismiss();
        this.f5748b.s.setVisibility(0);
        this.f5748b.s.bringToFront();
        new Thread(new bp(this)).start();
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a(String str) {
        if (str == null || str.trim().length() == 0) {
            this.f5747a.dismiss();
            this.f5748b.D = true;
            this.f5748b.J.setTextColor(com.baidu.ufosdk.b.y);
            this.f5748b.E.setEnabled(false);
            this.f5748b.s.setVisibility(0);
            this.f5748b.s.bringToFront();
            new Thread(new bo(this)).start();
            return;
        }
        this.f5747a.dismiss();
        this.f5748b.D = true;
        this.f5748b.J.setTextColor(com.baidu.ufosdk.b.y);
        this.f5748b.E.setEnabled(false);
        this.f5748b.s.setVisibility(0);
        this.f5748b.s.bringToFront();
        new Thread(new bn(this, str)).start();
    }
}
