package com.baidu.tieba.person;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ EditHeadActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(EditHeadActivity editHeadActivity) {
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
            radioButton = this.this$0.coa;
            if (compoundButton == radioButton) {
                horizontalScrollView2 = this.this$0.cnX;
                horizontalScrollView2.setVisibility(0);
                linearLayout2 = this.this$0.coc;
                linearLayout2.setVisibility(8);
                return;
            }
            radioButton2 = this.this$0.cob;
            if (compoundButton == radioButton2) {
                horizontalScrollView = this.this$0.cnX;
                horizontalScrollView.setVisibility(8);
                linearLayout = this.this$0.coc;
                linearLayout.setVisibility(0);
            }
        }
    }
}
