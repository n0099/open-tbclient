package com.baidu.tieba.person;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ EditHeadActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        HorizontalScrollView horizontalScrollView;
        LinearLayout linearLayout;
        HorizontalScrollView horizontalScrollView2;
        LinearLayout linearLayout2;
        if (z) {
            radioButton = this.this$0.dro;
            if (compoundButton == radioButton) {
                horizontalScrollView2 = this.this$0.drl;
                horizontalScrollView2.setVisibility(0);
                linearLayout2 = this.this$0.drq;
                linearLayout2.setVisibility(8);
                return;
            }
            radioButton2 = this.this$0.drp;
            if (compoundButton == radioButton2) {
                horizontalScrollView = this.this$0.drl;
                horizontalScrollView.setVisibility(8);
                linearLayout = this.this$0.drq;
                linearLayout.setVisibility(0);
            }
        }
    }
}
