package com.baidu.tieba.person;

import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        Button button;
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        RadioButton radioButton4;
        RadioButton radioButton5;
        HorizontalScrollView horizontalScrollView;
        RadioButton radioButton6;
        boolean z;
        linearLayout = this.a.t;
        linearLayout.setVisibility(0);
        button = this.a.l;
        button.setVisibility(8);
        if (Build.VERSION.SDK_INT >= 7) {
            z = this.a.A;
            if (z) {
                return;
            }
        }
        radioButton = this.a.r;
        radioButton2 = this.a.r;
        int paddingTop = radioButton2.getPaddingTop();
        radioButton3 = this.a.r;
        int paddingRight = radioButton3.getPaddingRight();
        radioButton4 = this.a.r;
        radioButton.setPadding(0, paddingTop, paddingRight, radioButton4.getPaddingBottom());
        radioButton5 = this.a.r;
        radioButton5.setChecked(true);
        horizontalScrollView = this.a.m;
        horizontalScrollView.setVisibility(8);
        radioButton6 = this.a.q;
        radioButton6.setVisibility(8);
    }
}
