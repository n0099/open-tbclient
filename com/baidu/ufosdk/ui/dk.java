package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class dk implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f22828a;

    public dk(FeedbackListActivity feedbackListActivity) {
        this.f22828a = feedbackListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f22828a.setResult(0);
        this.f22828a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.f22828a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.f22828a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.f22828a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception unused) {
            com.baidu.ufosdk.f.c.d("执行动画失败！！");
        }
    }
}
