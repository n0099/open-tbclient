package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
/* loaded from: classes22.dex */
final class cb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3799a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(FeedbackInputActivity feedbackInputActivity) {
        this.f3799a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f3799a, FeedbackListActivity.class);
        intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        this.f3799a.startActivity(intent);
    }
}
