package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class dy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f3845a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(FeedbackReportActivity feedbackReportActivity) {
        this.f3845a = feedbackReportActivity;
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
        z = this.f3845a.B;
        if (z) {
            return;
        }
        list = this.f3845a.x;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.f3845a.x;
        if (list2.size() == 1) {
            byte[] b = com.baidu.ufosdk.f.m.b(this.f3845a.getApplicationContext());
            if (b == null) {
                return;
            }
            list4 = this.f3845a.x;
            list4.set(0, b);
        }
        bArr = this.f3845a.j;
        if (bArr != null) {
            list3 = this.f3845a.x;
            bArr2 = this.f3845a.j;
            if (!list3.contains(bArr2)) {
                textView = this.f3845a.r;
                textView.setText("上传截图");
            }
        }
        this.f3845a.c();
    }
}
