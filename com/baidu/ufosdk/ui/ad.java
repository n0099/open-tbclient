package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* loaded from: classes5.dex */
public final class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23050a;

    public ad(FeedbackEditActivity feedbackEditActivity) {
        this.f23050a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f23050a.v;
        if (z) {
            return;
        }
        list = this.f23050a.q;
        if (list.size() >= 3) {
            FeedbackEditActivity.a(this.f23050a, 3);
        }
    }
}
