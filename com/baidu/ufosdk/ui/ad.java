package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* loaded from: classes5.dex */
public final class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22627a;

    public ad(FeedbackEditActivity feedbackEditActivity) {
        this.f22627a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f22627a.v;
        if (z) {
            return;
        }
        list = this.f22627a.q;
        if (list.size() >= 3) {
            FeedbackEditActivity.a(this.f22627a, 3);
        }
    }
}
