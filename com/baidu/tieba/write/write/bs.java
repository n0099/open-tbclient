package com.baidu.tieba.write.write;

import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(WriteImageActivity writeImageActivity) {
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
            radioButton = this.this$0.eMV;
            if (compoundButton == radioButton) {
                horizontalScrollView2 = this.this$0.eMS;
                horizontalScrollView2.setVisibility(0);
                linearLayout2 = this.this$0.eMX;
                linearLayout2.setVisibility(8);
                textView2 = this.this$0.FZ;
                textView2.setText(this.this$0.getPageContext().getString(r.j.beautify));
                return;
            }
            radioButton2 = this.this$0.eMW;
            if (compoundButton == radioButton2) {
                horizontalScrollView = this.this$0.eMS;
                horizontalScrollView.setVisibility(8);
                linearLayout = this.this$0.eMX;
                linearLayout.setVisibility(0);
                textView = this.this$0.FZ;
                textView.setText(this.this$0.getPageContext().getString(r.j.rotate));
            }
        }
    }
}
