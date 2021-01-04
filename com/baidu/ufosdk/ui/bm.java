package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class bm implements eu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ er f5746a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5747b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(FeedbackInputActivity feedbackInputActivity, er erVar) {
        this.f5747b = feedbackInputActivity;
        this.f5746a = erVar;
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a() {
        this.f5746a.dismiss();
        this.f5747b.s.setVisibility(0);
        this.f5747b.s.bringToFront();
        new Thread(new bp(this)).start();
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a(String str) {
        if (str == null || str.trim().length() == 0) {
            this.f5746a.dismiss();
            this.f5747b.D = true;
            this.f5747b.J.setTextColor(com.baidu.ufosdk.b.y);
            this.f5747b.E.setEnabled(false);
            this.f5747b.s.setVisibility(0);
            this.f5747b.s.bringToFront();
            new Thread(new bo(this)).start();
            return;
        }
        this.f5746a.dismiss();
        this.f5747b.D = true;
        this.f5747b.J.setTextColor(com.baidu.ufosdk.b.y);
        this.f5747b.E.setEnabled(false);
        this.f5747b.s.setVisibility(0);
        this.f5747b.s.bringToFront();
        new Thread(new bn(this, str)).start();
    }
}
