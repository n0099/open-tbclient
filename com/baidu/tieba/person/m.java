package com.baidu.tieba.person;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ EditHeadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        HorizontalScrollView horizontalScrollView;
        LinearLayout linearLayout;
        HorizontalScrollView horizontalScrollView2;
        LinearLayout linearLayout2;
        if (!z) {
            compoundButton.setTextColor(this.a.getResources().getColor(R.color.beautify_rotate_tab_unchecked_color));
            return;
        }
        compoundButton.setTextColor(this.a.getResources().getColor(R.color.white));
        radioButton = this.a.p;
        if (compoundButton == radioButton) {
            horizontalScrollView2 = this.a.l;
            horizontalScrollView2.setVisibility(0);
            linearLayout2 = this.a.r;
            linearLayout2.setVisibility(4);
            return;
        }
        radioButton2 = this.a.q;
        if (compoundButton == radioButton2) {
            horizontalScrollView = this.a.l;
            horizontalScrollView.setVisibility(4);
            linearLayout = this.a.r;
            linearLayout.setVisibility(0);
        }
    }
}
