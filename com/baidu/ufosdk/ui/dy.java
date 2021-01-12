package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class dy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f5546a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(FeedbackReportActivity feedbackReportActivity) {
        this.f5546a = feedbackReportActivity;
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
        z = this.f5546a.B;
        if (z) {
            return;
        }
        list = this.f5546a.x;
        list.remove(((Integer) view.getTag()).intValue());
        list2 = this.f5546a.x;
        if (list2.size() == 1) {
            byte[] b2 = com.baidu.ufosdk.f.m.b(this.f5546a.getApplicationContext());
            if (b2 == null) {
                return;
            }
            list4 = this.f5546a.x;
            list4.set(0, b2);
        }
        bArr = this.f5546a.j;
        if (bArr != null) {
            list3 = this.f5546a.x;
            bArr2 = this.f5546a.j;
            if (!list3.contains(bArr2)) {
                textView = this.f5546a.r;
                textView.setText("上传截图");
            }
        }
        this.f5546a.c();
    }
}
