package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class dy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f5548a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(FeedbackReportActivity feedbackReportActivity) {
        this.f5548a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        List list2;
        byte[] bArr;
        List list3;
        byte[] bArr2;
        TextView textView;
        List list4;
        z = this.f5548a.B;
        if (z) {
            return;
        }
        list = this.f5548a.x;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.f5548a.x;
        if (list2.size() == 1) {
            byte[] b2 = com.baidu.ufosdk.f.m.b(this.f5548a.getApplicationContext());
            if (b2 == null) {
                return;
            }
            list4 = this.f5548a.x;
            list4.set(0, b2);
        }
        bArr = this.f5548a.j;
        if (bArr != null) {
            list3 = this.f5548a.x;
            bArr2 = this.f5548a.j;
            if (!list3.contains(bArr2)) {
                textView = this.f5548a.r;
                textView.setText("上传截图");
            }
        }
        this.f5548a.c();
    }
}
