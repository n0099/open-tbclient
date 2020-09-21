package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class bq implements View.OnClickListener {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        List list;
        List list2;
        List list3;
        if (this.a.D) {
            return;
        }
        list = this.a.at;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.a.at;
        if (list2.size() == 1) {
            byte[] a = com.baidu.ufosdk.f.m.a(this.a.getApplicationContext());
            if (a == null) {
                return;
            }
            list3 = this.a.at;
            list3.set(0, a);
        }
        this.a.a(false);
    }
}
