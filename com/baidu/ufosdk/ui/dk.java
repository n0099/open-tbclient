package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class dk implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f23179a;

    public dk(FeedbackListActivity feedbackListActivity) {
        this.f23179a = feedbackListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23179a.setResult(0);
        this.f23179a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.f23179a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.f23179a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.f23179a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception unused) {
            com.baidu.ufosdk.f.c.d("执行动画失败！！");
        }
    }
}
