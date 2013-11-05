package com.baidu.tieba.square;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2350a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SquareSearchActivity squareSearchActivity) {
        this.f2350a = squareSearchActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        if (z) {
            this.f2350a.d(1);
            radioButton = this.f2350a.l;
            radioButton.setChecked(false);
        }
    }
}
