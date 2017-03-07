package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements TextWatcher {
    private int eNZ;
    final /* synthetic */ WriteActivity fQG;
    private EditText dgY = null;
    private TextView aaE = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.fQG.bds();
        z = this.fQG.fQf;
        if (z) {
            this.eNZ = this.dgY.getSelectionStart();
            this.dgY.setSelection(this.eNZ);
            this.fQG.b(this.aaE, this.dgY);
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
        z = this.fQG.fQf;
        if (z) {
            z3 = this.fQG.fQg;
            if (z3) {
                EditText editText5 = this.dgY;
                editText3 = this.fQG.fQa;
                if (editText5 == editText3) {
                    TextView textView5 = this.aaE;
                    textView4 = this.fQG.fQb;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.fQG.fQa;
                this.dgY = editText4;
                textView3 = this.fQG.fQb;
                this.aaE = textView3;
                return;
            }
        }
        z2 = this.fQG.fQf;
        if (z2) {
            EditText editText6 = this.dgY;
            editText = this.fQG.fPW;
            if (editText6 == editText) {
                TextView textView6 = this.aaE;
                textView2 = this.fQG.fQc;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.fQG.fPW;
            this.dgY = editText2;
            textView = this.fQG.fQc;
            this.aaE = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
