package com.baidu.tieba.square;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2510a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(SquareSearchActivity squareSearchActivity) {
        this.f2510a = squareSearchActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        if (z) {
            this.f2510a.a(0);
            radioButton = this.f2510a.k;
            radioButton.setChecked(false);
            radioButton2 = this.f2510a.k;
            radioButton2.setSelected(false);
            radioButton3 = this.f2510a.j;
            radioButton3.setSelected(true);
        }
    }
}
