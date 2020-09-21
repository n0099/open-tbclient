package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
/* loaded from: classes21.dex */
final class cb implements View.OnClickListener {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.a, FeedbackListActivity.class);
        intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        this.a.startActivity(intent);
    }
}
