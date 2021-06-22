package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
/* loaded from: classes5.dex */
public final class cb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22872a;

    public cb(FeedbackInputActivity feedbackInputActivity) {
        this.f22872a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f22872a, FeedbackListActivity.class);
        intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        this.f22872a.startActivity(intent);
    }
}
