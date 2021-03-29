package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* loaded from: classes5.dex */
public final class bq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23095a;

    public bq(FeedbackInputActivity feedbackInputActivity) {
        this.f23095a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        List list;
        List list2;
        List list3;
        FeedbackInputActivity feedbackInputActivity = this.f23095a;
        if (feedbackInputActivity.D) {
            return;
        }
        list = feedbackInputActivity.at;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.f23095a.at;
        if (list2.size() == 1) {
            byte[] a2 = com.baidu.ufosdk.f.m.a(this.f23095a.getApplicationContext());
            if (a2 == null) {
                return;
            }
            list3 = this.f23095a.at;
            list3.set(0, a2);
        }
        this.f23095a.a(false);
    }
}
