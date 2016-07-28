package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements TextWatcher {
    private int eHp;
    final /* synthetic */ WriteActivity fVn;
    private EditText cZK = null;
    private TextView Tl = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.fVn.bbv();
        z = this.fVn.fUU;
        if (z) {
            this.eHp = this.cZK.getSelectionStart();
            this.cZK.setSelection(this.eHp);
            this.fVn.b(this.Tl, this.cZK);
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
        z = this.fVn.fUU;
        if (z) {
            z3 = this.fVn.fUV;
            if (z3) {
                EditText editText5 = this.cZK;
                editText3 = this.fVn.fUP;
                if (editText5 == editText3) {
                    TextView textView5 = this.Tl;
                    textView4 = this.fVn.fUQ;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.fVn.fUP;
                this.cZK = editText4;
                textView3 = this.fVn.fUQ;
                this.Tl = textView3;
                return;
            }
        }
        z2 = this.fVn.fUU;
        if (z2) {
            EditText editText6 = this.cZK;
            editText = this.fVn.fUL;
            if (editText6 == editText) {
                TextView textView6 = this.Tl;
                textView2 = this.fVn.fUR;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.fVn.fUL;
            this.cZK = editText2;
            textView = this.fVn.fUR;
            this.Tl = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
