package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements TextWatcher {
    final /* synthetic */ WriteActivity dYD;
    private int dbU;
    private EditText cbx = null;
    private TextView mTextView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.dYD.aKN();
        z = this.dYD.dYu;
        if (z) {
            this.dbU = this.cbx.getSelectionStart();
            this.cbx.setSelection(this.dbU);
            this.dYD.b(this.mTextView, this.cbx);
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
        z = this.dYD.dYu;
        if (z) {
            z3 = this.dYD.dYv;
            if (z3) {
                EditText editText5 = this.cbx;
                editText3 = this.dYD.dYp;
                if (editText5 == editText3) {
                    TextView textView5 = this.mTextView;
                    textView4 = this.dYD.dYq;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.dYD.dYp;
                this.cbx = editText4;
                textView3 = this.dYD.dYq;
                this.mTextView = textView3;
                return;
            }
        }
        z2 = this.dYD.dYu;
        if (z2) {
            EditText editText6 = this.cbx;
            editText = this.dYD.dYl;
            if (editText6 == editText) {
                TextView textView6 = this.mTextView;
                textView2 = this.dYD.dYr;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.dYD.dYl;
            this.cbx = editText2;
            textView = this.dYD.dYr;
            this.mTextView = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
