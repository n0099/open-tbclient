package com.baidu.tieba.square;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2410a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(SquareSearchActivity squareSearchActivity) {
        this.f2410a = squareSearchActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        if (z) {
            this.f2410a.a(0);
            radioButton = this.f2410a.k;
            radioButton.setChecked(false);
            radioButton2 = this.f2410a.k;
            radioButton2.setSelected(false);
            radioButton3 = this.f2410a.j;
            radioButton3.setSelected(true);
        }
    }
}
