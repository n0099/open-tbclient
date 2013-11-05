package com.baidu.tieba.square;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2348a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(SquareSearchActivity squareSearchActivity) {
        this.f2348a = squareSearchActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        int i4;
        int i5;
        this.f2348a.E = charSequence.toString();
        str = this.f2348a.E;
        if (str.trim().length() > 0) {
            i5 = this.f2348a.F;
            if (i5 == 0) {
                this.f2348a.o();
                return;
            }
            return;
        }
        this.f2348a.b();
        i4 = this.f2348a.F;
        if (i4 == 0) {
            this.f2348a.n();
        } else {
            this.f2348a.p();
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
            button2 = this.f2348a.d;
            button2.setVisibility(8);
            return;
        }
        button = this.f2348a.d;
        button.setVisibility(0);
    }
}
