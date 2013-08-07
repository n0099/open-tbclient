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
    final /* synthetic */ WriteImageActivity f1888a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteImageActivity writeImageActivity) {
        this.f1888a = writeImageActivity;
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
            compoundButton.setTextColor(this.f1888a.getResources().getColor(R.color.white));
            radioButton = this.f1888a.m;
            if (compoundButton == radioButton) {
                horizontalScrollView2 = this.f1888a.g;
                horizontalScrollView2.setVisibility(0);
                linearLayout2 = this.f1888a.o;
                linearLayout2.setVisibility(4);
                textView2 = this.f1888a.q;
                textView2.setText(this.f1888a.getString(R.string.beautify));
                return;
            }
            radioButton2 = this.f1888a.n;
            if (compoundButton == radioButton2) {
                horizontalScrollView = this.f1888a.g;
                horizontalScrollView.setVisibility(4);
                linearLayout = this.f1888a.o;
                linearLayout.setVisibility(0);
                textView = this.f1888a.q;
                textView.setText(this.f1888a.getString(R.string.rotate));
                return;
            }
            return;
        }
        compoundButton.setTextColor(this.f1888a.getResources().getColor(R.color.beautify_rotate_tab_unchecked_color));
    }
}
