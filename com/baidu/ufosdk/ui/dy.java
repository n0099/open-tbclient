package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class dy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f3848a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(FeedbackReportActivity feedbackReportActivity) {
        this.f3848a = feedbackReportActivity;
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
        z = this.f3848a.B;
        if (z) {
            return;
        }
        list = this.f3848a.x;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.f3848a.x;
        if (list2.size() == 1) {
            byte[] b = com.baidu.ufosdk.f.m.b(this.f3848a.getApplicationContext());
            if (b == null) {
                return;
            }
            list4 = this.f3848a.x;
            list4.set(0, b);
        }
        bArr = this.f3848a.j;
        if (bArr != null) {
            list3 = this.f3848a.x;
            bArr2 = this.f3848a.j;
            if (!list3.contains(bArr2)) {
                textView = this.f3848a.r;
                textView.setText("上传截图");
            }
        }
        this.f3848a.c();
    }
}
