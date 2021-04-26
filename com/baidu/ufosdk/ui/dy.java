package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* loaded from: classes5.dex */
public final class dy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f23602a;

    public dy(FeedbackReportActivity feedbackReportActivity) {
        this.f23602a = feedbackReportActivity;
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
        z = this.f23602a.B;
        if (z) {
            return;
        }
        list = this.f23602a.x;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.f23602a.x;
        if (list2.size() == 1) {
            byte[] b2 = com.baidu.ufosdk.f.m.b(this.f23602a.getApplicationContext());
            if (b2 == null) {
                return;
            }
            list4 = this.f23602a.x;
            list4.set(0, b2);
        }
        bArr = this.f23602a.j;
        if (bArr != null) {
            list3 = this.f23602a.x;
            bArr2 = this.f23602a.j;
            if (!list3.contains(bArr2)) {
                textView = this.f23602a.r;
                textView.setText("上传截图");
            }
        }
        this.f23602a.c();
    }
}
