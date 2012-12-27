package com.baidu.tieba.write;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ WriteImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteImageActivity writeImageActivity) {
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
        if (!z) {
            compoundButton.setTextColor(this.a.getResources().getColor(R.color.beautify_rotate_tab_unchecked_color));
            return;
        }
        compoundButton.setTextColor(this.a.getResources().getColor(R.color.white));
        radioButton = this.a.l;
        if (compoundButton == radioButton) {
            horizontalScrollView2 = this.a.h;
            horizontalScrollView2.setVisibility(0);
            linearLayout2 = this.a.n;
            linearLayout2.setVisibility(4);
            textView2 = this.a.p;
            textView2.setText(this.a.getString(R.string.beautify));
            return;
        }
        radioButton2 = this.a.m;
        if (compoundButton == radioButton2) {
            horizontalScrollView = this.a.h;
            horizontalScrollView.setVisibility(4);
            linearLayout = this.a.n;
            linearLayout.setVisibility(0);
            textView = this.a.p;
            textView.setText(this.a.getString(R.string.rotate));
        }
    }
}
