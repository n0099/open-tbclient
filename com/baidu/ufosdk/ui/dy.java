package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class dy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f3751a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(FeedbackReportActivity feedbackReportActivity) {
        this.f3751a = feedbackReportActivity;
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
        z = this.f3751a.B;
        if (z) {
            return;
        }
        list = this.f3751a.x;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.f3751a.x;
        if (list2.size() == 1) {
            byte[] b = com.baidu.ufosdk.f.m.b(this.f3751a.getApplicationContext());
            if (b == null) {
                return;
            }
            list4 = this.f3751a.x;
            list4.set(0, b);
        }
        bArr = this.f3751a.j;
        if (bArr != null) {
            list3 = this.f3751a.x;
            bArr2 = this.f3751a.j;
            if (!list3.contains(bArr2)) {
                textView = this.f3751a.r;
                textView.setText("上传截图");
            }
        }
        this.f3751a.c();
    }
}
