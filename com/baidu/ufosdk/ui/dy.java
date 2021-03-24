package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* loaded from: classes5.dex */
public final class dy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f23197a;

    public dy(FeedbackReportActivity feedbackReportActivity) {
        this.f23197a = feedbackReportActivity;
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
        z = this.f23197a.B;
        if (z) {
            return;
        }
        list = this.f23197a.x;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.f23197a.x;
        if (list2.size() == 1) {
            byte[] b2 = com.baidu.ufosdk.f.m.b(this.f23197a.getApplicationContext());
            if (b2 == null) {
                return;
            }
            list4 = this.f23197a.x;
            list4.set(0, b2);
        }
        bArr = this.f23197a.j;
        if (bArr != null) {
            list3 = this.f23197a.x;
            bArr2 = this.f23197a.j;
            if (!list3.contains(bArr2)) {
                textView = this.f23197a.r;
                textView.setText("上传截图");
            }
        }
        this.f23197a.c();
    }
}
