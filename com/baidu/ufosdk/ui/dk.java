package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class dk implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackListActivity f3737a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(FeedbackListActivity feedbackListActivity) {
        this.f3737a = feedbackListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3737a.setResult(0);
        this.f3737a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.f3737a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.f3737a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.f3737a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("执行动画失败！！");
        }
    }
}
