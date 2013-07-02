package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        linearLayout = this.a.f;
        if (linearLayout.getVisibility() == 0) {
            linearLayout4 = this.a.f;
            linearLayout4.setVisibility(8);
            linearLayout5 = this.a.p;
            linearLayout5.setVisibility(8);
            return;
        }
        linearLayout2 = this.a.f;
        linearLayout2.setVisibility(0);
        linearLayout3 = this.a.p;
        linearLayout3.setVisibility(0);
    }
}
