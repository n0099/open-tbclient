package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements TextWatcher {
    private int eAA;
    final /* synthetic */ WriteActivity fDQ;
    private EditText cXt = null;
    private TextView Wd = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.fDQ.bbU();
        z = this.fDQ.fDp;
        if (z) {
            this.eAA = this.cXt.getSelectionStart();
            this.cXt.setSelection(this.eAA);
            this.fDQ.b(this.Wd, this.cXt);
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
        z = this.fDQ.fDp;
        if (z) {
            z3 = this.fDQ.fDq;
            if (z3) {
                EditText editText5 = this.cXt;
                editText3 = this.fDQ.fDk;
                if (editText5 == editText3) {
                    TextView textView5 = this.Wd;
                    textView4 = this.fDQ.fDl;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.fDQ.fDk;
                this.cXt = editText4;
                textView3 = this.fDQ.fDl;
                this.Wd = textView3;
                return;
            }
        }
        z2 = this.fDQ.fDp;
        if (z2) {
            EditText editText6 = this.cXt;
            editText = this.fDQ.fDg;
            if (editText6 == editText) {
                TextView textView6 = this.Wd;
                textView2 = this.fDQ.fDm;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.fDQ.fDg;
            this.cXt = editText2;
            textView = this.fDQ.fDm;
            this.Wd = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
