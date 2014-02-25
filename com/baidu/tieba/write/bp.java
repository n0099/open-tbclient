package com.baidu.tieba.write;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ WriteImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(WriteImageActivity writeImageActivity) {
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
            radioButton = this.a.j;
            if (compoundButton == radioButton) {
                horizontalScrollView2 = this.a.f;
                horizontalScrollView2.setVisibility(0);
                linearLayout2 = this.a.l;
                linearLayout2.setVisibility(8);
                textView2 = this.a.n;
                textView2.setText(this.a.getString(R.string.beautify));
                return;
            }
            radioButton2 = this.a.k;
            if (compoundButton == radioButton2) {
                horizontalScrollView = this.a.f;
                horizontalScrollView.setVisibility(8);
                linearLayout = this.a.l;
                linearLayout.setVisibility(0);
                textView = this.a.n;
                textView.setText(this.a.getString(R.string.rotate));
            }
        }
    }
}
