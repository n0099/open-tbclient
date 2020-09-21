package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class ab implements View.OnClickListener {
    final /* synthetic */ FeedbackEditActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FeedbackEditActivity feedbackEditActivity) {
        this.a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.a.v;
        if (z) {
            return;
        }
        list = this.a.q;
        if (list.size() > 0) {
            FeedbackEditActivity.a(this.a, 1);
        }
    }
}
