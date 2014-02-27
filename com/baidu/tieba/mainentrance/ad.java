package com.baidu.tieba.mainentrance;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* loaded from: classes.dex */
final class ad implements TextWatcher {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
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
            this.a.e();
            return;
        }
        this.a.a();
        i4 = this.a.D;
        if (i4 == 0) {
            this.a.c();
        } else {
            this.a.d();
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
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
