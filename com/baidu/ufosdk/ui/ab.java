package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f5707a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FeedbackEditActivity feedbackEditActivity) {
        this.f5707a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f5707a.v;
        if (z) {
            return;
        }
        list = this.f5707a.q;
        if (list.size() > 0) {
            FeedbackEditActivity.a(this.f5707a, 1);
        }
    }
}
