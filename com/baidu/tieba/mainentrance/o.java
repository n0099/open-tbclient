package com.baidu.tieba.mainentrance;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        if (z) {
            this.a.a(1);
            radioButton = this.a.k;
            radioButton.setChecked(false);
            radioButton2 = this.a.k;
            radioButton2.setSelected(false);
            radioButton3 = this.a.l;
            radioButton3.setSelected(true);
        }
    }
}
