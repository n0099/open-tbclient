package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class dy implements View.OnClickListener {
    final /* synthetic */ FeedbackReportActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(FeedbackReportActivity feedbackReportActivity) {
        this.a = feedbackReportActivity;
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
        z = this.a.B;
        if (z) {
            return;
        }
        list = this.a.x;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.a.x;
        if (list2.size() == 1) {
            byte[] b = com.baidu.ufosdk.f.m.b(this.a.getApplicationContext());
            if (b == null) {
                return;
            }
            list4 = this.a.x;
            list4.set(0, b);
        }
        bArr = this.a.j;
        if (bArr != null) {
            list3 = this.a.x;
            bArr2 = this.a.j;
            if (!list3.contains(bArr2)) {
                textView = this.a.r;
                textView.setText("上传截图");
            }
        }
        this.a.c();
    }
}
