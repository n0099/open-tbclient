package com.baidu.tieba.write;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ WriteImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        HorizontalScrollView horizontalScrollView;
        LinearLayout linearLayout;
        TextView textView;
        HorizontalScrollView horizontalScrollView2;
        LinearLayout linearLayout2;
        TextView textView2;
        if (z) {
            compoundButton.setTextColor(this.a.getResources().getColor(R.color.white));
            radioButton = this.a.m;
            if (compoundButton == radioButton) {
                horizontalScrollView2 = this.a.i;
                horizontalScrollView2.setVisibility(0);
                linearLayout2 = this.a.o;
                linearLayout2.setVisibility(4);
                textView2 = this.a.q;
                textView2.setText(this.a.getString(R.string.beautify));
                return;
            }
            radioButton2 = this.a.n;
            if (compoundButton == radioButton2) {
                horizontalScrollView = this.a.i;
                horizontalScrollView.setVisibility(4);
                linearLayout = this.a.o;
                linearLayout.setVisibility(0);
                textView = this.a.q;
                textView.setText(this.a.getString(R.string.rotate));
                return;
            }
            return;
        }
        compoundButton.setTextColor(this.a.getResources().getColor(R.color.beautify_rotate_tab_unchecked_color));
    }
}
