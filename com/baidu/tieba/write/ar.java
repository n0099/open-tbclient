package com.baidu.tieba.write;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2691a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteImageActivity writeImageActivity) {
        this.f2691a = writeImageActivity;
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
            compoundButton.setTextColor(this.f2691a.getResources().getColor(R.color.white));
            radioButton = this.f2691a.j;
            if (compoundButton == radioButton) {
                horizontalScrollView2 = this.f2691a.f;
                horizontalScrollView2.setVisibility(0);
                linearLayout2 = this.f2691a.l;
                linearLayout2.setVisibility(4);
                textView2 = this.f2691a.n;
                textView2.setText(this.f2691a.getString(R.string.beautify));
                return;
            }
            radioButton2 = this.f2691a.k;
            if (compoundButton == radioButton2) {
                horizontalScrollView = this.f2691a.f;
                horizontalScrollView.setVisibility(4);
                linearLayout = this.f2691a.l;
                linearLayout.setVisibility(0);
                textView = this.f2691a.n;
                textView.setText(this.f2691a.getString(R.string.rotate));
                return;
            }
            return;
        }
        compoundButton.setTextColor(this.f2691a.getResources().getColor(R.color.beautify_rotate_tab_unchecked_color));
    }
}
