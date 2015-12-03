package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements TextWatcher {
    private int cWT;
    final /* synthetic */ WriteActivity dRf;
    private EditText bXx = null;
    private TextView mTextView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.dRf = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.dRf.aIs();
        z = this.dRf.dQW;
        if (z) {
            this.cWT = this.bXx.getSelectionStart();
            this.bXx.setSelection(this.cWT);
            this.dRf.b(this.mTextView, this.bXx);
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
        z = this.dRf.dQW;
        if (z) {
            z3 = this.dRf.dQX;
            if (z3) {
                EditText editText5 = this.bXx;
                editText3 = this.dRf.dQR;
                if (editText5 == editText3) {
                    TextView textView5 = this.mTextView;
                    textView4 = this.dRf.dQS;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.dRf.dQR;
                this.bXx = editText4;
                textView3 = this.dRf.dQS;
                this.mTextView = textView3;
                return;
            }
        }
        z2 = this.dRf.dQW;
        if (z2) {
            EditText editText6 = this.bXx;
            editText = this.dRf.dQN;
            if (editText6 == editText) {
                TextView textView6 = this.mTextView;
                textView2 = this.dRf.dQT;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.dRf.dQN;
            this.bXx = editText2;
            textView = this.dRf.dQT;
            this.mTextView = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
