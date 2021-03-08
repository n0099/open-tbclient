package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3650a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FeedbackEditActivity feedbackEditActivity) {
        this.f3650a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f3650a.v;
        if (z) {
            return;
        }
        list = this.f3650a.q;
        if (list.size() >= 3) {
            FeedbackEditActivity.a(this.f3650a, 3);
        }
    }
}
