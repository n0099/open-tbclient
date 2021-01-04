package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes8.dex */
final class ay implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackHotActivity f5730a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(FeedbackHotActivity feedbackHotActivity) {
        this.f5730a = feedbackHotActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f5730a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.f5730a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.f5730a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.f5730a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("执行动画失败！！");
        }
    }
}
