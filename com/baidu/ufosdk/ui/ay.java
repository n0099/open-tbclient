package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes22.dex */
final class ay implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackHotActivity f3765a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(FeedbackHotActivity feedbackHotActivity) {
        this.f3765a = feedbackHotActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3765a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.f3765a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.f3765a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.f3765a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("执行动画失败！！");
        }
    }
}
