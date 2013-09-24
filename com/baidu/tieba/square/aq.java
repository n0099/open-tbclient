package com.baidu.tieba.square;

import android.widget.CompoundButton;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f1828a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SquareSearchActivity squareSearchActivity) {
        this.f1828a = squareSearchActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        if (z) {
            this.f1828a.b(0);
            radioButton = this.f1828a.m;
            radioButton.setChecked(false);
        }
    }
}
