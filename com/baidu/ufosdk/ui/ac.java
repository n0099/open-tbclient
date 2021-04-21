package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* loaded from: classes5.dex */
public final class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22742a;

    public ac(FeedbackEditActivity feedbackEditActivity) {
        this.f22742a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f22742a.v;
        if (z) {
            return;
        }
        list = this.f22742a.q;
        if (list.size() >= 2) {
            FeedbackEditActivity.a(this.f22742a, 2);
        }
    }
}
