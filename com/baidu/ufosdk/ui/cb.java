package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
/* loaded from: classes5.dex */
public final class cb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23109a;

    public cb(FeedbackInputActivity feedbackInputActivity) {
        this.f23109a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f23109a, FeedbackListActivity.class);
        intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        this.f23109a.startActivity(intent);
    }
}
