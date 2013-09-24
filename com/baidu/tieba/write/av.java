package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2099a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteImageActivity writeImageActivity) {
        this.f2099a = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        linearLayout = this.f2099a.f;
        if (linearLayout.getVisibility() == 0) {
            linearLayout4 = this.f2099a.f;
            linearLayout4.setVisibility(8);
            linearLayout5 = this.f2099a.p;
            linearLayout5.setVisibility(8);
            return;
        }
        linearLayout2 = this.f2099a.f;
        linearLayout2.setVisibility(0);
        linearLayout3 = this.f2099a.p;
        linearLayout3.setVisibility(0);
    }
}
