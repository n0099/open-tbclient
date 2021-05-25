package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* loaded from: classes5.dex */
public final class bq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22672a;

    public bq(FeedbackInputActivity feedbackInputActivity) {
        this.f22672a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        List list;
        List list2;
        List list3;
        FeedbackInputActivity feedbackInputActivity = this.f22672a;
        if (feedbackInputActivity.D) {
            return;
        }
        list = feedbackInputActivity.at;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.f22672a.at;
        if (list2.size() == 1) {
            byte[] a2 = com.baidu.ufosdk.f.m.a(this.f22672a.getApplicationContext());
            if (a2 == null) {
                return;
            }
            list3 = this.f22672a.at;
            list3.set(0, a2);
        }
        this.f22672a.a(false);
    }
}
