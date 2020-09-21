package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class dk implements View.OnClickListener {
    final /* synthetic */ FeedbackListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(FeedbackListActivity feedbackListActivity) {
        this.a = feedbackListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.setResult(0);
        this.a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("执行动画失败！！");
        }
    }
}
