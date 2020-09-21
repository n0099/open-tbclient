package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class ay implements View.OnClickListener {
    final /* synthetic */ FeedbackHotActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(FeedbackHotActivity feedbackHotActivity) {
        this.a = feedbackHotActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("执行动画失败！！");
        }
    }
}
