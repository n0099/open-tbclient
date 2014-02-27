package com.baidu.tieba.person;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ EditHeadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        HorizontalScrollView horizontalScrollView;
        LinearLayout linearLayout;
        HorizontalScrollView horizontalScrollView2;
        LinearLayout linearLayout2;
        if (z) {
            radioButton = this.a.q;
            if (compoundButton == radioButton) {
                horizontalScrollView2 = this.a.m;
                horizontalScrollView2.setVisibility(0);
                linearLayout2 = this.a.s;
                linearLayout2.setVisibility(8);
                return;
            }
            radioButton2 = this.a.r;
            if (compoundButton == radioButton2) {
                horizontalScrollView = this.a.m;
                horizontalScrollView.setVisibility(8);
                linearLayout = this.a.s;
                linearLayout.setVisibility(0);
            }
        }
    }
}
