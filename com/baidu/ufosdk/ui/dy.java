package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* loaded from: classes5.dex */
public final class dy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f23198a;

    public dy(FeedbackReportActivity feedbackReportActivity) {
        this.f23198a = feedbackReportActivity;
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
        z = this.f23198a.B;
        if (z) {
            return;
        }
        list = this.f23198a.x;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.f23198a.x;
        if (list2.size() == 1) {
            byte[] b2 = com.baidu.ufosdk.f.m.b(this.f23198a.getApplicationContext());
            if (b2 == null) {
                return;
            }
            list4 = this.f23198a.x;
            list4.set(0, b2);
        }
        bArr = this.f23198a.j;
        if (bArr != null) {
            list3 = this.f23198a.x;
            bArr2 = this.f23198a.j;
            if (!list3.contains(bArr2)) {
                textView = this.f23198a.r;
                textView.setText("上传截图");
            }
        }
        this.f23198a.c();
    }
}
