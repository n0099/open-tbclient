package com.baidu.tieba.mainentrance;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* loaded from: classes.dex */
final class ae implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        if (z) {
            this.a.a(0);
            radioButton = this.a.l;
            radioButton.setChecked(false);
            radioButton2 = this.a.l;
            radioButton2.setSelected(false);
            radioButton3 = this.a.k;
            radioButton3.setSelected(true);
        }
    }
}
