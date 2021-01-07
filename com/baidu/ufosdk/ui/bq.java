package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class bq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5753a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(FeedbackInputActivity feedbackInputActivity) {
        this.f5753a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        List list;
        List list2;
        List list3;
        if (this.f5753a.D) {
            return;
        }
        list = this.f5753a.at;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.f5753a.at;
        if (list2.size() == 1) {
            byte[] a2 = com.baidu.ufosdk.f.m.a(this.f5753a.getApplicationContext());
            if (a2 == null) {
                return;
            }
            list3 = this.f5753a.at;
            list3.set(0, a2);
        }
        this.f5753a.a(false);
    }
}
