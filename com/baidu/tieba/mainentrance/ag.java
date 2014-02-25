package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements TextWatcher {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        int i4;
        int i5;
        this.a.C = charSequence.toString();
        str = this.a.C;
        if (str.trim().length() > 0) {
            i5 = this.a.D;
            if (i5 != 0) {
                return;
            }
            this.a.h();
            return;
        }
        this.a.a();
        i4 = this.a.D;
        if (i4 == 0) {
            this.a.f();
        } else {
            this.a.g();
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
