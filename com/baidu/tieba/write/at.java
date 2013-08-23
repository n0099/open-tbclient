package com.baidu.tieba.write;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f1919a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteImageActivity writeImageActivity) {
        this.f1919a = writeImageActivity;
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
            compoundButton.setTextColor(this.f1919a.getResources().getColor(R.color.white));
            radioButton = this.f1919a.m;
            if (compoundButton == radioButton) {
                horizontalScrollView2 = this.f1919a.g;
                horizontalScrollView2.setVisibility(0);
                linearLayout2 = this.f1919a.o;
                linearLayout2.setVisibility(4);
                textView2 = this.f1919a.q;
                textView2.setText(this.f1919a.getString(R.string.beautify));
                return;
            }
            radioButton2 = this.f1919a.n;
            if (compoundButton == radioButton2) {
                horizontalScrollView = this.f1919a.g;
                horizontalScrollView.setVisibility(4);
                linearLayout = this.f1919a.o;
                linearLayout.setVisibility(0);
                textView = this.f1919a.q;
                textView.setText(this.f1919a.getString(R.string.rotate));
                return;
            }
            return;
        }
        compoundButton.setTextColor(this.f1919a.getResources().getColor(R.color.beautify_rotate_tab_unchecked_color));
    }
}
