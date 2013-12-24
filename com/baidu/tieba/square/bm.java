package com.baidu.tieba.square;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements TextWatcher {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        int i4;
        int i5;
        this.a.B = charSequence.toString();
        str = this.a.B;
        if (str.trim().length() > 0) {
            i5 = this.a.C;
            if (i5 == 0) {
                this.a.g();
                return;
            }
            return;
        }
        this.a.a();
        i4 = this.a.C;
        if (i4 == 0) {
            this.a.f();
        } else {
            this.a.h();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        Button button2;
        if (editable.toString().trim().length() == 0) {
            button2 = this.a.d;
            button2.setVisibility(8);
            return;
        }
        button = this.a.d;
        button.setVisibility(0);
    }
}
