package com.baidu.tieba.square;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2511a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(SquareSearchActivity squareSearchActivity) {
        this.f2511a = squareSearchActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        if (z) {
            this.f2511a.a(1);
            radioButton = this.f2511a.j;
            radioButton.setChecked(false);
            radioButton2 = this.f2511a.j;
            radioButton2.setSelected(false);
            radioButton3 = this.f2511a.k;
            radioButton3.setSelected(true);
        }
    }
}
