package com.baidu.tieba.square;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2411a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(SquareSearchActivity squareSearchActivity) {
        this.f2411a = squareSearchActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        if (z) {
            this.f2411a.a(1);
            radioButton = this.f2411a.j;
            radioButton.setChecked(false);
            radioButton2 = this.f2411a.j;
            radioButton2.setSelected(false);
            radioButton3 = this.f2411a.k;
            radioButton3.setSelected(true);
        }
    }
}
