package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements TextWatcher {
    private int eKw;
    final /* synthetic */ WriteActivity fMl;
    private EditText deH = null;
    private TextView Vt = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.fMl = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.fMl.bdH();
        z = this.fMl.fLK;
        if (z) {
            this.eKw = this.deH.getSelectionStart();
            this.deH.setSelection(this.eKw);
            this.fMl.b(this.Vt, this.deH);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        boolean z2;
        EditText editText;
        EditText editText2;
        TextView textView;
        TextView textView2;
        boolean z3;
        EditText editText3;
        EditText editText4;
        TextView textView3;
        TextView textView4;
        z = this.fMl.fLK;
        if (z) {
            z3 = this.fMl.fLL;
            if (z3) {
                EditText editText5 = this.deH;
                editText3 = this.fMl.fLF;
                if (editText5 == editText3) {
                    TextView textView5 = this.Vt;
                    textView4 = this.fMl.fLG;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.fMl.fLF;
                this.deH = editText4;
                textView3 = this.fMl.fLG;
                this.Vt = textView3;
                return;
            }
        }
        z2 = this.fMl.fLK;
        if (z2) {
            EditText editText6 = this.deH;
            editText = this.fMl.fLB;
            if (editText6 == editText) {
                TextView textView6 = this.Vt;
                textView2 = this.fMl.fLH;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.fMl.fLB;
            this.deH = editText2;
            textView = this.fMl.fLH;
            this.Vt = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
