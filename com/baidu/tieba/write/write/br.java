package com.baidu.tieba.write.write;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
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
            radioButton = this.this$0.cNs;
            if (compoundButton == radioButton) {
                horizontalScrollView2 = this.this$0.cNp;
                horizontalScrollView2.setVisibility(0);
                linearLayout2 = this.this$0.cNu;
                linearLayout2.setVisibility(8);
                textView2 = this.this$0.Mv;
                textView2.setText(this.this$0.getPageContext().getString(n.j.beautify));
                return;
            }
            radioButton2 = this.this$0.cNt;
            if (compoundButton == radioButton2) {
                horizontalScrollView = this.this$0.cNp;
                horizontalScrollView.setVisibility(8);
                linearLayout = this.this$0.cNu;
                linearLayout.setVisibility(0);
                textView = this.this$0.Mv;
                textView.setText(this.this$0.getPageContext().getString(n.j.rotate));
            }
        }
    }
}
